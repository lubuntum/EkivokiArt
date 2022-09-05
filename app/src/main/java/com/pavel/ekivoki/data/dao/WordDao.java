package com.pavel.ekivoki.data.dao;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.pavel.ekivoki.data.entity.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Query("select * from word where :categoryId == category_id")
    List<Word> findAllWordsByCategoryId(Long categoryId);
    @Query("select * from word where :wordName == word")
    Word findWordByName(String wordName);
    @Insert(onConflict = REPLACE)
    void insert(Word word);
    @Delete()
    void delete(Word word);
}
