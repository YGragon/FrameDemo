package com.example.lib_common.service.home;

import java.lang.System;

/**
 * 暴露服务给其他组件使用
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/example/lib_common/service/home/IHomeService;", "Lcom/alibaba/android/arouter/facade/template/IProvider;", "getFreshCount", "", "getImageDatas", "", "Lcom/example/lib_common/model/ImageData;", "lib_common_release"})
public abstract interface IHomeService extends com.alibaba.android.arouter.facade.template.IProvider {
    
    public abstract int getFreshCount();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<com.example.lib_common.model.ImageData> getImageDatas();
}