<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
<title>Add new Appointment</title>
<style> 
input[type=text] {
    padding: 12px 20px;
    margin: 8px 0;
    box-sizing: border-box;
    border: none;
    background-color: #3CBC8D;
    color: white;
}
input[type=submit] {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 16px 32px;
    text-decoration: none;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
</head>
<body>
  
    <form method="POST" action='AppointmentController'  name="frmAddAppointment" >
        Appointment ID : <input type="text"  readonly="readonly" name="appointmentid"
            value="<c:out value="${appointment.appointmentid}" />" /> <span>automatic</span><br /> 
        Shift Id : <input
            type="text" name="shiftid"
            value="<c:out value="${appointment.shiftid}" />" /><span>Like above,not null</span> <br /> 
        Patient Id : <input
            type="text" name="patientid" 
            value="<c:out value="${appointment.patientid}" />" /> <span>2500 or 2501.if null,equal 0(empty patient)</span><br />  
        Start Appointment : <input type="text" name="start_shift_app"
            value="<c:out value="${appointment.start_shift_app}" />" /> <span>free</span><br />
        End Appointment : <input type="text" name="end_shift_app"
            value="<c:out value="${appointment.end_shift_app}" />" /> <span>free</span><br /> 
        Comments : <input type="text" name="comments" 
            value="<c:out value="${appointment.comments}" />" /> <span>only in update.</span><br /> <input
            type="submit" value="Submit" />
    </form>
    
</body>
</html>