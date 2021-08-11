package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Appointment;
import model.Shift;
import util.DBUtil;

public class ShiftDA {
	
	private Connection connection;

	public ShiftDA() {
			connection = DBUtil.getConnection();
		}

		public void addShift(Shift shift) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into shift(doctorid,clinicid,date_shift,start_shift,end_shift)"
								+ "values ( ? , ? , ? , ?, ?)");
				preparedStatement.setInt(1, shift.getDoctorid());
				preparedStatement.setInt(2, shift.getClinicid());
				preparedStatement.setString(3, shift.getDate_shift());
				preparedStatement.setString(4, shift.getStart_shift());
				preparedStatement.setString(5, shift.getEnd_shift());
				preparedStatement.executeUpdate();
				afterAddShift();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		

		public void deleteShift(int shiftid) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from shift where shiftid=?");
				preparedStatement.setInt(1, shiftid);
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void updateShift(Shift shift) {
			
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("update shift set doctorid=?,clinicid=?,date_shift=?,start_shift=?,"
								+ "end_shift=? where shiftid=? ");
				
				preparedStatement.setInt(1, shift.getDoctorid());
				preparedStatement.setInt(2, shift.getClinicid());
				preparedStatement.setString(3, shift.getDate_shift());
				preparedStatement.setString(4, shift.getStart_shift());
				preparedStatement.setString(5, shift.getEnd_shift());
				preparedStatement.setInt(6, shift.getShiftid());
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public List<Shift> getAllShift() {
			List<Shift> shifts = new ArrayList<Shift>();
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from shift order by shiftid asc");
				while (rs.next()) {
					Shift shift = new Shift();
					shift.setShiftid(rs.getInt("shiftid"));
					shift.setDoctorid(rs.getInt("doctorid"));
					shift.setClinicid(rs.getInt("clinicid"));
					shift.setDate_shift(rs.getString("date_shift"));
					shift.setStart_shift(rs.getString("start_shift"));
					shift.setEnd_shift(rs.getString("end_shift"));
					
					shifts.add(shift);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return shifts;
		}
		
		public Shift getShiftById(int shiftid) {
			Shift shift = new Shift();
			try {
				PreparedStatement preparedStatement = connection.
						prepareStatement("select * from shift where shiftid=?");
				preparedStatement.setInt(1, shiftid);
				ResultSet rs = preparedStatement.executeQuery();
				
				if (rs.next()) {
					shift.setShiftid(rs.getInt("shiftid"));
					shift.setDoctorid(rs.getInt("doctorid"));
					shift.setClinicid(rs.getInt("clinicid"));
					shift.setDate_shift(rs.getString("date_shift"));
					shift.setStart_shift(rs.getString("start_shift"));
					shift.setEnd_shift(rs.getString("end_shift"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return shift;
		}
		
		
		public void afterAddShift(){
			Shift shift = new Shift();
			int newShift=0;
			String startS ="";
			String endS = "";
			try {
				PreparedStatement preparedStatement = connection.
						prepareStatement("select * from shift where "
								+ "shiftid=(select max(shiftid) from shift)");
				ResultSet rs = preparedStatement.executeQuery();
				
				if (rs.next()) {
					shift.setShiftid(rs.getInt("shiftid"));
					shift.setStart_shift(rs.getString("start_shift"));
					shift.setEnd_shift(rs.getString("end_shift"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			newShift=shift.getShiftid();
			startS=shift.getStart_shift();
			endS=shift.getEnd_shift();
			addAppointments(startS, endS, newShift);
			
		}
		
		public void addAppointments(String str1, String str2,int a){
			Appointment d = new Appointment();
			AppointmentDA dao = new AppointmentDA();
			d.setShiftid(a);
			
			int finish = Integer.parseInt(str2.substring(0, 2));
			int start = Integer.parseInt(str1.substring(0, 2));
			int finishMin = Integer.parseInt(str2.substring(3, 5));
			int startMin = Integer.parseInt(str1.substring(3, 5));
			
			float numOfIterations = (float) (((finish + finishMin/60.0) - (start + startMin/60.0))*4); 
			
			String now="";
			String endnow="";
			for( int i = 0; i<numOfIterations;i++){
				
				if(startMin == 0){
					now = start + ":" + startMin +"0" ; 
				    endnow = start + ":" + "15";
				    d.setStart_shift_app(now);
				    d.setEnd_shift_app(endnow);
				    dao.addAppointment(d);
				}
				else if(startMin == 45){
					now = start + ":" + startMin ; 
					endnow = start+1 + ":" + "00";
					d.setStart_shift_app(now);
				    d.setEnd_shift_app(endnow);
				    dao.addAppointment(d);

				}
				else{
					now =  start + ":" + startMin; endnow=  start + ":" + (startMin+15);
					d.setStart_shift_app(now);
				    d.setEnd_shift_app(endnow);
				    dao.addAppointment(d);
				}
				if((i+1)%4 ==0){start+=1;}
				startMin +=15;
				if(startMin>=60){
					startMin = 0;
				}
			}
			
		}

}
