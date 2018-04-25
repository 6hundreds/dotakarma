package com.smedialink.tokenplussteamid.errorhandling

import com.google.gson.Gson
import com.smedialink.tokenplussteamid.R
import com.smedialink.tokenplussteamid.base.CanShowError
import com.smedialink.tokenplussteamid.common.ext.weak
import com.smedialink.tokenplussteamid.data.manager.ResourceManager
import retrofit2.HttpException
import timber.log.Timber
import java.io.IOException
import java.lang.ref.WeakReference
import javax.inject.Inject

/**
 * Created by six_hundreds on 12.04.18.
 */
class DefaultErrorHandler @Inject constructor(private val resourceManager: ResourceManager)
    : ErrorHandler {

    private lateinit var view: WeakReference<CanShowError>

    override fun proceed(error: Throwable) {
        Timber.e(error)

        val view = view.get()
                ?: throw IllegalStateException("View must be attached to ErrorHandler")

        val message = when (error) {
            is HttpException -> when (error.code()) {
                401 -> resourceManager.getString(R.string.error_unauthorized)
                500 -> resourceManager.getString(R.string.error_server)
                else -> extractErrorMessage(error)
            }
            is IOException -> {
                resourceManager.getString(R.string.error_network)
            }
            else -> resourceManager.getString(R.string.error_unknown)
        }

        view.showError(message)
    }

    override fun attachView(view: CanShowError) {
        this.view = view.weak()
    }

    override fun detachView() {
        view.clear()
    }

    private fun extractErrorMessage(error: HttpException): String =
            error.response().errorBody()?.let { body ->
                Gson().fromJson(body.string(), ServerError::class.java).message
            } ?: resourceManager.getString(R.string.error_unknown)
}