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
public class MainThreadEvent extends BusEvent {
    public MainThreadEvent(int what) {
        super(what);
    }

    public MainThreadEvent(int what, String message) {
        super(what, message);
    }

    public MainThreadEvent(int what, Object obj) {
        super(what, obj);
    }


}
