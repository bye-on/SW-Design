import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSignUpGUI extends JFrame implements ActionListener {

    private JTabbedPane tabbedPane;
    private JPanel loginPanel;
    private JPanel signUpPanel;

    private JLabel usernameLabel;
    private JTextField usernameField;
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    private JRadioButton applicantButton;
    private JRadioButton employerButton;
    private JButton loginButton;

    private JLabel signUpUsernameLabel;
    private JTextField signUpUsernameField;
    private JLabel signUpPasswordLabel;
    private JPasswordField signUpPasswordField;
    private JComboBox<String> userTypeComboBox;
    private JButton signUpButton;

    public LoginSignUpGUI() {
        setTitle("Actor Login & Sign Up");

        // 로그인 탭 구성
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(20, 20, 80, 25);
        loginPanel.add(usernameLabel);
        usernameField = new JTextField();
        usernameField.setBounds(100, 20, 165, 25);
        loginPanel.add(usernameField);
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(20, 50, 80, 25);
        loginPanel.add(passwordLabel);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        loginPanel.add(passwordField);
        applicantButton = new JRadioButton("Applicant");
        applicantButton.setBounds(20, 80, 100, 25);
        employerButton = new JRadioButton("Employer");
        employerButton.setBounds(130, 80, 100, 25);
        loginPanel.add(applicantButton);
        loginPanel.add(employerButton);
        ButtonGroup userGroup = new ButtonGroup();
        userGroup.add(applicantButton);
        userGroup.add(employerButton);
        loginButton = new JButton("Login");
        loginButton.setBounds(100, 120, 80, 25);
        loginButton.addActionListener(this);
        loginPanel.add(loginButton);

        // 회원가입 탭 구성
        signUpPanel = new JPanel();
        signUpPanel.setLayout(null);
        signUpUsernameLabel = new JLabel("Username:");
        signUpUsernameLabel.setBounds(20, 20, 80, 25);
        signUpPanel.add(signUpUsernameLabel);
        signUpUsernameField = new JTextField();
        signUpUsernameField.setBounds(100, 20, 165, 25);
        signUpPanel.add(signUpUsernameField);
        signUpPasswordLabel = new JLabel("Password:");
        signUpPasswordLabel.setBounds(20, 50, 80, 25);
        signUpPanel.add(signUpPasswordLabel);
        signUpPasswordField = new JPasswordField();
        signUpPasswordField.setBounds(100, 50, 165, 25);
        signUpPanel.add(signUpPasswordField);
        userTypeComboBox = new JComboBox<>(new String[]{"Applicant", "Employer"});
        userTypeComboBox.setBounds(20, 80, 100, 25);
        signUpPanel.add(userTypeComboBox);
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(100, 120, 80, 25);
        signUpButton.addActionListener(this);
        signUpPanel.add(signUpButton);

        // 탭 패널에 추가
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Sign Up", signUpPanel);
        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            String userType = "";
            if (applicantButton.isSelected()) {
                userType = "Applicant";
            } else if (employerButton.isSelected()) {
                userType = "Employer";
            }
            // 입력된 자격 증명을 사용하여 로그인 처리 수행
            // userType에 따라 해당 계정의 기능 사용 가능
        } else if (e.getSource() == signUpButton) {
            String username = signUpUsernameField.getText();
            char[] password = signUpPasswordField.getPassword();
            String userType = (String) userTypeComboBox.getSelectedItem();
            if (username.equals("guest") && String.valueOf(password).equals("guest")) {
                userType = "Administer";
            }
            // 사용자 이름, 비밀번호 및 userType 정보를 사용하여 회원가입 처리 수행
        }
    }

    public static void main(String[] args) {
        new LoginSignUpGUI();
    }
}