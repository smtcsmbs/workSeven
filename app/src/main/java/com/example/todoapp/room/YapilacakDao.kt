package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.entity.Yapilacak

    @Dao
    interface YapilacakDao {
        @Query("SELECT * FROM yapilacak")
        suspend fun tumIsler() : List<Yapilacak>

        @Insert
        suspend fun yapilacakEkle(yapilacak:Yapilacak)

        @Update
        suspend fun yapilacakGuncelle(yapilacak:Yapilacak)

        @Delete
        suspend fun yapilacakSil(yapilacak: Yapilacak)

        @Query("SELECT * FROM yapilacak WHERE yapilacak_ad like '%'|| :aramaKelimesi ||'%'")
        suspend fun yapilacakArama(aramaKelimesi:String) : List<Yapilacak>

    }