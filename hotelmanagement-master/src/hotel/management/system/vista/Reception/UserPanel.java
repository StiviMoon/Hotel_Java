package hotel.management.system.vista.Reception;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class UserPanel extends JPanel {

    public UserPanel() {
        // Configuración principal del panel
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel de Filtro de Búsqueda
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBorder(BorderFactory.createTitledBorder("Filtro de Búsqueda"));
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Buscar");
        searchPanel.add(searchField, BorderLayout.CENTER);
        searchPanel.add(searchButton, BorderLayout.EAST);

        // Panel de Usuarios (Tabla)
        JPanel tablePanel = new JPanel(new BorderLayout());
        tablePanel.setBorder(BorderFactory.createTitledBorder("Usuarios"));

        // Crear la tabla de usuarios
        String[] columnNames = {"ID", "Nombre", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable userTable = new JTable(tableModel);

        // Agregar algunos datos de ejemplo a la tabla
        tableModel.addRow(new Object[] {"1", "Juan Pérez", "juan.perez@example.com"});
        tableModel.addRow(new Object[] {"2", "Ana Gómez", "ana.gomez@example.com"});

        JScrollPane tableScrollPane = new JScrollPane(userTable);
        tablePanel.add(tableScrollPane, BorderLayout.CENTER);

        // Panel de Botones para CRUD
        JPanel crudPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        crudPanel.setBorder(BorderFactory.createTitledBorder("Acciones CRUD"));
        JButton addButton = new JButton("Agregar");
        JButton editButton = new JButton("Actualizar");
        JButton deleteButton = new JButton("Eliminar");

        crudPanel.add(addButton);
        crudPanel.add(editButton);
        crudPanel.add(deleteButton);

        // Agregar los paneles al panel principal
        add(searchPanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(crudPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestión de Usuarios");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        UserPanel userPanel = new UserPanel();
        frame.add(userPanel);

        frame.setVisible(true);
    }
}
