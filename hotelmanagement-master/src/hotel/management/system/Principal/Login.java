package hotel.management.system.Principal;

import hotel.management.system.controlador.conexion.Conn;
import hotel.management.system.vista.Admin.Dashboard;
import hotel.management.system.vista.Reception.Reception;
import hotel.management.system.vista.Reception.ReceptionistDashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JTextField username;
    JPasswordField password;
    JButton login, cancel, register;

    public Login() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("Sistema de Gestión Hotelera");
        title.setBounds(150, 10, 300, 30);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        add(title);

        JLabel user = new JLabel("Usuario:");
        user.setBounds(60, 70, 100, 30);
        user.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(user);

        username = new JTextField();
        username.setBounds(180, 70, 200, 30);
        add(username);

        JLabel pass = new JLabel("Contraseña:");
        pass.setBounds(60, 120, 100, 30);
        pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(pass);

        password = new JPasswordField();
        password.setBounds(180, 120, 200, 30);
        add(password);

        login = new JButton("Login");
        login.setBounds(60, 180, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        cancel = new JButton("Cancelar");
        cancel.setBounds(180, 180, 100, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);

        register = new JButton("Registrar");
        register.setBounds(300, 180, 100, 30);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 150, 150);
        add(image);

        setBounds(450, 200, 600, 300);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == login) {
            String user = username.getText();
            String pass = new String(password.getPassword());

            try {
        Conn c = new Conn();

        
        String query = "SELECT * FROM login WHERE username = '" + user + "' AND password = '" + pass + "'";
        ResultSet rs = c.s.executeQuery(query);

        if (rs.next()) {
            
            if (user.equals("admin") && pass.equals("12345")) {
                setVisible(false);
                new Dashboard();
            } else {
                setVisible(false);
                new ReceptionistDashboard();
            }
        } else {
            
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
        }

        
        rs.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
        } else if (ae.getSource() == register) {
            String user = username.getText();
            
            String pass = new String(password.getPassword());
            try {
                Conn c = new Conn();
                String query3 = "insert into login values('"+user+"','" + pass + "')";
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "Usuario Registrado exitosamente");
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
