package com.smedialink.tokenplussteamid.features.steamauth

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebView
import android.webkit.WebViewClient
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_steam_auth_step.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject


// TEST ACCOUNT:
// smltest;02720272qQ

// Steam UserId: 76561198804763988

class SteamAuthFragment : BaseFragment(), SteamAuthView {

    companion object {
        fun getNewInstance() = SteamAuthFragment()

        private const val APP_NAME = "TokenPlusSteamId"
    }

    override val layoutId: Int
        get() = R.layout.fragment_steam_auth_step

    private val steamAuthUrl: String by lazy {
        val urlTemplate = resources.getString(R.string.constant_steam_auth_url)
        String.format(Locale.getDefault(), urlTemplate, APP_NAME)
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: SteamAuthPresenter

    @ProvidePresenter
    fun providePresenter() = presenter

    override fun onResume() {
        super.onResume()
        presenter.loadSteamAuthPage()
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun initWebView() {
        webview_auth_steam?.settings?.javaScriptEnabled = true
        webview_auth_steam?.settings?.setAppCacheEnabled(false)
        webview_auth_steam?.settings?.loadWithOverviewMode = true
        webview_auth_steam?.settings?.useWideViewPort = true
        webview_auth_steam?.scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
        webview_auth_steam?.isScrollbarFadingEnabled = false

        webview_auth_steam?.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {

                val parsedUrl = Uri.parse(url)

                if (parsedUrl.authority == APP_NAME.toLowerCase()) {

                    val userUrl = Uri.parse(parsedUrl.getQueryParameter("openid.identity"))
                    val steamUserId = userUrl.lastPathSegment

                    webview_auth_steam?.stopLoading()
                    presenter.navigateToRegistrationCompletedPage()

                    Timber.d("DETECTED STEAM USER ID: $steamUserId")
                }
            }
        }
    }

    override fun displaySteamAuthWebsite() {
        webview_auth_steam?.loadUrl(steamAuthUrl)
    }

    override fun clearWebView() {
        webview_auth_steam?.clearHistory()
        webview_auth_steam?.clearCache(true)
        webview_auth_steam?.loadUrl("about:blank")
    }
}
