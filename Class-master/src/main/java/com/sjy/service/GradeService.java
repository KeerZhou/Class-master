package com.sjy.service;

import com.sjy.po.Grade;

import java.util.List;
import java.util.Map;

public interface GradeService {
	
	/**
     * 	 添加成绩
     * @param grade   成绩
     * @return  插入结果 !=0则插入成功
     */
    public int insertGrade(Grade grade);
    /**
     * 	查询学生自己的总学分
     */
    public String queryCreditsSum(String sid);
    /**
     * 	学生查看本人已修改课程
     */
    public List<Grade> getEedCourseBySid(int pageNo, int pageSize, String sid);

}
