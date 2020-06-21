<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
  <a class="navbar-brand" href="#">学生选课管理系统</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
  <ul class="nav navbar-nav mr-auto" >

			<li><a href="/Class-master/AdminController/managestu/1"><strong>学生管理</strong></a>
		
			<li><a href="/Class-master/AdminController/managetea/1"><strong>教师管理</strong></a>
			
			
			
			
			<li><a href="/Class-master/CourseController/managecou/1"><strong>课程管理</strong></a>
			
			<li><a href="/Class-master/AdminController/addstu"><strong>添加学生</strong></a>
			
			<li><a href="/Class-master/AdminController/addtea"><strong>添加教师</strong></a>
			
			<li><a href="/Class-master/AdminController/addcou"><strong>添加课程</strong></a>
		</ul>
 
	<p class="navbar-text navbar-right">你好！ ${sessionScope.aname} <a href="/Class-master/LoginController/adminlogout" class="navbar-link" href="#">注销</a></p>
	<!--
    <ul class="nav navbar-nav mr-auto">
      <li class="active"><a href="#fakelink">Products</a></li>
      <li><a href="#fakelink">Features</a></li>
    </ul>-->
  </div> <!--/.navbar-collapse -->
</nav><!-- /navbar -->



