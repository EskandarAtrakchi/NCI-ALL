
package healthconnect;

/**
 *
 * @author Eskandar Atrakchi
 */
public class UserProfile {
    
    protected int patientId;
    protected String patientFirstName;
    protected String patientLastName;
    protected String patientAddress;
    protected int patientAge;
    protected String patientPassword;

    public UserProfile() {
    }

    public UserProfile(int patientId, String patientFirstName, String patientLastName, String patientAddress, int patientAge, String patientPassword) {
        this.patientId = patientId;
        this.patientFirstName = patientFirstName;
        this.patientLastName = patientLastName;
        this.patientAddress = patientAddress;
        this.patientAge = patientAge;
        this.patientPassword = patientPassword;
    }
    
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientFirstName() {
        return patientFirstName;
    }

    public void setPatientFirstName(String patientFirstName) {
        this.patientFirstName = patientFirstName;
    }

    public String getPatientLastName() {
        return patientLastName;
    }

    public void setPatientLastName(String patientLastName) {
        this.patientLastName = patientLastName;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientPassword() {
        return patientPassword;
    }

    public void setPatientPassword(String patientPassword) {
        this.patientPassword = patientPassword;
    }

    @Override
    public String toString() {
        return "UserProfile{" + "patientId=" + patientId + ", patientFirstName=" + patientFirstName + ", patientLastName=" + patientLastName + ", patientAddress=" + patientAddress + ", patientAge=" + patientAge + ", patientPassword=" + patientPassword + '}';
    }
}
