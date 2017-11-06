package com.mobileappyness.crypto.eltwallet.manager

import android.content.Context
import android.graphics.Bitmap
import android.os.Build
import android.support.annotation.RequiresApi
import android.webkit.*


/**
 * Created by olivermahoney on 06/11/2017.
 */
class NewWalletManager {


    fun importWalletWithPrivateKey(context: Context){

        var webView = WebView(context)
        val webSettings = webView.getSettings()
        webSettings.setJavaScriptEnabled(true)

        val webViewClient: WebViewClient = object: WebViewClient() {

            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                view?.loadUrl(request?.url.toString())
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {

                webView.loadUrl("javascript:myFunction()");

                super.onPageFinished(view, url)
            }
        }

        webView.webViewClient = webViewClient
        webView.settings.javaScriptEnabled = true
        webView.settings.defaultTextEncodingName = "utf-8"
        webView.loadUrl("/app/src/main/assets/index.html")
    }
}