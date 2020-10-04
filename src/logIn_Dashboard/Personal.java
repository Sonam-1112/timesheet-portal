package logIn_Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Personal {
    JFrame frame;
    Font font1 = new Font("Times New Roman",Font.BOLD,20);
    Font font2 = new Font("Times New Roman",Font.BOLD,15);
    Font font3 = new Font("Times New Roman",Font.PLAIN,15);
    JPanel mainpanel,p_1,p_2,p_3;
    JLabel h_1,h_2,h_3;
    JLabel title,name,email,ID,address,country,phone,dob,marital,bank,place_of_birth,nationality,personal_ID,SSN;
    JButton saveNew , saveChanges;
    Personal (){
        frame=new JFrame();
        frame.setJMenuBar(CommonMenu.displayMenu(frame));
        frame.setTitle("Personal Details");
        frame.setLayout(null);
        frame.setFont(font1);
        mainpanel=new JPanel();
        mainpanel.setLayout(new GridLayout(1,3));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        mainpanel.setBounds(0,0,screenSize.width, screenSize.height);

        p_1= new JPanel();
        p_1.setLayout(null);
        p_1.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        p_2= new JPanel();
        p_2.setLayout(null);
        p_2.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        p_3= new JPanel();
        p_3.setLayout(null);
        p_3.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        h_1 = new JLabel("Address And Financial");
        h_1.setFont(new Font("Times New Roman",Font.BOLD,20));
        h_1.setBounds(5,10,250,20);
        h_1.setForeground(Color.RED);
        p_1.add(h_1);

        h_2 = new JLabel("Other Information");
        h_2.setFont(new Font("Times New Roman",Font.BOLD,20));
        h_2.setBounds(20,10,250,20);
        h_2.setForeground(Color.RED);
        p_2.add(h_2);

        h_3 = new JLabel("Sensitive Information");
        h_3.setFont(new Font("Times New Roman",Font.BOLD,20));
        h_3.setBounds(30,10,250,20);
        h_3.setForeground(Color.RED);
        p_3.add(h_3);

        title = new JLabel("Title:");
        title.setFont(font2);
        title.setBounds(5,60,200,20);
        p_1.add(title);

        String s1[] = {"Mr.","Mrs.","Miss"};

        JComboBox title_combo = new JComboBox(s1);
        title_combo.setBounds(205,60,200,20);
        title_combo.setFont(font3);
        p_1.add(title_combo);

        name = new JLabel("Name:");
        name.setFont(font2);
        name.setBounds(5,100,200,20);
        p_1.add(name);

        JTextField name_text = new JTextField();
        name_text.setBounds(205,100,200,20);
        name_text.setFont(font3);
        p_1.add(name_text);

        email = new JLabel("E-mail Address:");
        email.setFont(font2);
        email.setBounds(5,140,200,20);
        p_1.add(email);

        JTextField email_text = new JTextField();
        email_text.setBounds(205,140,200,20);
        email_text.setFont(font3);
        p_1.add(email_text);

        address = new JLabel("Address:");
        address.setFont(font2);
        address.setBounds(5, 180,200,20);
        p_1.add(address);

        JTextArea address_text = new JTextArea(15,30);
        address_text.setBounds(205,180,200,75);
        address_text.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        address_text.setFont(font3);
        p_1.add(address_text);

        country = new JLabel("Country:");
        country.setFont(font2);
        country.setBounds(5,270,200,20);
        p_1.add(country);

        JTextField country_text = new JTextField();
        country_text.setBounds(205,270,200,20);
        country_text.setFont(font3);
        p_1.add(country_text);

        phone = new JLabel("Phone no.:");
        phone.setFont(font2);
        phone.setBounds(5,310,200,20);
        p_1.add(phone);

        JTextField phone_text = new JTextField();
        phone_text.setBounds(205,310,200,20);
        phone_text.setFont(font3);
        p_1.add(phone_text);

        ID = new JLabel("ID card:");
        ID.setFont(font2);
        ID.setBounds(5,350,200,20);
        p_1.add(ID);

        JTextField ID_text = new JTextField();
        ID_text.setBounds(205,350,200,20);
        ID_text.setFont(font3);
        p_1.add(ID_text);

        bank = new JLabel("Bank acc no.:");
        bank.setFont(font2);
        bank.setBounds(5,390,200,20);
        p_1.add(bank);

        JTextField bank_text = new JTextField();
        bank_text.setBounds(205,390,200,20);
        bank_text.setFont(font3);
        p_1.add(bank_text);

        dob = new JLabel("DOB:");
        dob.setFont(font2);
        dob.setBounds(20,60,200,20);
        p_2.add(dob);

        JTextField dob_text = new JTextField();
        dob_text.setBounds(220,60,200,20);
        dob_text.setFont(font3);
        p_2.add(dob_text);

        place_of_birth = new JLabel("Place of Birth:");
        place_of_birth.setFont(font2);
        place_of_birth.setBounds(20,100,200,20);
        p_2.add(place_of_birth);

        JTextField palce_birth_text = new JTextField();
        palce_birth_text.setBounds(220,100,200,20);
        palce_birth_text.setFont(font3);
        p_2.add(palce_birth_text);

        nationality = new JLabel("Nationality:");
        nationality.setFont(font2);
        nationality.setBounds(20,140,200,20);
        p_2.add(nationality);

        JTextField nationality_text = new JTextField();
        nationality_text.setBounds(220,140,200,20);
        nationality_text.setFont(font3);
        p_2.add(nationality_text);

        marital = new JLabel("Marital Status:");
        marital.setFont(font2);
        marital.setBounds(20,180,200,20);
        p_2.add(marital);

        String s2[] = {"Married","Unmarried","Separated"};

        JComboBox marital_combo = new JComboBox(s2);
        marital_combo.setBounds(220,180,200,20);
        marital_combo.setFont(font3);
        p_2.add(marital_combo);

        personal_ID = new JLabel("Personal ID no.:");
        personal_ID.setFont(font2);
        personal_ID.setBounds(30,60,200,20);
        p_3.add(personal_ID);

        JTextField personal_ID_text = new JTextField();
        personal_ID_text.setBounds(235,60,200,20);
        personal_ID_text.setFont(font3);
        p_3.add(personal_ID_text);

        SSN = new JLabel("Social Security no.:");
        SSN.setFont(font2);
        SSN.setBounds(30,100,200,20);
        p_3.add(SSN);

        JTextField SSN_text = new JTextField();
        SSN_text.setBounds(235,100,200,20);
        SSN_text.setFont(font3);
        p_3.add(SSN_text);

        saveNew = new JButton("Save New");
        saveNew.setBackground(Color.WHITE);
        saveNew.setBounds(50, 350, 170, 30);
        saveNew.setBorderPainted(false);
        saveNew.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sonam@123");	
				if(name_text.getText().equals("")  || email_text.getText().equals("") || 
					address_text.getText().equals("") || country_text.getText().equals("") ||
					phone_text.getText().equals("") || ID_text.getText().equals("") ||
					bank_text.getText().equals("") || dob_text.getText().equals("") ||
					palce_birth_text.getText().equals("") || nationality_text.getText().equals("") ||
					personal_ID_text.getText().equals("") || SSN_text.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Some field is empty!!!","Alert",JOptionPane.WARNING_MESSAGE);
				}
				else {
//					try {
//					String title_choice = title_combo.getSelectedItem().toString();
//					String marital_choice = marital_combo.getSelectedItem().toString();
//					String query = "insert into personal_deatils values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
//					PreparedStatement ps = con.prepareStatement(query);
//					ps.setString(1, LogIn_Form.userText.getText());
//					ps.setString(2, LogIn_Form.passwordText.getText());
//					ps.setString(3, select_date.getText());
//					ps.setString(4, taskname.getText());
//					ps.setString(5, taskdescription.getText());
//					ps.setString(6, proM);
//					ps.setString(7, proN);
//					ps.setString(8, final_time);
//					int rs = ps.executeUpdate();
//					if(rs>0) {
//						JOptionPane.showMessageDialog(null, "Timesheet Submitted...");
//					}	
//					}catch(Exception e1) {
//						e1.printStackTrace();
//					}
//					
				  }
				} catch (ClassNotFoundException | SQLException e2) {
					e2.printStackTrace();
				}
			}
        	
        });
        p_3.add(saveNew);
        
        saveChanges = new JButton("Save Changes");
        saveChanges.setBackground(Color.WHITE);
        saveChanges.setBounds(300,350, 170, 30);
        saveChanges.setBorderPainted(false);
        saveChanges.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb","root","Sonam@123");	
					
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
        	
        });
        p_3.add(saveChanges);
        
        mainpanel.add(p_1);
        mainpanel.add(p_2);
        mainpanel.add(p_3);

        frame.add(mainpanel);
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
