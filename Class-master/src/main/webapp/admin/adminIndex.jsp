<%--
  Created by IntelliJ IDEA.
  User: sjy
  Date: 2020/5/19
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
    <meta charset="UTF-8">
    <title>学生选课管理系统</title>
    <script type="text/javascript" src="/Class-master/utils/js/jquery-3.3.1.min.js"></script>
    <!-- Loading Bootstrap -->
    <link href="/Class-master/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
    <!-- Loading Flat UI Pro -->
    <link href="/Class-master/utils/css/flat-ui.css" rel="stylesheet">
    <!-- Loading animate -->
    <link href="/Class-master/utils/css/animate.css" rel="stylesheet">
    <script type='text/javascript' src='/Class-master/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<jsp:include page="adminLeft.jsp" />
<div class="main">
    <div class="main_left" id="frmTitle">

    </div>
    <div class="picBox" onclick="switchSysBar()" id="switchPoint" ></div>
    <div style="margin-top: 10rem;">
        <h3 class="text-center bounceIn animated">欢迎 ${sessionScope.aname} 管理员</h3>
        <h3 class="text-center flipInX animated" id="timer"></h3>
    </div>

</div>
<script src="/Class-master/utils/js/timer.js"></script>
<script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.js"></script><script src="/Class-master/utils/scripts/bganimation.js"></script></body>
</html>
