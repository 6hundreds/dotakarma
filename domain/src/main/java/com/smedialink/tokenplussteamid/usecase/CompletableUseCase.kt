package com.smedialink.tokenplussteamid.usecase

import io.reactivex.Completable

interface CompletableUseCase {

    fun execute(): Completable
}
