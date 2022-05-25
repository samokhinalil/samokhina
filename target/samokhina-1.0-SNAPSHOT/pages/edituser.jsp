<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
        <%@include file='style.css'%>
</style>
<%@ page import="java.util.*, java.text.*, ru.rsreu.samokhina.entity.*" %>

<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Edit user</title>
  </head>
  <body>
        	<div class="form">
        	<form action="jobrequest?action=useredited" method="POST">
        		<h3>Edit user</h3>
        		<label for="name">Name:</label><br>
        		<input type="text" name="name" value="${editedUser.getName()}"></input><br>
        		<label for="login">Login:</label><br>
        		<input type="text" name="login" value="${editedUser.getLogin()}"></input><br>
        		<label for="password">Password:</label><br>
        		<input type="text" name="password" value="${editedUser.getPassword()}"></input><br>
        		<br>
        		<input type="submit" value="Edit" class="button"></input>
        		<input type="hidden" value="${editedUser.getId()}" name="editedUserId"/>
        	</form>

            <input type="submit" value="Cancel" class="button"><a href="/jobrequest?action=admin"></input>

        	</div>
  </body>
</html>