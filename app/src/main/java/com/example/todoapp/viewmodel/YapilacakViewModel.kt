package com.example.todoapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.entity.Yapilacak
import com.example.todoapp.repo.YapilacakRepository

class YapilacakViewModel(application: Application) : AndroidViewModel(application) {

    var yapilacakListesi =  MutableLiveData<List<Yapilacak>>()
    val yrepo = YapilacakRepository(application)

    init {
        yapilacaklariYukle()
        yapilacakListesi = yrepo.yapilacaklariGetir()
    }

    fun ara(aramaKelimesi:String){
        yrepo.yapilacakAra(aramaKelimesi)
    }
    fun sil(kisi_id:Int){
        yrepo.yapilacakSil(kisi_id)
    }
    fun yapilacaklariYukle(){
        yrepo.tumYapilacaklariAl()
    }

}