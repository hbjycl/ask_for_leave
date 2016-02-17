<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<base href="<%=basePath%>">
  <link rel="apple-touch-icon-precomposed" href="resources/assets/i/app-icon72x72@2x.png">
  <link rel="stylesheet" href="resources/assets/css/amazeui.min.css">
  <link rel="stylesheet" href="resources/assets/css/app.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!--[if (gte IE 9)|!(IE)]><!-->
<script src="resources/assets/js/jquery.min.js"></script>
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="resources/assets/js/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="resources/assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script src="resources/assets/js/amazeui.min.js"></script>