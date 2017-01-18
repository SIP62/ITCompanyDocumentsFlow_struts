<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Recruit form</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <link rel="stylesheet" type="text/css" href="css/user.css">
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>           
      </button>
      <a class="navbar-brand" href="#">IT Company</a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href='<s:url action="logout"></s:url>'>Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href='<s:url action="logout"></s:url>'><span class="glyphicon glyphicon-log-out"></span> Logout</a></li>
      </ul>
    </div>
  </div>
</nav>

<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-3 sidenav">
      <h3>Menu</h3>
      <ul class="nav nav-pills nav-stacked" style="background-color:#aaa">
		<li><s:url action="return_to_page" var="rtp_url">
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{rtp_url}">Return</s:a>
        </li>
	  </ul>
    </div>
    
    <div class="col-sm-6 text-left"> 
      <h4>Project proposal form</h4>
      <s:form class="form-horizontal" role="form" action="add_recruit" method="POST">
      	<input type="hidden" name="command" value="add_recruit" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="companyModel.recruit.name" value="${user}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="phone">Phone:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="phone" name="companyModel.recruit.phone" placeholder="Enter phone">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="email">e-Mail:</label>
		    <div class="col-sm-9">
		      <input type="email" class="form-control" id="email" name="companyModel.recruit.email" placeholder="Enter email">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="specialization">Specialization:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="specialization" name="companyModel.recruit.specialization" placeholder="Enter specialization">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="resume">Resume:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="resume" name="companyModel.recruit.resume" placeholder="Enter resume"></textarea>
		    </div>
		  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Send</button>
		    </div>
		  </div>
	  </s:form>
    </div>
    <div class="col-sm-3 sidenav">
      <div class="well">
        <h3>Welcome</h3>
	    <hr/>
        <p>${user} ${role}, hello!</p>
      </div>
      <div class="well">
        <p>${errorRecruitMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>
</body>
</html>