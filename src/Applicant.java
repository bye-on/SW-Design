import java.io.File;

public class Applicant {
    private String A_ID;
    private String A_tel;
    private String A_eMail;
    private File resume_No;

    public Applicant(String A_ID, String A_tel, String A_eMail) {
        this.A_ID = A_ID;
        this.A_tel = A_tel;
        this.A_eMail = A_eMail;
        this.resume_No = null;
    }

    public void RegistrationResume(File file) {
        this.resume_No = file;
        // Additional logic to handle resume registration
    }

    public File DeleteResume() {
        File deletedResume = this.resume_No;
        this.resume_No = null;
        // Additional logic to handle resume deletion
        return deletedResume;
    }

    public File ModifyResume(File file) {
        File previousResume = this.resume_No;
        this.resume_No = file;
        // Additional logic to handle resume modification
        return previousResume;
    }

    public String getA_ID() {
        return A_ID;
    }

    public String getA_tel() {
        return A_tel;
    }

    public String getA_eMail() {
        return A_eMail;
    }

    public File getResume_No() {
        return resume_No;
    }
}
