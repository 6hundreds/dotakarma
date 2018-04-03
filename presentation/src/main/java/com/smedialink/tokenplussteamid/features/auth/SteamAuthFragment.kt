package com.smedialink.tokenplussteamid.features.auth

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.app.Layout
import com.smedialink.tokenplussteamid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_steam_auth.*
import javax.inject.Inject

@Layout(R.layout.fragment_steam_auth)
class SteamAuthFragment : BaseFragment(), SteamAuthView {

    companion object {

        fun newInstance() = SteamAuthFragment()

        private const val AUTH_URL = "https://b3de5d2d.ngrok.io/api/steam"
        private const val DEEPLINK_SCHEME = "dotakarma"
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SteamAuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun showSteamPage() {
        webview_auth_steam.loadUrl(AUTH_URL)
    }

    override fun initUi() {
        with(webview_auth_steam.settings) {
            javaScriptEnabled = true
            cacheMode = WebSettings.LOAD_NO_CACHE
        }

        webview_auth_steam?.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                loading_indicator.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                loading_indicator.visibility = View.GONE
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
                if (url.contains(DEEPLINK_SCHEME)) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(url)
                    startActivity(intent)

                    return true
                }
                return false
            }
        }
    }
}
