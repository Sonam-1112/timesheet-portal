package logIn_Dashboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Manager_Dashboard {
	JFrame frame;
	JPanel panel;
	JLabel welcome,label;
	JTable table;
	Object[] row;
    DefaultTableModel model;
    String prev1,prev2;
    String name;
	Manager_Dashboard(){
		frame = new JFrame("Dashboard");
        panel = new JPanel();
        frame.setJMenuBar(CommonMenu.displayMenu(frame));
        frame.setLayout(null);
        panel.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        panel.setSize(screenSize.width,screenSize.height);
		
        Date date = new Date();  
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
        String strDate= formatter.format(date);  
        
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        prev1=formatter.format( cal.getTime());
        
        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.DATE, -2);
        prev2=formatter.format( cal1.getTime());
        
        
        try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sonam@123");	
			String query = "select * from personal_deatils where user_name=?;";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, LogIn_Form.userText.getText());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
					name=rs.getString("employee_name");
					welcome = new JLabel("Hello " +name+" !!!");
			        welcome.setBounds(20,30,1000,25);
			        welcome.setFont(new Font("Times New Roman",Font.BOLD,30));
			        panel.add(welcome);
			}
        	}catch(Exception e1) {
        		System.out.println(e1);
        	}

        label = new JLabel("Your Last Two Day's Timesheet");
        label.setBounds(20,60,300,50);
        label.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label);

        table = new JTable();
        row = new Object[6];
        //Object[] columns = {"Date","Task Name","Task Description","Project Manager","Project Name","Time"};
        table.setBounds(20,100,1000,650);
        model = new DefaultTableModel();
        table.setModel(model);
        model.addColumn("Date");
        model.addColumn("Task Name");
        model.addColumn("Task Description");
        model.addColumn("Project Manager");
        model.addColumn("Project Name");
        model.addColumn("Time");

        table.setBackground(Color.white);
        table.setForeground(Color.BLACK);
        table.setSelectionBackground(Color.RED);
        table.setGridColor(Color.red);
        table.setSelectionForeground(Color.white);
        table.setFont(new Font("", Font.PLAIN,15));
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.setRowHeight(table.getRowHeight()+20);
        table.setAutoCreateColumnsFromModel(true);
        table.setPreferredScrollableViewportSize(new Dimension(450,630));
        table.setFillsViewportHeight(true);

        JScrollPane pane = new JScrollPane(table);
        pane.setForeground(Color.RED);
        pane.setBackground(Color.white);
        pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        pane.setVisible(true);
        panel.add(pane);
        panel.add(table);

        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        showTask();
    }

    public ArrayList<viewUserData> taskList(){
    	ArrayList<viewUserData> tasksList = new ArrayList<>();
    	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sonam@123");
		viewUserData user;
    	String query = "select * from add_task where user_name=? and selected_date>=? and selected_date<=?;";
    	PreparedStatement ps = con.prepareStatement(query);
    	ps.setString(1, LogIn_Form.userText.getText());
    	ps.setString(2, prev2);
    	ps.setString(3, prev1);
    	ResultSet rs = ps.executeQuery();
    	while(rs.next()) {
    		 user = new viewUserData(rs.getString("user_name"),rs.getString("selected_date"),rs.getString("task_name"),rs.getString("task_description")
    				 				 ,rs.getString("project_manager"),rs.getString("project_name"),rs.getString("time_spent"));
    		 tasksList.add(user);
    	}
    	}catch(Exception e1) {
    		System.out.println(e1);
    	}
		return tasksList;
    }
    
    public void showTask() {
    	ArrayList<viewUserData> list = taskList();
    	for(int i=0;i<list.size();i++) {
    		row[0]=list.get(i).getselected_date();
    		row[1]=list.get(i).gettask_name();
    		row[2]=list.get(i).gettask_description();
    		row[3]=list.get(i).getproject_manager();
    		row[4]=list.get(i).getproject_name();
    		row[5]=list.get(i).gettime_spent();
    		model.addRow(row);
    	}
    }
}
