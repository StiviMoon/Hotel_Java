
package hotel.management.system.vista.Reception;
import hotel.management.system.Principal.Login;
import hotel.management.system.vista.Customer.AddCustomer;
import hotel.management.system.vista.Customer.CustomerInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reception extends JPanel implements ActionListener{
    JButton newCostumer,rooms,depa,allEmp,managerinfo,customer,searchRonm,update,roomsta,pickup,checkout,logout;
    public Reception(){




        newCostumer = new JButton("NUEVO CLIENTE");// creamos el boton para redireccionar a las otras clases
        newCostumer.setBounds(10,30,200,30);//ubicamos el boton
        newCostumer.setBackground(Color.BLACK);//color del boton
        newCostumer.setForeground(Color.WHITE);//colocamos el color de la letra del boton
        newCostumer.addActionListener(this);//añadimos un listener al boton para darle funcionalidad
        add(newCostumer);//añadimos el boton a la ventana

        rooms = new JButton("HABITACIONES");// creamos el boton para redireccionar a las otras clases
        rooms.setBounds(10,70,200,30);//ubicamos el boton
        rooms.setBackground(Color.BLACK);//color del boton
        rooms.setForeground(Color.WHITE);//colocamos el color de la letra del boton
        rooms.addActionListener(this);//añadimos un listener al boton para darle funcionalidad
        add(rooms);//añadimos el boton a la ventana



        customer = new JButton("INFORMACION CLIENTE ");
        customer.setBounds(10,190,200,30);
        customer.setBackground(Color.BLACK);
        customer.setForeground(Color.WHITE);
        customer.addActionListener(this);
        add(customer);




        checkout = new JButton(" HORA DE SALIDA  ");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);

        update = new JButton(" ACTUALIZAR ESTADO");
        update.setBounds(10,310,200,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);

        roomsta = new JButton("ESTADO DE HABITACION");
        roomsta.setBounds(10,350,200,30);
        roomsta.setBackground(Color.BLACK);
        roomsta.setForeground(Color.WHITE);
        roomsta.addActionListener(this);
        add(roomsta);




        searchRonm = new JButton("BUSCAR HABITACION");
        searchRonm.setBounds(10,430,200,30);
        searchRonm.setBackground(Color.BLACK);
        searchRonm.setForeground(Color.WHITE);
        searchRonm.addActionListener(this);
        add(searchRonm);




        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel (i1);
        image.setBounds(250,30,500,470);
        add(image);


        setBounds(350,200,800,570);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae){
    if(ae.getSource()==newCostumer){
        setVisible(false);
        new AddCustomer();

    } else if (ae.getSource()== rooms){
        setVisible(false);
        new Room();
    }
    else if (ae.getSource()==customer){
        setVisible(false);
        new CustomerInfo();

    }else if (ae.getSource()==searchRonm){
            setVisible(false);
            new SearchRoom();
    }else if (ae.getSource()==update){
            setVisible(false);
            new UpdateCheck();
    }else if (ae.getSource()==roomsta){
            setVisible(false);
            new UpdateRoom();
    }else if (ae.getSource()==checkout){
            setVisible(false);
            new Checkout();
    }
    }
    public static void main (String[] args) {
        new Reception();
    }
}
