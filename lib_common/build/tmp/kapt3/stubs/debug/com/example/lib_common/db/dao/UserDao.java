package com.example.lib_common.db.dao;

import java.lang.System;

/**
 * User 数据 Dao
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0002H\'\u00a8\u0006\t"}, d2 = {"Lcom/example/lib_common/db/dao/UserDao;", "Lcom/example/lib_common/db/dao/BaseDao;", "Lcom/example/lib_common/model/User;", "findUserByName", "name", "", "insertUser", "", "element", "lib_common_debug"})
public abstract interface UserDao extends com.example.lib_common.db.dao.BaseDao<com.example.lib_common.model.User> {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertUser(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.model.User element);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from user where username=:name")
    public abstract com.example.lib_common.model.User findUserByName(@org.jetbrains.annotations.NotNull()
    java.lang.String name);
}