package com.smedialink.tokenplussteamid.features.steamauth

import android.annotation.SuppressLint
import android.webkit.WebView
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_steam_auth.*
import javax.inject.Inject

class SteamAuthFragment : BaseFragment(), SteamAuthView {

    companion object {
        fun getNewInstance() = SteamAuthFragment()
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

        webview_auth_steam?.apply {
            settings?.javaScriptEnabled = true
            settings?.setAppCacheEnabled(false)
            settings?.loadWithOverviewMode = true
            settings?.useWideViewPort = true
            scrollBarStyle = WebView.SCROLLBARS_OUTSIDE_OVERLAY
            isScrollbarFadingEnabled = false
        }

//        webview_auth_steam?.webViewClient = object : WebViewClient() {
//
//            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
//
//                val parsedUrl = Uri.parse(url)
//
//                if (parsedUrl.authority.contains(REDIRECT_SUCCESS_AUTHORITY_MARKER)) {
//
//                    Timber.d("Redirect completed, parsing user steamId...")
//
//                    val userUrl = Uri.parse(parsedUrl.getQueryParameter("openid.identity"))
//                    val steamUserId = userUrl.lastPathSegment
//
//                    webview_auth_steam?.stopLoading()
//                    presenter.navigateToRegistrationCompletedPage()
//                    presenter.saveDetectedSteamUserId(steamUserId)
//
//                    Timber.d("Detected steamId: $steamUserId")
//                }
//            }
//        }
    }

    override fun displaySteamAuthWebsite() {

    }

    override fun clearWebView() {
        webview_auth_steam?.apply {
            clearHistory()
            clearCache(true)
            loadUrl("about:blank")
        }
    }
}
