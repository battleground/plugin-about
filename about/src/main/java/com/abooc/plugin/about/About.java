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

    public interface Action {

        int ACTION_UPDATE = 0;
        int ACTION_INTRODUCE = 1;
        int ACTION_HELP = 2;
        int ACTION_CHECK = 3;
        int ACTION_TERMS = 4;
        int ACTION_POLICY = 5;
        int ACTION_LICENCE = 6;

        /**
         * 覆写点击事件
         *
         * @param action
         */
        void onAction(int action);
    }

    public static class SimpleAction implements Action {


        public void onAction(int action) {

        }
    }

    /**
     * 扩展点击事件
     *
     * @param action
     */
    public void implAction(Action action) {
        mAction = action;
    }

    Action mAction;

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

    /**
     * 使用默认配置
     *
     * @param context
     */
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
        copyright = "©" + String.valueOf(year);
        updateUrl = "";
    }

    /**
     * 设置Copyright {yyyy} {name of copyright owner}
     *
     * @param owner
     * @return this
     */
    public About setCopyright(String owner) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        this.copyright = "©" + String.valueOf(year) + " " + owner;
        return this;
    }

    /**
     * 设置更新地址
     *
     * @param updateUrl
     * @return this
     */
    public About setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
        return this;
    }

    /**
     * 设置服务条款
     *
     * @param termsUrl
     * @return this
     */
    public About setTermsUrl(String termsUrl) {
        this.termsUrl = termsUrl;
        return this;
    }

    /**
     * 设置隐私政策
     *
     * @param policyUrl
     * @return this
     */
    public About setPolicyUrl(String policyUrl) {
        this.policyUrl = policyUrl;
        return this;
    }

    /**
     * 设置开源许可证
     *
     * @param licenceUrl
     * @return this
     */
    public About setLicenceUrl(String licenceUrl) {
        this.licenceUrl = licenceUrl;
        return this;
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
