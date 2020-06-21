package com.sjy.service;

public interface AdminService {
    /**
     *  管理员登录设置
     * @param aname   管理员账号（唯一）
     * @param apassword   密码
     * @return
     */
    public String queryByNamePwd(String aname, String apassword);
}
