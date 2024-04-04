package hotel.management.system;
import javax.swing.*;
import java.awt.*;

public class splash extends JFrame {

    splash()
    {
        ImageIcon icon=new ImageIcon(ClassLoader.getSystemResource("icon/welcome.gif"));
        Image i= icon.getImage().getScaledInstance(500,500, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel image=new JLabel(i2);
        image.setBounds(0,0,500,500);
        add(image);



        setUndecorated(true);
        setLayout(null);
        setSize(500,500);
        setVisible(true);

        setLocation(420,130);

        try
        {
            Thread.sleep(5000);
            setVisible(false);
            new Login();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new splash();
    }
}
