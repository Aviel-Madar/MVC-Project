package da;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
import util.DBUtil;

public class AppointmentDA {
	
	private Connection connection;

	public AppointmentDA() {
			connection = DBUtil.getConnection();
		}

		public void addAppointment(Appointment appointment) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("insert into appointment(shiftid,patientid,start_shift_app,end_shift_app) values ( ? , ? , ? , ?)");
				preparedStatement.setInt(1, appointment.getShiftid());
				preparedStatement.setInt(2, appointment.getPatientid());
				preparedStatement.setString(3, appointment.getStart_shift_app());
				preparedStatement.setString(4, appointment.getEnd_shift_app());
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void deleteAppointment(int appointmentid) {
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("delete from appointment where appointmentid=?");
				preparedStatement.setInt(1, appointmentid);
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void updateAppointment(Appointment appointment) {
			
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement("update appointment set shiftid=?, patientid=?, start_shift_app=?, end_shift_app=?, comments=? where appointmentid=? ");
				
				preparedStatement.setInt(1, appointment.getShiftid());
				preparedStatement.setInt(2, appointment.getPatientid());
				preparedStatement.setString(3, appointment.getStart_shift_app());
				preparedStatement.setString(4, appointment.getEnd_shift_app());
				preparedStatement.setString(5, appointment.getComments());
				preparedStatement.setInt(6, appointment.getAppointmentid());
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		public List<Appointment> getAllAppointment() {
			List<Appointment> appointments = new ArrayList<Appointment>();
			try {
				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("select * from appointment order by appointmentid asc");
				while (rs.next()) {
					Appointment appointment = new Appointment();
					appointment.setAppointmentid(rs.getInt("appointmentid"));
					appointment.setShiftid(rs.getInt("shiftid"));
					appointment.setPatientid(rs.getInt("patientid"));
					appointment.setStart_shift_app(rs.getString("start_shift_app"));
					appointment.setEnd_shift_app(rs.getString("end_shift_app"));
					appointment.setComments(rs.getString("comments"));
					
					appointments.add(appointment);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return appointments;
		}
		
		public Appointment getAppointmentById(int appointmentid) {
			Appointment appointment = new Appointment();
			try {
				PreparedStatement preparedStatement = connection.
						prepareStatement("select * from appointment where appointmentid=?");
				preparedStatement.setInt(1, appointmentid);
				ResultSet rs = preparedStatement.executeQuery();
				
				if (rs.next()) {
					appointment.setAppointmentid(rs.getInt("appointmentid"));
					appointment.setShiftid(rs.getInt("shiftid"));
					appointment.setPatientid(rs.getInt("patientid"));
					appointment.setStart_shift_app(rs.getString("start_shift_app"));
					appointment.setEnd_shift_app(rs.getString("end_shift_app"));
					appointment.setComments(rs.getString("comments"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return appointment;
		}
	

}
