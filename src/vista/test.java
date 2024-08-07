package vista;

// Importing File Class
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;


import javax.swing.*;
 


//Ventana de prueba
public class test extends JFrame implements ActionListener {
  
    
    JButton btn;
    //Cosntructor
     public test() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("File Upload");
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout());
      
        //Crea el boton de subida y lo agrega al layout
        btn = new JButton("Upload File");
        btn.setFocusable(false);
        this.add(btn);
        btn.addActionListener(this);

        this.pack();
        this.setVisible(true);

    }

    //Lee todos los eventos
    public void actionPerformed(ActionEvent event){
        
        //Si el evento fue presionar el boton de arriba se ejecuta
        if(event.getSource() == btn){

            //Crea el objeto con el se va a seleccionar el archivo
            //Y coloca el directorio de seleccion en donde esta el archivo
            JFileChooser fileUpload = new JFileChooser();
            fileUpload.setCurrentDirectory(new File("."));
            int resSave = fileUpload.showSaveDialog(fileUpload); 

            // Si se guarda el archivo, crea un objeto y obtiene el nombre del archivo a guardar
            if (resSave == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileUpload.getSelectedFile();
                String fileName = selectedFile.getName();
                String destinationPath = System.getProperty("user.home") + File.separator + "OneDrive" + File.separator + "Escritorio" + File.separator + "Equipo6_Proyecto Login" + File.separator + "Equipo6_Proyecto" + File.separator + "src/Cursos" + File.separator;

                // Crea la carpeta cursos si no existe
                File destinationDir = new File(destinationPath);
                if (!destinationDir.exists()) {
                    destinationDir.mkdirs();
                }

                // Crea la ruta completa para guardar el archivo en la carpeta cursos
                File destinationFile = new File(destinationPath + fileName);

                try {
                    // Copia el archivo al destino deseado
                    Files.copy(selectedFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    System.out.println("Archivo guardado en: " + destinationFile.getAbsolutePath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
