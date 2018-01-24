package com.smedialink.tokenplussteamid.usecase

import io.reactivex.Single

interface SingleUseCase<T> {

    fun execute(): Single<T>
}
