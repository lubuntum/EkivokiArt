package com.pavel.ekivoki.data.entity;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "word",
indices = {@Index(value = {"name"},unique = true)},
foreignKeys = {@ForeignKey(entity = Category.class,parentColumns = "id",childColumns = "category_id",onDelete = CASCADE)})
public class Word {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "category_id")
    private Long categoryId;
    @ColumnInfo(name = "word")
    private String word;

    public Word(){}
    @Ignore
    public Word(String word){
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
