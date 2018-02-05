package com.smedialink.tokenplussteamid.features.matches.matchdetails

import com.smedialink.tokenplussteamid.basic.BasePresenter
import com.smedialink.tokenplussteamid.entity.Hero
import com.smedialink.tokenplussteamid.features.matches.HeroFactory
import io.reactivex.Single

/**
 * Created by six_hundreds on 05.02.18.
 */
class MatchDetailsPresenter : BasePresenter<MatchDetailsView>(), HeroFactory {

    override fun getHero(heroId: Int): Single<Hero> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}