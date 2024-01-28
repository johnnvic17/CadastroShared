package com.example.cadastroshared.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cadastroshared.R
import com.example.cadastroshared.databinding.ActivitySignupBinding
import com.example.cadastroshared.infra.UserConstants
import com.example.cadastroshared.infra.UserPreferences

class SignUpActivity: AppCompatActivity(), View.OnClickListener {
    private lateinit var bindingSignUp: ActivitySignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingSignUp =  ActivitySignupBinding.inflate(layoutInflater)
        setContentView(bindingSignUp.root)

        bindingSignUp.btnSignUp.setOnClickListener(this)

        verifySignUp()
    }

    override fun onClick(viewSign: View) {
        if(viewSign.id == R.id.btn_sign_up){

        handleInfo()
        }
    }

    private fun handleInfo(){

        if(validate()){

            //recebendo os dados do usuário
            val name = bindingSignUp.editName.text.toString()
            val email = bindingSignUp.editEmail.text.toString()
            val age = bindingSignUp.editAge.text.toString().toInt()

            //salvar os dados no Shared
            UserPreferences(this).saveString(UserConstants.KEY.USER_NAME, name)
            UserPreferences(this).saveString(UserConstants.KEY.USER_EMAIL, email)
            UserPreferences(this).saveNumber(UserConstants.KEY.USER_AGE, age)

            //Ir para Main e fechar o cadastro
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        } else {

            Toast.makeText(this, R.string.validate_all_fields, Toast.LENGTH_SHORT).show()
        }

    }

    private fun validate(): Boolean{

        return (bindingSignUp.editName.text.toString() != ""
                && bindingSignUp.editEmail.text.toString() != ""
                && bindingSignUp.editAge.text.toString() != ""
                && bindingSignUp.editAge.text.toString().toInt() != 0)
    }

    private fun verifySignUp(){

        val verifySign = UserPreferences(this).getString(UserConstants.KEY.USER_NAME)

        if(verifySign != ""){

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}