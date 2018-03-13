package com.app.zhl.demo.Tools;

/**
 * Created by zhuhuliang on 2018/3/5.
 */

public class Instance {
    private static final Instance ourInstance = new Instance();

    public static Instance getInstance() {
        return ourInstance;
    }

    private Instance() {
    }

    public static boolean isImmersive = false;
}
