package com.sjy.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjy.service.CourseService;
import com.sjy.service.StudentService;
import com.sjy.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/AjaxController")
public class AjaxController {
	@Autowired
	StudentService studentService;
	@Autowired
	TeacherService teacherService;
	@Autowired
	CourseService courseService;


	//ajax验证学生id
	@RequestMapping(value="/existSid",method = RequestMethod.POST)
	public void existSid(@RequestParam("sid") String sid,HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("学号="+sid);
 
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out=null;
		
		out=response.getWriter();
		if(studentService.getByStuSid(sid) != null && sid.length() ==12){
			out.println("学号已存在");
		}else if(sid.length() ==12){
			out.println("学号可以使用");
		}else {
			out.println("学号必须是12位");
		}
		out.flush();
		out.close();
		
	}

	//ajax验证教师id
	@RequestMapping(value="/existTid",method = RequestMethod.POST)
	public void existTid(@RequestParam("tid") String tid,HttpServletResponse response,HttpServletRequest request) throws IOException{
 
		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		PrintWriter out=null;
		
		out=response.getWriter();
		if(teacherService.getByTeaTid(tid) != null && tid.length() <=5){
			out.println("教师编号已存在");
		}else if(tid.length() <=12){
			out.println("教师编号可以使用");
		}else {
			out.println("教师编号必须小于等于5位");
		}
		out.flush();
		out.close();
		
	}

	/**
	 * ajax验证课程编号是否存在
	 * @param cid
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping(value="/existCid",method = RequestMethod.POST)
	public void existCid(@RequestParam("cid") String cid,HttpServletResponse response,HttpServletRequest request) throws IOException{
		System.out.println("课程编号="+cid);

		response.setContentType("text/html;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		System.out.println(cid+"----------");
		PrintWriter out=null;

		out=response.getWriter();
		if(courseService.getByCouCid(cid) != null && cid !=null && !"".equals(cid)){
			out.println("课程编号已存在");
		}else if(cid !=null && !"".equals(cid)){
			out.println("此课程编号可以使用");
		}else {
			out.println("课程编号不能为空");
		}
		out.flush();
		out.close();

	}

	
}
