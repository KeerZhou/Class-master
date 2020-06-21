<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport"
          content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="shortcut icon" href="/Class-master/utils/image/favicon.ico"
          type="utils/image/x-icon" />
    <meta charset="UTF-8">
    <title>学生选课管理系统</title>

    <script type="text/javascript" src="utils/js/jquery-3.3.1.min.js"></script>

    <!-- Loading Bootstrap -->
    <link href="utils/css/vendor/bootstrap.min.css" rel="stylesheet">

    <!-- Loading Flat UI Pro -->
    <link href="utils/css/flat-ui.css" rel="stylesheet">

    <!-- Loading Flat UI Pro -->
    <link href="utils/css/animate.css" rel="stylesheet">

    <link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
          rel='stylesheet' type='text/css'>
    <script type='text/javascript' src='utils/scripts/particles.js'></script>
    <!--<script type='text/javascript' src='scripts/jquery.particleground.js'></script>-->
    <script src="utils/js/bootstrap.min.js"></script>
    <style>
        .login-plane {
            padding: 2rem;
            margin-top: 3rem;
        }

        .center-block {
            display: block;
            margin-left: auto;
            margin-right: auto;
        }

        .center-carousel {
            width: 33%;
            margin-left: auto;
            margin-right: auto;
        }

        .login-btn {
            width: 100%;
            margin-top: 1rem;
        }

        .container {
            padding-top: 4rem;
        }
        .login-check {
            text-align: center;
            color: red;
        }

        body {
            /*background: url(image/bj.jpg)*/

        }
    </style>

    <link href="/Class-master/utils/css/animate.css" rel="stylesheet">
</head>
<body style="display: flex;">


<div id="particles-js">
    <canvas class="particles-js-canvas-el" width="1322" height="774"
            style="width: 100%; height: 100%;">
    </canvas>
</div>
<div class="container" id="particles"
     style="position: relative; top: -4rem; margin: auto;">
    <div class="row">
        <div class="col-md-12">
            <h4 class="text-center animated bounceInDown">学生选课管理系统</h4>


            <div class="login-check">
                <%-- 提示信息--%>
                <span>${msg}</span>
            </div>
        </div>
        <div class="col-md-12">
            <div class="row login-plane animated fadeIn">
                <div class="col-md-4 center-block">
                    <form method="post" name="login" id="login" action=""
                          onsubmit="return submitHandler()">
                        <strong>账号信息</strong>
                        <div class="form-group has-feedback">
                            <input name="" type="text" id="userid" value=""
                                   placeholder="userid" class="form-control" m="userid"
                                   onkeyup="value=value.replace(/[\u4e00-\u9fa5]|(^\s+)|(\s+$)/ig,'')"
                                   maxlength="12" /> <span class="form-control-feedback fui-user"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input name="" type="password" value="" id="password"
                                   placeholder="password" class="form-control" m="password"
                                   onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');"
                                   maxlength="16" /> <span class="form-control-feedback fui-lock"></span>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <strong>角色信息</strong>
                            </div>
                            <div class="col-md-4">
                                <label class="radio" for="radio1"> <input type="radio"
                                                                          name="optionsRadios1" value="student" checked="checked"
                                                                          id="radio1" data-toggle="radio" class="custom-radio">
                                    <span class="icons"> <span class="icon-unchecked"></span>
											<span class="icon-checked"></span>
									</span> <font style="vertical-align: inherit;"> <font
                                            style="vertical-align: inherit;"> 学生 </font>
                                    </font>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <label class="radio" for="radio2"> <input type="radio"
                                                                          name="optionsRadios1" value="teacher" id="radio2"
                                                                          data-toggle="radio" class="custom-radio"> <span
                                        class="icons"> <span class="icon-unchecked"></span> <span
                                        class="icon-checked"></span>
									</span> <font style="vertical-align: inherit;"> <font
                                        style="vertical-align: inherit;"> 老师 </font>
                                </font>
                                </label>
                            </div>
                            <div class="col-md-4">
                                <label class="radio" for="radio3"> <input type="radio"
                                                                          name="optionsRadios1" value="admin" id="radio3"
                                                                          data-toggle="radio" class="custom-radio"> <span
                                        class="icons"> <span class="icon-unchecked"></span> <span
                                        class="icon-checked"></span>
									</span> <font style="vertical-align: inherit;"> <font
                                        style="vertical-align: inherit;"> 管理员 </font>
                                </font>
                                </label>
                            </div>
                        </div>

                        <input class="btn btn-primary btn-wide login-btn" value="LOGIN"
                               type="submit" />
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    var useridEle = document.getElementById("userid");
    var passwordEle = document.getElementById("password");
    var roleRadio = document.getElementsByName("optionsRadios1");

    /*
     * 点击登录执行的逻辑
     */
    function submitHandler() {

        if (!vali()) {
            return false;
        }

        var role = 'student';

        for (var i = 0; i < roleRadio.length; i++) {
            if (roleRadio[i].checked) {
                role = roleRadio[i].value;
            }
        }

        var action = null;
        if (role == 'student') {
            action = "/Class-master/LoginController/studentlogin";
            useridEle.name = "sid";
            passwordEle.name = "spassword";
        } else if (role == 'teacher') {
            action = "/Class-master/LoginController/teacherlogin";
            useridEle.name = "tid";
            passwordEle.name = "tpassword";
        } else {
            action = "/Class-master/LoginController/adminlogin";
            useridEle.name = "aname";
            passwordEle.name = "apassword";
        }
        document.getElementById("login").action = action;
        return true;
    }

    function vali() {
        var valiObjs = createInputMsgObj([ 'userid', 'password' ])

        for (var i = 0; i < valiObjs.length; i++) {
            console.log(valiObjs[i].el.val())
            if (valiObjs[i].el.val() == null || valiObjs[i].el.val() == '') {
                valiObjs[i].el.css({
                    "border-color" : "red"
                })
                console.log(valiObjs[i].el)
                var alertEl = $("<div style=\"position:fixed;top:1rem;right:1rem;\" class=\"alert alert-warning\">"
                    + valiObjs[i].msg + "没有填写！" + "</h5></div>")
                $("body").append(alertEl);
                setTimeout(function() {
                    alertEl.remove();
                }, 1000)
                return false;
            }
        }
        return true;
    }

    function createInputMsgObj(ids) {
        var objs = [];

        for (var i = 0; i < ids.length; i++) {

            var obj = {
                el : $("#" + ids[i]),
                msg : $("#" + ids[i]).attr('m')
            }
            objs.push(obj);
        }

        return objs;
    }
</script>
<script src="utils/scripts/bganimation.js"></script>
</body>
</html>