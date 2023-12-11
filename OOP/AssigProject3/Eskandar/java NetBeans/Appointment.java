package healthconnect;
/**
 *
 * @author eskandar atrakchi
 */
public class Appointment extends UserProfile {
    
    private int appointmentId;
    private String date;
    private String contactNumber;
    private String doctorName;

    public Appointment() {
    }

    public Appointment(int appointmentId, String date, String contactNumber, String doctorName, int patientId, String patientFirstName, String patientLastName, String patientAddress, int patientAge, String patientPassword) {
        super(patientId, patientFirstName, patientLastName, patientAddress, patientAge, patientPassword);
        this.appointmentId = appointmentId;
        this.date = date;
        this.contactNumber = contactNumber;
        this.doctorName = doctorName;
    }
   
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @Override
    //I will use toString method in
    //1. display method on appointment tab 
    public String toString() {
        return "The appointments that been booked are\nAppointment{" + "appointmentId=" + appointmentId + ", date=" + date + ", contactNumber=" + contactNumber + ", doctorName=" + doctorName + '}';   
    }
}
