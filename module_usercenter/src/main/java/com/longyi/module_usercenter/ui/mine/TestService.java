package com.longyi.module_usercenter.ui.mine;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.view.accessibility.AccessibilityManager;

import java.util.List;

import static android.content.Context.ACCESSIBILITY_SERVICE;

/**
 * AccessibilityService 测试
 */
public class TestService {
    /*
     * 参考：https://github.com/qyxxjd/ClearProcesses
     */
    public static boolean isRun(Context context, String serviceName) {
        ActivityManager mActivityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> runServiceList = mActivityManager.getRunningServices(100);
        for (ActivityManager.RunningServiceInfo info : runServiceList) {
            String name = info.service.getClassName();
            Log.e("222", "isRun-name-->" + name);
            Log.e("222", "isRun-getClassName -->" + info.service.getClassName());

            if (serviceName.equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 参考 https://www.jianshu.com/p/4cd8c109cdfb
     *
     * @param name
     * @param context
     * @return
     */
    public static boolean enabled(String name, Context context) {
        AccessibilityManager am = (AccessibilityManager) context.getSystemService(Context.ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> serviceInfos = am.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);

        List<AccessibilityServiceInfo> installedAccessibilityServiceList = am.getInstalledAccessibilityServiceList();
        Log.d("222", "enabled -->" + installedAccessibilityServiceList);
        for (AccessibilityServiceInfo info : installedAccessibilityServiceList) {
            Log.e("222", "enabled -->" + info.getId());
            if (name.equals(info.getId())) {
                return true;
            }
        }
        return false;
    }


    public static boolean checkEnabledAccessibilityService(Context context) {
        AccessibilityManager mAccessibilityManager = (AccessibilityManager) context.getSystemService(ACCESSIBILITY_SERVICE);
        List<AccessibilityServiceInfo> accessibilityServices =
                mAccessibilityManager.getEnabledAccessibilityServiceList(AccessibilityServiceInfo.FEEDBACK_GENERIC);
        for (AccessibilityServiceInfo info : accessibilityServices) {
            Log.e("222","info:"+info);
            if (info.getId().equals("com.example.framedemo/com.longyi.module_usercenter.ui.mine.MyAccessibilityService")) {
                return true;
            }
        }
        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        return false;
    }

}
