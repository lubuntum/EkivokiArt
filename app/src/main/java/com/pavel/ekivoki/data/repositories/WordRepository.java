package com.pavel.ekivoki.data.repositories;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.pavel.ekivoki.data.Database;
import com.pavel.ekivoki.data.dao.WordDao;
import com.pavel.ekivoki.data.entity.Word;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WordRepository {
    private Database database;
    private final Executor threadIOExecutor;

    private final WordDao wordDao;
    private static volatile WordRepository INSTANCE = null;
    public static WordRepository getInstance(Application application){
        if (INSTANCE == null){
            synchronized (WordRepository.class){
                if (INSTANCE == null){
                    INSTANCE = new WordRepository(application);
                }
            }
        }
        return INSTANCE;
    }
    public WordRepository(Application application){
        database = Database.getInstance(application);
        threadIOExecutor = Executors.newCachedThreadPool();

        wordDao = database.wordDao();
    }

    public void findAllWordsByCategoryId(MutableLiveData<List<Word>> words, Long categoryId){
        Runnable findAllWordsByCategoryIdRnb = new Runnable() {
            @Override
            public void run() {
                wordDao.findAllWordsByCategoryId(categoryId);
            }
        };
        threadIOExecutor.execute(findAllWordsByCategoryIdRnb);
    }

    public void insert(Word word){
        Runnable insertRnb = new Runnable() {
            @Override
            public void run() {
                wordDao.insert(word);
            }
        };
        threadIOExecutor.execute(insertRnb);
    }
    public void delete(Word word){
        Runnable deleteRnb = new Runnable() {
            @Override
            public void run() {
                wordDao.delete(word);
            }
        };
        threadIOExecutor.execute(deleteRnb);
    }

}
