package com.zwb.args.relatvieui.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zwb.args.relatvieui.R;
import com.zwb.args.relatvieui.annotation.Listener;
import com.zwb.args.relatvieui.constant.ViewListenerType;
import com.zwb.args.relatvieui.ui.ViewController;


public class SampleActivity extends ActionBarActivity {
    @Listener(id = R.id.tv_view, listener = {R.id.btn_change, R.id.et_input}, type = {ViewListenerType.TYPE_CLICK, ViewListenerType.TYPE_EDIT})
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewController controller = ViewController.getInstance();
        controller.register(this);
        controller.changText(R.id.tv_view, R.id.btn_change, "你好");
        controller.changText(R.id.tv_view, R.id.et_input);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
