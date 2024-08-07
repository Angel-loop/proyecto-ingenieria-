package controlador;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import vista.Proponente;
import vista.Deu;
import vista.Cf;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private static final String USER_DATA_FOLDER = "src/BD"; // Carpeta para almacenar los datos
    private static final String USER_DATA_FILE = USER_DATA_FOLDER + "/usuarios.txt"; // Archivo de usuarios

    public MainFrame() {
        setTitle("SVCE");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(createLoginPanel(), "login");
        cardPanel.add(createRegisterPanel(), "register");

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);

        // Crear la carpeta de datos si no existe
        File dataFolder = new File(USER_DATA_FOLDER);
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        // Crear el archivo de datos si no existe
        File dataFile = new File(USER_DATA_FILE);
        try {
            if (!dataFile.exists()) {
                dataFile.createNewFile();
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al crear el archivo de usuarios");
        }
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel loginLabel = new JLabel("Inicio de Sesion", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Usuario"), gbc);
        gbc.gridx = 1;
        JTextField userField = new JTextField(15);
        loginPanel.add(userField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(new JLabel("Contrasena"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        loginPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(new JLabel("Tipo de Usuario"), gbc);
        gbc.gridx = 1;
        String[] userTypes = {"Selecciona", "Aliado/Proponente", "DEU/Coordinacion de extension", "CF/Comision de extension"};
        JComboBox<String> userTypeCombo = new JComboBox<>(userTypes);
        loginPanel.add(userTypeCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Ingresar");
        loginPanel.add(loginButton, gbc);

        // Acción para el botón de iniciar sesión
        loginButton.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());
            String userType = (String) userTypeCombo.getSelectedItem();

            if (authenticateUser(username, password, userType)) {
                JOptionPane.showMessageDialog(this, "Inicio de sesión exitoso");
                // Abrir la ventana correspondiente según el tipo de usuario
                switch (userType) {
                    case "Aliado/Proponente":
                        // Cierra la ventana actual
                        dispose();
                          // Abre la nueva ventana
                        Proponente proponente = new Proponente();
                        proponente.setVisible(true);
                        proponente.setLocationRelativeTo(null);
                        break;
                    case "DEU/Coordinacion de extension":
                        // Cierra la ventana actual
                        dispose();
                          // Abre la nueva ventana
                        Deu deu = new Deu();
                        deu.setVisible(true);
                        deu.setLocationRelativeTo(null);
                        break;
                    case "CF/Comision de extension":
                        // Cierra la ventana actual
                        dispose();
                          // Abre la nueva ventana
                        Cf cf = new Cf();
                        cf.setVisible(true);
                        cf.setLocationRelativeTo(null);
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Usuario, contraseña o tipo de usuario incorrectos");
            }
        });

        gbc.gridy = 5;
        JButton registerButton = new JButton("¿Eres nuevo? Regístrate aquí");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(false);
        registerButton.setForeground(Color.BLUE);
        loginPanel.add(registerButton, gbc);

        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "register"));

        gbc.gridy = 6;
        JButton forgotPasswordButton = new JButton("¿Olvidaste tu contrasena?");
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setOpaque(false);
        forgotPasswordButton.setForeground(Color.BLUE);
        loginPanel.add(forgotPasswordButton, gbc);

        forgotPasswordButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "Recuperacion de contrasena"));

        return loginPanel;
    }

    private JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new GridBagLayout());
        registerPanel.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel registerLabel = new JLabel("Crear Cuenta", SwingConstants.CENTER);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(registerLabel, gbc);

        gbc.gridwidth = 1;
        gbc.gridy = 1;
        registerPanel.add(new JLabel("Nombre de proponente"), gbc);
        gbc.gridx = 1;
        JTextField proponentNameField = new JTextField(15);
        registerPanel.add(proponentNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(new JLabel("C.I. o RIF del Proponente"), gbc);
        gbc.gridx = 1;
        JTextField rifField = new JTextField(15);
        registerPanel.add(rifField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(new JLabel("Nombre de Usuario"), gbc);
        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        registerPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        registerPanel.add(new JLabel("Contrasena"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        registerPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        registerPanel.add(new JLabel("Confirmar Contrasena"), gbc);
        gbc.gridx = 1;
        JPasswordField confirmPasswordField = new JPasswordField(15);
        registerPanel.add(confirmPasswordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        registerPanel.add(new JLabel("Tipo de Usuario"), gbc);
        gbc.gridx = 1;
        String[] userTypes = {"Selecciona", "Aliado/Proponente", "DEU/Coordinacion de extension", "CF/Comision de extension"};
        JComboBox<String> userTypeCombo = new JComboBox<>(userTypes);
        registerPanel.add(userTypeCombo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton registerButton = new JButton("Registrarse");
        registerPanel.add(registerButton, gbc);

        gbc.gridy = 9;
        JButton loginButton = new JButton("Iniciar Sesion");
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(false);
        loginButton.setForeground(Color.BLUE);
        registerPanel.add(loginButton, gbc);

        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "login"));

        // Acción para el botón de registrarse
        registerButton.addActionListener(e -> {
            String proponentName = proponentNameField.getText();
            String rif = rifField.getText();
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());
            String userType = (String) userTypeCombo.getSelectedItem();

            if (!password.equals(confirmPassword)) {
                JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
            } else {
                try (PrintWriter writer = new PrintWriter(new FileWriter(USER_DATA_FILE, true))) {
                    writer.println(proponentName + "," + rif + "," + username + "," + password + "," + userType);
                    JOptionPane.showMessageDialog(this, "Registro exitoso");
                    cardLayout.show(cardPanel, "login");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al guardar el archivo de usuarios");
                }
            }
        });

        return registerPanel;
    }

    private boolean authenticateUser(String username, String password, String userType) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USER_DATA_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String storedUsername = parts[2];
                    String storedPassword = parts[3];
                    String storedUserType = parts[4];
                    if (storedUsername.equals(username) && storedPassword.equals(password) && storedUserType.equals(userType)) {
                        return true;
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo de usuarios");
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
                
    }
}
