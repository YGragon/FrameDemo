package com.example.lib_common.utils.rxbus.lifecycle;

import java.lang.System;

/**
 * 无界面的 Fragment 管理生命周期
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\u000e\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/lib_common/utils/rxbus/lifecycle/HolderLifeFragment;", "Landroidx/fragment/app/Fragment;", "()V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "sHolderFragmentManager", "Lcom/example/lib_common/utils/rxbus/lifecycle/HolderLifeFragment$Companion$HolderFragmentManager;", "sTAG", "", "holderFragmentFor", "fragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setDispose", "dispose", "Lio/reactivex/disposables/Disposable;", "Companion", "lib_common_release"})
public final class HolderLifeFragment extends androidx.fragment.app.Fragment {
    private final java.lang.String sTAG = null;
    private final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment.Companion.HolderFragmentManager sHolderFragmentManager = null;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private static final java.lang.String HOLDER_TAG = "com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment.tag";
    public static final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment holderFragmentFor(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.FragmentActivity activity) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment holderFragmentFor(@org.jetbrains.annotations.Nullable()
    androidx.fragment.app.Fragment fragment) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    public final void setDispose(@org.jetbrains.annotations.NotNull()
    io.reactivex.disposables.Disposable dispose) {
    }
    
    public HolderLifeFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/lib_common/utils/rxbus/lifecycle/HolderLifeFragment$Companion;", "", "()V", "HOLDER_TAG", "", "HolderFragmentManager", "lib_common_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\fJ\u000e\u0010\u0019\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\n0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/lib_common/utils/rxbus/lifecycle/HolderLifeFragment$Companion$HolderFragmentManager;", "", "()V", "mActivityCallbacks", "Lcom/example/lib_common/utils/rxbus/lifecycle/EmptyActivityLifecycleCallbacks;", "mActivityCallbacksIsAdded", "", "mNotCommittedActivityHolders", "Ljava/util/HashMap;", "Landroid/app/Activity;", "Lcom/example/lib_common/utils/rxbus/lifecycle/HolderLifeFragment;", "mNotCommittedFragmentHolders", "Landroidx/fragment/app/Fragment;", "mParentDestroyedCallback", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "sTAG", "", "createHolderFragment", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "findHolderFragment", "manager", "holderFragmentCreated", "", "holderFragment", "holderFragmentFor", "parentFragment", "activity", "Landroidx/fragment/app/FragmentActivity;", "lib_common_release"})
        public static final class HolderFragmentManager {
            private final java.lang.String sTAG = null;
            private final java.util.HashMap<android.app.Activity, com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment> mNotCommittedActivityHolders = null;
            private final java.util.HashMap<androidx.fragment.app.Fragment, com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment> mNotCommittedFragmentHolders = null;
            private boolean mActivityCallbacksIsAdded;
            private final com.example.lib_common.utils.rxbus.lifecycle.EmptyActivityLifecycleCallbacks mActivityCallbacks = null;
            private final androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks mParentDestroyedCallback = null;
            
            public final void holderFragmentCreated(@org.jetbrains.annotations.NotNull()
            androidx.fragment.app.Fragment holderFragment) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment holderFragmentFor(@org.jetbrains.annotations.NotNull()
            androidx.fragment.app.FragmentActivity activity) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment holderFragmentFor(@org.jetbrains.annotations.NotNull()
            androidx.fragment.app.Fragment parentFragment) {
                return null;
            }
            
            private final java.lang.Object findHolderFragment(androidx.fragment.app.FragmentManager manager) {
                return null;
            }
            
            private final com.example.lib_common.utils.rxbus.lifecycle.HolderLifeFragment createHolderFragment(androidx.fragment.app.FragmentManager fragmentManager) {
                return null;
            }
            
            public HolderFragmentManager() {
                super();
            }
        }
    }
}