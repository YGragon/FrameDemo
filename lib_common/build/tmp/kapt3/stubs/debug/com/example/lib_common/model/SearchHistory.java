package com.example.lib_common.model;

import java.lang.System;

/**
 * 历史搜索
 */
@androidx.room.Entity(tableName = "shistory")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\nJ\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J&\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u00c6\u0001\u00a2\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0005H\u00d6\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0016"}, d2 = {"Lcom/example/lib_common/model/SearchHistory;", "", "sId", "", "keyWord", "", "(Ljava/lang/Long;Ljava/lang/String;)V", "getKeyWord", "()Ljava/lang/String;", "getSId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/lang/String;)Lcom/example/lib_common/model/SearchHistory;", "equals", "", "other", "hashCode", "", "toString", "lib_common_debug"})
public final class SearchHistory {
    @org.jetbrains.annotations.Nullable()
    @androidx.room.PrimaryKey()
    private final java.lang.Long sId = null;
    @org.jetbrains.annotations.Nullable()
    @androidx.room.ColumnInfo(name = "key_word")
    private final java.lang.String keyWord = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getSId() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getKeyWord() {
        return null;
    }
    
    public SearchHistory(@org.jetbrains.annotations.Nullable()
    java.lang.Long sId, @org.jetbrains.annotations.Nullable()
    java.lang.String keyWord) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component2() {
        return null;
    }
    
    /**
     * 历史搜索
     */
    @org.jetbrains.annotations.NotNull()
    public final com.example.lib_common.model.SearchHistory copy(@org.jetbrains.annotations.Nullable()
    java.lang.Long sId, @org.jetbrains.annotations.Nullable()
    java.lang.String keyWord) {
        return null;
    }
    
    /**
     * 历史搜索
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * 历史搜索
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * 历史搜索
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}