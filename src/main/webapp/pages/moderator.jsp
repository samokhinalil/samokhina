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
      <title>Moderator page</title>
  </head>
  <body>
        <h1>Moderator page</h1>
            <h3>Job requests for assigning expert group</h3>
            <table>
            	<tr>
            		<th>ID</th>
            		<th>Start date</th>
            		<th>End date</th>
            		<th>Job type</th>
            		<th>Description</th>
            		<th>Current state</th>
            		<th>Initiator</th>
            		<th></th>
            	</tr>

            <c:forEach var="req" items="${requests}">
              <tr>
               <td>
                <c:out value="${req.getId()}"/>
               </td>
               <td>
                <c:out value="${req.getStartDate()}"/>
               </td>
               <td>
                <c:out value="${req.getEndDate()}"/>
               </td>
               <td>
                <c:out value="${req.getJobType().getTitle()}"/>
               </td>
               <td>
                <c:out value="${req.getDescription()}"/>
               </td>
               <td>
                <c:out value="${req.getState().getTitle()}"/>
               </td>
               <td>Initiator</td>
              <td>
             <form action="jobrequest?action=chooseexperts" method="POST">
              <input type="submit" value="Choose expert group" class="button"></input>
              <input type="hidden" value="${req.getId()}" name="getReqId"/>
             </form>
             </td>
             </tr>
            </c:forEach>
            </table>

        	<h3>Job states</h3>
        	<table>
        		<tr>
        			<th>ID</th>
        			<th>Title</th>
        			<th></th>
        			<th></th>
        		</tr>
        		<%
                List<State> states = (List<State>) request.getAttribute("states");
                if (states != null) {
                    for (State state : states) {
                        out.println("<tr><td>" + state.getId() + "</td><td>" + state.getTitle() + "</td>");
                        out.println("<td><input type='submit' value='Edit' class='button'></input></td>");
                        out.println("<td><input type='submit' value='Delete' class='button'></input></td></tr>");
                    }
                }
                %>

        	</table>

        	<div class="form">
        	<form action="jobrequest?action=addjobstate" method="POST">
        		<h3>Add job state</h3>
        		<label for="statetitle">Title:</label><br>
        		<input type="text" name="statetitle"></input><br>
        		<input type="submit" value="Add state" class="button"></input>
        	</form>
        	</div>

        	<h3>Job types</h3>
        	<table>
        		<tr>
        			<th>ID</th>
        			<th>Title</th>
        			<th></th>
        			<th></th>
        		</tr>
        		<%
                                List<JobType> types = (List<JobType>) request.getAttribute("types");
                                if (types != null) {
                                    for (JobType type : types) {
                                        out.println("<tr><td>" + type.getId() + "</td><td>" + type.getTitle() + "</td>");
                                        out.println("<td><input type='submit' value='Edit' class='button'></input></td>");
                                        out.println("<td><input type='submit' value='Delete' class='button'></input></td></tr>");
                                    }
                                }
                                %>
        	</table>

        	<div class="form">
        	<form action="jobrequest?action=addjobtype" method="POST">
        		<h3>Add job type</h3>
        		<label for="typetitle">Title:</label><br>
        		<input type="text" name="typetitle"></input><br>
        		<input type="submit" value="Add type" class="button"></input>
        	</form>
        	</div>
  </body>
</html>