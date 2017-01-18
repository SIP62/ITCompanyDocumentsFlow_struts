<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project</title>
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
      <h4>Menu</h4>
      <ul class="nav nav-pills nav-stacked" style="background-color:#aaa">
      
        <c:if test="${role eq 'project_manager'}">
      	  <li><s:url action="change_executants_form" var="cef_url">
				<s:param name="projectid">${companyModel.project.id}</s:param>
				<s:param name="user_id">${user_id}</s:param>
				<s:param name="user">${user}</s:param>
				<s:param name="role">${role}</s:param>
			</s:url>
        	<s:a href="%{cef_url}">ChangeExecutants</s:a>
      	  </li>
		</c:if>
		
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
      <h4>Project ${companyModel.project.name}</h4>
      <s:form class="form-horizontal" role="form" action="update_project" method="POST">
		<input type="hidden" name="companyModel.project.id" value="${companyModel.project.id}" />
		<input type="hidden" name="user_id" value="${user_id}" />
		<input type="hidden" name="user" value="${user}" />
		<input type="hidden" name="role" value="${role}" />

		  <div class="form-group">
		    <label class="control-label col-sm-3" for="name">Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="name" name="companyModel.project.name" value="${companyModel.project.name}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="description">Project description:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="description" name="companyModel.project.description">${companyModel.project.description}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="requirements_specification">Requirements Specification:</label>
		    <div class="col-sm-9">
		      <textarea class="form-control" rows="6" id="requirements_specification" name="companyModel.project.requirementSpecification">${companyModel.project.requirementSpecification}</textarea>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="cost">Cost:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="cost" name="companyModel.project.cost" value="${companyModel.project.cost}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="start_date">Start Date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="start_date" name="companyModel.project.startDate" value="${companyModel.project.startDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="finish_date">Finish Date:</label>
		    <div class="col-sm-9">
		      <input type="date" class="form-control" id="finish_date" name="companyModel.project.finishDate" value="${companyModel.project.finishDate}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="progress">Progress:</label>
		    <div class="col-sm-9">
		      <input type="number" class="form-control" id="progress" name="companyModel.project.progress" value="${companyModel.project.progress}">
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="client_name">Client Name:</label>
		    <div class="col-sm-9">
		      <input type="text" class="form-control" id="client_name" name="companyModel.project.client.users.name" value="${companyModel.project.client.users.name}" readonly>
		    </div>
		  </div>
		  <div class="form-group">
		    <label class="control-label col-sm-3" for="executant">Executants:</label>
		    
		    <div class="col-sm-9">
		    <c:forEach var="executant" items="${companyModel.project.employees}">
		      <input type="text" class="form-control" id="executant" name="executant" value="${executant.users.name} ${executant.users.roles.role}" readonly>
		    </c:forEach>
		    </div>
		    
		  </div>
		  <div class="form-group"> 
		    <div class="col-sm-offset-3 col-sm-9">
		      <button type="submit" class="btn btn-default">Update</button>
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
        <p>${errorUpdateProjectDataMessage}</p>
      </div>
    </div>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Project Made By Sytau</p>
</footer>

</body>
</html>