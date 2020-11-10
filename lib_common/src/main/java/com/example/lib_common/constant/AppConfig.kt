package com.example.lib_common.constant

/**
 * 其中的 moduleApps 是一个静态的 String 数组，我们将需要初始化的组件的 Application 的完整类名放入到这个数组中
 */
object AppConfig {
    private const val ModuleGank = "com.longyi.module_gank.GankApplication"
    private const val ModuleMap = "com.longyi.module_map.MapApplication"
    private const val ModuleSearch = "com.longyi.module_search.SearchMainApplication"
    private const val ModuleShare = "com.longyi.module_share.ShareApplication"
    private const val ModuleUserCenter = "com.longyi.module_usercenter.UserApplication"
    private const val ModuleHome = "com.longyi.module_home.HomeApplication"
    private const val ModuleTodo = "com.longyi.module_todo.TodoApplication"
    private const val ModuleJetPack = "com.longyi.module_android_jetpack.JetpackApplication"
    private const val ModuleWeb = "com.longyi.module_web.WebApplication"

    var moduleApps = arrayOf( ModuleGank, ModuleMap, ModuleSearch, ModuleShare,ModuleHome, ModuleTodo,ModuleUserCenter, ModuleJetPack,ModuleWeb)
}