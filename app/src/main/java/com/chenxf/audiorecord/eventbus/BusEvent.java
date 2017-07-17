package com.chenxf.audiorecord.eventbus;

/**
 * ****************************************************
 * Copyright (C) 2014 iQIYI.COM - All Rights Reserved
 * <p/>
 * This file is part of PaopaoAndroid
 * Unauthorized copy of this file, via any medium is strictly prohibited.
 * Proprietary and Confidential.
 * <p/>
 * Author(s): yun
 * Date: 2015/10/9
 * <p/>
 * *****************************************************
 */
public class BusEvent {
    private int what;
    private Object obj;
    private Object obj1;

    public BusEvent(int what) {
        this.what = what;
    }

    public BusEvent(int what, Object obj) {
        this.what = what;
        this.obj = obj;
    }

    public Object getObj1() {
        return obj1;
    }

    public BusEvent setObj1(Object obj1) {
        this.obj1 = obj1;
        return this;
    }

    public int getWhat() {
        return what;
    }

    public BusEvent setWhat(int what) {
        this.what = what;
        return this;
    }

    public Object getObj() {
        return obj;
    }

    public BusEvent setObj(Object obj) {
        this.obj = obj;
        return this;
    }

}
