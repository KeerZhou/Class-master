package com.sjy.po;

public class Course {
    //课程编号
    private String cid;
    //课程名称
    private String cname;
    //课程介绍
    private String cintroduction;
    //类型
    private String type;
    //任课教师
    private String tname;
    //所属学院
    private String belongcoll;
    //所属专业
    private String belongpro;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCintroduction() {
        return cintroduction;
    }

    public void setCintroduction(String cintroduction) {
        this.cintroduction = cintroduction;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getBelongcoll() {
        return belongcoll;
    }

    public void setBelongcoll(String belongcoll) {
        this.belongcoll = belongcoll;
    }

    public String getBelongpro() {
        return belongpro;
    }

    public void setBelongpro(String belongpro) {
        this.belongpro = belongpro;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", cintroduction='" + cintroduction + '\'' +
                ", type='" + type + '\'' +
                ", tname='" + tname + '\'' +
                ", belongcoll='" + belongcoll + '\'' +
                ", belongpro='" + belongpro + '\'' +
                '}';
    }
}
