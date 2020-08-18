package com.example.abyte

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_statement.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class StatementActivity : AppCompatActivity() {

    val viewModel: StatementViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statement)
        setSupportActionBar(toolbar)
        val a = intent.extras!!.get(Constants.KEY_USER)
        txtUsuario.text = getString(R.string.bienvendio, a)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recycler.addItemDecoration(dividerItemDecoration)
        recycler.setHasFixedSize(true)
        recycler.layoutManager = LinearLayoutManager(this@StatementActivity)



        viewModel.getData()
        viewModel.data.observe(this, Observer {
            progressbar.visibility = View.GONE
            recycler.adapter = AdaptadorList(it, this)
        })

        btnConfirmar.setOnClickListener {
            returnLogin()
        }
        imglogout.setOnClickListener {
            returnLogin()
        }
    }

    fun returnLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }
}