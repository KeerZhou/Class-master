<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head><script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
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
	<jsp:include page="adminLeft.jsp" />
	<div class="container">
		<div class="row"> 
			<div class="col-md-12">
				<h5>修改学生</h5>
				<c:forEach var="student" items="${requestScope.studentList}">
							
						<form action="../moditystud/${student.sid}" method="get">
				<div class="row">
					
							<div class="col-md-6">
								<h6>姓名</h6>
						<input type="text" name="sname" value="${student.sname }" class="form-control" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4"></input>
						<h6>身份证号</h6>
						<input type="text" name="sidcard" value="${student.sidcard }" class="form-control" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="18"></input>
						
						<h6>性别</h6>
						<c:choose>
							<c:when test="${student.ssex == '男'}">
								<label class="radio" for="radio1">
			                  		<input type="radio" name="ssex" value="男" checked id="radio1" data-toggle="radio" class="custom-radio">
			               			<span class="icons">
			               				<span class="icon-unchecked"></span>
			               				<span class="icon-checked"></span>
			               			</span>
			               			<font style="vertical-align: inherit;">
			               				<font style="vertical-align: inherit;">
			               			 		男
			               				</font>
			               			</font>
               					</label>
               					
               					<label class="radio" for="radio2">
			                  		<input type="radio" name="ssex" value="女" id="radio2" data-toggle="radio" class="custom-radio">
			               			<span class="icons">
			               				<span class="icon-unchecked"></span>
			               				<span class="icon-checked"></span>
			               			</span>
			               			<font style="vertical-align: inherit;">
			               				<font style="vertical-align: inherit;">
			               			 		女
			               				</font>
			               			</font>
               					</label>
							
							</c:when>
						
							<c:otherwise>
								<label class="radio" for="radio1">
			                  		<input type="radio" name="ssex" value="男"  id="radio1" data-toggle="radio" class="custom-radio">
			               			<span class="icons">
			               				<span class="icon-unchecked"></span>
			               				<span class="icon-checked"></span>
			               			</span>
			               			<font style="vertical-align: inherit;">
			               				<font style="vertical-align: inherit;">
			               			 		男
			               				</font>
			               			</font>
               					</label>
               					
               					<label class="radio" for="radio2">
			                  		<input type="radio" name="ssex" value="女" checked id="radio2" data-toggle="radio" class="custom-radio">
			               			<span class="icons">
			               				<span class="icon-unchecked"></span>
			               				<span class="icon-checked"></span>
			               			</span>
			               			<font style="vertical-align: inherit;">
			               				<font style="vertical-align: inherit;">
			               			 		女
			               				</font>
			               			</font>
               					</label>
							
							</c:otherwise>
						</c:choose>
						
						
						<h6>密码</h6>
						<input type="password" name="spassword" value="${student.spassword }" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"></input>
								
							</div>
							<div class="col-md-6">
							
							<h6>年龄</h6>
						<input type="text" name="sage" value="${student.sage}" class="form-control" maxlength="2"></input>
							
							<h6>专业 ${student.profession }</h6>
							<select name="profession"
								class="form-control select select-primary select-block mbl" id="belongcoll">
								<option value="">-请选择学院-</option>
							</select>
							
							<h6>学院 ${student.college}</h6>
							<select name="college"
								class="form-control select select-primary select-block mbl" id="belongpro">
								<option value="">-请选择专业-</option>
							</select>
							
							<h6>班级 ${student.classr }</h6>
							<select name="classr"
								class="form-control select select-primary select-block mbl" id="belongcla">
								<option value="">-请选择班级-</option>
							</select>
							
							
							
							</div>
							<div class="col-md-12">
								<input type="submit" class="btn btn-primary btn-wide login-btn" style="margin-top:2rem" value="修改" />
							</div>
							
				</div>
	</form>
					</c:forEach>
   					
</div>
</div>
</div>


	<script type="text/javascript" src="/Class-master/utils/scripts/flat-ui.js"></script><script src="/Class-master/utils/scripts/bganimation.js"></script>
	
	
	<script type="text/javascript">
    
