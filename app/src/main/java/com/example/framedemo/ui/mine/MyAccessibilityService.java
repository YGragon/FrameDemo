package com.example.framedemo.ui.mine;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

import java.util.List;

/**
 * Created by Aller on 2020/8/2.
 */
public class MyAccessibilityService extends AccessibilityService{
    private static final String       TEXT_FORCE_STOP = "强行停止";
    private static final String       TEXT_DETERMINE  = "确定";
    private static final CharSequence PACKAGE         = "com.android.settings";
    private static final CharSequence NAME_APP_DETAILS  = "com.android.settings.applications.InstalledAppDetailsTop";
    private static final CharSequence NAME_ALERT_DIALOG = "android.app.AlertDialog";

    private boolean isAppDetail;
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) @Override public void onAccessibilityEvent(final AccessibilityEvent event) {

        if(null == event || null == event.getSource()) { return; }
        if(event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED &&
                event.getPackageName().equals(PACKAGE)){
            final CharSequence className = event.getClassName();
            if(className.equals(NAME_APP_DETAILS)){
                simulationClick(event, TEXT_FORCE_STOP);
                performGlobalAction(GLOBAL_ACTION_BACK);
                isAppDetail = true;
            }
            if(isAppDetail && className.equals(NAME_ALERT_DIALOG)){
                simulationClick(event, TEXT_DETERMINE);
                performGlobalAction(GLOBAL_ACTION_BACK);
                isAppDetail = false;
            }
        }
    }
    @Override
    protected void onServiceConnected() {
        AccessibilityServiceInfo serviceInfo = new AccessibilityServiceInfo();
        serviceInfo.eventTypes = AccessibilityEvent.TYPES_ALL_MASK;
        serviceInfo.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
        serviceInfo.packageNames = new String[]{"com.tencent.mm"};
        serviceInfo.notificationTimeout=100;
        setServiceInfo(serviceInfo);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN) private void simulationClick(AccessibilityEvent event, String text){
        List<AccessibilityNodeInfo> nodeInfoList = event.getSource().findAccessibilityNodeInfosByText(text);
        for (AccessibilityNodeInfo node : nodeInfoList) {
            if (node.isClickable() && node.isEnabled()) {
                node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
            }
        }
    }

    @Override public void onInterrupt() { }
}
