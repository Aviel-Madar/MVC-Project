<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Show All Appointments</title>
<style>
table {
    border-collapse: collapse;
}

th, td {
    text-align: left;
    padding: 8px;
}

tr:nth-child(even){background-color: #f2f2f2}

th {
    background-color: #4CAF50;
    color: white;
}
</style>
</head>
<body>
    <table border=1>
        <thead>
            <tr>
                <th>Appointment Id</th>
                <th>Shift Id</th>
                <th>Patient Id</th>
                <th>Start Appointment</th>
                <th>End Appointment</th>
                <th>Comments</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${appointments}" var="appointment">
                <tr>
                    <td><c:out value="${appointment.appointmentid}" /></td>
                    <td><c:out value="${appointment.shiftid}" /></td>
                    <td><c:out value="${appointment.patientid}" /></td>
              		<td><c:out value="${appointment.start_shift_app}" /></td>
              		<td><c:out value="${appointment.end_shift_app}" /></td>
                    <td><c:out value="${appointment.comments}" /></td>
                    <td><a href="AppointmentController?action=edit&appointmentId=<c:out value="${appointment.appointmentid}"/>">Update</a></td>
                    <td><a href="AppointmentController?action=delete&appointmentId=<c:out value="${appointment.appointmentid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="AppointmentController?action=insert">Add Appointment</a></p>
    
</body>
</html>