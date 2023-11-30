
package Hamming;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ProtegerArchivo extends Archivos{
    
    public  ProtegerArchivo(){
       super();
    }
 
    // SELECCIONA UN ARCHIVO LUEGO DE LOS CONTROLES CORRESPONDIENTES
    public  File SelectArchivo(){
        
        JFileChooser jf = new JFileChooser(); //crea objeto de tipo FileChooser
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT","txt","huf"); //crea filtro .txt
        jf.setFileFilter(filtro); //filtra archivos .txt
        int select = jf.showOpenDialog(jf); //abre ventana
        
        if(select == JFileChooser.APPROVE_OPTION){
            String ex = this.getExtensionFiles(jf.getSelectedFile().getAbsolutePath());
         
          if( !controlExtensiontxt(ex) ){ //Si igualmente se selecciona un archivo que no es .txt, muestra mensaje de error
              JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo con extensión .txt", "Extensión inválida", JOptionPane.ERROR_MESSAGE);
              
          }else{
              this.archivoSeleccionado = jf.getSelectedFile();
          }
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó ningun archivo.", "", JOptionPane.ERROR_MESSAGE);
        }
        return this.archivoSeleccionado;
    }   
}
    
    
    
    

