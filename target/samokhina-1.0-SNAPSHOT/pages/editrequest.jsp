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
      <title>Edit request</title>
  </head>
  <body>
        	<div class="form">
        	<form action="jobrequest?action=requestupdate" method="POST">
        		<h3>Edit request</h3>
        		<label for="startdate">Choose start date:</label><br>
                <input type="date" name="startdate" value="${jobRequest.getStartDate()}"></input><br>
                <label for="enddate">Choose end date:</label><br>
                <input type="date" name="enddate" value="${jobRequest.getEndDate()}"></input><br>

                <label for="description">Description:</label><br>
                <input type="text" name="description" value="${jobRequest.getDescription()}"></input><br>
                <br>
                <input type="hidden" value="${jobRequest.getId()}" name="editedRequestId"/>
                <input type="submit" value="Update" class="button"></input>
        	</form>

            <input type="submit" value="Cancel" class="button"><a href="/jobrequest?action=user"></input>

        	</div>
  </body>
</html>