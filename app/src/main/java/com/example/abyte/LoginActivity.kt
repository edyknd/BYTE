package com.example.abyte

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnIngresar.setOnClickListener {
            when {
                txtUsuario.text.length < 8 -> {
                    Toast.makeText(this, getString(R.string.usuario_invalido), Toast.LENGTH_SHORT)
                        .show()

                }
                txtContraseña.text.length < 6 -> {
                    Toast.makeText(
                        this,
                        getString(R.string.contrasena_invalida),
                        Toast.LENGTH_SHORT
                    ).show()

                }
                else -> {
                    val i = Intent(this, StatementActivity::class.java)
                    i.putExtra(Constants.KEY_USER, txtUsuario.text)
                    startActivity(i)
                    finish()
                }
            }
        }
    }
}