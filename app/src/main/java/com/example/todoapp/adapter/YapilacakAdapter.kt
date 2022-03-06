package com.example.todoapp.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.databinding.CardDesignBinding
import com.example.todoapp.entity.Yapilacak
import com.example.todoapp.fragment.YapilacaklarFragmentDirections
import com.example.todoapp.viewmodel.YapilacakViewModel
import com.google.android.material.snackbar.Snackbar

class YapilacakAdapter(var mContext: Context, var yapilacakListesi:List<Yapilacak>, var viewModel:YapilacakViewModel)
    : RecyclerView.Adapter<YapilacakAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(tasarim: CardDesignBinding) : RecyclerView.ViewHolder(tasarim.root){
        var tasarim: CardDesignBinding
        init {
            this.tasarim = tasarim
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val layoutInflater = LayoutInflater.from(mContext)
        val tasarim = CardDesignBinding.inflate(layoutInflater,parent,false)
        return CardTasarimTutucu(tasarim)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val yapilacakIs = yapilacakListesi.get(position)
        val t = holder.tasarim

        t.yapilacakNesnesi = yapilacakIs

        t.satirCard.setOnClickListener {
            val gecis = YapilacaklarFragmentDirections.detayGecis(yapilacakIs = yapilacakIs)
            Navigation.findNavController(it).navigate(gecis)
        }

        t.imageView.setOnClickListener{
            Snackbar.make(it,"${yapilacakIs.yapilacak_ad} silinsin mi?",Snackbar.LENGTH_LONG)
                .setAction("EVET") {viewModel.sil(yapilacakIs.yapilacak_id)}.show()
        }
    }

    override fun getItemCount(): Int {
        return yapilacakListesi.size
    }
}