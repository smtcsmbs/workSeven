package com.example.todoapp.repo

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.entity.Yapilacak
import com.example.todoapp.room.Veritabani
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class YapilacakRepository(application: Application) {
    var yapilacakListesi : MutableLiveData<List<Yapilacak>>

    var vt : Veritabani

    init {
        yapilacakListesi = MutableLiveData()
        vt = Veritabani.veritabaniErisim(application)!!
    }

    fun yapilacaklariGetir() : MutableLiveData<List<Yapilacak>>{
        return yapilacakListesi
    }

    fun yapilacakKayit(yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val yeniKayit = Yapilacak(0,yapilacak_is)
            vt.yapilacakDao().yapilacakEkle(yeniKayit)
        }
    }
    fun yapilacakGuncelle(yapilacak_id:Int,yapilacak_is:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val guncellenenIs = Yapilacak(yapilacak_id,yapilacak_is)
            vt.yapilacakDao().yapilacakGuncelle(guncellenenIs)
        }
    }
    fun yapilacakAra(aramaKelimesi:String){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacakListesi.value = vt.yapilacakDao().yapilacakArama(aramaKelimesi)
        }
    }
    fun yapilacakSil(kisi_id:Int){
        val job = CoroutineScope(Dispatchers.Main).launch {
            val silinenYapilacak = Yapilacak(kisi_id,"")
            vt.yapilacakDao().yapilacakSil(silinenYapilacak)
            tumYapilacaklariAl()
        }
    }

    fun tumYapilacaklariAl(){
        val job = CoroutineScope(Dispatchers.Main).launch {
            yapilacakListesi.value = vt.yapilacakDao().tumIsler()
        }
    }


}