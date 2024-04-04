package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


public class AddRoom extends JFrame implements ActionListener {
    JTextField rNo,pricee;
    JComboBox avl,clean,bed,r;

    JButton save,back;
    AddRoom()
    {
        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,490);
        panel.setBackground(new Color(58, 1, 37));
        panel.setLayout(null);
        add(panel);


        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        JLabel l1=new JLabel("ADD ROOMS");
        l1.setBounds(194,10,160,22);
        l1.setFont(new Font("Regular",Font.BOLD,22));
        l1.setForeground(Color.WHITE);
        panel.add(l1);
//        add(l1);


        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(64,70,152,22);
        roomNo.setFont(new Font("Regular",Font.BOLD,16));
        roomNo.setForeground(Color.WHITE);
        panel.add(roomNo);
//        add(roomNo);


        rNo=new JTextField();
        rNo.setBounds(200,70,156,20);
        rNo.setFont(new Font("Regular",Font.PLAIN,16));
        rNo.setForeground(Color.WHITE);
        rNo.setBackground(new Color(148, 212, 229));
        panel.add(rNo);
//        add(rNo);

        JLabel availblity=new JLabel("Availability");
        availblity.setBounds(64,110,152,22);
        availblity.setFont(new Font("Regular",Font.BOLD,16));
        availblity.setForeground(Color.WHITE);
        panel.add(availblity);
//        add(availblity);

        avl=new JComboBox<>(new String[] {"Available","Occupied"});
        avl.setBounds(200,110,156,20);
        avl.setFont(new Font("Regular",Font.PLAIN,16));
        avl.setForeground(Color.WHITE);
        avl.setBackground(new Color(148, 212, 229));
        panel.add(avl);
//        add(avl);


        JLabel price=new JLabel("Price");
        price.setBounds(64,150,152,22);
        price.setFont(new Font("Regular",Font.BOLD,16));
        price.setForeground(Color.WHITE);
        panel.add(price);
//        add(price);


        pricee=new JTextField();
        pricee.setBounds(200,150,156,20);
        pricee.setFont(new Font("Regular",Font.PLAIN,16));
        pricee.setForeground(Color.WHITE);
        pricee.setBackground(new Color(148, 212, 229));
        panel.add(pricee);
//        add(pricee);



        JLabel cleaningStatus=new JLabel("Cleaning Status");
        cleaningStatus.setBounds(64,190,152,22);
        cleaningStatus.setFont(new Font("Regular",Font.BOLD,16));
        cleaningStatus.setForeground(Color.WHITE);
        panel.add(cleaningStatus);
//        add(cleaningStatus);



        clean=new JComboBox<>(new String[] {"Spotless","Un-Clean"});
        clean.setBounds(200,190,156,22);
        clean.setFont(new Font("Regular",Font.PLAIN,16));
        clean.setForeground(Color.WHITE);
        clean.setBackground(new Color(148, 212, 229));
        panel.add(clean);
//        add(clean);


        JLabel bedType=new JLabel("Type of Bed");
        bedType.setBounds(64,230,152,22);
        bedType.setFont(new Font("Regular",Font.BOLD,16));
        bedType.setForeground(Color.WHITE);
        panel.add(bedType);
//        add(bedType);


        bed=new JComboBox<>(new String[] {"Single-Bed","Double-Bed","King-size Bed"});
        bed.setBounds(200,230,156,22);
        bed.setFont(new Font("Regular",Font.PLAIN,16));
        bed.setForeground(Color.WHITE);
        bed.setBackground(new Color(148, 212, 229));
        panel.add(bed);
//        add(bed);


        JLabel roomType=new JLabel("Type of Room");
        roomType.setBounds(64,270,152,22);
        roomType.setFont(new Font("Regular",Font.BOLD,16));
        roomType.setForeground(Color.WHITE);
        panel.add(bedType);
//        add(roomType);


        r=new JComboBox<>(new String[] {"Single Room","2-in-One","4-in-One"});
        r.setBounds(200,270,156,22);
        r.setFont(new Font("Regular",Font.PLAIN,16));
        r.setForeground(Color.WHITE);
        r.setBackground(new Color(148, 212, 229));
        panel.add(bed);
//        add(r);


        save=new JButton("Save");
        save.setBounds(64,321,135,33);
        save.setFont(new Font("Regular",Font.BOLD,16));
        save.setForeground(Color.WHITE);
        save.setBackground(Color.BLACK);
        panel.add(save);
//        add(save);


        back=new JButton("Back");
        back.setBounds(220,321,135,33);
        back.setFont(new Font("Regular",Font.BOLD,16));
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
//        add(back);

        ImageIcon i11= new ImageIcon(ClassLoader.getSystemResource("icon/roomser.png"));
        Image i2=i11.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(500,60,300,300);
        panel.add(img);
//        add(img);
        save.addActionListener(this);
        back.addActionListener(this);
        setLocation(20,100);
        setLayout(null);
        setVisible(true);
        setSize(850,500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==save)
        {
            try
            {
                jdbcConnection jd=new jdbcConnection();
                String room=rNo.getText();
                String av= Objects.requireNonNull(avl.getSelectedItem()).toString();
                String status= Objects.requireNonNull(clean.getSelectedItem()).toString();
                String price =pricee.getText();
                String type= Objects.requireNonNull(bed.getSelectedItem()).toString();
                String room_type= Objects.requireNonNull(r.getSelectedItem()).toString();


                String query="insert into room values('"+room+"','"+av+"','"+status+"','"+price+"','"+type+"','"+room_type+"')";
                jd.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Room Details Saved Successfully");
                setVisible(false);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddRoom();
    }
}
