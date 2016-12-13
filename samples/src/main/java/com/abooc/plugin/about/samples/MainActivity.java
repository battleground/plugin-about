package com.abooc.plugin.about.samples;

import android.os.Bundle;
import android.support.v4.util.DebugUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.abooc.plugin.about.About;
import com.abooc.plugin.about.AboutActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        About.defaultAbout(this);
        About about = About.getAbout();
        about.setLicenceUrl("http://www.abooc.com");
        about.setUpdateUrl("http://www.abooc.com");
        about.setCopyright("abooc, Inc.");
        setContentView(R.layout.activity_main);

        About.SimpleAction simpleAction = new About.SimpleAction() {
            @Override
            public void onAction(int action) {
                StringBuilder builder = new StringBuilder("action:" + action);
                DebugUtils.buildShortClassTag(this, builder);
                Log.d("TAG", builder.toString());
            }
        };
//        about.implAction(simpleAction);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.Settings:
                Toast.makeText(this, R.string.action_menu_settings, Toast.LENGTH_LONG).show();
                return true;
            case R.id.About:
                AboutActivity.launch(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view) {
        AboutActivity.launch(this);
    }
}
