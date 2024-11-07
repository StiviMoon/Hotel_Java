package hotel.management.system.vista.Admin;

import hotel.management.system.controlador.conexion.Conn;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class AddRooms extends JPanel implements ActionListener {

    JButton add, cancel;
    JTextField tfroom, tfprice;
    JComboBox<String> avaiablecombo, cleancombo, bedcombo;

    public AddRooms() {
        setBackground(new Color(245, 245, 245));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Título
        JLabel heading = new JLabel("AGREGAR HABITACION");
        heading.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Ocupa dos columnas
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el título
        add(heading, gbc);

        // Número de habitación
        gbc.gridwidth = 1; // Solo ocupa una columna
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.WEST; // Alinear a la izquierda
        add(new JLabel("NUMERO DE HABITACION:"), gbc);
        tfroom = new JTextField(10);
        tfroom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        gbc.gridx = 1; // Segunda columna
        add(tfroom, gbc);

        // Habitación disponible
        gbc.gridx = 0; // Regresar a la primera columna
        gbc.gridy++;
        add(new JLabel("HABITACION DISPONIBLE:"), gbc);
        avaiablecombo = new JComboBox<>(new String[]{"DISPONIBLE", "OCUPADA"});
        gbc.gridx = 1; // Segunda columna
        add(avaiablecombo, gbc);

        // Estado de la habitación
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("ESTADO DE HABITACION:"), gbc);
        cleancombo = new JComboBox<>(new String[]{"LIMPIA", "SUCIA"});
        gbc.gridx = 1; // Segunda columna
        add(cleancombo, gbc);

        // Precio de la habitación
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("PRECIO DE HABITACION:"), gbc);
        tfprice = new JTextField(10);
        gbc.gridx = 1; // Segunda columna
        add(tfprice, gbc);

        // Tipo de cama
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("TIPO DE CAMA:"), gbc);
        bedcombo = new JComboBox<>(new String[]{"CAMA SENCILLA", "CAMA DOBLE"});
        gbc.gridx = 1; // Segunda columna
        add(bedcombo, gbc);

        // Botones
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1; // Asegurarse que ocupen una columna cada uno
        add = new JButton("AGREGAR HABITACION");
        add.setForeground(Color.WHITE);
        add.setBackground(new Color(0, 120, 215));
        add.addActionListener(this);
        gbc.anchor = GridBagConstraints.CENTER; // Centrar el botón
        add(add, gbc);

        gbc.gridx = 1; // Segunda columna para el botón cancelar
        cancel = new JButton("CANCELAR");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(new Color(0, 120, 215));
        cancel.addActionListener(this);
        add(cancel, gbc);

        // Imagen
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2; // La imagen ocupará dos columnas
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setPreferredSize(new Dimension(200, 100)); // Ajustar el tamaño de la imagen
        add(image, gbc);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String room_number = tfroom.getText(); // Obtener el número de habitación
            String dispo = (String) avaiablecombo.getSelectedItem();
            String estado = (String) cleancombo.getSelectedItem();
            String precio = tfprice.getText();
            String tipo = (String) bedcombo.getSelectedItem();

            try {
                Conn conn = new Conn();

                // Comprobar si el número de habitación ya existe
                String checkQuery = "SELECT COUNT(*) FROM room WHERE numerohab='" + room_number + "'";
                ResultSet rs = conn.s.executeQuery(checkQuery);
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    JOptionPane.showMessageDialog(null, "EL NÚMERO DE HABITACION YA EXISTE. POR FAVOR INGRESE UN NÚMERO ÚNICO.");
                } else {
                    // Insertar nueva habitación
                    String str = "INSERT INTO room VALUES('" + room_number + "','" + dispo + "','" + estado + "','" + precio + "','" + tipo + "')";
                    conn.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null, "NUEVA HABITACION AÑADIDA EXITOSAMENTE");
                    tfroom.setText(""); // Limpiar el campo de número de habitación
                    tfprice.setText(""); // Limpiar el campo de precio
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            // Acción para cancelar
            // Aquí puedes implementar la acción que deseas realizar al cancelar
        }
    }
}
