package com.example.abyte

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_statement.*


class StatementActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statement)
        setSupportActionBar(toolbar)
        val a = intent.extras!!.get(Constants.KEY_USER)

        // Begin the transaction

        // Begin the transaction
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.replace(R.id.frame, FragmentStatement.newInstance(a.toString()))
        ft.commit()
        imglogout.setOnClickListener {
            returnLogin()
        }
    }

    fun returnLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}