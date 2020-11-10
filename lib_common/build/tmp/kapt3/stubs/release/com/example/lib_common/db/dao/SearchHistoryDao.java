package com.example.lib_common.db.dao;

import java.lang.System;

/**
 * 搜索历史
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H\'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\'\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/db/dao/SearchHistoryDao;", "Lcom/example/lib_common/db/dao/BaseDao;", "Lcom/example/lib_common/model/SearchHistory;", "deleteAll", "", "deleteSearchHistory", "key_word", "", "getAllSearchHistory", "", "insert", "element", "lib_common_release"})
public abstract interface SearchHistoryDao extends com.example.lib_common.db.dao.BaseDao<com.example.lib_common.model.SearchHistory> {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.model.SearchHistory element);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "select * from shistory")
    public abstract java.util.List<com.example.lib_common.model.SearchHistory> getAllSearchHistory();
    
    @androidx.room.Query(value = "delete from shistory where key_word = :key_word")
    public abstract void deleteSearchHistory(@org.jetbrains.annotations.NotNull()
    java.lang.String key_word);
    
    @androidx.room.Query(value = "delete from shistory")
    public abstract void deleteAll();
}