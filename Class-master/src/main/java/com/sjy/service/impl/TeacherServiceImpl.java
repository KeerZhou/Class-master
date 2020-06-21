package com.sjy.service.impl;

import com.sjy.mapper.TeacherMapper;
import com.sjy.po.Teacher;
import com.sjy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    /**
     *  教师登录设置
     * @param tid   教师账号（唯一）
     * @param tpassword   密码
     * @return
     */
    @Override
    public String queryByNamePwd(String tid, String tpassword) {
        return teacherMapper.queryByNamePwd(tid,tpassword);
    }
    /**
     *  查询全部教师
     * @param pageNo    开始条数
     * @param pageSize  结束条数
     * @return  查询结果
     */
    @Override
    public List<Teacher> selectTeacherBySql(int pageNo, int pageSize) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        return teacherMapper.selectTeacherBySql(data);
    }

    /**
     *  根据id查询教师
     * @param pageNo    开始条数
     * @param pageSize  结束条数
     * @param tid   教师编号
     * @return  查询结果
     */
    @Override
    public List<Teacher> getByTeacherTid(int pageNo, int pageSize, String tid) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("pageNo",(pageNo-1) * pageSize);
        data.put("pageSize",pageSize);
        data.put("tid",tid);
        return teacherMapper.getByTeacherTid(data);
    }
    /**
     *  根据教师编号删除教师信息
     * @param tid   教师编号
     * @return  删除结果，!=0则删除成功
     */
    @Override
    public int deleteTeacher(String tid) {
        return teacherMapper.deleteTeacher(tid);
    }

    /**
     *  修改教师信息
     * @param teacher   教师信息
     * @return  修改结果 !=0则修改成功
     */
    @Override
    public int modifyTeacher(Teacher teacher) {
        return teacherMapper.modifyTeacher(teacher);
    }

    /**
     *  修改教师密码
     * @param tpassword     修改后的密码
     * @param tid   查询条件教师编号
     * @return  修改结果 !=0则修改成功
     */
    @Override
    public int modifyTeacherPwd(String tpassword, String tid) {
        return teacherMapper.modifyTeacherPwd(tpassword,tid);
    }

    /**
     *  根据教师编号查询出教师实体
     * @param tid
     * @return
     */
    @Override
    public Teacher getByTeaTid(String tid) {
        return teacherMapper.getByTeaTid(tid);
    }
    /**
     *  添加教师
     * @param teacher   学生教师
     * @return  插入结果 !=0则插入成功
     */
    @Override
    public int insertTeacher(Teacher teacher) {
        return teacherMapper.insertTeacher(teacher);
    }



}
