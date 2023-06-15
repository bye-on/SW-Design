public class Member {
    private String name;
    private String ID;
    private String passWord;
    private String tel;
    private String eMail;
    private int approach;

    public Member(String ID, String passWord, String name, String tel, String eMail, int approach) {
        this.ID = ID;
        this.passWord = passWord;
        this.name = name;
        this.tel = tel;
        this.eMail = eMail;
        this.approach = approach;
    }

    public Member() {
        // Default constructor
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setApproach(int approach) {
        this.approach = approach;
    }

    public String getID() {
        return ID;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getName() {
        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getEMail() {
        return eMail;
    }

    public int getApproach() {
        return approach;
    }
}
