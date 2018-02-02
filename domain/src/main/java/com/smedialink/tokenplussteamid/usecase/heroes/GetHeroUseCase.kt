package com.smedialink.tokenplussteamid.usecase.heroes

import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.repository.IHeroRepository
import com.smedialink.tokenplussteamid.usecase.SingleUseCaseWithParameter
import io.reactivex.Single
import javax.inject.Inject

/**
 * Created by six_hundreds on 01.02.18.
 */
class GetHeroUseCase @Inject constructor(private val repository: IHeroRepository)
    : SingleUseCaseWithParameter<Int, Hero> {

    override fun execute(parameter: Int): Single<Hero> =
            repository.getHero(parameter)
}