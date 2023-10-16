package com.example.doanthietbididong;

public class Model2 {
    String id1;
    String title1;
    String desc1;
    public Model2() {}
    public Model2(String id, String title, String desc) {
        this.id1 = id;
        this.desc1 = desc;
        this.title1 = title;
    }
    public String getId() {
        return id1;
    }

    public void setId(String id) {
        this.id1 = id;
    }

    public String getTitle() {
        return title1;
    }

    public void setTitle(String title) {
        this.title1 = title;
    }

    public String getDesc() {
        return desc1;
    }

    public void setDesc(String desc) {
        this.desc1 = desc;
    }
}
