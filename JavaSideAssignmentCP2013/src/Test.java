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
    static String myUrl = "com.mysql.jdbc.Drver";
    static String myDriver = "jdbc:mysql://db4free.net:3306/teamname";
    public static boolean connect() {
        boolean done = false;
        //load driver
        try {
            Class.forName(myUrl).newInstance();
            System.out.println("driver loaded"); // THIS IS BEING RETURNED
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.err.println("unable to load driver");
        }
        // Connection
        try {
            Connection conn = DriverManager.getConnection(myDriver, "teamname", "TeamName");
            System.out.println("connected"); // THIS IS NOT BEING RETURNED
            done = true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return done;
    }
}
