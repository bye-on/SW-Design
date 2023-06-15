import java.io.File;
import java.util.TreeMap;

public class Server {
    private TreeMap<String, Member> memInfo;
    private String currentID;
    private File resumeData;
    private File memberData;

    public Server() {
        memInfo = new TreeMap<>();
        currentID = null;
        resumeData = new File("resumeData.txt");
        memberData = new File("memberData.txt");
    }

    public File getResumeData() {
        return resumeData;
    }

    public File getMemberData() {
        return memberData;
    }
}
