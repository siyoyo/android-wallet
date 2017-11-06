package com.mobileappyness.crypto.eltwallet.model

/**
 * Created by olivermahoney on 06/11/2017.
 */
data class Wallet (
    var address: String,
    var checksumAddress: String,
    var encrypted: Boolean,
    var privKey: String,
    var pubKey: String,
    var publisher: String,
    var version: Int
)