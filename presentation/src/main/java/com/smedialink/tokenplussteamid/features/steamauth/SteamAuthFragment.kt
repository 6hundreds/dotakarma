package com.smedialink.tokenplussteamid.features.steamauth

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_steam_auth.*
import javax.inject.Inject

class SteamAuthFragment : BaseFragment(), SteamAuthView {

    companion object {
        fun getNewInstance() = SteamAuthFragment()

        private const val AUTH_URL = "https://0a0b9101.ngrok.io/api/steam"
        private const val URL_MARKER = "dotakarma"
    }

    override val layoutId: Int
        get() = R.layout.fragment_steam_auth

    @Inject
    @InjectPresenter
    lateinit var presenter: SteamAuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter


    @SuppressLint("SetJavaScriptEnabled")
    override fun initWebView() {

        with(webview_auth_steam.settings) {
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }

        webview_auth_steam?.webViewClient = object : WebViewClient() {

            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                if (url.contains(URL_MARKER)) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                    return true
                }
                return false
            }
        }
    }

    override fun displaySteamAuthWebsite() {
        webview_auth_steam.loadUrl(AUTH_URL)
    }

    override fun clearWebView() {
        with(webview_auth_steam) {
            clearHistory()
            clearCache(true)
            loadUrl("about:blank")
        }
    }
}
