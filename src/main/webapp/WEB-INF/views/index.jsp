<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>请假条</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="renderer" content="webkit">
    <!-- Add to homescreen for Safari on iOS -->
    <!-- 添加至主屏, 从主屏进入会隐藏地址栏和状态栏, 全屏(content="yes") -->
    <meta name="apple-mobile-web-app-capable" content="yes">

    <!-- 系统顶栏的颜色(content = black、white 和 black-translucent)选其一就可以 -->
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-status-bar-style" content="white">
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent">

    <!-- 指定标题 -->
    <meta name="apple-mobile-web-app-title" content="Web Starter Kit">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <!-- Tile icon for Win8 (144x144 + tile color) -->
    <!-- win 8 磁贴图标 -->
    <meta name="msapplication-TileImage" content="images/touch/ms-touch-icon-144x144-precomposed.png">
    <!-- win 8 磁贴颜色 -->
    <meta name="msapplication-TileColor" content="#3372DF">
    <!-- Add to homescreen for Chrome on Android -->
    <meta name="mobile-web-app-capable" content="yes">
    <%@include file="common/import.jsp" %>
</head>
<body>
<header class="am-topbar am-topbar-inverse">
    <h1 class="am-topbar-brand">
        <a href="#">请假条</a>
    </h1>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#doc-topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="doc-topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li class="am-active"><a href="#">首页</a></li>
            <li><a href="#">More...</a></li>
        </ul>
        <div class="am-topbar-right">
            <button id="loginBtn" class="am-btn am-btn-primary am-topbar-btn am-btn-sm">登录</button>
        </div>
    </div>
</header>
<form id="form" class="am-form">
    <fieldset>

        <div class="am-form-group">
            <label>部门：</label>
            <select name="departmentId" data-am-selected="{btnWidth: '100%', btnSize: 'sm',maxHeight: 100,searchBox: 1}"
                    onchange="changeNameList()">
                <option value="">-----请选择-----</option>
                <c:forEach var="department" items="${departments }">
                    <option value="${department.departmentId }">${department.departmentName }</option>
                </c:forEach>
            </select>
        </div>
        <div class="am-form-group">
            <label>姓名：</label>
            <select name="staffId" data-am-selected="{btnWidth: '100%', btnSize: 'sm',maxHeight: 100,searchBox: 1}">
                <option value="">-----请选择-----</option>
                <c:forEach var="staff" items="${staffs }">
                    <option value="${staff.staffId }">${staff.name }</option>
                </c:forEach>
            </select>
        </div>

        <div class="am-form-group">
            <label>原因：</label>
            <textarea class="" rows="5" name="context" id="context"></textarea>
        </div>

        <p>
            <a onclick="addCause()" class="am-btn am-btn-primary am-btn-block">
                提交
            </a>


        </p>
    </fieldset>
</form>

<div class="am-modal am-modal-prompt" tabindex="-1" id="login-prompt">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">登陆</div>
        <div class="am-modal-bd">
            <form id="loginForm">
                <input type="text" class="am-modal-prompt-input" placeholder="用户名" name="username">
                <input type="password" class="am-modal-prompt-input" placeholder="密码" name="password">
            </form>
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
            <span class="am-modal-btn" data-am-modal-confirm>提交</span>
        </div>
    </div>
</div>

<div class="am-modal am-modal-alert" tabindex="-1" id="success-alert">
    <div class="am-modal-dialog">
        <div class="am-modal-hd">提交成功</div>
        <div class="am-modal-bd">
            该请假事由已成功提交
        </div>
        <div class="am-modal-footer">
            <span class="am-modal-btn">确定</span>
        </div>
    </div>
</div>
<script>
    $(function () {
        $('#loginBtn').on('click', function () {
            $('#login-prompt').modal({
                relatedTarget: this,
                onConfirm: function (e) {
                    $.post("login", $('#loginForm').serialize(), function (result) {
                        if (result.rc == 0) {
                            alert("登陆成功")
                        } else if (result.rc == 1) {
                            alert(result.message);
                        }
                    })
                },
                onCancel: function (e) {
                }
            });
        });
    });

    function addCause() {
        if ($("#context").val() == null || $("#context").val() == '') {
            alert("内容不能为空");
            return;
        }
        $.post("addCause", $('#form').serialize(), function (result) {
            console.log("success");
            if (result.rc == 0) {
                $('#success-alert').modal();
            } else if (result.rc == 1) {
                alert("提交失败！");
            }
        }, "json")

    }

    function changeNameList() {
        $.get("getNameList", $('#departmentId').val(), function (data) {

            alert(data.staffId)

        })
    }

</script>
</body>
</html>