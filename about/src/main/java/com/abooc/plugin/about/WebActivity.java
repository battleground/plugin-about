package com.abooc.plugin.about;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by author:李瑞宇
 * email:allnet@live.cn
 * on 14-09-05.
 * <p/>
 * 关于页面
 */
public class WebActivity extends AppCompatActivity {

    public static void launch(Context context, String title, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        String title = getIntent().getStringExtra("title");
        ActionBar actionBar = getSupportActionBar();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (actionBar == null) {
            setSupportActionBar(toolbar);
            actionBar = getSupportActionBar();
        } else {
            toolbar.setVisibility(View.GONE);
        }

        actionBar.setTitle(title);
        actionBar.setDisplayHomeAsUpEnabled(true);

        init();
    }

    private void init() {
        String url = getIntent().getStringExtra("url");
        TextView textView = (TextView) findViewById(R.id.TextView);
        if (TextUtils.isEmpty(url)) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.INVISIBLE);
            WebView webView = (WebView) findViewById(R.id.WebView);
            webView.loadUrl(url);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }

}
