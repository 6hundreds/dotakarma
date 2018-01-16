package com.smedialink.tokenplussteamid.data.network

import com.smedialink.tokenplussteamid.data.entity.RegisteredPlayerEntity
import io.reactivex.Completable
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class MockServerApiImpl : ServerApi {

    override fun sendRegistrationCompleRequest(login: String, password: String): Completable =
            Completable.complete()

    override fun loadPlayerProfile(): Single<RegisteredPlayerEntity> =

            Single.just(
                    RegisteredPlayerEntity(
                            steamid = 76561197960435530L,
                            communityvisibilitystate = 3,
                            profilestate = 1,
                            personaname = "Robin",
                            lastlogoff = 1515655149L,
                            profileurl = "http://steamcommunity.com/id/robinwalker/",
                            avatar = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/f1/f1dd60a188883caf82d0cbfccfe6aba0af1732d4.jpg",
                            avatarmedium = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/f1/f1dd60a188883caf82d0cbfccfe6aba0af1732d4_medium.jpg",
                            avatarfull = "https://steamcdn-a.akamaihd.net/steamcommunity/public/images/avatars/f1/f1dd60a188883caf82d0cbfccfe6aba0af1732d4_full.jpg",
                            personastate = 0,
                            realname = "Robin Walker",
                            primaryclanid = 103582791429521412L,
                            timecreated = 1063407589L,
                            personastateflags = 0,
                            loccountrycode = "US",
                            locstatecode = "WA",
                            loccityid = 3961))
                    .delay(2, TimeUnit.SECONDS)
}