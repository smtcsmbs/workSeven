package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.repo.YapilacakRepository

class YapilacakKayitViewModel(application: Application) : AndroidViewModel(application) {

    val yrepo = YapilacakRepository(application)

    fun kayit(yapilacak_ad:String){
        yrepo.yapilacakKayit(yapilacak_ad)
    }
}