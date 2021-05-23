package com.example.databindingdata

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.databindingdata.R
import com.example.databindingdata.databinding.ActivityMainBinding
import com.example.databindingdata.modelData.User

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var userData: User = User("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.user = userData

        binding.showTextButton.setOnClickListener {

            binding.apply {
                userData.name = "Amir"
                invalidateAll()
            }

        }

    }
}