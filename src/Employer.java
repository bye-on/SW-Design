public class Employer {
    private String E_ID;
    private String E_tel;
    private String E_eMail;
    private String Scheduling_No;

    public Employer(String E_ID, String E_tel, String E_eMail) {
        this.E_ID = E_ID;
        this.E_tel = E_tel;
        this.E_eMail = E_eMail;
        this.Scheduling_No = "";
    }

    public void RegistrationScheduling(String scheduling) {
        // Code to register the scheduling
        // Implementation details omitted
        this.Scheduling_No = scheduling;
    }

    public String DeleteScheduling() {
        // Code to delete the scheduling
        // Implementation details omitted
        String deletedScheduling = this.Scheduling_No;
        this.Scheduling_No = "";
        return deletedScheduling;
    }

    public String ModifyScheduling(String scheduling) {
        // Code to modify the scheduling
        // Implementation details omitted
        String previousScheduling = this.Scheduling_No;
        this.Scheduling_No = scheduling;
        return previousScheduling;
    }

    public String ShowScheduling() {
        return this.Scheduling_No;
    }

    // Getters and setters for the attributes
    public String getE_ID() {
        return E_ID;
    }

    public void setE_ID(String E_ID) {
        this.E_ID = E_ID;
    }

    public String getE_tel() {
        return E_tel;
    }

    public void setE_tel(String E_tel) {
        this.E_tel = E_tel;
    }

    public String getE_eMail() {
        return E_eMail;
    }

    public void setE_eMail(String E_eMail) {
        this.E_eMail = E_eMail;
    }
}
