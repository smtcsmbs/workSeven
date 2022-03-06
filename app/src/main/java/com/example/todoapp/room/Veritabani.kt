package com.example.todoapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.todoapp.entity.Yapilacak

@Database(entities = [Yapilacak::class], version = 1)
abstract  class Veritabani : RoomDatabase() {
    abstract fun yapilacakDao() : YapilacakDao

    companion object {
        var INSTANCE : Veritabani? = null

        fun veritabaniErisim(context: Context) : Veritabani? {
            if (INSTANCE == null) {
                synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,Veritabani::class.java,"yapilacak.sqlite").createFromAsset("yapilacak.sqlite").build()
                }
            }
            return INSTANCE
        }
    }
}