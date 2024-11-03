package hotel.management.system.vista.Admin;

import hotel.management.system.controlador.conexion.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddRooms extends JPanel implements ActionListener {

    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox<String> avaiablecombo, cleancombo, bedcombo;

    public AddRooms() {

        setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("AGREGAR HABITACION");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 300, 20);
        add(heading);

        JLabel lblrooms = new JLabel("NUMERO DE HABITACION");
        lblrooms.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblrooms.setBounds(60, 80, 320, 30);
        add(lblrooms);

        tfroom = new JTextField();
        tfroom.setBounds(280, 80, 150, 30);
        add(tfroom);

        JLabel lblavaible = new JLabel("HABITACION DISPONIBLE");
        lblavaible.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavaible.setBounds(60, 130, 320, 30);
        add(lblavaible);

        String[] availableOptions = {"DISPONIBLE", "OCUPADA"};
        avaiablecombo = new JComboBox<>(availableOptions);
        avaiablecombo.setBounds(280, 130, 150, 30);
        avaiablecombo.setBackground(Color.WHITE);
        add(avaiablecombo);

        JLabel lblclean = new JLabel("ESTADO DE HABITACION");
        lblclean.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblclean.setBounds(60, 180, 320, 30);
        add(lblclean);

        String[] cleanOptions = {"LIMPIA", "SUCIA"};
        cleancombo = new JComboBox<>(cleanOptions);
        cleancombo.setBounds(280, 180, 150, 30);
        cleancombo.setBackground(Color.WHITE);
        add(cleancombo);

        JLabel lblprice = new JLabel("PRECIO DE HABITACION");
        lblprice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblprice.setBounds(60, 230, 320, 30);
        add(lblprice);

        tfprice = new JTextField();
        tfprice.setBounds(280, 230, 150, 30);
        add(tfprice);

        JLabel lbltype = new JLabel("TIPO DE CAMA");
        lbltype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbltype.setBounds(60, 280, 320, 30);
        add(lbltype);

        String[] bedOptions = {"CAMA SENCILLA", "CAMA DOBLE"};
        bedcombo = new JComboBox<>(bedOptions);
        bedcombo.setBounds(280, 280, 150, 30);
        bedcombo.setBackground(Color.WHITE);
        add(bedcombo);

        add = new JButton("AGREGAR HABITACION");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 350, 200, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("CANCELAR");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(280, 350, 150, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String numerohab = tfroom.getText();
            String dispo = (String) avaiablecombo.getSelectedItem();
            String estado = (String) cleancombo.getSelectedItem();
            String precio = tfprice.getText();
            String tipo = (String) bedcombo.getSelectedItem();

            try {
                Conn conn = new Conn();
                String str = "insert into room values('" + numerohab + "','" + dispo + "','" + estado + "','" + precio + "','" + tipo + "')";
                conn.s.executeUpdate(str);

                JOptionPane.showMessageDialog(null, "NUEVA HABITACION AÑADIDA EXITOSAMENTE");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Puedes hacer alguna acción adicional para el botón cancelar si es necesario
        }
    }
}
