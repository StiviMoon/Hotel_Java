package hotel.management.system.Principal;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class HotelManagementSystem extends JFrame implements ActionListener {

 private static final int FRAME_WIDTH = 1000;
 private static final int FRAME_HEIGHT = 565;

 public HotelManagementSystem() {
  initializeUI();
 }

 private void initializeUI() {
  setSize(FRAME_WIDTH, FRAME_HEIGHT);
  setLocationRelativeTo(null); // Centrar la ventana en la pantalla
  setResizable(false); // Desactivar la redimensión
  setLayout(null);

  ImageIcon backgroundIcon = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
  JLabel backgroundImage = new JLabel(backgroundIcon);
  backgroundImage.setBounds(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
  add(backgroundImage);

  JLabel titleText = new JLabel("HOTEL LOS MANIACOS");
  titleText.setBounds(20, 430, 1000, 90);
  titleText.setForeground(Color.WHITE);
  titleText.setFont(new Font("serif", Font.BOLD, 50));
  titleText.setHorizontalAlignment(SwingConstants.CENTER);
  backgroundImage.add(titleText);

  JButton nextButton = new JButton("NEXT");
  nextButton.setBounds(830, 450, 150, 50);
  nextButton.setBackground(Color.BLACK);
  nextButton.setForeground(Color.WHITE);
  nextButton.setFont(new Font("serif", Font.PLAIN, 20));
  nextButton.addActionListener(this);
  backgroundImage.add(nextButton);

  Timer blinkTimer = new Timer(500, e -> titleText.setVisible(!titleText.isVisible()));
  blinkTimer.start();

  setVisible(true);
 }

 @Override
 public void actionPerformed(ActionEvent ae) {
  setVisible(false);
  new Login();
 }

 public static void main(String[] args) {
  SwingUtilities.invokeLater(HotelManagementSystem::new);
 }
}
