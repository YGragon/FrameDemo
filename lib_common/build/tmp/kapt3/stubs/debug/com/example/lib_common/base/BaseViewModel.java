package com.example.lib_common.base;

import java.lang.System;

/**
 * * ViewModel 基类
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u0000 \u000f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u000f\u0010B\u0005\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u0003H\u0016R2\u0010\u0005\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/example/lib_common/base/BaseViewModel;", "Landroidx/lifecycle/ViewModel;", "Lautodispose2/lifecycle/LifecycleScopeProvider;", "Lcom/example/lib_common/base/BaseViewModel$ViewModelEvent;", "()V", "lifecycleEvents", "Lio/reactivex/rxjava3/subjects/BehaviorSubject;", "kotlin.jvm.PlatformType", "correspondingEvents", "Lautodispose2/lifecycle/CorrespondingEventsFunction;", "lifecycle", "Lio/reactivex/rxjava3/core/Observable;", "onCleared", "", "peekLifecycle", "Companion", "ViewModelEvent", "lib_common_debug"})
public abstract class BaseViewModel extends androidx.lifecycle.ViewModel implements autodispose2.lifecycle.LifecycleScopeProvider<com.example.lib_common.base.BaseViewModel.ViewModelEvent> {
    private final io.reactivex.rxjava3.subjects.BehaviorSubject<com.example.lib_common.base.BaseViewModel.ViewModelEvent> lifecycleEvents = null;
    
    /**
     * * Function of current event -> target disposal event. ViewModel has a very simple lifecycle.
     *         * It is created and then later on cleared. So we only have two events and all subscriptions
     *         * will only be disposed at [ViewModelEvent.CLEARED].
     */
    private static final autodispose2.lifecycle.CorrespondingEventsFunction<com.example.lib_common.base.BaseViewModel.ViewModelEvent> CORRESPONDING_EVENTS = null;
    public static final com.example.lib_common.base.BaseViewModel.Companion Companion = null;
    
    /**
     * * The observable representing the lifecycle of the [ViewModel].
     *     *
     *     * @return [Observable] modelling the [ViewModel] lifecycle.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.rxjava3.core.Observable<com.example.lib_common.base.BaseViewModel.ViewModelEvent> lifecycle() {
        return null;
    }
    
    /**
     * * Returns a [CorrespondingEventsFunction] that maps the
     *     * current event -> target disposal event.
     *     *
     *     * @return function mapping the current event to terminal event.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public autodispose2.lifecycle.CorrespondingEventsFunction<com.example.lib_common.base.BaseViewModel.ViewModelEvent> correspondingEvents() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public com.example.lib_common.base.BaseViewModel.ViewModelEvent peekLifecycle() {
        return null;
    }
    
    /**
     * * Emit the [ViewModelEvent.CLEARED] event to
     *     * dispose off any subscriptions in the ViewModel.
     */
    @java.lang.Override()
    protected void onCleared() {
    }
    
    public BaseViewModel() {
        super();
    }
    
    /**
     * * The events that represent the lifecycle of a [ViewModel].
     *     *
     *     * The [ViewModel] lifecycle is very simple. It is created
     *     * and then allows you to clean up any resources in the
     *     * [ViewModel.onCleared] method before it is destroyed.
     */
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/lib_common/base/BaseViewModel$ViewModelEvent;", "", "(Ljava/lang/String;I)V", "CREATED", "CLEARED", "lib_common_debug"})
    public static enum ViewModelEvent {
        /*public static final*/ CREATED /* = new CREATED() */,
        /*public static final*/ CLEARED /* = new CLEARED() */;
        
        ViewModelEvent() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/lib_common/base/BaseViewModel$Companion;", "", "()V", "CORRESPONDING_EVENTS", "Lautodispose2/lifecycle/CorrespondingEventsFunction;", "Lcom/example/lib_common/base/BaseViewModel$ViewModelEvent;", "lib_common_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}