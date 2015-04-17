package com.zwb.args.relatvieui.model;

import com.zwb.args.relatvieui.constant.DataSendType;

/**
 * Created by pc on 2015/4/16.
 */
public class Status extends BaseModel {
    private String name;
    private String id;

    public void setName(String name) {
        this.name = name;

        controller.send(this, DataSendType.TYPE_TEXT);
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;

        controller.send(this, DataSendType.TYPE_TEXT);
    }

    public String getId() {
        return id;
    }
}
