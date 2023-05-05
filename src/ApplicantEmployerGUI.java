import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ApplicantEmployerGUI extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane;

    // Applicant 탭
    private JPanel applicantPanel;
    private JButton resumeUploadButton;

    // Employer 탭
    private JPanel employerPanel;
    private JButton scheduleInterviewButton;

    public ApplicantEmployerGUI() {
        setTitle("Applicant/Employer GUI");

        // Applicant 탭 구성
        applicantPanel = new JPanel();
        applicantPanel.setLayout(null);
        resumeUploadButton = new JButton("Upload Resume");
        resumeUploadButton.setBounds(75, 50, 150, 30);  // 버튼 크기 조절
        resumeUploadButton.addActionListener(this);
        applicantPanel.add(resumeUploadButton);

// Employer 탭 구성
        employerPanel = new JPanel();
        employerPanel.setLayout(null);
        scheduleInterviewButton = new JButton("Schedule Interview");
        scheduleInterviewButton.setBounds(75, 50, 150, 30);  // 버튼 크기 조절
        scheduleInterviewButton.addActionListener(this);
        employerPanel.add(scheduleInterviewButton);


        // 탭 패널에 추가
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Applicant", applicantPanel);
        tabbedPane.addTab("Employer", employerPanel);
        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == resumeUploadButton) {
            // 이력서 업로드 처리 수행
        } else if (e.getSource() == scheduleInterviewButton) {
            // 면접 일정 등록 처리 수행
        }
    }

    public static void main(String[] args) {
        new ApplicantEmployerGUI();
    }
}
