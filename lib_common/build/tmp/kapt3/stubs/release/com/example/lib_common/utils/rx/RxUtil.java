package com.example.lib_common.utils.rx;

import java.lang.System;

/**
 * RxUtil 工具类，包括 防抖事件处理，EditText 联想搜索
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0004\u000e\u000f\u0010\u0011B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\tJ\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/example/lib_common/utils/rx/RxUtil;", "", "()V", "clickView", "Lio/reactivex/rxjava3/core/Observable;", "view", "Landroid/view/View;", "searchViewTextChanges", "", "Landroidx/appcompat/widget/SearchView;", "textChanges", "Landroid/widget/EditText;", "textEmpty", "Landroid/widget/TextView;", "SearchViewChangeOnSubscribe", "TextEmptyOnSubscribe", "ViewChangeOnSubscribe", "ViewClickOnSubscribe", "lib_common_release"})
public final class RxUtil {
    public static final com.example.lib_common.utils.rx.RxUtil INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Observable<java.lang.Object> clickView(@org.jetbrains.annotations.Nullable()
    android.view.View view) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Observable<java.lang.String> textChanges(@org.jetbrains.annotations.Nullable()
    android.widget.EditText view) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Observable<java.lang.String> searchViewTextChanges(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.SearchView view) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.rxjava3.core.Observable<java.lang.String> textEmpty(@org.jetbrains.annotations.Nullable()
    android.widget.TextView view) {
        return null;
    }
    
    private RxUtil() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/utils/rx/RxUtil$ViewChangeOnSubscribe;", "Lio/reactivex/rxjava3/core/ObservableOnSubscribe;", "", "view", "Landroid/widget/EditText;", "(Landroid/widget/EditText;)V", "getView", "()Landroid/widget/EditText;", "subscribe", "", "emitter", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "lib_common_release"})
    static final class ViewChangeOnSubscribe implements io.reactivex.rxjava3.core.ObservableOnSubscribe<java.lang.String> {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.EditText view = null;
        
        @java.lang.Override()
        public void subscribe(@org.jetbrains.annotations.NotNull()
        io.reactivex.rxjava3.core.ObservableEmitter<java.lang.String> emitter) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.EditText getView() {
            return null;
        }
        
        public ViewChangeOnSubscribe(@org.jetbrains.annotations.NotNull()
        android.widget.EditText view) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/utils/rx/RxUtil$SearchViewChangeOnSubscribe;", "Lio/reactivex/rxjava3/core/ObservableOnSubscribe;", "", "view", "Landroidx/appcompat/widget/SearchView;", "(Landroidx/appcompat/widget/SearchView;)V", "getView", "()Landroidx/appcompat/widget/SearchView;", "subscribe", "", "emitter", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "lib_common_release"})
    static final class SearchViewChangeOnSubscribe implements io.reactivex.rxjava3.core.ObservableOnSubscribe<java.lang.String> {
        @org.jetbrains.annotations.NotNull()
        private final androidx.appcompat.widget.SearchView view = null;
        
        @java.lang.Override()
        public void subscribe(@org.jetbrains.annotations.NotNull()
        io.reactivex.rxjava3.core.ObservableEmitter<java.lang.String> emitter) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final androidx.appcompat.widget.SearchView getView() {
            return null;
        }
        
        public SearchViewChangeOnSubscribe(@org.jetbrains.annotations.NotNull()
        androidx.appcompat.widget.SearchView view) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/utils/rx/RxUtil$ViewClickOnSubscribe;", "Lio/reactivex/rxjava3/core/ObservableOnSubscribe;", "", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "getView", "()Landroid/view/View;", "subscribe", "", "emitter", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "lib_common_release"})
    static final class ViewClickOnSubscribe implements io.reactivex.rxjava3.core.ObservableOnSubscribe<java.lang.Object> {
        @org.jetbrains.annotations.NotNull()
        private final android.view.View view = null;
        
        @java.lang.Override()
        public void subscribe(@org.jetbrains.annotations.NotNull()
        io.reactivex.rxjava3.core.ObservableEmitter<java.lang.Object> emitter) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getView() {
            return null;
        }
        
        public ViewClickOnSubscribe(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lcom/example/lib_common/utils/rx/RxUtil$TextEmptyOnSubscribe;", "Lio/reactivex/rxjava3/core/ObservableOnSubscribe;", "", "view", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "getView", "()Landroid/widget/TextView;", "subscribe", "", "emitter", "Lio/reactivex/rxjava3/core/ObservableEmitter;", "lib_common_release"})
    static final class TextEmptyOnSubscribe implements io.reactivex.rxjava3.core.ObservableOnSubscribe<java.lang.String> {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView view = null;
        
        @java.lang.Override()
        public void subscribe(@org.jetbrains.annotations.NotNull()
        io.reactivex.rxjava3.core.ObservableEmitter<java.lang.String> emitter) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getView() {
            return null;
        }
        
        public TextEmptyOnSubscribe(@org.jetbrains.annotations.NotNull()
        android.widget.TextView view) {
            super();
        }
    }
}