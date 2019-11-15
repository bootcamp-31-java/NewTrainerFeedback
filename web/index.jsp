<%-- 
    Document   : index
    Created on : Nov 12, 2019, 1:27:20 PM
    Author     : Aseprudin
--%>

<%@page import="java.util.List"%>
<%@page import="models.Role"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }

            tr:nth-child(even) {
                background-color: #dddddd;
            }
        </style>
    </head>
    <%
        List<Role> roles = (List<Role>) session.getAttribute("roles");

        if (roles != null) {
    %>
    <body>
        <form action="roleservlet" method="POST">
            ID:<br>
            <input type="text" name="id" >
            <br>
            Name:<br>
            <input type="text" name="name">
            <br><br>
            <input type="submit" value="Submit">
        </form> 
        <table>
            <tr>
                <th>No</th>
                <th>Id</th>
                <th>Name</th>
            </tr>
            <%
                int record = 1;
                for (Role role : roles) {
            %>
            <tr>
                <td><%=record++%></td>
                <td><%=role.getId()%></td>
                <td><%=role.getName()%></td>
            </tr>
            <%}%>
        </table>
    </body>
    <%
        } else {
            response.sendRedirect("roleservlet");
        }
        session.removeAttribute("roles");
    %>

</html>
