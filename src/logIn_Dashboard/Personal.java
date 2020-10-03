package logIn_Dashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Personal {
    JFrame frame;
    Font font1 = new Font("Times New Roman",Font.BOLD,20);
    Font font2 = new Font("Times New Roman",Font.BOLD,15);
    Font font3 = new Font("Times New Roman",Font.PLAIN,15);
    JPanel mainpanel,p_1,p_2,p_3;
    JLabel h_1,h_2,h_3;
    JLabel title,name,email,ID,address,country,phone,dob,marital,bank,place_of_birth,nationality,personal_ID,SSN;
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

        JComboBox t = new JComboBox(s1);
        t.setBounds(205,60,200,20);
        t.setFont(font3);
        p_1.add(t);

        name = new JLabel("Name:");
        name.setFont(font2);
        name.setBounds(5,100,200,20);
        p_1.add(name);

        JTextField n = new JTextField();
        n.setBounds(205,100,200,20);
        n.setFont(font3);
        p_1.add(n);

        email = new JLabel("E-mail Address:");
        email.setFont(font2);
        email.setBounds(5,140,200,20);
        p_1.add(email);

        JTextField p = new JTextField();
        p.setBounds(205,140,200,20);
        p.setFont(font3);
        p_1.add(p);

        address = new JLabel("Address:");
        address.setFont(font2);
        address.setBounds(5, 180,200,20);
        p_1.add(address);

        JTextArea a = new JTextArea(15,30);
        a.setBounds(205,180,200,75);
        a.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        a.setFont(font3);
        p_1.add(a);

        country = new JLabel("Country:");
        country.setFont(font2);
        country.setBounds(5,270,200,20);
        p_1.add(country);

        JTextField q = new JTextField();
        q.setBounds(205,270,200,20);
        q.setFont(font3);
        p_1.add(q);

        phone = new JLabel("Phone no.:");
        phone.setFont(font2);
        phone.setBounds(5,310,200,20);
        p_1.add(phone);

        JTextField r = new JTextField();
        r.setBounds(205,310,200,20);
        r.setFont(font3);
        p_1.add(r);

        ID = new JLabel("ID card:");
        ID.setFont(font2);
        ID.setBounds(5,350,200,20);
        p_1.add(ID);

        JTextField u = new JTextField();
        u.setBounds(205,350,200,20);
        u.setFont(font3);
        p_1.add(u);

        bank = new JLabel("Bank acc no.:");
        bank.setFont(font2);
        bank.setBounds(5,390,200,20);
        p_1.add(bank);

        JTextField y = new JTextField();
        y.setBounds(205,390,200,20);
        y.setFont(font3);
        p_1.add(y);

        dob = new JLabel("DOB:");
        dob.setFont(font2);
        dob.setBounds(20,60,200,20);
        p_2.add(dob);

        JTextField d = new JTextField();
        d.setBounds(220,60,200,20);
        d.setFont(font3);
        p_2.add(d);

        place_of_birth = new JLabel("Place of Birth:");
        place_of_birth.setFont(font2);
        place_of_birth.setBounds(20,100,200,20);
        p_2.add(place_of_birth);

        JTextField m = new JTextField();
        m.setBounds(220,100,200,20);
        m.setFont(font3);
        p_2.add(m);

        nationality = new JLabel("Nationality:");
        nationality.setFont(font2);
        nationality.setBounds(20,140,200,20);
        p_2.add(nationality);

        JTextField o = new JTextField();
        o.setBounds(220,140,200,20);
        o.setFont(font3);
        p_2.add(o);

        marital = new JLabel("Marital Status:");
        marital.setFont(font2);
        marital.setBounds(20,180,200,20);
        p_2.add(marital);

        String s2[] = {"Married","Unmarried","Separated"};

        JComboBox z = new JComboBox(s2);
        z.setBounds(220,180,200,20);
        z.setFont(font3);
        p_2.add(z);

        personal_ID = new JLabel("Personal ID no.:");
        personal_ID.setFont(font2);
        personal_ID.setBounds(30,60,200,20);
        p_3.add(personal_ID);

        JTextField x = new JTextField();
        x.setBounds(235,60,200,20);
        x.setFont(font3);
        p_3.add(x);

        SSN = new JLabel("Social Security no.:");
        SSN.setFont(font2);
        SSN.setBounds(30,100,200,20);
        p_3.add(SSN);

        JTextField l = new JTextField();
        l.setBounds(235,100,200,20);
        l.setFont(font3);
        p_3.add(l);

        mainpanel.add(p_1);
        mainpanel.add(p_2);
        mainpanel.add(p_3);

        frame.add(mainpanel);
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
