<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/Class-master/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>学生选课管理系统</title>

<!-- 标题图标、CSS、js、jQ 
<link href="/online/image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="/online/css/main.css">
<script src="/online/js/fun.js" type="text/javascript"></script>-->
<script type="text/javascript" src="/Class-master/utils/js/jquery-3.3.1.min.js"></script>

<!-- Loading Bootstrap -->
<link href="/Class-master/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/Class-master/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.min.js"></script>


<script type='text/javascript' src='/Class-master/utils/scripts/particles.js'></script><link href="/Class-master/utils/css/animate.css" rel="stylesheet"></head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
<jsp:include page="studentLeft.jsp" />
<div class="container">
		<div class="row">
			<div class="col-md-12">
			<h5>修改密码</h5>
			<form
			action="../StudentController/moditypasswordstu/${sessionScope.sid }"
			method="get">
			<div class="row">
			
				<div class="col-md-3"><input type="password" name="spassword" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/> </div>
				<div class="col-md-3"><input type="submit" class="btn btn-primary btn-wide login-btn" value="确定修改" /></div>
				
			</div>
			</form>


			
			

		
			</div></div></div>


<script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.js"></script><script src="/Class-master/utils/scripts/bganimation.js"></script></body>
</html>