package com.smedialink.tokenplussteamid.interactor

import io.reactivex.Single

interface SingleUseCase<T> {

    fun execute(): Single<T>
}
