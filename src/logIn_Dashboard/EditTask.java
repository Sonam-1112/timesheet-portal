package logIn_Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EditTask {
    JFrame frame = new JFrame("Edit Tasks");
    JPanel panel = new JPanel();
    Font font = new Font("",Font.BOLD,20);
    JButton selectdate = new JButton("Select Date");
    JTextField dateText = new  JTextField();
    JTextField taskname;
    JTextArea taskdescription;
    JComboBox projectManager;
    JComboBox projects;
    JComboBox time;
    JComboBox minutes;
    JButton add;
    JButton submit;
    EditTask(){
        frame.setJMenuBar(CommonMenu.displayMenu(frame));
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        panel.setSize(screenSize.width,screenSize.height);

        dateText.setEditable(false);
        dateText.setBounds(50,55,150,30);
        panel.add(dateText);

        selectdate.setBorderPainted(false);
        selectdate.setBackground(Color.white);
        selectdate.setFont(new Font("Times New Roman",Font.BOLD,20));
        selectdate.setBounds(50,20,150,30);
        selectdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateText.setText(new DatePicker(frame).setPickedDate());
            }
        });
        panel.add(selectdate);

        taskname = new JTextField();
        taskname.setBounds(50,100,300,30);
        taskname.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        panel.add(taskname);

        taskdescription = new JTextArea(20,100);
        taskdescription.setBounds(355,100,200,100);
        taskdescription.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        taskdescription.setLineWrap(true);
        panel.add(taskdescription);

        String s1[] = { "Project Manager", "Mumbai", "Noida", "Kolkata", "New Delhi" };

        projectManager= new JComboBox(s1);
        projectManager.setBackground(Color.white);
        projectManager.setBounds(560,100,200,40);
        //projectManager.addItemListener((ItemListener) this);
        panel.add(projectManager);

        String s2[] = { "Projects   ", "Mumbai", "Noida", "Kolkata", "New Delhi" };

        projects = new JComboBox(s2);
        projects.setBackground(Color.white);
        projects.setBounds(765,100,150,40);
        panel.add(projects);

        String t[] = { "Hours","3", "4", "5", "6", "7","8","9","10"};

        time = new JComboBox(t);
        time.setBackground(Color.white);
        time.setBounds(920,100,75,40);
        panel.add(time);

        String t1[] = { "Minutes","10", "15","20","25" ,"30","35", "40","45","50","55"};

        minutes = new JComboBox(t1);
        minutes.setBackground(Color.white);
        minutes.setBounds(1000,100,75,40);
        panel.add(minutes);

        add = new JButton("Add Event");
        add.setFont(font);
        add.setBorderPainted(false);
        add.setForeground(Color.RED);
        add.setBackground(Color.green);
        add.setBounds(1080,100,150,30);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        panel.add(add);

        submit = new JButton("+Submit Timesheet");
        submit.setForeground(Color.WHITE);
        submit.setBorderPainted(false);
        submit.setBackground(Color.BLUE);
        submit.setFont(font);
        submit.setBounds(1040,150,250,30);
        panel.add(submit);



        frame.add(panel);
        frame.setBackground(Color.pink);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
