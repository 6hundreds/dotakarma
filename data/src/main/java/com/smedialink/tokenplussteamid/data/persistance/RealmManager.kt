package com.smedialink.tokenplussteamid.data.persistance

import io.reactivex.Observable
import io.reactivex.Single
import io.realm.Realm
import io.realm.RealmChangeListener
import io.realm.RealmModel
import io.realm.RealmResults
import io.realm.exceptions.RealmException
import javax.inject.Inject

/**
 * Created by six_hundreds on 03.04.18.
 */
class RealmManager  {

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

    fun <T : RealmModel> findOneAsync(field: String, value: Int, clazz: Class<T>): Single<T> =
            Single.create { emitter ->
                with(Realm.getDefaultInstance()) {
                    where(clazz)
                            .equalTo(field, value)
                            .findFirst()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find $clazz with $field == $value in Realm"))
                    close()
                }
            }

    fun <T : RealmModel> findOneAsync(field: String, value: Long, clazz: Class<T>): Single<T> =
            Single.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where(clazz)
                            .equalTo(field, value)
                            .findFirst()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find $clazz with $field == $value in Realm"))
                    close()
                }
            })

    fun <T : RealmModel> findOneAsync(field: String, value: String, clazz: Class<T>): Single<T> =
            Single.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where(clazz)
                            .equalTo(field, value)
                            .findFirst()
                            ?.let { emitter.onSuccess(copyFromRealm(it)) }
                            ?: emitter.onError(RealmException("Can't find $clazz with $field == $value in Realm"))
                    close()
                }
            })

    fun <T : RealmModel> observableQuery(field: String, value: Int, clazz: Class<T>): Observable<List<T>> =
            Observable.create({ emitter ->
                with(Realm.getDefaultInstance()) {
                    where(clazz)
                            .equalTo(field, value)
                            .findAll()
                            .addChangeListener(RealmChangeListener<RealmResults<T>> { emitter.onNext(copyFromRealm(it)) })
                    close()
                }
            })
}