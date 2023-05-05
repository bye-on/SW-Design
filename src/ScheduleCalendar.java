import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class ScheduleCalendar implements ActionListener {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JButton prevMonthButton;
    private JButton nextMonthButton;
    private JLabel monthLabel;
    private JPanel calendarPanel;
    private JPanel dayPanel;
    private Calendar currentCalendar;

    public ScheduleCalendar() {
        // 프레임 생성
        frame = new JFrame("Schedule Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 캘린더 패널 생성
        calendarPanel = new JPanel();
        calendarPanel.setLayout(new BorderLayout());

        // 일정 추가/삭제/수정 버튼 생성
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(this);
        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);
        JButton editButton = new JButton("Edit");
        editButton.addActionListener(this);
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        calendarPanel.add(buttonPanel, BorderLayout.NORTH);

        // 캘린더 헤더 패널 생성
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BorderLayout());

        // 이전/다음 월 버튼 생성
        prevMonthButton = new JButton("<");
        prevMonthButton.addActionListener(this);
        nextMonthButton = new JButton(">");
        nextMonthButton.addActionListener(this);
        headerPanel.add(prevMonthButton, BorderLayout.WEST);
        headerPanel.add(nextMonthButton, BorderLayout.EAST);

        // 월 표시 라벨 생성
        monthLabel = new JLabel();
        monthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerPanel.add(monthLabel, BorderLayout.CENTER);

        // 캘린더 패널에 헤더 패널 추가
        calendarPanel.add(headerPanel, BorderLayout.NORTH);

        // 일정 목록 테이블 생성
        String[] columns = {"Date", "Time", "Description"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        JScrollPane tableScrollPane = new JScrollPane(table);
        calendarPanel.add(tableScrollPane, BorderLayout.EAST);

        // 날짜 패널 생성
        dayPanel = new JPanel();
        dayPanel.setLayout(new GridLayout(0, 7));
        dayPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        calendarPanel.add(dayPanel, BorderLayout.CENTER);

        // 현재 날짜 설정
        currentCalendar = Calendar.getInstance();
        currentCalendar.set(Calendar.DAY_OF_MONTH, 1);
        updateCalendar();

        // 프레임에 패널 추가
        frame.add(calendarPanel);

        // 프레임 크기 설정
        frame.setSize(800, 600);

        // 프레임 표시
        frame.setVisible(true);
    }

    private void updateCalendar() {
        // 월 표시 라벨 업데이트
        SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM yyyy");
        monthLabel.setText(monthFormat.format(currentCalendar.getTime()));

        // 날짜 패널 업데이트
        dayPanel.removeAll();

        // 요일 표시 라벨 추가
        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : daysOfWeek) {
            JLabel dayLabel = new JLabel(day, JLabel.CENTER);
            dayPanel.add(dayLabel);
        }

        // 첫번째 요일의 위치 찾기
        int firstDayOfWeek = currentCalendar.get(Calendar.DAY_OF_WEEK);
        for (int i = 1; i < firstDayOfWeek; i++) {
            dayPanel.add(new JLabel(""));
        }

        // 날짜 버튼 추가
        int numDaysInMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= numDaysInMonth; i++) {
            JButton dayButton = new JButton(String.valueOf(i));
            dayButton.addActionListener(this);
            dayPanel.add(dayButton);
        }

        // 날짜 패널 재구성
        dayPanel.revalidate();
        dayPanel.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        // 이전 월 버튼 클릭
        if (source == prevMonthButton) {
            currentCalendar.add(Calendar.MONTH, -1);
            updateCalendar();
        }

        // 다음 월 버튼 클릭
        else if (source == nextMonthButton) {
            currentCalendar.add(Calendar.MONTH, 1);
            updateCalendar();
        }

        // 날짜 버튼 클릭
        else if (source instanceof JButton) {
            // TODO: 해당 날짜에 대한 일정 목록을 보여준다.
            JButton button = (JButton) source;
            int dayOfMonth = Integer.parseInt(button.getText());
            System.out.println("Day of month: " + dayOfMonth);
        }

//        // 일정 추가 버튼 클릭
//        else if (source == addButton) {
//            // TODO: 일정 추가 다이얼로그를 보여준다.
//            System.out.println("Add button clicked");
//        }
//
//        // 일정 삭제 버튼 클릭
//        else if (source == deleteButton) {
//            // TODO: 선택한 일정을 삭제한다.
//            System.out.println("Delete button clicked");
//        }
//
//        // 일정 수정 버튼 클릭
//        else if (source == editButton) {
//            // TODO: 선택한 일정을 수정한다.
//            System.out.println("Edit button clicked");
//        }
    }

    public static void main(String[] args) {
        new ScheduleCalendar();
    }
}