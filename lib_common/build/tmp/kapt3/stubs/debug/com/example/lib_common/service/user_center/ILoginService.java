package com.example.lib_common.service.user_center;

import java.lang.System;

/**
 * 暴露服务给其他组件使用
 */
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lcom/example/lib_common/service/user_center/ILoginService;", "Lcom/alibaba/android/arouter/facade/template/IProvider;", "isLogin", "", "lib_common_debug"})
public abstract interface ILoginService extends com.alibaba.android.arouter.facade.template.IProvider {
    
    public abstract boolean isLogin();
}