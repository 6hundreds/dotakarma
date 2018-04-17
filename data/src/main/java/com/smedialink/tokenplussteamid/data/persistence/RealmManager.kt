package com.smedialink.tokenplussteamid.data.persistence

import io.reactivex.Observable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmModel
import io.realm.exceptions.RealmException
import io.realm.kotlin.delete
import io.realm.kotlin.where

/**
 * Created by six_hundreds on 03.04.18.
 */
class RealmManager {

    fun saveOrUpdate(model: RealmModel) {
        with(Realm.getDefaultInstance()) {
            executeTransaction { realm -> realm.copyToRealmOrUpdate(model) }
            close()
        }
    }

    fun saveOrUpdate(models: Iterable<RealmModel>) {
        with(Realm.getDefaultInstance()) {
            executeTransaction { realm -> realm.copyToRealmOrUpdate(models) }
            close()
        }
    }

    inline fun <reified T : RealmModel> clearTable() {
        with(Realm.getDefaultInstance()) {
            executeTransaction { realm -> realm.delete<T>() }
            close()
        }
    }

    inline fun <reified T : RealmModel> findOneAsync(field: String, value: Int): Single<T> =
            Single.create { emitter ->
                with(Realm.getDefaultInstance()) {
                    where<T>()
                            .equalTo(field, value)
                            .findFirst()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find ${T::class} with $field == $value in Realm"))
                    close()
                }
            }

    inline fun <reified T : RealmModel> findOneAsync(field: String, value: Long): Single<T> =
            Single.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where<T>()
                            .equalTo(field, value)
                            .findFirst()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find ${T::class} with $field == $value in Realm"))
                    close()
                }
            })

    inline fun <reified T : RealmModel> findOneAsync(field: String, value: String): Single<T> =
            Single.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where<T>()
                            .equalTo(field, value)
                            .findFirst()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find ${T::class} with $field == $value in Realm"))
                    close()
                }
            })

    inline fun <reified T : RealmModel> findAllAsync(): Single<List<T>> =
            Single.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where<T>()
                            .findAll()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find ${T::class} in Realm"))
                    close()
                }
            })


    inline fun <reified T : RealmModel> observableQuery(field: String, value: Int): Observable<List<T>> =
            Observable.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where<T>()
                            .equalTo(field, value)
                            .findAll()
                            .asChangesetObservable()
                            .subscribe { emitter.onNext(copyFromRealm(it.collection)) }
                    close()
                }
            })
}