package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.StrokeBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame implements ActionListener {
    JTable table;
    JButton back;
    Room()
    {
        JPanel panel =new JPanel();
        panel.setBounds(5,5,890,590);
        panel.setBackground(new Color(58, 1, 37));
        panel.setLayout(null);
        add(panel);

        ImageIcon i= new ImageIcon(ClassLoader.getSystemResource("icon/roomm.png"));
        Image ii=i.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon iii= new ImageIcon(ii);
        JLabel image=new JLabel(iii);
        image.setBounds(600,200,200,200);
        panel.add(image);


        JLabel label=new JLabel("Room Details");
        label.setBounds(285,20,200,30);
        label.setFont(new Font("Regular",Font.BOLD,24));
        label.setForeground(Color.WHITE);
        panel.add(label);



        table=new JTable();
        table.setBounds(40,95,700,400);
        table.setBackground(new Color(58, 1, 37));
        table.setForeground(Color.WHITE);
        panel.add(table);








        back=new JButton("BACK");
        back.setBounds(200,500,140,33);
        back.setFont(new Font("Regular",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(this);


        JLabel available=new JLabel("Availability");
        available.setBounds(175,70,80,19);
        available.setFont(new Font("Regular",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel status=new JLabel("Clean Status");
        status.setBounds(290,70,100,19);
        status.setFont(new Font("Regular",Font.BOLD,14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        JLabel price=new JLabel("Price");
        price.setBounds(425,70,50,19);
        price.setFont(new Font("Regular",Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);


        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(70,70,80,19);
        roomNo.setFont(new Font("Regular",Font.BOLD,14));
        roomNo.setForeground(Color.WHITE);
        panel.add(roomNo);

        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(525,70,80,19);
        bed.setFont(new Font("Regular",Font.BOLD,14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);


        JLabel roomType=new JLabel("Room Type");
        roomType.setBounds(640,70,80,19);
        roomType.setFont(new Font("Regular",Font.BOLD,14));
        roomType.setForeground(Color.WHITE);
        panel.add(roomType);

        try
        {
            jdbcConnection jdbc=new jdbcConnection();
            String query="select * from room";
            ResultSet rs=jdbc.statement.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));

        }catch (Exception e)
        {
            e.printStackTrace();
        }



        setUndecorated(true);
        setLayout(null);
        setVisible(true);
        setSize(900,600);
        setLocation(210,80);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back)
        {
                setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Room();
    }
}
