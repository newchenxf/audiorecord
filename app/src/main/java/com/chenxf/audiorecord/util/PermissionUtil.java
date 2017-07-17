package com.chenxf.audiorecord.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {

    private PermissionUtil() {
    }

    /**
     * android权限是否6.0以上
     *
     * @return true表示是
     * @see Build.VERSION#SDK_INT
     */
    public static boolean isOverMarshmallow() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
    }


    /**
     * 获取没有授权的权限
     *
     * @param activity   当前的activity
     * @param permission 权限名称数组
     * @return 没有授权的权限集合
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static List<String> findDeniedPermissions(Activity activity, String... permission) {
        List<String> denyPermissions = new ArrayList<>();
        for (String value : permission) {
            if (activity.checkSelfPermission(value) != PackageManager.PERMISSION_GRANTED) {
                denyPermissions.add(value);
            }
        }
        return denyPermissions;
    }

    /**
     * 指定的权限表是否授权了
     *
     * @param object     可以是activity或者fragment 的引用
     * @param permission 权限名称数组
     * @return true表示授权了
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static boolean isHaveSpecialPermisson(Object object, String... permission) {
        Activity activity = getActivity(object);
        List<String> denyPermissions = findDeniedPermissions(activity, permission);
        return denyPermissions == null || (denyPermissions.size() == 0);
    }

    /**
     * 请求权限
     *
     * @param object      可以是activity或者fragment 的引用
     * @param requestCode 请求权限回调的请求码
     * @param permissions 权限名称数组
     * @see Activity#requestPermissions(String[], int)
     */
    @TargetApi(value = Build.VERSION_CODES.M)
    public static void requestPermissions(Object object, int requestCode, String[] permissions) {
        List<String> deniedPermissions = findDeniedPermissions(getActivity(object), permissions);

        if (deniedPermissions.size() > 0) {
            if (object instanceof Activity) {
                ((Activity) object).requestPermissions(deniedPermissions.toArray(
                        new String[deniedPermissions.size()]), requestCode);
            } else {
                throw new IllegalArgumentException(
                        object.getClass().getName() + " is not supported");
            }
        }
    }


    /**
     * 获取当前的activity
     *
     * @param object 可以是activity或者fragment 的引用，否则返回null
     */
    public static Activity getActivity(Object object) {
        if (object instanceof Fragment) {
            return ((Fragment) object).getActivity();
        } else if (object instanceof Activity) {
            return (Activity) object;
        }
        return null;
    }
    public static boolean hasSelfPermission(Context context, String permission) {
        boolean hasPermission = context.checkPermission(permission, android.os.Process.myPid(), android.os.Process.myUid())
                == PackageManager.PERMISSION_GRANTED;
        return hasPermission;
    }

}
