package com.chenxf.audiorecord.util;

import android.util.Log;


public final class PPLog {

    private static String defaultTag = "AudioRecord";
    private static boolean isDebugMode = true;

    private PPLog() {
    }

    public static boolean isDebug() {
        return isDebugMode;
    }

    public static void setTag(String tag) {
        defaultTag = tag;
    }

    public static int i(Object o) {
        return isDebug() && o != null ? Log.i(defaultTag, o.toString()) : -1;
    }

    public static int i(String m) {
        return isDebug() && m != null ? Log.i(defaultTag, m) : -1;
    }

    public static int d(String m) {
        return isDebug() && m != null ? Log.d(defaultTag, m) : -1;
    }

    public static int e(String m) {
        return isDebug() && m != null ? Log.e(defaultTag, m) : -1;
    }

    public static int w(String m) {
        return isDebug() && m != null ? Log.w(defaultTag, m) : -1;
    }

    public static int v(String m) {
        return isDebug() && m != null ? Log.v(defaultTag, m) : -1;
    }

    public static int v(String tag, String msg) {
//        return isDebug() && msg != null ? Log.v(tag, msg) : -1;
        return isDebug() && msg != null ? v("[" + tag + "] " + msg) : -1;
    }

    public static int d(String tag, String msg) {
//        return isDebug() && msg != null ? Log.d(tag, msg) : -1;
        return isDebug() && msg != null ? d("[" + tag + "] " + msg) : -1;
    }

    public static int i(String tag, String msg) {
//        return isDebug() && msg != null ? Log.i(tag, msg) : -1;
        return isDebug() && msg != null ? i("[" + tag + "] " + msg) : -1;
    }

    public static int w(String tag, String msg) {
//        return isDebug() && msg != null ? Log.w(tag, msg) : -1;
        return isDebug() && msg != null ? w("[" + tag + "] " + msg) : -1;
    }

    public static int e(String tag, String msg) {
//        return isDebug() && msg != null ? Log.e(tag, msg) : -1;
        return isDebug() && msg != null ? e("[" + tag + "] " + msg) : -1;
    }
}
