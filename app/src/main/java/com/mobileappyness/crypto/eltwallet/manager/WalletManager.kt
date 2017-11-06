package com.mobileappyness.crypto.eltwallet.manager

import android.content.Context
import android.preference.PreferenceManager
import com.beust.klaxon.JsonObject
import com.beust.klaxon.Parser
import com.google.gson.Gson
import com.mobileappyness.crypto.eltwallet.model.Wallet
import android.R.attr.key
import android.R.id.edit
import android.content.SharedPreferences


/**
 * Created by olivermahoney on 06/11/2017.
 */
object WalletManager {

    private val walletKey: String = "WALLET"
    private val gson = Gson()

    fun getWallet(context: Context): Wallet? {

        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        var wallet: Wallet? = null

        if (preferences != null) {
            var walletString = preferences.getString(walletKey, null)
            wallet = gson.fromJson(walletString, Wallet::class.java)
        }

        return wallet
    }

    fun setWallet(context: Context, wallet: Wallet){
        val json = gson.toJson(wallet)
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        if (preferences != null) {
            val editor = preferences.edit()
            editor.putString(walletKey, json)
            editor.commit()
        }
    }
}