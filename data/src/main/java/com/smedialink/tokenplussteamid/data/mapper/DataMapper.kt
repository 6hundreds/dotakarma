package com.smedialink.tokenplussteamid.data.mapper

/**
 * Created by six_hundreds on 24.01.18.
 */
interface DataMapper<DataEntity, DomainEntity> {

    fun mapToData(input: DomainEntity): DataEntity

    fun mapToDomain(input: DataEntity): DomainEntity
}