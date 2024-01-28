package com.example.cadastroshared.infra

import android.content.Context
import android.content.SharedPreferences

class UserPreferences(context: Context) {

    private val userInfo: SharedPreferences =
        context.getSharedPreferences("USER_INFO", Context.MODE_PRIVATE)

    fun saveString(key: String, str: String){

        userInfo.edit().putString(key, str).apply()
    }

    fun getString(key: String): String{

        return userInfo.getString(key, "") ?: ""
    }

    fun saveNumber(key: String, num: Int){

        userInfo.edit().putInt(key, num).apply()
    }

    fun getNumber(key: String): Int {

        return userInfo.getInt(key, 0) ?: 0
    }
}