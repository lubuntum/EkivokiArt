package com.pavel.ekivoki.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "category",
        indices = {@Index(value = "category_name",unique = true)})
public class Category {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "category_name")
    private String categoryName;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name="image_resource")
    private int imageResourceId;

    @Ignore
    private List<Word> words;

    public Category(){}
    @Ignore
    public Category(String categoryName){
        this.categoryName = categoryName;
    }
    @Ignore
    public Category(String categoryName, int imageResourceId){
        this.categoryName = categoryName;
        this.imageResourceId = imageResourceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
