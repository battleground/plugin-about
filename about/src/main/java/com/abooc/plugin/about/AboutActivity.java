package com.abooc.plugin.about;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by author:李瑞宇
 * email:allnet@live.cn
 * on 14-09-05.
 * <p/>
 * 关于页面
 */
public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    public static void launch(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar actionBar = getSupportActionBar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (actionBar == null) {
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
        } else {
            toolbar.setVisibility(View.GONE);
        }

        actionBar.setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init() {
        About about = About.getAbout();
        TextView AppName = (TextView) findViewById(R.id.AppName);
        AppName.setText(about.AppName);
        TextView VersionView = (TextView) findViewById(R.id.Version);
        VersionView.setText("版本：" + about.versionName + " (build:" + about.versionCode + ")");
        TextView Copyright = (TextView) findViewById(R.id.Copyright);
        Copyright.setText(about.copyright);
        ImageView logoView = (ImageView) findViewById(R.id.Logo);
        logoView.setImageResource(about.iconResId);
    }

    @Override
    protected void onResume() {
        super.onResume();
        TextView updateText = (TextView) findViewById(R.id.Update);

        About about = About.getAbout();
        if (null == about.updateUrl || "".equals(about.updateUrl)) {
            updateText.setClickable(false);
            updateText.setTextColor(Color.parseColor("#616161"));
            updateText.setText(getString(R.string.plugin_about_already_latest));
        } else {
            updateText.setOnClickListener(this);
            updateText.setClickable(true);
            updateText.setTextColor(Color.parseColor("#4271c3"));
            updateText.setText(getString(R.string.plugin_about_update));
        }
    }

    /**
     * 有新版本，立即安装
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        About about = About.getAbout();
        if (about.mAction == null) {
            Uri uri = Uri.parse(about.updateUrl);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else {
            about.mAction.onAction(About.Action.ACTION_UPDATE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

    public void onClickIntroduce(View view) {
        About about = About.getAbout();
        if (about.mAction == null) {
        } else {
            about.mAction.onAction(About.Action.ACTION_INTRODUCE);
        }

    }

    public void onClickHelp(View view) {
        About about = About.getAbout();
        if (about.mAction == null) {
        } else {
            about.mAction.onAction(About.Action.ACTION_HELP);
        }

    }

    /**
     * 检查更新事件
     *
     * @param view
     */
    public void onClickCheck(View view) {
        About about = About.getAbout();
        if (about.mAction == null) {
        } else {
            about.mAction.onAction(About.Action.ACTION_CHECK);
        }

    }

    /**
     * 条款
     *
     * @param view
     */
    public void onClickTerms(View view) {
        About about = About.getAbout();
        if (about.mAction == null) {
            String title = getString(R.string.plugin_about_terms);
            WebActivity.launch(this, title, about.termsUrl);
        } else {
            about.mAction.onAction(About.Action.ACTION_TERMS);
        }
    }

    /**
     * 隐私政策
     *
     * @param view
     */
    public void onClickPolicy(View view) {
        About about = About.getAbout();
        if (about.mAction == null) {
            String title = getString(R.string.plugin_about_policy);
            WebActivity.launch(this, title, about.policyUrl);
        } else {
            about.mAction.onAction(About.Action.ACTION_POLICY);
        }
    }

    /**
     * 开源许可证
     *
     * @param view
     */
    public void onClickLicence(View view) {
        About about = About.getAbout();
        if (about.mAction == null) {
            String title = getString(R.string.plugin_about_licence);
            WebActivity.launch(this, title, about.licenceUrl);
        } else {
            about.mAction.onAction(About.Action.ACTION_LICENCE);
        }
    }
}
