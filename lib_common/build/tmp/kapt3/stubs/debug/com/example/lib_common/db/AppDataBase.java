package com.example.lib_common.db;

import java.lang.System;

/**
 * 数据库示例
 */
@androidx.room.Database(entities = {com.example.lib_common.model.SearchHistory.class, com.example.lib_common.model.Hotkey.class, com.example.lib_common.model.User.class}, version = 1)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\n"}, d2 = {"Lcom/example/lib_common/db/AppDataBase;", "Landroidx/room/RoomDatabase;", "()V", "getHotKeyDao", "Lcom/example/lib_common/db/dao/HotKeyDao;", "getSearchHistoryDao", "Lcom/example/lib_common/db/dao/SearchHistoryDao;", "getUserDao", "Lcom/example/lib_common/db/dao/UserDao;", "Companion", "lib_common_debug"})
public abstract class AppDataBase extends androidx.room.RoomDatabase {
    private static final java.lang.String DB_NAME = "FrameDemo.db";
    private static volatile com.example.lib_common.db.AppDataBase INSTANCE;
    public static final com.example.lib_common.db.AppDataBase.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.lib_common.db.dao.SearchHistoryDao getSearchHistoryDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.lib_common.db.dao.HotKeyDao getHotKeyDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.example.lib_common.db.dao.UserDao getUserDao();
    
    public AppDataBase() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/example/lib_common/db/AppDataBase$Companion;", "", "()V", "DB_NAME", "", "INSTANCE", "Lcom/example/lib_common/db/AppDataBase;", "instance", "context", "Landroid/content/Context;", "lib_common_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.lib_common.db.AppDataBase instance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}