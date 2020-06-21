package com.sjy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjy.po.Course;
import com.sjy.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/CourseController")
@SessionAttributes("courseList")
public class CourseController {
    @Autowired
    CourseService courseService;

    public void pageIn(Model model,List list) {
        PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", page);
    }

    //跳转到queryCourse页面
    @RequestMapping("/managecou/{pn}")
    public String manageCourse(HttpServletRequest request, @PathVariable(value = "pn") String pn, Model model) {
        int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        courseList = courseService.selectCourseBySql(1,10);
        pageIn(model, courseList);
        request.setAttribute("courseList", courseList);
        return "admin/queryCourse";
    }

    // 添加课程
    @RequestMapping("/addCourse")
    public String addCourse(Course course, Model model) {
        if (courseService.insertCourse(course) != 0) {
            model.addAttribute("course", course);
            return "success";
        } else {
            return "fail";
        }
    }

    public void queryCou(HttpServletRequest request) {
        List<Course> courseList = new ArrayList<Course>();
        courseList = courseService.selectCourseBySql(1,10);
        request.setAttribute("courseList", courseList);
    }

    // 查询课程
    @RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
    public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition,
                           HttpServletRequest request, @PathVariable(value = "pn") String pn, Model model) {

        int no = Integer.parseInt(pn);
        List<Course> courseList = new ArrayList<Course>();
        PageHelper.startPage(no, 5);
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);

        if (serc.equals("all")) {
            courseList = courseService.selectCourseBySql(1,10);
            pageIn(model, courseList);
            request.setAttribute("courseList", courseList);
            System.out.println(courseList);
            return "admin/queryCourse";

        } else if (serc.equals("sid")) {

            courseList = courseService.getByCourseCid(1,10,condition);
            pageIn(model, courseList);
            request.setAttribute("courseList", courseList);
            System.out.println("sid");

            return "admin/queryCourse";

        } else if (serc.equals("nam")) {
            courseList = courseService.getByCourseCname(1,10,condition);
            pageIn(model, courseList);
            request.setAttribute("courseList", courseList);
            System.out.println(courseList);
            System.out.println("cla");
            return "admin/queryCourse";

        } else if (serc.equals("col")) {
            courseList = courseService.getByCourseCol(1,10,condition);
            pageIn(model, courseList);
            request.setAttribute("courseList", courseList);
            System.out.println(courseList);
            System.out.println("col");
            return "admin/queryCourse";

        } else if (serc.equals("type")) {
            courseList = courseService.getByCourseType(1,10,condition);
            pageIn(model, courseList);
            request.setAttribute("courseList", courseList);
            System.out.println(courseList);
            System.out.println("pro");
            return "admin/queryCourse";

        } else {

            courseList = courseService.selectCourseBySql(1,10);
            pageIn(model, courseList);
            request.setAttribute("courseList", courseList);
            return "admin/queryCourse";

        }

    }

    //删除课程
    @RequestMapping(value = "/delete/{cid}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable(value = "cid") String cid, HttpServletRequest request) {

        if (courseService.deleteCourse(cid) != 0) {
            System.out.println("success");
            queryCou(request);
            return "success";
        } else {
            System.out.println("fail");
            return "fail";
        }

    }

    //跳转到queryCourse页面
    @RequestMapping(value = "/finalPage", method = RequestMethod.GET)
    public String finalPage(HttpSession httpSession, HttpServletRequest request) {
        Object admin = request.getSession().getAttribute("courseList");
        System.out.println(admin+"111111111111111111111111111111111111111111111111111111111111111111111111111");
        return "admin/queryCourse";
    }

    /**
     * 	修改课程定位
     * @param cid
     * @param model
     * @return
     */
    @RequestMapping(value = "/moditystu/{cid}", method = RequestMethod.GET)
    public String editPre(@PathVariable("cid") String cid, HttpServletRequest request) {


        List<Course> courseList = new ArrayList<Course>();
        courseList = courseService.getByCourseCid(1,10,cid);
        request.setAttribute("courseList", courseList);

        return "admin/modiCourse";
    }

    //修改课程信息
    @RequestMapping(value = "/moditystud/{cid}", method = RequestMethod.GET)
    public String update(@PathVariable("cid") String cid, Course course, Model model) {

        if (courseService.modifyCourse(course) != 0) {
            return "success";
        } else {
            return "fail";
        }
    }

}
