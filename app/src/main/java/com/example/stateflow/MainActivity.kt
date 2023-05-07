package com.example.stateflow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.stateflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel:MyViewModel= ViewModelProvider(this)[MyViewModel::class.java]
        val _binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        _binding.viewModel = viewModel
        _binding.lifecycleOwner = this
    }
}