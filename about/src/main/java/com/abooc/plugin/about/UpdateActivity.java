package com.abooc.plugin.about;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;

/**
 * Created by author:李瑞宇
 * email:allnet@live.cn
 * on 14-09-05.
 * <p/>
 * 立即升级
 */
public class UpdateActivity extends Activity {

    static void launch(Context context) {
        Intent intent = new Intent(context, UpdateActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        About.getAbout().setUpdateUrl("http://fir.im/fmpd");
    }

    /**
     * 立即更新
     *
     * @param view
     */
    public void onUpdate(View view) {
        About about = About.getAbout();
        String url = about.updateUrl;
        if (URLUtil.isValidUrl(url)) {
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
    }

    @Override
    public void onBackPressed() {
        if (Updater.isBackEnable()) {
            super.onBackPressed();
        }
    }
}
