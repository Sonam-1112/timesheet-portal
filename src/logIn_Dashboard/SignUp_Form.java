package logIn_Dashboard;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SignUp_Form implements ActionListener {
    JFrame frame;
    JPanel panel;
    JLabel newuser;
    Font font = new Font("",Font.BOLD,20);
    JLabel newpassword;
    JLabel confirmpassword;
    JTextField nameText;
    JPasswordField password;
    JPasswordField againpassword;
    JButton buttonRegister;
    JLabel login;
    JLabel success;
    SignUp_Form(){
        frame = new JFrame();
        panel = new JPanel();
       // frame.setJMenuBar(CommonMenu.displayMenu(frame));
        panel.setBackground(Color.LIGHT_GRAY);
        frame.setTitle("SignUp");
        frame.setLayout(new BorderLayout());
        frame.setSize(400,400);
        panel.setSize(300,300);
        frame.setResizable(false);

        newuser = new JLabel("Username");
        newuser.setBounds(30,50,100,25);
        panel.add(newuser);

        nameText = new JTextField(20);
        nameText.setBounds(180,50,165,25);
        panel.add(nameText);

        newpassword =new JLabel("Password");
        newpassword.setBounds(30,100,100,25);
        panel.add(newpassword);

        password = new JPasswordField(20);
        password.setBounds(180,100,165,25);
        panel.add(password);

        confirmpassword =new JLabel(" Confirm Password");
        confirmpassword.setBounds(30,150,150,25);
        panel.add(confirmpassword);

        againpassword = new JPasswordField(20);
        againpassword.setBounds(180,150,165,25);
        panel.add(againpassword);

        buttonRegister = new JButton("Register Now");
        buttonRegister.setBounds(90,230,200,30);
        buttonRegister.setBorderPainted(false);
        buttonRegister.setBackground(Color.GREEN);
        buttonRegister.addActionListener(this);
        panel.add(buttonRegister);

        login = new JLabel("<HTML><U>Already Registered?Login</U></HTML>");
        login.setForeground(Color.RED);
        login.setFont(new Font("Times New Roman",Font.ITALIC,15));
        login.setBounds(110,270,220,20);
        login.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                login.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                LogIn_Form l = new LogIn_Form();
                frame.dispose();
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        panel.add(login);

        success = new JLabel("");
        success.setBounds(120,190,500,30);
        success.setForeground(Color.red);
        success.setFont(new Font("",Font.CENTER_BASELINE,15));
        panel.add(success);

        panel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panel.setLayout(null);
        frame.add(panel,BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonRegister){
            String user =nameText.getText();
            String password1 = password.getText();
            String password2 = againpassword.getText();
            if(user.equals("") || password1.equals("") || password2.equals("")) {
                success.setText("Something is Empty??");
            }
            else if(!(password1.equals(password2))){
                success.setText("Password is different???");
            }
            else{
                success.setText("Registered Successfully");
                Dashboard dashboard = new Dashboard();
                frame.dispose();
            }
        }
    }
}