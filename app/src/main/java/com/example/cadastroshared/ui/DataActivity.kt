package com.example.cadastroshared.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cadastroshared.R
import com.example.cadastroshared.databinding.ActivityDataBinding
import com.example.cadastroshared.infra.UserConstants
import com.example.cadastroshared.infra.UserPreferences

class DataActivity : AppCompatActivity() {
    private lateinit var bindingData: ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingData = ActivityDataBinding.inflate(layoutInflater)
        setContentView(bindingData.root)

        userInfo()

    }

    private fun userInfo(){

        val nameData = UserPreferences(this).getString(UserConstants.KEY.USER_NAME)
        bindingData.textUserName.text = "Nome: $nameData"

        val emailData = UserPreferences(this).getString(UserConstants.KEY.USER_EMAIL)
        bindingData.textUserEmail.text = "E-mail: $emailData"

        val ageData = UserPreferences(this).getNumber(UserConstants.KEY.USER_AGE)
        bindingData.textUserAge.text = "Idade: $ageData"
    }
}