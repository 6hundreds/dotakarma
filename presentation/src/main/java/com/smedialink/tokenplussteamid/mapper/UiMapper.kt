package com.smedialink.tokenplussteamid.mapper

/**
 * Created by six_hundreds on 02.04.18.
 */
interface UiMapper<PresentationEntity, DomainEntity> {

    fun mapToUi(input: DomainEntity): PresentationEntity

    fun mapToDomain(input: PresentationEntity): DomainEntity =
            throw UnsupportedOperationException("$this not supporting mapping to domain layer")

}