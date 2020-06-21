package com.sjy.controller;

import com.sjy.po.Student;
import com.sjy.po.Teacher;
import com.sjy.service.AdminService;
import com.sjy.service.StudentService;
import com.sjy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/LoginController")
public class LoginController {
    @Autowired
    StudentService studentServiceImpl;
    @Autowired
    TeacherService teacherServiceImpl;
    @Autowired
    AdminService adminServiceImpl;

    //学生登录
    @RequestMapping(value = "/studentlogin")
    public ModelAndView loginStudent(@RequestParam("sid") String sid, @RequestParam("spassword") String spassword,
                               Model model, HttpSession httpSession, HttpServletRequest reuqest) {
        String n = null;
        Student stu;
        n = studentServiceImpl.queryByNamePwd(sid,spassword);
        stu = studentServiceImpl.getByStuSid(sid);
        //n存在
        if (n != null && !"".equals(n)) {
            httpSession.setAttribute("sname", stu.getSname());
            httpSession.setAttribute("sid", sid);
            httpSession.removeAttribute("msg");
            return new ModelAndView(new RedirectView("../student/studentIndex.jsp"));
        } else {
            httpSession.setAttribute("msg","账号或密码不正确，登录失败!");
            return new ModelAndView(new RedirectView("../index.jsp"));
        }
    }

    // 学生退出登录
    @RequestMapping("/studentlogout")
    public ModelAndView studentLogout(HttpSession httpSession) {

        httpSession.removeAttribute("sid");
        httpSession.removeAttribute("sname");
        httpSession.removeAttribute("courseList");
        httpSession.removeAttribute("ssrList");
        httpSession.removeAttribute("sesList");
        return new ModelAndView(new RedirectView("/Class-master/index.jsp"));
    }

    //教师登录
    @RequestMapping(value = "/teacherlogin")
    public ModelAndView loginTeacher(@RequestParam("tid") String tid, @RequestParam("tpassword") String tpassword,
                                     Model model, HttpSession httpSession, HttpServletRequest reuqest) {
        String n = null;
        Teacher tea;
        n = teacherServiceImpl.queryByNamePwd(tid,tpassword);
        tea = teacherServiceImpl.getByTeaTid(tid);
        //n存在
        if (n != null && !"".equals(n)) {
            httpSession.setAttribute("tname", tea.getTname());
            httpSession.setAttribute("tid", tid);
            httpSession.removeAttribute("msg");
            return new ModelAndView(new RedirectView("../teacher/teacherIndex.jsp"));
        } else {
            httpSession.setAttribute("msg","账号或密码不正确，登录失败!");
            return new ModelAndView(new RedirectView("../index.jsp"));
        }
    }
    // 教师退出登录
    @RequestMapping("/teacherlogout")
    public ModelAndView teacherLogout(HttpSession httpSession) {

        httpSession.removeAttribute("tid");
        httpSession.removeAttribute("tname");
        httpSession.removeAttribute("couList");
        httpSession.removeAttribute("sesList");
        httpSession.removeAttribute("lookList");

        return new ModelAndView(new RedirectView("/Class-master/index.jsp"));
    }

    //管理员登录
    @RequestMapping(value = "/adminlogin")
    public ModelAndView loginAdmin(@RequestParam("aname") String aname, @RequestParam("apassword") String apassword,
                             Model model, HttpSession httpSession, HttpServletRequest reuqest) {
        String n = null;
        n = adminServiceImpl.queryByNamePwd(aname,apassword);
        //n存在
        if (n != null && !"".equals(n)) {
            httpSession.setAttribute("aname", aname);
            httpSession.removeAttribute("msg");
            return new ModelAndView(new RedirectView("../admin/adminIndex.jsp"));
        } else {
            httpSession.setAttribute("msg","账号或密码不正确，登录失败!");
            return new ModelAndView(new RedirectView("../index.jsp"));
        }
    }

    // 管理员退出登录
    @RequestMapping("/adminlogout")
    public ModelAndView adminLogout(HttpSession httpSession) {
        httpSession.removeAttribute("aname");
        httpSession.removeAttribute("couList");
        return new ModelAndView(new RedirectView("/Class-master/index.jsp"));
    }
}
