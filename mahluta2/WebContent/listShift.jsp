<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Show All Shifts</title>
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
                <th>Shift Id</th>
                <th>Doctor Id</th>
                <th>Clinic Id</th>
                <th>Date Shift</th>
                <th>Start Shift</th>
                <th>End Shift</th>
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${shifts}" var="shift">
                <tr>
                    <td><c:out value="${shift.shiftid}" /></td>
                    <td><c:out value="${shift.doctorid}" /></td>
                    <td><c:out value="${shift.clinicid}" /></td>
              		<td><c:out value="${shift.date_shift}" /></td>
              		<td><c:out value="${shift.start_shift}" /></td>
                    <td><c:out value="${shift.end_shift}" /></td>
                    <td><a href="ShiftController?action=edit&shiftId=<c:out value="${shift.shiftid}"/>">Update</a></td>
                    <td><a href="ShiftController?action=delete&shiftId=<c:out value="${shift.shiftid}"/>">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="ShiftController?action=insert">Add Shift</a></p>
    
</body>
</html>