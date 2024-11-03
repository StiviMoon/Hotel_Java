package hotel.management.system.vista.Admin;

import hotel.management.system.Principal.Login; // Asegúrate de importar la clase de Login// Asegúrate de importar la clase DeleteRoom
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private AddRooms addRoomsPanel;
    private hotel.management.system.vista.Admin.DeleteRoom deleteRoomsPanel; // Declaración del panel de eliminar habitaciones
    private JButton logout;
    private JLabel headerLabel; // JLabel para el encabezado

    public Dashboard() {
        setTitle("Dashboard - Hotel Los Maniacos");
        setSize(1550, 750);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel de Navegación Lateral
        JPanel sidePanel = new JPanel();
        sidePanel.setBackground(new Color(45, 45, 45));
        sidePanel.setPreferredSize(new Dimension(250, 750));
        sidePanel.setLayout(new GridLayout(11, 1, 10, 10)); // Cambiado a 11 filas para incluir el encabezado

        // Encabezado
        headerLabel = new JLabel("Perfil de Administrador", SwingConstants.CENTER);
        headerLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        headerLabel.setForeground(Color.WHITE);
        headerLabel.setBackground(new Color(45, 45, 45)); // Fondo igual al del panel lateral
        headerLabel.setOpaque(true); // Para que se muestre el fondo

        // Añadir el encabezado al panel lateral
        sidePanel.add(headerLabel); // Añadir el encabezado en la primera posición

        JButton btnAddRoom = new JButton("Agregar Habitación");
        styleButton(btnAddRoom);
        btnAddRoom.addActionListener(this);

        JButton btnDelete = new JButton("Eliminar Habitación");
        styleButton(btnDelete);
        btnDelete.addActionListener(this);

        // Botón de Cerrar Sesión
        logout = new JButton("Cerrar Sesión");
        styleButton(logout); // Aplicar el mismo estilo
        logout.addActionListener(this); // Añadir listener para cerrar sesión

        sidePanel.add(new JLabel()); // Espacio superior
        sidePanel.add(btnAddRoom);
        sidePanel.add(btnDelete);
        sidePanel.add(logout); // Añadir el botón al panel lateral

        add(sidePanel, BorderLayout.WEST);

        // Panel Principal con CardLayout
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Integrar AddRooms como panel
        addRoomsPanel = new AddRooms();
        cardPanel.add(addRoomsPanel, "AddRoom");

        // Integrar DeleteRoom como panel
        deleteRoomsPanel = new DeleteRoom();
        cardPanel.add(deleteRoomsPanel, "DeleteRoom");

        add(cardPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    private void styleButton(JButton button) {
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBackground(new Color(60, 60, 60));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        switch (command) {
            case "Agregar Habitación":
                cardLayout.show(cardPanel, "AddRoom");
                break;
            case "Eliminar Habitación":
                cardLayout.show(cardPanel, "DeleteRoom");
                break;
            case "Cerrar Sesión":
                setVisible(false);
                new Login();
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Dashboard::new);
    }
}
