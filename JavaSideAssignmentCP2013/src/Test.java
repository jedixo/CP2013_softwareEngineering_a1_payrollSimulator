import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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
                            scanner = new Scanner(file);
                            while (scanner.hasNext()){

                                String text = scanner.nextLine();
                                System.out.println(text);
                            }


                        }catch (FileNotFoundException e1){
                            System.out.println("not here");
                        }
                    }
                });
                test.add(button);
                test.setVisible(true);
            }
        });
    }
}
