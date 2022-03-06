package com.example.todoapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "yapilacak")
data class Yapilacak(@PrimaryKey(autoGenerate = true)
                     @ColumnInfo(name = "yapilacak_id") @NotNull var yapilacak_id:Int,
                     @ColumnInfo(name = "yapilacak_ad") @NotNull var yapilacak_ad:String) : Serializable {

}
