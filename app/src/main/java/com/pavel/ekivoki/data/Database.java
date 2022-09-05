package com.pavel.ekivoki.data;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.pavel.ekivoki.data.dao.CategoryDao;
import com.pavel.ekivoki.data.dao.WordDao;
import com.pavel.ekivoki.data.entity.Category;
import com.pavel.ekivoki.data.entity.Word;

@androidx.room.Database(entities = {Category.class, Word.class},version = 1)
public abstract class Database extends RoomDatabase {
    private static final String DATABASE_NAME = "EkivokiDatabase";
    public static volatile Database INSTANCE = null;
    public abstract CategoryDao categoryDao();
    public abstract WordDao wordDao();

    public static Database getInstance(Context context){
        if (INSTANCE == null){
            synchronized (Database.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(
                            context,
                            Database.class,
                            DATABASE_NAME).build();
                }
            }
        }
        return INSTANCE;
    }
}
