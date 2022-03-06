package com.example.todoapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentYapilacakIsDetayBinding
import com.example.todoapp.viewmodel.YapilacakDetayVMF
import com.example.todoapp.viewmodel.YapilacakDetayViewModel


class YapilacakIsDetayFragment : Fragment() {
    private lateinit var tasarim : FragmentYapilacakIsDetayBinding
    private lateinit var viewModel : YapilacakDetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacak_is_detay,container, false)

        tasarim.yapilacakIsDetayFragment = this
        tasarim.toolbarDetayBaslik = "Yapılacak Detay"

        val bundle:YapilacakIsDetayFragmentArgs by navArgs()
        val yapilacakIs = bundle.yapilacakIs

        tasarim.isNesnesi = yapilacakIs
        return tasarim.root

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : YapilacakDetayViewModel by viewModels() {
            YapilacakDetayVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    fun buttonGuncelleTikla(yapilacak_id:Int,yapilacak_is:String){
        viewModel.guncelle(yapilacak_id,yapilacak_is)
    }



}