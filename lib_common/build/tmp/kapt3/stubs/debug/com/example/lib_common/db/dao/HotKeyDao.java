package com.example.lib_common.db.dao;

import java.lang.System;

/**
 * * 搜索历史
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\'J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\'\u00a8\u0006\b"}, d2 = {"Lcom/example/lib_common/db/dao/HotKeyDao;", "Lcom/example/lib_common/db/dao/BaseDao;", "Lcom/example/lib_common/model/Hotkey;", "getAllHotKey", "", "insert", "", "element", "lib_common_debug"})
public abstract interface HotKeyDao extends com.example.lib_common.db.dao.BaseDao<com.example.lib_common.model.Hotkey> {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.model.Hotkey element);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from hotkey")
    public abstract java.util.List<com.example.lib_common.model.Hotkey> getAllHotKey();
}