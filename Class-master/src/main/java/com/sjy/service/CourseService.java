package com.sjy.service;

import com.sjy.po.Course;

import java.util.List;

public interface CourseService {
    /**
     *  添加课程
     * @param course   课程信息
     * @return  插入结果 !=0则插入成功
     */
    public int insertCourse(Course course);

    /**
     *  根据课程编号删除课程信息信息
     * @param cid   课程编号
     * @return  删除结果，!=0则删除成功
     */
    public int deleteCourse(String cid);

    /**
     *  修改课程信息
     * @param course   课程信息
     * @return  修改结果 !=0则修改成功
     */
    public int modifyCourse(Course course);

    /**
     *  根据课程编号查询出课程实体
     * @param cid
     * @return
     */
    public Course getByCouCid(String cid);


    /**
     * 查询全部课程，接住sql语句进行分页
     * @param pageNo
     * @param pageSize
     * @return      查询结果
     */
    public List<Course> selectCourseBySql(int pageNo, int pageSize);

    /**
     * 根据课程编号查询课程信息
     * @param pageNo
     * @param pageSize
     * @return  查询结果
     */
    public List<Course> getByCourseCid(int pageNo, int pageSize,String cid);

    /**
     * 根据课程名称查询课程信息
     * @param pageNo
     * @param pageSize
     * @param cname     课程名称
     * @return  查询结果
     */
    public List<Course> getByCourseCname(int pageNo, int pageSize,String cname);

    /**
     *  根据学院查询课程信息
     * @param pageNo
     * @param pageSize
     * @param belongcoll    所属学院
     * @return 结果
     */
    public List<Course> getByCourseCol(int pageNo, int pageSize,String belongcoll);

    /**
     *  根据课程类型查询课程信息
     * @param pageNo
     * @param pageSize
     * @param type      课程类型
     * @return  结果
     */
    public List<Course> getByCourseType(int pageNo, int pageSize,String type);



    /**
     *  ajax验证课程编号是否存在
     * @param cid   课程编号
     * @return  结果
     */
    public String ajaxQueryByCid(String cid);
}
