package model;

public class Shift {
	
	private int shiftid;
	private int doctorid;
	private int clinicid;
	private String date_shift;
	private String start_shift;
	private String end_shift;
	public int getShiftid() {
		return shiftid;
	}
	public void setShiftid(int shiftid) {
		this.shiftid = shiftid;
	}
	public int getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(int doctorid) {
		this.doctorid = doctorid;
	}
	public int getClinicid() {
		return clinicid;
	}
	public void setClinicid(int clinicid) {
		this.clinicid = clinicid;
	}
	public String getDate_shift() {
		return date_shift;
	}
	public void setDate_shift(String date_shift) {
		this.date_shift = date_shift;
	}
	public String getStart_shift() {
		return start_shift;
	}
	public void setStart_shift(String start_shift) {
		this.start_shift = start_shift;
	}
	public String getEnd_shift() {
		return end_shift;
	}
	public void setEnd_shift(String end_shift) {
		this.end_shift = end_shift;
	}
	@Override
	public String toString() {
		return "Shift [shiftid=" + shiftid + ", doctorid=" + doctorid + ", clinicid=" + clinicid + ", date_shift="
				+ date_shift + ", start_shift=" + start_shift + ", end_shift=" + end_shift + "]";
	}
	

}
