
package Hamming;

import static frame.DesprotegerFrame.archivo;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class DesprotegerArchivo extends Archivos {
     public  DesprotegerArchivo(){
       super();
    }

    
   
 // SELECCIONA UN ARCHIVO LUEGO DE LOS CONTROLES CORRESPONDIENTES
     public  File SelectArchivo(){
        //archivo.archivoSeleccionado = null;
        JFileChooser jf = new JFileChooser(); //crea objeto de tipo FileChooser
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.HAx, .HEx","HA1","HA2","HA3","HE1","HE2","HE3"); //crea filtro
        jf.setFileFilter(filtro); //filtra archivos 
        int select = jf.showOpenDialog(jf); //abre ventana
        
        if(select == JFileChooser.APPROVE_OPTION){
            String ex = this.getExtensionFiles(jf.getSelectedFile().getAbsolutePath());
         
          if( !((controlExtensionHA() || controlExtensionHE() ))){ //Si igualmente se selecciona un archivo con una extension incorrecta, muestra mensaje de error
              JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo con extensión .HAx o .HEx", "Extensión inválida", JOptionPane.ERROR_MESSAGE); 
              
          }else{
              this.archivoSeleccionado = jf.getSelectedFile();
              this.extension=ex;
           
          }
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó ningun archivo.", "", JOptionPane.ERROR_MESSAGE);
        }
        return this.archivoSeleccionado;
    }   
     
   
}
