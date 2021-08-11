package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.AppointmentDA;
import model.Appointment;

public class AppointmentController extends HttpServlet{

	    private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT_A = "/appointment.jsp";
	    private static String LIST_APPOINTMENT = "/listAppointment.jsp";
	    private AppointmentDA da;

	    public AppointmentController() {
	        super();
	        da = new AppointmentDA();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
	            da.deleteAppointment(appointmentId);
	            forward = LIST_APPOINTMENT;
	            request.setAttribute("appointments", da.getAllAppointment());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT_A;
	            int appointmentId = Integer.parseInt(request.getParameter("appointmentId"));
	            Appointment appointment = da.getAppointmentById(appointmentId);
	            request.setAttribute("appointment", appointment);
	        } else if (action.equalsIgnoreCase("listAppointment")){
	            forward = LIST_APPOINTMENT;
	            request.setAttribute("appointments", da.getAllAppointment());
	        } else {
	            forward = INSERT_OR_EDIT_A;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Appointment appointment = new Appointment();
	    	String shiftid = request.getParameter("shiftid");
	    	appointment.setShiftid(Integer.parseInt(shiftid));
	    	String patientid = request.getParameter("patientid");
	    	if (!(patientid == null || patientid.isEmpty()))
	    		appointment.setPatientid(Integer.parseInt(patientid));
	    	appointment.setStart_shift_app(request.getParameter("start_shift_app"));
	    	appointment.setEnd_shift_app(request.getParameter("end_shift_app"));
	    	appointment.setComments(request.getParameter("comments"));
	    	
	    	String appointmentid = request.getParameter("appointmentid");
	    	if (appointmentid == null || appointmentid.isEmpty())
	    		da.addAppointment(appointment);
	    	else {
	    		
	    		appointment.setAppointmentid(Integer.parseInt(appointmentid));
	    		da.updateAppointment(appointment);
	    	}
	     
	       
	        RequestDispatcher view = request.getRequestDispatcher(LIST_APPOINTMENT);
	        request.setAttribute("appointments", da.getAllAppointment());
	        view.forward(request, response);
	    }

}
