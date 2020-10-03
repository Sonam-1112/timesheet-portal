package logIn_Dashboard;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewTask {
    JFrame frame;
    JPanel panel;
    JButton startDate;
    JTextField datestart;
    JButton endDate;
    JTextField dateend;
    JButton View;
    JTable table;
    ViewTask(){
        frame = new JFrame("View Tasks");
        panel = new JPanel();
        frame.setJMenuBar(CommonMenu.displayMenu(frame));
        frame.setLayout(null);
        panel.setLayout(null);
        panel.setBackground(Color.pink);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setBounds(0,0,screenSize.width, screenSize.height);
        panel.setSize(screenSize.width,screenSize.height);

        datestart=  new JTextField();
        datestart.setEditable(false);
        datestart.setBounds(50,55,150,30);
        panel.add(datestart);

        startDate = new JButton("   From    ");
        startDate.setBackground(Color.white);
        startDate.setBorderPainted(false);
        startDate.setBounds(50,20,150,30);
        startDate.setFont(new Font("Times New Roman",Font.BOLD,20));
        startDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datestart.setText(new DatePicker(frame).setPickedDate());
            }
        });
        panel.add(startDate);

        dateend=  new JTextField();
        dateend.setEditable(false);
        dateend.setBounds(210,55,150,30);
        panel.add(dateend);

        endDate = new JButton("    To    ");
        endDate.setBackground(Color.white);
        endDate.setBorderPainted(false);
        endDate.setBounds(210,20,150,30);
        endDate.setFont(new Font("Times New Roman",Font.BOLD,20));
        endDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dateend.setText(new DatePicker(frame).setPickedDate());
            }
        });
        panel.add(endDate);

        View = new JButton("View Task");
        View.setBackground(Color.BLUE);
        View.setBorderPainted(false);
        View.setBounds(380,25,150,30);
        View.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        panel.add(View);

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
       // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.pink);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
