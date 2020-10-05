package logIn_Dashboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class CommonMenu {

    public CommonMenu() {
    }

    public static JMenuBar displayMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setOpaque(true);
        menuBar.setBackground(Color.CYAN);
        //JMenu dashboard = new JMenu("Dashboard");
        JMenu person = new JMenu("Personal Details");
        JMenu task = new JMenu("Task");
        JMenu logout = new JMenu("Logout");

//        dashboard.addMenuListener(new MenuListener() {
//            @Override
//            public void menuSelected(MenuEvent e) {
//                f.setVisible(false);
//                Dashboard d = new Dashboard();
//            }
//
//            @Override
//            public void menuDeselected(MenuEvent e) {
//
//            }
//
//            @Override
//            public void menuCanceled(MenuEvent e) {
//
//            }
//        });

        person.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                f.setVisible(false);
                Personal p = new Personal();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        logout.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                f.setVisible(false);
                LogIn_Form l =new LogIn_Form();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {

            }
        });

        JMenuItem add_task = new JMenuItem("Add Task");
        add_task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                AddTask d = new AddTask();
            }
        });

        JMenuItem edit_task = new JMenuItem("Edit Task");
        edit_task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
               EditTask et =new EditTask();
            }
        });

        JMenuItem view_task = new JMenuItem("View Task");
        view_task.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                ViewTask v =new ViewTask();
            }
        });


        task.add(add_task);
        task.addSeparator();
        task.add(edit_task);
        task.addSeparator();
        task.add(view_task);

        //menuBar.add(dashboard);
        menuBar.add(person);
        menuBar.add(task);
        menuBar.add(logout);

        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        return menuBar;
    }
}

