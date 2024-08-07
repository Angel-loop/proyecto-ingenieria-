package vista;

import java.awt.FlowLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class Pantalla extends javax.swing.JFrame {
    private Deu deu;
    private Proponente proponente;

    public Pantalla() {
        initComponents();
    }
    
    public Pantalla(Deu deu) {
        this.deu = deu;
        initComponents();
    }
    
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        Aprobado = new javax.swing.JButton();
        Aprobado1 = new javax.swing.JButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        Aprobado2 = new javax.swing.JButton();
        Aprobado3 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        Aprobado4 = new javax.swing.JButton();
        Aprobado5 = new javax.swing.JButton();
        jToggleButton3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setText("Cursos Propuestos");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setText("Curso");
        
        //Accion para rechazar curso
        Aprobado.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        // Establece el texto del botón "Aprobado" a "Rechazado"
        Aprobado.setText("Rechazado");
        // Añade un ActionListener al botón
        Aprobado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            // Si la instancia de "deu" es nula, crea una nueva instancia
            if (deu == null) {
                    deu = new Deu();
                    proponente = new Proponente();
                }
                // Establece el texto de la etiqueta en "Rechazado"
                deu.setLabelText("Rechazado");
                proponente.setLabelText("Rechazado");
                
                // Cierra la ventana actual
                dispose();
                
                //Hace visible la pantalla de la deu con los cambios
                
                deu.setVisible(true);
            }
        });
        setLayout(new FlowLayout());
        add(Aprobado);
        
        //Accion para aprobar curso
        Aprobado1.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        // Establece el texto del botón "Aprobado" a "Aprobado"
        Aprobado1.setText("Aprobado");
         // Añade un ActionListener al botón
        Aprobado1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        // Si la instancia de "deu" es nula, crea una nueva instancia
        if (deu == null) {
            deu = new Deu();
        }
        if (proponente == null) {
            proponente = new Proponente();
        }

        // Establece el texto de la etiqueta en "Aprobado"
        proponente.setLabelText("Aprobado");
        deu.setLabelText("Aprobado");
        
        // Cierra la ventana actual
        dispose();
        
        // Hace visible la pantalla de "deu" con los cambios
        deu.setVisible(true);

        
    }
});

        setLayout(new FlowLayout());
        add(Aprobado1);
        
        //Accion para descargar archivo
        jToggleButton4.setText("Descargar Doc");
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        
        // Define la ruta de destino donde esta el archivo
        String destinationPath = System.getProperty("user.home") + File.separator + "OneDrive" + File.separator + "Escritorio" + File.separator + "Equipo6_Proyecto Login" + File.separator + "Equipo6_Proyecto" + File.separator + "src/Cursos" + File.separator;
        String fileName = "CursoMarketingDigital.pdf";
        File destinationFile = new File(destinationPath + fileName);

        // Crea un cuadro de diálogo para seleccionar la carpeta donde se guaradara el archivo
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName));
        int userSelection = fileChooser.showSaveDialog(null);

        // Si el usuario aprueba la operación de guardar el archivo
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(destinationFile);
                 FileOutputStream fos = new FileOutputStream(saveFile)) {
                
                // Buffer para leer y escribir el archivo
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                // Cierra la ventana actual
                dispose();
                // Muestra un mensaje de éxito
                JOptionPane.showMessageDialog(null, "Archivo descargado exitosamente.");
            } catch (IOException e) {
                // Muestra un mensaje de error si ocurre una excepción
                JOptionPane.showMessageDialog(null, "Error al descargar el archivo: " + e.getMessage());
            }
        }
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jToggleButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(Aprobado1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Aprobado)))
                .addGap(0, 18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aprobado)
                    .addComponent(Aprobado1))
                .addGap(20, 20, 20))
        );

        Aprobado.getAccessibleContext().setAccessibleName("Rechazado");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel4.setText("Curso");

        Aprobado2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Aprobado2.setText("Rechazado");
        Aprobado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (deu == null) {
                    deu = new Deu();
                    proponente = new Proponente();
                }
                deu.setLabelText2("Rechazado");
                proponente.setLabelText2("Rechazado");
                // Cierra la ventana actual
                dispose();
                // Abre la nueva ventana
                deu.setVisible(true);
            }
        });
        setLayout(new FlowLayout());
        add(Aprobado2);

        Aprobado3.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Aprobado3.setText("Aprobado");
        Aprobado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (deu == null) {
                    deu = new Deu();
                    proponente = new Proponente();
                }
            
                deu.setLabelText2("Aprobado");
                proponente.setLabelText2("Aprobado");
                // Cierra la ventana actual
                dispose();
                // Abre la nueva ventana
                deu.setVisible(true);
            }
        });
        setLayout(new FlowLayout());
        add(Aprobado3);

        jToggleButton2.setText("Descargar Doc");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        String destinationPath = System.getProperty("user.home") + File.separator + "OneDrive" + File.separator + "Escritorio" + File.separator + "Equipo6_Proyecto Login" + File.separator + "Equipo6_Proyecto" + File.separator + "src/Cursos" + File.separator;
        String fileName = "CursoMarketingDigital.pdf";
        File destinationFile = new File(destinationPath + fileName);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(destinationFile);
                 FileOutputStream fos = new FileOutputStream(saveFile)) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                JOptionPane.showMessageDialog(null, "Archivo descargado exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al descargar el archivo: " + e.getMessage());
            }
        }
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(Aprobado3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Aprobado2)))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton2)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aprobado3)
                    .addComponent(Aprobado2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("Curso");

        Aprobado4.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Aprobado4.setText("Rechazado");
        Aprobado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (deu == null) {
                    deu = new Deu();
                    proponente = new Proponente();
                }
            
                deu.setLabelText3("Rechazado");
                proponente.setLabelText3("Rechazado");
                // Cierra la ventana actual
                dispose();
                // Abre la nueva ventana
                deu.setVisible(true);
            }
        });
        setLayout(new FlowLayout());
        add(Aprobado4);

        Aprobado5.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N
        Aprobado5.setText("Aprobado");
        Aprobado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            if (deu == null) {
                    deu = new Deu();
                    proponente = new Proponente();
                }
            
                deu.setLabelText3("Aprobado");
                proponente.setLabelText3("Aprobado");
                
                // Cierra la ventana actual
                dispose();
                // Abre la nueva ventana
                deu.setVisible(true);
              
            }
        });
        setLayout(new FlowLayout());
        add(Aprobado5);

        jToggleButton3.setText("Descargar Doc");
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
        String destinationPath = System.getProperty("user.home") + File.separator + "OneDrive" + File.separator + "Escritorio" + File.separator + "Equipo6_Proyecto Login" + File.separator + "Equipo6_Proyecto" + File.separator + "src/Cursos" + File.separator;
        String fileName = "CursoMarketingDigital.pdf";
        File destinationFile = new File(destinationPath + fileName);

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setSelectedFile(new File(fileName));
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File saveFile = fileChooser.getSelectedFile();
            try (FileInputStream fis = new FileInputStream(destinationFile);
                 FileOutputStream fos = new FileOutputStream(saveFile)) {

                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                JOptionPane.showMessageDialog(null, "Archivo descargado exitosamente.");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al descargar el archivo: " + e.getMessage());
            }
        }
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(Aprobado5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Aprobado4))
                            .addComponent(jToggleButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jToggleButton3)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Aprobado5)
                    .addComponent(Aprobado4))
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 127, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("Rechazado");

        pack();
    }// </editor-fold>                        

    private void AprobadoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
    }                                        

    private void Aprobado1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void Aprobado2ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void Aprobado3ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void Aprobado4ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void Aprobado5ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jToggleButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.JButton Aprobado;
    private javax.swing.JButton Aprobado1;
    private javax.swing.JButton Aprobado2;
    private javax.swing.JButton Aprobado3;
    private javax.swing.JButton Aprobado4;
    private javax.swing.JButton Aprobado5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JToggleButton jToggleButton2;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    // End of variables declaration                   
}

