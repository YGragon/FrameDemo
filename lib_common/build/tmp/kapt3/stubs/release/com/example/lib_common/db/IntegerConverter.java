package com.example.lib_common.db;

import java.lang.System;

/**
 * Room List<Integer> 转换
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u0018\u0010\n\u001a\u0004\u0018\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/db/IntegerConverter;", "", "()V", "gson", "Lcom/google/gson/Gson;", "integerToSomeObjectList", "", "", "data", "", "someIntegerListToString", "someObjects", "lib_common_release"})
public final class IntegerConverter {
    private com.google.gson.Gson gson;
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.util.List<java.lang.Integer> integerToSomeObjectList(@org.jetbrains.annotations.Nullable()
    java.lang.String data) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.String someIntegerListToString(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> someObjects) {
        return null;
    }
    
    public IntegerConverter() {
        super();
    }
}