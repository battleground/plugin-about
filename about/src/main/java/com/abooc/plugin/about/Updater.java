package com.abooc.plugin.about;

import android.content.Context;

/**
 * Created by dayu on 2017/2/18.
 */

public class Updater {

    private static boolean mBackEnable;


    public static void launch(Context context) {
        UpdateActivity.launch(context);
    }

    public static void setBackEnable(boolean enable) {
        mBackEnable = enable;
    }

    public static boolean isBackEnable() {
        return mBackEnable;
    }

}
