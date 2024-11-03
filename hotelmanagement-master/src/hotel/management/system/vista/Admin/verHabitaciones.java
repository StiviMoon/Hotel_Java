package hotel.management.system.vista.Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import hotel.management.system.controlador.conexion.Conn;
import net.proteanit.sql.DbUtils;

public class verHabitaciones extends JPanel implements ActionListener {
    private JTable table;
    private JButton deleteButton;
    private JButton updateButton; // Nuevo botón para actualizar
    private JButton backButton;

    public verHabitaciones() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        // Crear tabla
        table = new JTable();
        loadData(); // Cargar datos de habitaciones

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel();

        deleteButton = new JButton("Eliminar Habitación");
        deleteButton.addActionListener(this);
        buttonPanel.add(deleteButton);

        // Botón de actualizar
        updateButton = new JButton("Actualizar");
        updateButton.addActionListener(this); // Añadir acción para el botón de actualizar
        buttonPanel.add(updateButton);

        backButton = new JButton("Volver");
        backButton.addActionListener(e -> {
            // Regresar al panel anterior (Reception)
            // Aquí debes implementar la lógica para regresar al panel anterior
        });
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void loadData() {
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteButton) {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                String roomNumber = table.getValueAt(selectedRow, 0).toString();
                System.out.println(roomNumber); // Asumiendo que la primera columna es el número de habitación

                // Eliminar habitación de la base de datos
                try {
                    Conn c = new Conn();
                    String query = "DELETE FROM room WHERE numerohab = '" + roomNumber + "'";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(this, "Habitación eliminada exitosamente");
                    loadData(); // Recargar datos después de la eliminación
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Seleccione una habitación para eliminar.");
            }
        } else if (e.getSource() == updateButton) {
            loadData(); // Actualizar datos cuando se hace clic en el botón de actualizar
        }
    }
}
