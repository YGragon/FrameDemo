package com.example.lib_common.db.dao;

import java.lang.System;

/**
 * * 数据 Dao 基类
 */
@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\bg\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\'J!\u0010\n\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b\"\u00028\u0000H\'\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\'J\u0015\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H\'\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/example/lib_common/db/dao/BaseDao;", "T", "", "delete", "", "element", "(Ljava/lang/Object;)V", "deleteList", "elements", "", "deleteSome", "", "([Ljava/lang/Object;)V", "insertAll", "list", "update", "lib_common_debug"})
public abstract interface BaseDao<T extends java.lang.Object> {
    
    /**
     * * 插入全部
     */
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<T> list);
    
    /**
     * * 删除一个元素
     */
    @androidx.room.Delete()
    public abstract void delete(T element);
    
    /**
     * * 珊瑚列表
     */
    @androidx.room.Delete()
    public abstract void deleteList(@org.jetbrains.annotations.NotNull()
    java.util.List<T> elements);
    
    /**
     * * 删除一些元素
     */
    @androidx.room.Delete()
    public abstract void deleteSome(@org.jetbrains.annotations.NotNull()
    T... elements);
    
    /**
     * * 更新
     */
    @androidx.room.Update()
    public abstract void update(T element);
}