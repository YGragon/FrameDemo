package com.example.lib_common.base;

import java.lang.System;

/**
 * MVP Base Presenter
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0015\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00018\u00002\b\u0010\n\u001a\u0004\u0018\u00018\u0000@BX\u0086\u000e\u00a2\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/example/lib_common/base/BasePresenter;", "T", "Lcom/example/lib_common/base/IBaseView;", "Lcom/example/lib_common/base/IPresenter;", "()V", "compositeDisposable", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "isViewAttached", "", "()Z", "<set-?>", "mRootView", "getMRootView", "()Lcom/example/lib_common/base/IBaseView;", "Lcom/example/lib_common/base/IBaseView;", "addSubscription", "", "disposable", "Lio/reactivex/rxjava3/disposables/Disposable;", "attachView", "(Lcom/example/lib_common/base/IBaseView;)V", "checkViewAttached", "detachView", "MvpViewNotAttachedException", "lib_common_debug"})
public class BasePresenter<T extends com.example.lib_common.base.IBaseView> implements com.example.lib_common.base.IPresenter<T> {
    @org.jetbrains.annotations.Nullable()
    private T mRootView;
    private io.reactivex.rxjava3.disposables.CompositeDisposable compositeDisposable;
    
    @org.jetbrains.annotations.Nullable()
    public final T getMRootView() {
        return null;
    }
    
    @java.lang.Override()
    public void attachView(@org.jetbrains.annotations.NotNull()
    T mRootView) {
    }
    
    @java.lang.Override()
    public void detachView() {
    }
    
    private final boolean isViewAttached() {
        return false;
    }
    
    public final void checkViewAttached() {
    }
    
    public final void addSubscription(@org.jetbrains.annotations.NotNull()
    io.reactivex.rxjava3.disposables.Disposable disposable) {
    }
    
    public BasePresenter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007\b\u0000\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/example/lib_common/base/BasePresenter$MvpViewNotAttachedException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "()V", "lib_common_debug"})
    static final class MvpViewNotAttachedException extends java.lang.RuntimeException {
        
        public MvpViewNotAttachedException() {
            super();
        }
    }
}