import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    private JLabel signUpIDLabel;
    private JTextField signUpIDField;
    private JLabel signUpNameLabel;
    private JTextField signUpNameField;
    private JLabel signUpTelLabel;
    private JTextField signUpTelField;
    private JLabel signUpEmailLabel;
    private JTextField signUpEmailField;


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

        userTypeComboBox = new JComboBox<>(new String[]{"Applicant", "Employer"});
        userTypeComboBox.setBounds(20, 40, 100, 25);
        signUpPanel.add(userTypeComboBox);

        signUpNameLabel = new JLabel("Name:");
        signUpNameLabel.setBounds(20, 80, 80, 25);
        signUpPanel.add(signUpNameLabel);
        signUpNameField = new JTextField();
        signUpNameField.setBounds(100, 80, 165, 25);
        signUpPanel.add(signUpNameField);

        signUpIDLabel = new JLabel("ID:");
        signUpIDLabel.setBounds(20, 110, 80, 25);
        signUpPanel.add(signUpIDLabel);
        signUpIDField = new JTextField();
        signUpIDField.setBounds(100, 110, 165, 25);
        signUpPanel.add(signUpIDField);

        signUpPasswordLabel = new JLabel("Password:");
        signUpPasswordLabel.setBounds(20, 140, 80, 25);
        signUpPanel.add(signUpPasswordLabel);
        signUpPasswordField = new JPasswordField();
        signUpPasswordField.setBounds(100, 140, 165, 25);
        signUpPanel.add(signUpPasswordField);

        signUpTelLabel = new JLabel("Telephone:");
        signUpTelLabel.setBounds(20, 170, 80, 25);
        signUpPanel.add(signUpTelLabel);
        signUpTelField = new JTextField();
        signUpTelField.setBounds(100, 170, 165, 25);
        signUpPanel.add(signUpTelField);

        signUpEmailLabel = new JLabel("Email:");
        signUpEmailLabel.setBounds(20, 200, 80, 25);
        signUpPanel.add(signUpEmailLabel);
        signUpEmailField = new JTextField();
        signUpEmailField.setBounds(100, 200, 165, 25);
        signUpPanel.add(signUpEmailField);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(100, 240, 80, 25);
        signUpButton.addActionListener(this);
        signUpPanel.add(signUpButton);

        // 탭 패널에 추가
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Login", loginPanel);
        tabbedPane.addTab("Sign Up", signUpPanel);
        add(tabbedPane);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            char[] password = passwordField.getPassword();
            String userType = applicantButton.isSelected() ? "Applicant" : "Employer";

            boolean isValidUser = checkRegisteredInformation(username, new String(password), userType);
            if (isValidUser) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials!");
            }
        } else if (e.getSource() == signUpButton) {
            String username = signUpUsernameField.getText();
            char[] password = signUpPasswordField.getPassword();
            String userType = (String) userTypeComboBox.getSelectedItem();
            String id = signUpIDField.getText();
            String name = signUpNameField.getText();
            String tel = signUpTelField.getText();
            String email = signUpEmailField.getText();

            // Perform membership registration processing using username, password, and userType information
            saveSignUpInformation(username, new String(password), userType, id, name, tel, email);
        }
    }

    private boolean checkRegisteredInformation(String username, String password, String userType) {
        // Check if the login information is registered
        // You can implement your logic here to check against a file or database containing registered user information
        // For demonstration purposes, let's assume there is a registered user with username "admin" and password "admin" for all user types

        // Example implementation with hardcoded values
        if (username.equals("admin") && password.equals("admin")) {
            return true;
        } else {
            return false;
        }
    }

    private void saveSignUpInformation(String username, String password, String userType, String id, String name, String tel, String email) {
        // Save the sign-up information as a file
        // You can customize the file-saving logic according to your requirements
        // For demonstration purposes, let's assume we are saving the information in a text file called "signup.txt"

        String filename = "signup.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write("Username: " + username);
            writer.newLine();
            writer.write("Password: " + password);
            writer.newLine();
            writer.write("User Type: " + userType);
            writer.newLine();
            writer.write("ID: " + id);
            writer.newLine();
            writer.write("Name: " + name);
            writer.newLine();
            writer.write("Telephone: " + tel);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
            writer.newLine();
            writer.flush();

            JOptionPane.showMessageDialog(this, "Sign-up information saved successfully.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving sign-up information.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new LoginSignUpGUI();
    }
}