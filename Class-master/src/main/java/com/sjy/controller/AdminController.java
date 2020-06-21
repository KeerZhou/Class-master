package com.sjy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sjy.po.Student;
import com.sjy.po.Teacher;
import com.sjy.service.StudentService;
import com.sjy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/AdminController")
public class AdminController {
    @Autowired
    StudentService studentService;
    @Autowired
    TeacherService teacherService;

    String[] arr_belongcoll = {"电子信息学院","商学院","外国语学院","机械学院"};
    String[][] arr_belongpro = {
            {"网络工程","软件工程","物联网","通信工程"},
            {"市场营销","国际贸易","财务管理", "会计学"},
            {"英语", "日语", "俄语", "西班牙语"},
            {"机械设计", "自动化", "车辆工程", "焊接技术"}
    };
    String[][][] arr_belongcla = {
            {
                    {"网络1611","网络1612","网络1711","网络1712","网络1811","网络1812"},
                    {"软件1611","软件1612","软件1711","软件1712","软件1811","软件1812"},
                    {"物联1611","物联1612","物联1711","物联1712","物联1811","物联1812"},
                    {"通信1611","通信1612","通信1711","通信1712","通信1811","通信1812"}

            },
            {
                    {"市销1611","市销1612","市销1711","市销1712","市销1811","市销1812"},
                    {"国贸1611","国贸1612","国贸1711","国贸1712","国贸1811","国贸1812"},
                    {"财务1611","财务1612","财务1711","财务1712","财务1811","财务1812"},
                    {"会计1611","会计1612","会计1711","会计1712","会计1811","会计1812"}

            },
            {
                    {"英语1611","英语1612","英语1711","英语1712","英语1811","英语1812"},
                    {"日语1611","日语1612","日语1711","日语1712","日语1811","日语1812"},
                    {"俄语1611","俄语1612","俄语1711","俄语1712","俄语1811","俄语1812"},
                    {"牙语1611","牙语1612","牙语1711","牙语1712","牙语1811","牙语1812"}

            },
            {
                    {"机械1611","机械1612","机械1711","机械1712","机械1811","机械1812"},
                    {"自动1611","自动1612","自动1711","自动1712","自动1811","自动1812"},
                    {"车辆1611","车辆1612","车辆1711","车辆1712","车辆1811","车辆1812"},
                    {"焊接1611","焊接1612","焊接1711","焊接1712","焊接1811","焊接1812"}

            }
    };

//    //查询全部学生方法
//    public void queryStu(HttpServletRequest request) {
//        List<Student> studentList = new ArrayList<Student>();
//        studentList = studentService.selectStudentBySql(1,10);
//
//
//        request.setAttribute("slist", studentList);
//    }
//

    public void pageIn(Model model,List list) {
        PageInfo page = new PageInfo(list, 5);
        model.addAttribute("pageInfo", page);
    }

    // 学生管理跳转页面
    @RequestMapping("/managestu/{pn}")
    public String manageStudent(HttpServletRequest request,
                                @PathVariable(value = "pn") String pn, Model model) {
        int no = Integer.parseInt(pn);

        PageHelper.startPage(no, 5);
        List<Student> studentList = new ArrayList<Student>();
        studentList = studentService.selectStudentBySql(1,10);
        pageIn(model, studentList);
        request.setAttribute("slist", studentList);
        return "admin/queryStudent";
    }

