package com.zwb.args.relatvieui.model;

import com.zwb.args.relatvieui.ui.ViewController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pc on 2015/4/16.
 */
public class BaseModel {
    protected ViewController controller;
    public Map<Integer, String> bindMap;

    public BaseModel() {
        controller = ViewController.getInstance();
        bindMap = new HashMap<Integer, String>();
    }
}
