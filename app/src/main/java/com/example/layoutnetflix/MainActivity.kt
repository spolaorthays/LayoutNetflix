package com.example.layoutnetflix

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.layoutnetflix.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TODO remover a barra de "LayoutNetflix" do app
        binding = bind(R.layout.activity_main) {
            viewmodel = viewModel
            lifecycleOwner = this@MainActivity
        }

        setupRecyclerView()
    }

    fun setupRecyclerView() {
        binding.recyclerUsers.layoutManager = GridLayoutManager(this, 2)
        viewModel.userList.observe(this, Observer {
            binding.recyclerUsers.adapter = MainRecyclerView(viewModel, it)
        })
    }

}