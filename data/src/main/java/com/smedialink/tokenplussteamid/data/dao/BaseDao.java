package com.smedialink.tokenplussteamid.data.dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import java.util.List;

/**
 * Created by six_hundreds on 31.01.18.
 */

public interface BaseDao<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T entity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<T> entity);
}
