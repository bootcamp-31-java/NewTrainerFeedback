<%-- 
    Document   : schedule
    Created on : Nov 13, 2019, 1:38:25 PM
    Author     : Aseprudin
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="models.Materi"%>
<%@page import="models.Trainer"%>
<%@page import="models.Room"%>
<%@page import="models.Shcedule"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        List<Shcedule> shcedules = (List<Shcedule>) session.getAttribute("shcedules");
        List<Room> rooms = (List<Room>) session.getAttribute("rooms");
        List<Trainer> trainers = (List<Trainer>) session.getAttribute("trainers");
        List<Materi> materis = (List<Materi>) session.getAttribute("materis");

        if (shcedules != null) {
    %>
    <body>
        <form action="scheduleservlet" method="POST">
            Trainer Name:<br>
            <select name="trainer">    
                <option value="null">---</option>
                <%
                    for (Trainer trainer : trainers) {
                %>
                <option name="trainer" value="<%=trainer.getId()%>"><%=trainer.getEmployee().getName()%></option>
                <%}%>
            </select>
            <br>
            Room Name:<br>
            <select name="room">    
                <option value="null">---</option>
                <%
                    for (Room room : rooms) {
                %>
                <option name="room" value="<%=room.getId()%>"><%=room.getName()%></option>
                <%}%>
            </select>
            <br>
            Materi:<br>
            <select name="materi">    
                <option value="null">---</option>
                <%
                    for (Materi materi : materis) {
                %>
                <option name="materi" value="<%=materi.getId()%>"><%=materi.getTitle()  %></option>
                <%}%>
            </select>
            <br>
            Event Date:<br>
            <input name="eventDate" type="date" data-date="" data-date-format="" value="">
            <input type="submit" value="Submit">
        </form>
        <table>
            <tr>
                <th>No</th>
                <th>Id</th>
                <th>Name Trainer</th>
                <th>Materi</th>
                <th>Room</th>
                <th>Date</th>

            </tr>
            <%
                int record = 1;
                for (Shcedule shcedule : shcedules) {
            %>
            <tr>
                <td><%=record++%></td>
                <td><%=shcedule.getId()%></td>
                <td><%=shcedule.getTrainer().getName()%></td>
                <td><%=shcedule.getTitle().getTitle()%></td>
                <td><%=shcedule.getRoom().getName()%></td>                
                <td><%=shcedule.getEventDate()%></td>
            </tr>
            <% } %>
        </table>
    </body>

    <%
        } else {
            response.sendRedirect("scheduleservlet");
        }
        session.removeAttribute("shcedules");
    %>
</html>
