package com.example.lib_common.service.gank;

import java.lang.System;

/**
 * Created by Aller on 2020/10/26.
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/example/lib_common/service/gank/IGankService;", "Lcom/alibaba/android/arouter/facade/template/IProvider;", "getHeaderPhoto", "", "iGankPhotoCallBack", "Lcom/example/lib_common/service/gank/IGankPhotoCallBack;", "lib_common_debug"})
public abstract interface IGankService extends com.alibaba.android.arouter.facade.template.IProvider {
    
    public abstract void getHeaderPhoto(@org.jetbrains.annotations.NotNull()
    com.example.lib_common.service.gank.IGankPhotoCallBack iGankPhotoCallBack);
}