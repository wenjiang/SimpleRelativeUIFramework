package com.zwb.args.relatvieui.model;

import com.zwb.args.relatvieui.ui.ViewController;

/**
 * Created by pc on 2015/4/16.
 */
public class BaseModel {
    protected ViewController controller;
    public int viewId;
    public String fieldName;
    public boolean isBind = false;

    public BaseModel() {
        controller = ViewController.getInstance();
    }
}
