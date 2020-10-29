package com.example.lib_common.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H\'J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\'\u00a8\u0006\u000b"}, d2 = {"Lcom/example/lib_common/db/dao/StudentDao;", "", "getAllStudent", "Landroidx/paging/DataSource$Factory;", "", "Lcom/example/lib_common/model/Student;", "insert", "", "student", "students", "", "lib_common_debug"})
public abstract interface StudentDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Student ORDER BY name COLLATE NOCASE ASC")
    public abstract androidx.paging.DataSource.Factory<java.lang.Integer, com.example.lib_common.model.Student> getAllStudent();
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.lib_common.model.Student> students);
    
    @androidx.room.Insert()
    public abstract void insert(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.model.Student student);
}