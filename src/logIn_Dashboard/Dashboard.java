package logIn_Dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Dashboard {
    JFrame frame;
    JPanel panel;
    JLabel welcome,label;
    JTable table;
    Dashboard(){
        frame = new JFrame("Dashboard");
        panel = new JPanel();
        frame.setJMenuBar(CommonMenu.displayMenu(frame));
        frame.setLayout(null);
        panel.setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width,screenSize.height);
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        panel.setSize(screenSize.width,screenSize.height);

        welcome = new JLabel("Hello User !!!");
        welcome.setBounds(20,30,200,25);
        welcome.setFont(new Font("Times New Roman",Font.BOLD,30));
        panel.add(welcome);

        label = new JLabel("Your Last Week's Timesheet");
        label.setBounds(20,60,300,50);
        label.setFont(new Font("Times New Roman",Font.PLAIN,20));
        panel.add(label);

        table = new JTable();
        Object[] row = new Object[6];
        //Object[] columns = {"Date","Task Name","Task Description","Project Manager","Project Name","Time"};
        table.setBounds(20,100,1450,650);
        DefaultTableModel model = new DefaultTableModel();
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
    }
}
