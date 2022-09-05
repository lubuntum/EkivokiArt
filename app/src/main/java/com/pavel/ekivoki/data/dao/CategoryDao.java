package com.pavel.ekivoki.data.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.pavel.ekivoki.data.entity.Category;

import java.util.List;

@Dao
public interface CategoryDao {
    @Query("select * from category")
    List<Category> getAllCategories();
    @Query("select * from category where :categoryName == category_name")
    Category findCategoryByName(String categoryName);
    @Insert(onConflict = REPLACE)
    void insert(Category category);
    @Delete()
    void delete(Category category);
}
