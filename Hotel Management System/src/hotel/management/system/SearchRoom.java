package hotel.management.system;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


public class SearchRoom extends JFrame {
    JCheckBox check;
    JButton Rsearch,back;
    Choice choice;

    JTable table;
    SearchRoom()
    {
        setUndecorated(true);
        JPanel panel =new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setBackground(new Color(58, 1, 37));
        panel.setLayout(null);
        add(panel);

        JLabel search=new JLabel("SEARCH ROOM");
        search.setBounds(250,10,185,30);
        search.setForeground(Color.WHITE);
        search.setFont(new Font("Regular",Font.BOLD,20));
        panel.add(search);

        JLabel req=new JLabel("Required Bed Type:");
        req.setBounds(5,70,145,19);
        req.setFont(new Font("Regular",Font.BOLD,14));
        req.setForeground(Color.WHITE);
        panel.add(req);


        JLabel roomNo=new JLabel("Room No");
        roomNo.setBounds(20,105,80,19);
        roomNo.setFont(new Font("Regular",Font.BOLD,14));
        roomNo.setForeground(Color.WHITE);
        panel.add(roomNo);

        JLabel available=new JLabel("Availability");
        available.setBounds(125,105,80,19);
        available.setFont(new Font("Regular",Font.BOLD,14));
        available.setForeground(Color.WHITE);
        panel.add(available);

        JLabel status=new JLabel("Clean Status");
        status.setBounds(245,105,100,19);
        status.setFont(new Font("Regular",Font.BOLD,14));
        status.setForeground(Color.WHITE);
        panel.add(status);

        JLabel price=new JLabel("Price");
        price.setBounds(375,105,50,19);
        price.setFont(new Font("Regular",Font.BOLD,14));
        price.setForeground(Color.WHITE);
        panel.add(price);


        JLabel bed=new JLabel("Bed Type");
        bed.setBounds(475,105,80,19);
        bed.setFont(new Font("Regular",Font.BOLD,14));
        bed.setForeground(Color.WHITE);
        panel.add(bed);


        JLabel roomType=new JLabel("Room Type");
        roomType.setBounds(590,105,80,19);
        roomType.setFont(new Font("Regular",Font.BOLD,14));
        roomType.setForeground(Color.WHITE);
        panel.add(roomType);

        check=new JCheckBox("Display Only Available Rooms");
        check.setBounds(400,70,205,25);
        check.setForeground(Color.WHITE);
        check.setBackground(new Color(58, 1, 37));
        panel.add(check);

        choice=new Choice();
        choice.add("Single-Bed");
        choice.add("Double-Bed");
        choice.add("King-size Bed");
        choice.setBounds(150,70,120,20);
        choice.setForeground(Color.WHITE);
        choice.setBackground(new Color(58, 1, 37));
        panel.add(choice);



        table=new JTable();
        table.setBounds(0,130,700,280);
        table.setBackground(new Color(58, 1, 37));
        table.setForeground(Color.WHITE);
        panel.add(table);

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


        Rsearch=new JButton("SEARCH");
        Rsearch.setBounds(250,415,150,30);
        Rsearch.setForeground(Color.WHITE);
        Rsearch.setBackground(Color.BLACK);
        panel.add(Rsearch);
        Rsearch.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    jdbcConnection jd=new jdbcConnection();
                    String query="select * from room where bed_type='"+choice.getSelectedItem()+"'";
                    String Available_query="select * from room where avilability='Available' And  bed_type='"+choice.getSelectedItem()+"'";
                    ResultSet rs=jd.statement.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    if(check.isSelected())
                    {
                        ResultSet rss=jd.statement.executeQuery(Available_query);
                        table.setModel(DbUtils.resultSetToTableModel(rss));
                    }
                }catch (Exception ee)
                {
                    ee.printStackTrace();
                }


            }
        });


        back=new JButton("BACK");
        back.setBounds(50,415,150,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        panel.add(back);
        back.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });














        setLayout(null);
        setSize(700,500);
        setLocation(325,125);
        setVisible(true);
    }
    public static void main(String[] args) {
        new SearchRoom();
    }
}
