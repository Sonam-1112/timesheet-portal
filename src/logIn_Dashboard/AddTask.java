package logIn_Dashboard;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class AddTask extends LogIn_Form implements ActionListener {
    JFrame frame = new JFrame();
    Font font = new Font("",Font.BOLD,20);
    JPanel panel= new JPanel();
//    JPanel panel_1,panel_2,panel_3,panel_4,panel_5;
//    JScrollPane sc;
    JTextField taskname;
    JTextArea taskdescription;
    JTextField date;
    JButton select;
    JComboBox projectManager;
    JComboBox projects;
    JComboBox time;
    JComboBox minutes;
    JButton add;
    JButton submit;
    AddTask(){
        frame.setJMenuBar(CommonMenu.displayMenu(frame));
        frame.setTitle("Add Task");
        frame.setLayout(null);
        panel.setLayout(null);
       // sc = new JScrollPane(panel);
//        try {
//            BufferedImage i = ImageIO.read(new File("C:\\Users\\DELL\\Desktop\\Projects\\Login__DashBoard\\src\\logIn_Dashboard\\Images\\user.png"));
//            JLabel picLabel = new JLabel(new ImageIcon(i));
//            panel1_1.add(picLabel);
//        } catch(IOException e){
//            e.printStackTrace();
//        }

        try {
            BufferedImage i = ImageIO.read(new File("C:\\Users\\DELL\\Desktop\\Projects\\Login__DashBoard\\src\\logIn_Dashboard\\Images\\dash.jpg"));
            frame.setIconImage(i);
        } catch(IOException e){
            e.printStackTrace();
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        panel.setSize(screenSize.width,screenSize.height);
        panel.setBounds(0,0,screenSize.width, screenSize.height);

//        panel_1 = new JPanel();
//        panel_1.setBackground(Color.PINK);
//        panel_1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//        panel_1.setLayout(null);
//
//        panel_2 = new JPanel();
//        panel_2.setBackground(Color.PINK);
//        panel_2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//        panel_2.setLayout(null);
//
//        panel_3 = new JPanel();
//        panel_3.setBackground(Color.PINK);
//        panel_3.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//        panel_3.setLayout(null);
//
//        panel_4 = new JPanel();
//        panel_4.setBackground(Color.PINK);
//        panel_4.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//        panel_4.setLayout(null);
//
//        panel_5 = new JPanel();
//        panel_5.setBackground(Color.PINK);
//        panel_5.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
//        panel_5.setLayout(null);


        date=  new JTextField();
        date.setEditable(false);
        date.setBounds(50,60,150,30);
        panel.add(date);

        select = new JButton("Select Date");
        select.setBorderPainted(false);
        select.setBackground(Color.white);
        select.setBounds(50,20,150,30);
        select.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                date.setText(new DatePicker(frame).setPickedDate());
            }
        });
        panel.add(select);

        taskname = new JTextField();
        taskname.setText("Task Name");
        taskname.setBounds(50,100,300,30);
        taskname.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        taskname.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if((taskname.getText()).equals("Task Name"))
                taskname.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if((taskname.getText()).equals(""))
                taskname.setText("Task Name");
            }
        });
        panel.add(taskname);

        taskdescription = new JTextArea(20,100);
        taskdescription.setText("Task Description");
        taskdescription.setBounds(355,30,200,100);
        taskdescription.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        taskdescription.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if((taskdescription.getText()).equals("Task Description"))
                    taskdescription.setText("");
            }

            @Override
            public void focusLost(FocusEvent e) {
                if((taskdescription.getText()).equals(""))
                    taskdescription.setText("Task Description");
            }
        });
        taskdescription.setLineWrap(true);
        panel.add(taskdescription);

        String s1[] = { "Project Manager", "Mumbai", "Noida", "Kolkata", "New Delhi" };

        projectManager= new JComboBox(s1);
        projectManager.setBackground(Color.white);
        projectManager.setBounds(560,30,200,40);
        //projectManager.addItemListener((ItemListener) this);
        panel.add(projectManager);

        String s2[] = { "Projects   ", "Mumbai", "Noida", "Kolkata", "New Delhi" };

        projects = new JComboBox(s2);
        projects.setBackground(Color.white);
        projects.setBounds(765,30,150,40);
        panel.add(projects);

        String t[] = { "Hours","3", "4", "5", "6", "7","8","9","10"};

        time = new JComboBox(t);
        time.setBackground(Color.white);
        time.setBounds(920,30,75,40);
        panel.add(time);

        String t1[] = { "Minutes","10", "15","20","25" ,"30","35", "40","45","50","55"};

        minutes = new JComboBox(t1);
        minutes.setBackground(Color.white);
        minutes.setBounds(1000,30,75,40);
        panel.add(minutes);

//        add = new JButton("Add Event");
//        add.setFont(font);
//        add.setBorderPainted(false);
//        add.setForeground(Color.RED);
//        add.setBackground(Color.green);
//        add.setBounds(1080,30,150,30);
//        add.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//            }
//        });
//        panel.add(add);

        submit = new JButton("+Submit Timesheet");
        submit.setForeground(Color.WHITE);
        submit.setBorderPainted(false);
        submit.setBackground(Color.BLUE);
        submit.setFont(font);
        submit.setBounds(1080,80,250,30);
        panel.add(submit);


//        panel.add(panel_1);
//        panel.add(panel_2);
//        panel.add(panel_3);
//        panel.add(panel_4);
//        panel.add(panel_5);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}


