package model;

public class Appointment {
	
	private int appointmentid;
	private int shiftid;
	private int patientid=0;
	private String start_shift_app;
	private String end_shift_app;
	private String comments;
	
	public int getAppointmentid() {
		return appointmentid;
	}
	public void setAppointmentid(int appointmentid) {
		this.appointmentid = appointmentid;
	}
	public int getShiftid() {
		return shiftid;
	}
	public void setShiftid(int shiftid) {
		this.shiftid = shiftid;
	}
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getStart_shift_app() {
		return start_shift_app;
	}
	public void setStart_shift_app(String start_shift_app) {
		this.start_shift_app = start_shift_app;
	}
	public String getEnd_shift_app() {
		return end_shift_app;
	}
	public void setEnd_shift_app(String end_shift_app) {
		this.end_shift_app = end_shift_app;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	@Override
	public String toString() {
		return "Appointment [appointmentid=" + appointmentid + ", shiftid=" + shiftid + ", patientid=" + patientid
				+ ", start_shift_app=" + start_shift_app + ", end_shift_app=" + end_shift_app + ", comments=" + comments
				+ "]";
	}
	
}
