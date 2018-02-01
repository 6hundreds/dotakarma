package com.smedialink.tokenplussteamid.data.dao;

import android.arch.persistence.room.Insert;

import java.util.List;

/**
 * Created by six_hundreds on 31.01.18.
 */

public interface BaseDao<T> {

    @Insert
    void insert(T entity);

    @Insert
    void insert(List<T> entity);
}
