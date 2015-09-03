import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;
import java.sql.*;

/**
 * Created by jc300016 on 20/08/15.
 */
public class Test extends JFrame{
    public Test() {
        initUI();
    }
    private static String user = "teamname2";
    private static String pass = "TeamName";
    private static String dbClass = "com.mysql.jdbc.Driver";
    private static String dbDriver = "jdbc:mysql://db4free.net:3306/teamname";
    private static Connection conn = null;
    private void initUI(){
        setTitle("Test Window");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) throws FileNotFoundException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Test test = new Test();

                JButton button = new JButton("button1");
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e)  {
                        Scanner scanner;
                        File file = new File("testFile.txt");
                        try {
                            boolean a = connect();
                            scanner = new Scanner(file);
                            while (scanner.hasNext()){

                                String text = scanner.nextLine();
                                System.out.println(text);
                            }


                        }catch (Exception e1){
                            System.out.println("World Destroyed!!");
                        }
                    }
                });
                test.add(button);
                test.setVisible(true);
            }
        });
    }



    public static boolean connect() {
        boolean done = false;
        //load driver
        try {
            Class.forName(dbClass).newInstance();
            System.out.println("driver loaded"); // THIS IS BEING RETURNED
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println(ex);
        }
        // Connection

        try {
            System.out.println("hi");
            conn = DriverManager.getConnection(dbDriver, user, pass);

            System.out.println("connected"); // THIS IS NOT BEING RETURNED
            done = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return done;
    }
}
