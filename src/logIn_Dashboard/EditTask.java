package logIn_Dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EditTask {
    JFrame frame = new JFrame("Edit Tasks");
    JPanel panel = new JPanel();
    Font font = new Font("",Font.BOLD,20);
    JButton selectdate = new JButton("Select Date");
    JTextField dateText = new  JTextField();
    DefaultTableModel model;
    Object[] row;
    JButton show;
    JTable table;
    JButton save;
    JButton delete;
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
        
        show = new JButton("Show Task");
        show.setForeground(Color.WHITE);
        show.setBorderPainted(false);
        show.setBackground(Color.BLUE);
        show.setFont(font);
        show.setBounds(250,30,250,30);
        show.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				showTask();
			}
        	
        });
        panel.add(show);

        save = new JButton("Save Changes");
        save.setForeground(Color.WHITE);
        save.setBorderPainted(false);
        save.setBackground(Color.BLUE);
        save.setFont(font);
        save.setBounds(550,30,250,30);
        save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        	
        });
        panel.add(save); 
       
        delete = new JButton("Delete Task");
        delete.setForeground(Color.WHITE);
        delete.setBorderPainted(false);
        delete.setBackground(Color.BLUE);
        delete.setFont(font);
        delete.setBounds(850,30,250,30);
        delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				model.removeRow(row);
		        String eve1 = table.getModel().getValueAt(row, 0).toString();
		        String eve2= table.getModel().getValueAt(row, 0).toString();
		        
		      //  String delRow = "delete from add_task where user_name =? and selected_date=?;";
		        try {
		    		Class.forName("com.mysql.cj.jdbc.Driver");
		    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sonam@123");
		        	String query ="delete from add_task where user_name=? and selected_date=? and ;";
		        	PreparedStatement ps = con.prepareStatement(query);
		        	ps.setString(1, LogIn_Form.userText.getText());
		        	ps.setString(2, eve1);
		        	ps.setString(3, eve2);
		        	ps.executeUpdate();
		        	
		        	}catch(Exception e1) {
		        		System.out.println(e1);
		        	}
			}
        	
        });
        panel.add(delete); 
        
        
        table = new JTable();
        row = new Object[6];
        //Object[] columns = {"Date","Task Name","Task Description","Project Manager","Project Name","Time"};
        table.setBounds(20,100,1450,650);
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
        frame.setBackground(Color.pink);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public ArrayList<editUserData> taskList(){
    	ArrayList<editUserData> tasksList = new ArrayList<>();
    	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sonam@123");
		editUserData user;
    	String query = "select * from add_task where user_name=? and selected_date=?;";
    	PreparedStatement ps = con.prepareStatement(query);
    	ps.setString(1, LogIn_Form.userText.getText());
    	ps.setString(2, dateText.getText());
    	ResultSet rs = ps.executeQuery();
    	while(rs.next()) {
    		 user = new editUserData(rs.getString("user_name"),rs.getString("selected_date"),rs.getString("task_name"),rs.getString("task_description")
    				 				 ,rs.getString("project_manager"),rs.getString("project_name"),rs.getString("time_spent"));
    		 tasksList.add(user);
    	}
    	}catch(Exception e1) {
    		System.out.println(e1);
    	}
		System.out.println(tasksList+","+LogIn_Form.userText.getText());
		return tasksList;
    	
    }
    
    public void showTask() {
    	ArrayList<editUserData> list = taskList();
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
