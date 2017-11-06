package com.mobileappyness.crypto.eltwallet

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.mobileappyness.crypto.eltwallet.manager.NewWalletManager
import com.mobileappyness.crypto.eltwallet.manager.WalletManager

import kotlinx.android.synthetic.main.activity_new_wallet.*

class NewWalletActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_wallet)
        setSupportActionBar(toolbar)

        var newWalletButton = findViewById<Button>(R.id.newWalletButton)
        newWalletButton.setOnClickListener {
            importWallet()
        }
    }

    fun importWallet(){
        NewWalletManager().importWalletWithPrivateKey(this)

    }

}
