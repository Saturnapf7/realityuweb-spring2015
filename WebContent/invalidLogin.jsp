<%--*******************************************************************
 *	RealityUWeb: invalidLogin.jsp
 *  03/12/2014
 *******************************************************************--%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

<title>Communities In Schools - Reality U Invalid Login</title>
<meta charset="utf-8">
<!--Edge = render site in highest standards mode possible 8, 9..., chrome = use Google engine if installed-->

<meta http-equiv="pragma" content="no-cache">

<link rel="stylesheet" href="css/reset.css" media="screen">
<link rel="stylesheet" href="css/mainstyles.css" media="screen">

<!--FOR STICKY FOOTER IN OLDER IE BROWSERS (except IE 7 OK)-->
<!--[if (lt IE 9) & (!(IE 7))]>
	<style type="text/css">
		#wrapper {display:table; height:100%;}
	</style>
<![endif]-->



</head>

<body>
<div id="wrapper">
 
<!--HEADER-->

<div id="header"><jsp:include page="HeaderTemp.jsp"/></div>

<!--END HEADER-->

<!--MAIN CONTENT CONTAINER -->
<div id="main">


<div id="title">
<h2>Invalid Login</h2>
</div>



<br><br>

<div id="mainArea">




	<h2 class="msgSpacing">
		Sorry. Your login is invalid. Please try again.
	</h2>


</div><!--END mainArea-->



</div><!--END Main Area-->


<!--FOR STICKY FOOTER-->
<div id="push"></div>


</div><!--END Content Wrapper-->


<!--FOOTER OUTSIDE WRAPPER-->
<div id="footer" class="legal">
Copyright &copy; 2009-2014 CIS of Marietta/Cobb County
</div><!--END FOOTER-->


</body>
</html>