    // 查询
    @RequestMapping(value = "/query/{pn}", method = RequestMethod.GET)
    public String redirect(@RequestParam("serc") String serc, @RequestParam("condition") String condition, HttpServletRequest request,
                           @PathVariable(value = "pn") String pn, Model model) {
        int no = Integer.parseInt(pn);
// 		System.out.println("-----"+no+"----");
        List<Student> studentList = new ArrayList<Student>();
        PageHelper.startPage(no, 5);
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);
        //查询全部
        if (serc.equals("all")) {
            System.out.println("------------------------------------------------------------------------------------------------");
// 			studentList = studentService.selectStudentBySql(1,10);
// 			//model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
            studentList = studentService.selectStudentBySql(1,10);
            pageIn(model, studentList);
            request.setAttribute("slist", studentList);
            return "admin/queryStudent";

            //根据学号查询
        } else if (serc.equals("sid")) {
            studentList = studentService.getByStudentSid(1,10,condition);
            pageIn(model, studentList);
            request.setAttribute("slist", studentList);
            //System.out.println("sid");
            return "admin/queryStudent";

            //根据学院查询
        } else if (serc.equals("col")) {
            studentList = studentService.getByStudentCol(1,10,condition);
            pageIn(model, studentList);
            request.setAttribute("slist", studentList);
            //System.out.println(studentList);
            //System.out.println("col");
            return "admin/queryStudent";

            //根据专业查询
        } else if (serc.equals("pro")) {
            studentList = studentService.getByStudentPro(1,10,condition);
            pageIn(model, studentList);
            request.setAttribute("slist", studentList);
            //System.out.println(studentList);
            //System.out.println("pro");
            return "admin/queryStudent";

            //根据班级查询
        } else if (serc.equals("cla")) {
            studentList = studentService.getByStudentCla(1,10,condition);
            pageIn(model, studentList);
            //model.addAttribute("studentList", studentList);
            request.setAttribute("slist", studentList);
// 			System.out.println(studentList);
// 			System.out.println("cla");
            return "admin/queryStudent";

        } else {
// 			studentList = studentService.selectStudentBySql(1,10);
// 			model.addAttribute("studentList", studentList);
// 			request.setAttribute("slist", studentList);
// 			System.out.println("00000"+request.getAttribute("slist"));
// 			System.out.println(studentList);
            studentList = studentService.selectStudentBySql(1,10);
            pageIn(model, studentList);
            request.setAttribute("slist", studentList);
            return "admin/queryStudent";
        }
    }

    // 修改定位
    @RequestMapping(value = "/moditystu/{sid}", method = RequestMethod.GET)
    public String editPre(@PathVariable("sid") String sid, HttpServletRequest request) {

        List<Student> studentList = new ArrayList<Student>();
        studentList = studentService.getByStudentSid(1,10,sid);

        request.setAttribute("studentList", studentList);
        System.out.println("-----进入修改");
        return "admin/modiStudent";
    }

    // 修改
    @RequestMapping(value = "/moditystud/{sid}", method = RequestMethod.GET)
    public String update(@PathVariable("sid") String sid, Student student, HttpServletRequest request) {

        int col = Integer.parseInt(student.getCollege());
        int pro = Integer.parseInt(student.getProfession());
        int cla = Integer.parseInt(student.getClassr());

        student.setCollege(arr_belongcoll[pro]);
        student.setProfession(arr_belongpro[pro][col]);
        student.setClassr(arr_belongcla[pro][col][cla]);

        if (studentService.modifyStudent(student) != 0) {
            System.out.println("----修改成功--------------------------------------------------------------------------------------------------------");
            return "success";
        } else {
            System.out.println("----修改失败----------------------------------------------------------------");
            return "fail";
        }
    }

    // 删除学生
    @RequestMapping(value = "/delete/{sid}", method = RequestMethod.GET)
    public String deleteStudent(@PathVariable(value = "sid") String sid, Model model) {
        if (studentService.deleteStudent(sid) != 0) {
            System.out.println("success");

            return "success";
        } else {
            System.out.println("fail");
            return "fail";
        }

    }

    // 添加学生跳转页面
    @RequestMapping("/addstu")
    public String adStudent() {
        return "admin/addStudent";
    }

    // 添加学生
    @RequestMapping("/addStudent")
    public String addStudent(Student student, Model model) {
        int col = Integer.parseInt(student.getCollege());
        int pro = Integer.parseInt(student.getProfession());
        int cla = Integer.parseInt(student.getClassr());

        student.setCollege(arr_belongcoll[pro]);
        student.setProfession(arr_belongpro[pro][col]);
        student.setClassr(arr_belongcla[pro][col][cla]);


        if (studentService.insertStudent(student) != 0) {
            model.addAttribute("student", student);
            return "success";
            // return "admin/addStudent";
        } else {
            return "fail";
        }

    }

    /**
     * 教师相关
     */
    // 跳转到教师管理页面
    @RequestMapping("/managetea/{pn}")
    public String manageTeacher(HttpServletRequest request,
                                @PathVariable(value = "pn") String pn,Model model) {
        int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = teacherService.selectTeacherBySql(1,10);
        pageIn(model, teacherList);
        request.setAttribute("teacherList", teacherList);
        return "admin/queryTeacher";
    }

    // 跳转到添加教师页面
    @RequestMapping("/addtea")
    public String adTeacher() {
        return "admin/addTeacher";
    }

    // 添加
    @RequestMapping("/addTeacher")
    public String addTeacher(Teacher teacher, Model model, HttpSession httpSession) {

        if (teacherService.insertTeacher(teacher) != 0) {
            model.addAttribute("teacher", teacher);

            //---------------------------------待优化-----同样不能实时刷新--------------------------------------------
            return "success";
            //return new ModelAndView(new RedirectView("/StudentInfo/TeacherHandler/finalPage"));
            // return "techer/teacherFace";
        } else {
            return "fail";
            //return new ModelAndView(new RedirectView("fail"));
        }

    }

    //查询全部教师方法
    public void queryTea(HttpServletRequest request) {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = teacherService.selectTeacherBySql(1,10);
        request.setAttribute("teacherList", teacherList);
    }

    // 查询
    @RequestMapping(value = "/queryTea/{pn}", method = RequestMethod.GET)
    public String redirectTea(@RequestParam("serc") String serc, @RequestParam("condition") String condition,HttpServletRequest request,
                              @PathVariable(value = "pn") String pn,Model model) {
        int no = Integer.parseInt(pn);
        PageHelper.startPage(no, 5);
        List<Teacher> teacherList = new ArrayList<Teacher>();
        request.setAttribute("serc", serc);
        request.setAttribute("condition", condition);

        if (serc.equals("all")) {

            teacherList = teacherService.selectTeacherBySql(1,10);
            pageIn(model, teacherList);
            request.setAttribute("teacherList", teacherList);
            return "admin/queryTeacher";

        } else if (serc.equals("tid")) {

            teacherList = teacherService.getByTeacherTid(1,10,condition);
            pageIn(model, teacherList);
            request.setAttribute("teacherList", teacherList);
            System.out.println("tid");

            return "admin/queryTeacher";

        } else {

            teacherList = teacherService.selectTeacherBySql(1,10);
            pageIn(model, teacherList);
            request.setAttribute("teacherList", teacherList);
            return "admin/queryTeacher";

        }

    }



    //删除教师
    @RequestMapping(value = "/deleteTea/{tid}", method = RequestMethod.GET)
    public String deleteTeacher(@PathVariable(value = "tid") String tid, Model model) {


        if (teacherService.deleteTeacher(tid) != 0) {
            //System.out.println("success");
            //------------------------代优化，现状：删除后需要手动刷新界面或者重新查询，不能实时刷新。---------------------------------------------------
            return "success";
        } else {
            System.out.println("fail");
            return "fail";

        }

    }

    @RequestMapping(value = "/finalPageTea", method = RequestMethod.GET)
    public String finalPageTea(HttpServletRequest request) {
        queryTea(request);
        return "admin/queryTeacher";
    }

    //修改定位，可优化
    @RequestMapping(value = "/modityTea/{tid}", method = RequestMethod.GET)
    public String editPreTea(@PathVariable("tid") String tid, HttpServletRequest request) {

        List<Teacher> teacherList = new ArrayList<Teacher>();
        teacherList = teacherService.getByTeacherTid(1,10,tid);
        //model.addAttribute("teacherList", teacherList);
        request.setAttribute("teacherList", teacherList);

        return "admin/modiTeacher";
    }

    // 修改
    @RequestMapping(value = "/modityTeac/{tid}", method = RequestMethod.GET)
    public String update(@PathVariable("tid") String tid, Teacher teacher, HttpServletRequest request) {

        if (teacherService.modifyTeacher(teacher) != 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    /**
     * 课程相关
     */
    // 跳转到添加课程页面
    @RequestMapping("/addcou")
    public String adCourse() {
        return "admin/addCourse";
    }

}
