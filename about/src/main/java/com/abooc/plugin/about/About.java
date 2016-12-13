package com.abooc.plugin.about;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import java.util.Calendar;

/**
 * Created by author:李瑞宇
 * email:allnet@live.cn
 * on 16/10/27.
 */
public class About {


    int iconResId;
    String AppName;
    String versionName;
    int versionCode;
    String copyright;
    String updateUrl;

    String termsUrl;
    String policyUrl;
    String licenceUrl;

    private static About ourInstance = new About();

    public static About getAbout() {
        return ourInstance;
    }

    private About() {
    }

    public static void defaultAbout(Context context) {
        ourInstance.build(context.getApplicationContext());
    }

    private void build(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        AppName = getApplicationName(context);
        iconResId = applicationInfo.icon;
        Log.d("TAG", "iconResId:" + iconResId);
        versionName = getVersionName(context);
        versionCode = getVersionCode(context);
        int year = Calendar.getInstance().get(Calendar.YEAR);
        copyright = String.valueOf(year);
        updateUrl = "";
    }

    /**
     * 设置更新地址
     *
     * @param updateUrl
     */
    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    /**
     * 设置服务条款
     *
     * @param termsUrl
     */
    public void setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
    }

    /**
     * 设置隐私政策
     *
     * @param policyUrl
     */
    public void setPolicyUrl(String policyUrl) {
        this.policyUrl = policyUrl;
    }

    /**
     * 设置开源许可证
     *
     * @param licenceUrl
     */
    public void setLicenceUrl(String licenceUrl) {
        this.licenceUrl = licenceUrl;
    }

    public static String getApplicationName(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        int stringId = applicationInfo.labelRes;
        return stringId == 0 ? applicationInfo.nonLocalizedLabel.toString() : context.getString(stringId);
    }

    public static String getVersionName(Context context) {
        PackageManager packagemanager = context.getPackageManager();
        String packName = context.getPackageName();
        try {
            PackageInfo packageinfo = packagemanager.getPackageInfo(packName, 0);
            return packageinfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getVersionCode(Context context) {
        PackageManager packagemanager = context.getPackageManager();
        String packName = context.getPackageName();
        try {
            PackageInfo packageinfo = packagemanager.getPackageInfo(packName, 0);
            return packageinfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

}
