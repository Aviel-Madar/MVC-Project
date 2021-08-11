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
<title>Add new Shift</title>
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
  
    <form method="POST" action='ShiftController'  name="frmAddShift" >
        Shift ID : <input type="text"  readonly="readonly" name="shiftid"
            value="<c:out value="${shift.shiftid}" />" /> <span>automatic</span><br /> 
        Doctor Id : <input
            type="text" name="doctorid"
            value="<c:out value="${shift.doctorid}" />" /><span>1500 or 1501,not null</span> <br /> 
        Clinic Id : <input
            type="text" name="clinicid" 
            value="<c:out value="${shift.clinicid}" />" /><span>1000-1004,not null</span> <br />  
        Date Shift : <input type="text" name="date_shift"
            value="<c:out value="${shift.date_shift}" />" /> <span>Date in free format</span><br />
        Start Shift : <input type="text" name="start_shift"
            value="<c:out value="${shift.start_shift}" />" /> <span>The system only works during round hours,format: --:00 not null</span><br />
        End Shift : <input type="text" name="end_shift"
            value="<c:out value="${shift.end_shift}" />" /> <span>The system only works during round hours,format: --:00 not null</span><br /> <input
            type="submit" value="Submit" />
    </form>
    
</body>
</html>