package com.sjy.po;
/**
 * @ClassName: Admin
 * @Description: 管理员实体类
 */
public class Admin {
    //管理员名称
    private String aname;
    //管理员密码
    private String apassword;

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApassword() {
        return apassword;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "aname='" + aname + '\'' +
                ", apassword='" + apassword + '\'' +
                '}';
    }
}
