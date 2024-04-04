package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class AdminLogin extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;

    JButton login,back;
    AdminLogin()
    {
        setTitle("Admin Login");
        JLabel username= new JLabel("Username");
        username.setBounds(100,300,100,30);
        add(username);
        username.setFont(new Font("Regular", Font.BOLD, 15));
        username.setBackground(Color.BLACK);
        username.setForeground(Color.WHITE);
        tusername=new JTextField();

        tusername.setBounds(200,300,150,30);
        add(tusername);



        JLabel password= new JLabel("Password");
        password.setFont(new Font("Regular", Font.BOLD, 15));
        password.setBackground(Color.BLACK);
        password.setForeground(Color.WHITE);
        password.setBounds(100,350,100,30);
        add(password);

        tpassword=new JPasswordField();
        tpassword.setBounds(200,350,150,30);
        add(tpassword);
//        ImageIcon ic=new ImageIcon("hotel images/unnamed.png");
        login=new JButton("Login");
        login.setBounds(250,400,100,30);
        add(login);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);


        back=new JButton("Back");
        back.setBounds(100,400,100,30);


        add(back);

        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);



        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/hazbinhotel.gif"));
        Image i22=i11.getImage().getScaledInstance(350,250,Image.SCALE_DEFAULT);
        ImageIcon i33= new ImageIcon(i22);
        JLabel imgg=new JLabel(i33);
        imgg.setBounds(70,30,350,250);
        add(imgg);


        getContentPane().setBackground(new Color(58, 1, 37));









        JLabel n1=new JLabel(" ");
        n1.setBounds(150,300,100,30);
        add(n1);

        setLayout(null);
        setSize(500,650);
        setVisible(true);

        setLocation(440,50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login)
        {
            try
            {
                String name=tusername.getText();
                String password=tpassword.getText();

                jdbcConnection c=new jdbcConnection();

                String query="select * from adminLogin where username='"+ name +"' and password='"+password +"' ";
                ResultSet result=c.statement.executeQuery(query);
                if(result.next())
                {
                    new admin();
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Invalid Username or Password");
                }

            }catch (Exception ee)
            {
                System.out.println(ee);
            }
        } else if (e.getSource()==back) {
            int n =JOptionPane.showConfirmDialog(null,"Do you really want to close Admin Page ","Select", JOptionPane.YES_NO_OPTION);
            if(n==0)
            {
                new Home();
                setVisible(false);
            }

        }
    }

    public static void main(String[] args) {
        new AdminLogin();
    }

}
