package com.example.todoapp.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapp.R
import com.example.todoapp.adapter.YapilacakAdapter
import com.example.todoapp.databinding.FragmentYapilacaklarBinding
import com.example.todoapp.entity.Yapilacak
import com.example.todoapp.viewmodel.YapilacakVMF
import com.example.todoapp.viewmodel.YapilacakViewModel


class YapilacaklarFragment : Fragment(),  androidx.appcompat.widget.SearchView.OnQueryTextListener {
    private lateinit var tasarim : FragmentYapilacaklarBinding
    private lateinit var viewModel : YapilacakViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_yapilacaklar,container, false)

        tasarim.yapilacakFragment = this
        tasarim.toolbarYapilacakBaslik = "Yapilacaklar"

        (activity as AppCompatActivity).setSupportActionBar(tasarim.toolbarYapilacaklar)


        viewModel.yapilacakListesi.observe(viewLifecycleOwner,{
            val adapter = YapilacakAdapter(requireContext(),it,viewModel)
            tasarim.yapilacakAdapter = adapter
        })

        val yapilacakListesi = ArrayList<Yapilacak>()


        val adapter = YapilacakAdapter(requireContext(),yapilacakListesi,viewModel)
        tasarim.yapilacakAdapter = adapter


        return tasarim.root
    }

    fun fabTikla(v:View){
        Navigation.findNavController(v).navigate(R.id.kayitGecis)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        val tempViewModel : YapilacakViewModel by viewModels() {
            YapilacakVMF(requireActivity().application)
        }
        viewModel = tempViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbar_menu,menu)

        val item = menu.findItem(R.id.action_ara)
        val searchView = item.actionView as androidx.appcompat.widget.SearchView
        searchView.setOnQueryTextListener(this)

        super.onCreateOptionsMenu(menu, inflater)

    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }

}