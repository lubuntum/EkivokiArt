package com.pavel.ekivoki.data.repositories;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.pavel.ekivoki.data.Database;
import com.pavel.ekivoki.data.dao.CategoryDao;
import com.pavel.ekivoki.data.entity.Category;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CategoryRepository {
    private Database database;
    private Executor threadIOExecutor;

    private CategoryDao categoryDao;

    private static volatile CategoryRepository INSTANCE = null;
    public static CategoryRepository getInstance(Application application){
        if (INSTANCE == null){
            synchronized (CategoryRepository.class){
                if(INSTANCE == null){
                    INSTANCE = new CategoryRepository(application);
                }
            }
        }
        return INSTANCE;
    }
    private CategoryRepository(Application app){
        database = Database.getInstance(app);
        threadIOExecutor = Executors.newCachedThreadPool();

        categoryDao = database.categoryDao();
    }

    public void insertCategory(Category category){
        Runnable insertCategoryRnb = new Runnable() {
            @Override
            public void run() {
                categoryDao.insert(category);
            }
        };
        threadIOExecutor.execute(insertCategoryRnb);
    }
    public void deleteCategory(Category category){
        Runnable deleteCategoryRnb = new Runnable() {
            @Override
            public void run() {
                categoryDao.delete(category);
            }
        };
        threadIOExecutor.execute(deleteCategoryRnb);
    }
    public void findAllCategories(MutableLiveData<List<Category>> categories){
        Runnable findAllCategoriesRnb = new Runnable() {
            @Override
            public void run() {
                categories.postValue(categoryDao.getAllCategories());
            }
        };
        threadIOExecutor.execute(findAllCategoriesRnb);
    }
    public void findCategoryByName(MutableLiveData<Category> categoryMutableLiveData,String name){
        Runnable findCategoryByNameRnb = new Runnable() {
            @Override
            public void run() {
                categoryMutableLiveData.postValue(categoryDao.findCategoryByName(name));
            }
        };
        threadIOExecutor.execute(findCategoryByNameRnb);
    }
}
