<%-- 
    Document   : newjsp
    Created on : Oct 9, 2017, 3:26:57 AM
    Author     : Ndricim Rrapi
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html"  import="com.mycompany.mavenproject1.MealParser" import="com.mycompany.mavenproject1.Day" import="java.util.ArrayList" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Meals!</h1>
        <br/>

        <%
            // make an object of the class
            MealParser parser = new MealParser();
            //monday
           
           ArrayList<String> days = parser.returnDays();
            
            
             request.setAttribute("days", days);
        %>
      
<pre>
<c:forEach var="obj" items="${days}">
<c:out value="${obj}"/>
</c:forEach>
</pre>
        
</body>
</html>

