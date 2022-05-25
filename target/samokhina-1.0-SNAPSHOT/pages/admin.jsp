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
      <title>Admin page</title>
  </head>
  <body>
        <h1>Admin page</h1>

        	<h3>Users</h3>

            <table>
            <tr>
            	<th>ID</th>
            	<th>Name</th>
            	<th>Login</th>
            	<th>Role</th>
            	<th></th>
            	<th></th>
            </tr>
            <c:forEach var="user" items="${users}">
              <tr>
               <td>
                <c:out value="${user.getId()}"/>
               </td>
               <td>
                <c:out value="${user.getName()}"/>
               </td>
               <td>
                <c:out value="${user.getLogin()}"/>
               </td>
               <td>
                <c:out value="${user.getRole().getTitle()}"/>
               </td>
              <td>
             <form action="jobrequest?action=adminedituser" method="POST">
              <input type="submit" value="Edit" name="edit" class="button"/>
              <input type="hidden" value="${user.getId()}" name="getEditedId"/>
             </form>
             </td>
             <td>
             <form action="jobrequest?action=admindeleteuser" method="POST">
              <input type="submit" value="Delete" name="delete" class="button"/>
              <input type="hidden" value="${user.getId()}" name="getDeletedId"/>
             </form>
             </td>
             </tr>
            </c:forEach>
            </table>


        	<div class="form">
        	<form action="jobrequest?action=adminadduser" method="POST">
        		<h3>Add user</h3>
        		<label for="name">Name:</label><br>
        		<input type="text" name="name"></input><br>
        		<label for="login">Login:</label><br>
        		<input type="text" name="login"></input><br>
        		<label for="password">Password:</label><br>
        		<input type="text" name="password"></input><br>
        		<label for="role">Choose role:</label><br>
        		<select name="role">
                <%
                List<Role> roles = (List<Role>) request.getAttribute("roles");
                if (roles != null) {
                    for (Role role : roles) {
                        out.println("<option>" + role.getTitle() + "</option>");
                    }
                } else out.println("<p>There are no roles yet!</p>");
                %>
                </select>
        		<br>
        		<input type="submit" value="Add" class="button"></input>
        	</form>
        	</div>
  </body>
</html>