import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

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
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridBagLayout());
        loginPanel.setBackground(Color.LIGHT_GRAY);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiqueta de inicio de sesión
        JLabel loginLabel = new JLabel("Inicio de Sesion", SwingConstants.CENTER);
        loginLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        loginPanel.add(loginLabel, gbc);

        // Campo de usuario
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        loginPanel.add(new JLabel("Usuario"), gbc);
        gbc.gridx = 1;
        JTextField userField = new JTextField(15);
        loginPanel.add(userField, gbc);

        // Campo de contraseña
        gbc.gridx = 0;
        gbc.gridy = 2;
        loginPanel.add(new JLabel("Contrasena"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        loginPanel.add(passwordField, gbc);

        // Campo de tipo de usuario
        gbc.gridx = 0;
        gbc.gridy = 3;
        loginPanel.add(new JLabel("Tipo de Usuario"), gbc);
        gbc.gridx = 1;
        String[] userTypes = {"Selecciona", "Aliado/Proponente", "DEU/Coordinacion de extension", "CF/Comision de extension"};
        JComboBox<String> userTypeCombo = new JComboBox<>(userTypes);
        loginPanel.add(userTypeCombo, gbc);

        // Botón de ingresar
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        JButton loginButton = new JButton("Ingresar");
        loginPanel.add(loginButton, gbc);

        //Accion de boton ingresar
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                String selectedUserType = (String) userTypeCombo.getSelectedItem();
                if ("Aliado/Proponente".equals(selectedUserType)) {
                Proponente proponente = new Proponente();
                proponente.setVisible(true);
                proponente.setLocationRelativeTo(null);
             }
             if ("DEU/Coordinacion de extension".equals(selectedUserType)) {
                Deu deu = new Deu();
                deu.setVisible(true);
                deu.setLocationRelativeTo(null);
             }
             if ("CF/Comision de extension".equals(selectedUserType)) {
                Cf cf = new Cf();
                cf.setVisible(true);
                cf.setLocationRelativeTo(null);
             }
            }
        });

        // Botón para registro
        gbc.gridy = 5;
        JButton registerButton = new JButton(" ¿Eres nuevo? Registrate aqui");
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setFocusPainted(false);
        registerButton.setOpaque(false);
        registerButton.setForeground(Color.BLUE);
        loginPanel.add(registerButton, gbc);

        // Acción para el botón de registro
        registerButton.addActionListener(e -> cardLayout.show(cardPanel, "register"));

        // Añadir enlace para contraseña olvidada
        gbc.gridy = 6;
        JButton forgotPasswordButton = new JButton(" ¿Olvidaste tu contrasena?");
        forgotPasswordButton.setBorderPainted(false);
        forgotPasswordButton.setContentAreaFilled(false);
        forgotPasswordButton.setFocusPainted(false);
        forgotPasswordButton.setOpaque(false);
        forgotPasswordButton.setForeground(Color.BLUE);
        loginPanel.add(forgotPasswordButton, gbc);

        // Acción para el botón de contraseña olvidada
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

        // Etiqueta de crear cuenta
        JLabel registerLabel = new JLabel("Crear Cuenta", SwingConstants.CENTER);
        registerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        registerPanel.add(registerLabel, gbc);

        // Campo de nombre de proponente
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        registerPanel.add(new JLabel("Nombre de proponente"), gbc);
        gbc.gridx = 1;
        JTextField proponentNameField = new JTextField(15);
        registerPanel.add(proponentNameField, gbc);

        // Campo de C.I. o RIF del proponente
        gbc.gridx = 0;
        gbc.gridy = 2;
        registerPanel.add(new JLabel("C.I. o RIF del Proponente"), gbc);
        gbc.gridx = 1;
        JTextField rifField = new JTextField(15);
        registerPanel.add(rifField, gbc);

        // Campo de nombre de usuario
        gbc.gridx = 0;
        gbc.gridy = 3;
        registerPanel.add(new JLabel("Nombre de Usuario"), gbc);
        gbc.gridx = 1;
        JTextField usernameField = new JTextField(15);
        registerPanel.add(usernameField, gbc);

        // Campo de contraseña
        gbc.gridx = 0;
        gbc.gridy = 4;
        registerPanel.add(new JLabel("Contrasena"), gbc);
        gbc.gridx = 1;
        JPasswordField passwordField = new JPasswordField(15);
        registerPanel.add(passwordField, gbc);

        // Campo de confirmar contraseña
        gbc.gridx = 0;
        gbc.gridy = 5;
        registerPanel.add(new JLabel("Confirmar Contraseña"), gbc);
        gbc.gridx = 1;
        JPasswordField confirmPasswordField = new JPasswordField(15);
        registerPanel.add(confirmPasswordField, gbc);

        // Panel para el tipo de curso
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        JPanel courseTypePanel = new JPanel();
        courseTypePanel.setBackground(Color.LIGHT_GRAY);
        courseTypePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        courseTypePanel.add(new JLabel("Tipo de Curso"));

        JRadioButton noRequirementsButton = new JRadioButton("Sin Requisitos");
        noRequirementsButton.setBackground(Color.LIGHT_GRAY);
        JRadioButton withRequirementsButton = new JRadioButton("Con Requisitos");
        withRequirementsButton.setBackground(Color.LIGHT_GRAY);

        ButtonGroup courseTypeGroup = new ButtonGroup();
        courseTypeGroup.add(noRequirementsButton);
        courseTypeGroup.add(withRequirementsButton);

        courseTypePanel.add(noRequirementsButton);
        courseTypePanel.add(withRequirementsButton);
        registerPanel.add(courseTypePanel, gbc);

        // Botón de cargar requisitos
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton loadRequirementsButton = new JButton("Cargar Requisitos");
        registerPanel.add(loadRequirementsButton, gbc);

        // Botón de registrarse
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        JButton registerButton = new JButton("Registrarse");
        registerPanel.add(registerButton, gbc);

        // Botón para volver a iniciar sesión
        gbc.gridy = 9;
        JButton loginButton = new JButton("Iniciar Sesion");
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setFocusPainted(false);
        loginButton.setOpaque(false);
        loginButton.setForeground(Color.BLUE);
        registerPanel.add(loginButton, gbc);

        // Acción para el botón de iniciar sesión
        loginButton.addActionListener(e -> cardLayout.show(cardPanel, "login"));

        return registerPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}
