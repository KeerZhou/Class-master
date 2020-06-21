package com.sjy.po;
/**
 * @ClassName: Teacher
 * @Description: 教师实体类
 */
public class Teacher {
    //教师编号
    private String tid;
    //教师姓名
    private String tname;
    //教师密码
    private String tpassword;
    //教师性别
    private String tsex;
    //教师简介
    private String introduction;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTpassword() {
        return tpassword;
    }

    public void setTpassword(String tpassword) {
        this.tpassword = tpassword;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tpassword='" + tpassword + '\'' +
                ", tsex='" + tsex + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
