package logIn_Dashboard;

import java.awt.*;
import javax.swing.*;

public class Project_details {
	Font font = new Font("Times New Roman",Font.PLAIN,20);
	JFrame frame ;
	JPanel panel;
	
	Project_details(){
		frame = new JFrame("Project Details");
		frame.setJMenuBar(CommonMenu.displayMenu(frame));
		frame.setLayout(null);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
		
		panel = new JPanel();
		panel.setLayout(null);
        panel.setBackground(Color.decode("#FFE4B5"));
        panel.setSize(screenSize.width,screenSize.height);
		
		frame.add(panel);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
