package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.todoapp.repo.YapilacakRepository

class YapilacakDetayViewModel(application:Application):AndroidViewModel(application) {
    val yrepo = YapilacakRepository(application)

    fun guncelle(yapilacak_id:Int,yapilacak_is:String){
        yrepo.yapilacakGuncelle(yapilacak_id,yapilacak_is)
    }


}