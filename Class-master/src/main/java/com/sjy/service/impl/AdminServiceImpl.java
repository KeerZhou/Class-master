package com.sjy.service.impl;

import com.sjy.mapper.AdminMapper;
import com.sjy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    /**
     *  管理员登录设置
     * @param aname   管理员账号（唯一）
     * @param apassword   密码
     * @return
     */
    @Override
    public String queryByNamePwd(String aname, String apassword) {
        return adminMapper.queryByNamePwd(aname,apassword);
    }
}
