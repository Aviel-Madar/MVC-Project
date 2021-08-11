package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import da.ShiftDA;
import model.Shift;

public class ShiftController extends HttpServlet{

	    private static final long serialVersionUID = 1L;
	    private static String INSERT_OR_EDIT_A = "/shift.jsp";
	    private static String LIST_SHIFT = "/listShift.jsp";
	    private ShiftDA da;

	    public ShiftController() {
	        super();
	        da = new ShiftDA();
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String forward="";
	        String action = request.getParameter("action");

	        if (action.equalsIgnoreCase("delete")){
	            int shiftId = Integer.parseInt(request.getParameter("shiftId"));
	            da.deleteShift(shiftId);
	            forward = LIST_SHIFT;
	            request.setAttribute("shifts", da.getAllShift());    
	        } else if (action.equalsIgnoreCase("edit")){
	            forward = INSERT_OR_EDIT_A;
	            int shiftId = Integer.parseInt(request.getParameter("shiftId"));
	            Shift shift = da.getShiftById(shiftId);
	            request.setAttribute("shift", shift);
	        } else if (action.equalsIgnoreCase("listShift")){
	            forward = LIST_SHIFT;
	            request.setAttribute("shifts", da.getAllShift());
	        } else {
	            forward = INSERT_OR_EDIT_A;
	        }

	        RequestDispatcher view = request.getRequestDispatcher(forward);
	        view.forward(request, response);
	    }

	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Shift shift = new Shift();
	    	String doctorid = request.getParameter("doctorid");
	    	if (!(doctorid == null || doctorid.isEmpty()))
	    		shift.setDoctorid(Integer.parseInt(doctorid));
	    	String clinicid = request.getParameter("clinicid");
	    	if (!(clinicid == null || clinicid.isEmpty()))
	    		shift.setClinicid(Integer.parseInt(clinicid));
	    	shift.setDate_shift(request.getParameter("date_shift"));
	    	shift.setStart_shift(request.getParameter("start_shift"));
	    	shift.setEnd_shift(request.getParameter("end_shift"));
	    	
	    	String shiftid = request.getParameter("shiftid");
	    	if (shiftid == null || shiftid.isEmpty())
	    		da.addShift(shift);
	    	else {
	    		
	    		shift.setShiftid(Integer.parseInt(shiftid));
	    		da.updateShift(shift);
	    	}
	     
	       
	        RequestDispatcher view = request.getRequestDispatcher(LIST_SHIFT);
	        request.setAttribute("shifts", da.getAllShift());
	        view.forward(request, response);
	    }

}
