
package hotel.management.system.vista.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import hotel.management.system.vista.Reception.Reception;
import hotel.management.system.controlador.conexion.Conn;
import net.proteanit.sql.*;




public class CustomerInfo extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    
    public CustomerInfo(){
        
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        
     
        
        JLabel l1 = new JLabel ("Tipo de Doc");
        l1.setBounds(40,10,100,20);
        add(l1);
        
        
        JLabel l2 = new JLabel ("Numero ");
        l2.setBounds(170,10,100,20);
        add(l2);
        
        JLabel l3 = new JLabel ("Nombre ");
        l3.setBounds(290,10,100,20);
        add(l3);
        
        JLabel l4 = new JLabel ("Genero ");
        l4.setBounds(400,10,100,20);
        add(l4);
        
        JLabel l5 = new JLabel ("Pais ");
        l5.setBounds(540,10,100,20);
        add(l5);
        
        
        JLabel l6 = new JLabel ("Haibtacion ");
        l6.setBounds(650,10,100,20);
        add(l6);
        
        JLabel l7 = new JLabel ("Fecha ");
        l7.setBounds(790,10,100,20);
        add(l7);
        
        JLabel l8 = new JLabel ("Deposito ");
        l8.setBounds(890,10,100,20);
        add(l8);
        
        
        
        table = new JTable();
        table.setBounds(0,40,990,400);
        add(table);
        
        
        try{
            Conn c = new Conn();
            ResultSet rs  = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        
        }catch (Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("Volver");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        back.setBounds(420,500,120,30);
        add(back);
        
        
        setBounds(100,100,1000,600);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Reception();
    
    }
    
    
    
    public static void main(String[]args){
        new CustomerInfo();
    }
}