$("form").submit(function(){
  //当表单提交的时候，对字段验证，并根据需要放出提示
  if($.trim($("#belongcoll").val())==""){
      alert("学院不能为空");
      return false;//终止表单提交
      
  }else if($.trim($("#belongpro").val())==""){
      alert("专业不能为空");
      return false;//终止表单提交
      
  }else if($.trim($("#belongcla").val())==""){
      alert("班级不能为空");
      return false;//终止表单提交
      
  }
});
    
    
    var arr_belongcoll = ["电子信息学院","商学院","外国语学院","机械学院"];
    var arr_belongpro = [
							["网络工程","软件工程","物联网","通信工程"],
							["市场营销","国际贸易","财务管理", "会计学"],
							["英语", "日语", "俄语", "西班牙语"],
							["机械设计", "自动化", "车辆工程", "焊接技术"]
                		];
     var arr_belongcla = [
                [
					["网络1611","网络1612","网络1711","网络1712","网络1811","网络1812"],
					["软件1611","软件1612","软件1711","软件1712","软件1811","软件1812"],
					["物联1611","物联1612","物联1711","物联1712","物联1811","物联1812"],
					["通信1611","通信1612","通信1711","通信1712","通信1811","通信1812"]
                    
                ],
                [
					["市销1611","市销1612","市销1711","市销1712","市销1811","市销1812"],
					["国贸1611","国贸1612","国贸1711","国贸1712","国贸1811","国贸1812"],
					["财务1611","财务1612","财务1711","财务1712","财务1811","财务1812"],
					["会计1611","会计1612","会计1711","会计1712","会计1811","会计1812"]
                    
                ],
                [
					["英语1611","英语1612","英语1711","英语1712","英语1811","英语1812"],
					["日语1611","日语1612","日语1711","日语1712","日语1811","日语1812"],
					["俄语1611","俄语1612","俄语1711","俄语1712","俄语1811","俄语1812"],
					["牙语1611","牙语1612","牙语1711","牙语1712","牙语1811","牙语1812"]
                    
                ],
                [
					["机械1611","机械1612","机械1711","机械1712","机械1811","机械1812"],
					["自动1611","自动1612","自动1711","自动1712","自动1811","自动1812"],
					["车辆1611","车辆1612","车辆1711","车辆1712","车辆1811","车辆1812"],
					["焊接1611","焊接1612","焊接1711","焊接1712","焊接1811","焊接1812"]
                    
                ]
                ];
  
    var ocoll=document.getElementById("belongcoll");
    var opro=document.getElementById("belongpro");
    var ocla=document.getElementById("belongcla");


    var  quanju_arr;//创建一个全局对象，用于存储一个中间数组

    function input_arr(arr,event){//封装一个函数，用于向下拉栏中添加元素
        for(var i=0;i<arr.length;i++){//下拉栏内的元素来源于数组中的元素，遍历数组
            var option=new Option(arr[i],i);//创建Option对象（这个O要大写），存入值
            event.appendChild(option);//把option添加到event对象的末尾
        }
    }

    input_arr(arr_belongcoll,ocoll);//调用,给省下拉栏添元素

    ocoll.onchange= function () {//给下拉栏绑定事件（当下拉栏元素改变时执行）
        
        opro.options.length=1;//当省下拉栏改变时，清空市的下拉栏内元素
        ocla.options.length=1;//当省下拉栏改变时，清空县的下拉栏内元素
        
        var index=this.value;//每一个option标签都有一个value值索引，获取索引，用于数组中元素的选择
        var arr_pro_next=arr_belongpro[index];//获取当前选择省的市元素并赋给一个数组
        quanju_arr=arr_belongcla[index];//获取当前选择省中市的县元素并赋给定义的中间数组
        input_arr(arr_pro_next,opro);//调用,给市下拉栏添元素
    }

    opro.onchange= function () {
        ocla.options.length=1;
        var index=this.value;
        var arr_cla_next=quanju_arr[index];
        input_arr(arr_cla_next,ocla);//调用,给县下拉栏添元素
    }


</script>
	
	
	<script>
		$("select").select2({
			dropdownCssClass : 'dropdown-inverse'
		});
	</script>
	</body>
</html>