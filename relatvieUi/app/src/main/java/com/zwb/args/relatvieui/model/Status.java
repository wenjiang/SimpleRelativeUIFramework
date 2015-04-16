package com.zwb.args.relatvieui.model;

/**
 * Created by pc on 2015/4/16.
 */
public class Status extends BaseModel {
    private String name;

    public void setName(String name) {
        this.name = name;

        if (isBind) {
            controller.send(this);
        }
    }

    public String getName() {
        return name;
    }
}
