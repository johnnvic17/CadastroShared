package com.example.cadastroshared.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.cadastroshared.R
import com.example.cadastroshared.databinding.ActivityMainBinding
import com.example.cadastroshared.infra.UserConstants
import com.example.cadastroshared.infra.UserPreferences

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgProfile.setOnClickListener(this)

        handleUserName()
    }

    override fun onClick(view: View) {
        if(view.id == R.id.img_profile){
            userData()
        }
    }

    private fun userData(){

        startActivity(Intent(this, DataActivity::class.java))
    }

    private fun handleUserName(){

        val userName = UserPreferences(this).getString(UserConstants.KEY.USER_NAME)
        binding.textWelcome.text = "Olá, $userName"
    }
}