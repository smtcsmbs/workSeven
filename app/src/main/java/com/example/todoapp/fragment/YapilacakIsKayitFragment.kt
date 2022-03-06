package com.example.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentYapilacakIsKayitBinding
import com.example.todoapp.viewmodel.YapilacakKayitVMF
import com.example.todoapp.viewmodel.YapilacakKayitViewModel


class YapilacakIsKayitFragment : Fragment() {
    private lateinit var tasarim : FragmentYapilacakIsKayitBinding
    private lateinit var viewModel : YapilacakKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacak_is_kayit,container,false)
        tasarim.yapilacakKayitFragment = this

        tasarim.toolbarKayitBaslik = "Yapılacak Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val tempViewModel : YapilacakKayitViewModel by viewModels(){
            YapilacakKayitVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }


    fun butonKaydetTıkla(yapilacak_is:String){
        viewModel.kayit(yapilacak_is)
    }

    }

