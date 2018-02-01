package com.smedialink.tokenplussteamid.usecase.heroes

import com.smedialink.tokenplussteamid.repository.IHeroImageRepository
import com.smedialink.tokenplussteamid.usecase.SingleUseCaseWithParameter
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class GetHeroImageUseCase @Inject constructor(private val repository: IHeroImageRepository)
    : SingleUseCaseWithParameter<Int, String> {

    override fun execute(parameter: Int): Single<String> =
            repository.getHeroImage(parameter)
                    .map { it.imageUrl }
}