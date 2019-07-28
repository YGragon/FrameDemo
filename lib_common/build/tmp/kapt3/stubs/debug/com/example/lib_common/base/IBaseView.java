package com.example.lib_common.base;

import java.lang.System;

/**
 * * MVP 基础接口 View
 */
@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lcom/example/lib_common/base/IBaseView;", "", "hideLoading", "", "showLoading", "lib_common_debug"})
public abstract interface IBaseView {
    
    public abstract void showLoading();
    
    public abstract void hideLoading();
}