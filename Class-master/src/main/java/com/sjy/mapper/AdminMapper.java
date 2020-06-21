package com.sjy.mapper;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    /**
     *  管理员登录设置
     * @param aname   管理员名称
     * @param apassword   密码
     * @return
     */
    public String queryByNamePwd(@Param("aname") String aname, @Param("apassword") String apassword);
}
