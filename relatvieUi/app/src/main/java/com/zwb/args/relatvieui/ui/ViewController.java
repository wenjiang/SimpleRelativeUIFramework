package com.zwb.args.relatvieui.ui;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.zwb.args.relatvieui.annotation.Listener;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 负责处理监听的注册和回调
 * Created by pc on 2015/4/16.
 */
public class ViewController {
    private static ViewController controller;
    private Map<Integer, List<String>> bindMap;
    private Activity activity;

    private ViewController() {
        bindMap = new HashMap<Integer, List<String>>();
    }

    public static ViewController getInstance() {
        if (controller == null) {
            controller = new ViewController();
        }

        return controller;
    }

    /**
     * 注册
     *
     * @param activity 需要注册的Activity
     */
    public void register(Activity activity) {
        Field[] fields = activity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Listener.class)) {
                Listener listener = field.getAnnotation(Listener.class);
                int id = listener.id();
                int listenerId = listener.listener();
                String type = listener.type();

                List<String> bindList = bindMap.get(id);
                if (bindList == null) {
                    bindList = new ArrayList<String>();
                }

                bindList.add(listenerId + "_" + type);
                bindMap.put(id, bindList);
            }
        }

        this.activity = activity;
    }

    /**
     * 改变Text的事件
     *
     * @param id   会被改变Text的View的id
     * @param text 要改变的Text
     */
    public void changText(int id, final String text) {
        List<String> bindList = bindMap.get(id);
        final TextView textView = (TextView) activity.findViewById(id);
        for (String bindStr : bindList) {
            String[] bindArr = bindStr.split("_");
            int listenerId = Integer.valueOf(bindArr[0]);
            String listenerMethod = bindArr[1];

            View listenerView = activity.findViewById(listenerId);
            if (listenerMethod.equals("onClick")) {
                listenerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        textView.setText(text);
                    }
                });
            }
        }
    }
}
