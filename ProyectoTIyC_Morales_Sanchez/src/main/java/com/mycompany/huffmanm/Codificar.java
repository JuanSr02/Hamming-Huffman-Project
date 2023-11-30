
package com.mycompany.huffmanm;
import static com.mycompany.huffmanm.FilesClass.controlExtensionEntrada;
import static com.mycompany.huffmanm.FilesClass.getExtensionFiles;
import static com.mycompany.huffmanm.FilesClass.setArchivoCodificado;
import static com.mycompany.huffmanm.FilesClass.setArchivoEntrada;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
    
    

public class Codificar extends FilesClass {
    
    public static String archivoTabla;
    

    
    //SET
    public static void setArchivoTabla(){
        String nombreArchivo= obtenerNombre(archivoCodificado);
        archivoTabla= nombreArchivo.concat("_tabla.txt");
    }
    

    
    //SELECCIONAR ARCHIVO PARA COMPACTAR
    
       public static void SelectArchivo(){
        
        JFileChooser jf = new JFileChooser(); //crea objeto de tipo FileChooser
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.TXT .DOCX","txt","docx"); //crea filtro .txt
        jf.setFileFilter(filtro); //filtra archivos .txt
        int select = jf.showOpenDialog(jf); //abre ventana
        
        if(select == JFileChooser.APPROVE_OPTION){
            String ex = getExtensionFiles(jf.getSelectedFile().getAbsolutePath());
         
          if( !controlExtensionEntrada(ex) ){ //Si igualmente se selecciona un archivo que no es .txt, muestra mensaje de error
              JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo con extensión .txt o .docx", "Extensión inválida", JOptionPane.ERROR_MESSAGE);
              
          }else{
              String ruta = jf.getSelectedFile().getAbsolutePath();
              String nuevaRuta=ruta;
                 
              setArchivoEntrada(ruta);
              if(getExtensionFiles(ruta).equals("txt")){
                  
                 nuevaRuta=nuevaRuta.replace(".txt", ".huf");
              }else{
                nuevaRuta=nuevaRuta.replace(".docx", ".huf");
              }
              
              setArchivoCodificado(nuevaRuta);
          }
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó ningun archivo.", "", JOptionPane.ERROR_MESSAGE);
        }
        
    }
       
       
  //COMPACTA EL ARCHIVO
    public static void codificacion(String mensaje, long size) throws IOException {
        //OutputStream archivo = new FileOutputStream(new File(archivoCodificado));
        setArchivoTabla();
        List<Character> limes= stringToList(mensaje);
        Map<Character, String> dictHuffman = TablaHuffman.MaketablaHuffman(Probabilidades.probabilidad(limes));
        generarArchivoExtra(dictHuffman, size);
        int binario = 0;
        String text = "";
        OutputStream archivo = new FileOutputStream(new File(archivoCodificado),true); //
        for (int i = 0; i < mensaje.length(); i++) {
            text = text + dictHuffman.get(mensaje.charAt(i));
        }
        int bitsPendientes = 8; // Cantidad de bits pendientes para llenar el último byte
        byte byteActual = 0; // Byte actual que se está construyendo

        for (int i = 0; i < text.length(); i++) {
            char bit = text.charAt(i);

            // Agrega el bit actual al byte actual
            byteActual <<= 1;
            if (bit == '1') {
                byteActual |= 1;
            }

            bitsPendientes--;

            // Si el byte actual está lleno, escríbelo en el archivo
            if (bitsPendientes == 0) {
                archivo.write(byteActual);
                byteActual = 0;
                bitsPendientes = 8;
            }
        }

        // Si quedan bits pendientes por escribir en el último byte, llena con ceros
        if (bitsPendientes < 8) {
            byteActual <<= bitsPendientes;
            archivo.write(byteActual);
        }
        archivo.close();
    }
    
    public static void generarArchivoExtra(Map<Character, String> dictHuffman, long size) throws IOException {
        //File nuevo = new File(archivoTabla);
        File nuevo = new File(archivoCodificado); //
        FileWriter archivo = new FileWriter(nuevo);
        archivo.write(String.valueOf(size));
        archivo.write('\n');
        String aux = escapeMapToString(dictHuffman);
        archivo.write(aux);
        archivo.write('\n');archivo.write('\n'); //
        archivo.close();
    }
    
    public static String escapeMapToString(Map<Character,String> map) {
    StringBuilder sb = new StringBuilder();
    sb.append("{");
    for (Map.Entry<Character,String> entry : map.entrySet()) {
        sb.append(escape(String.valueOf(entry.getKey()))).append("=").append(escape(entry.getValue().toString())).append(", ");
    }
    if (!map.isEmpty()) {
        sb.setLength(sb.length() - 2);
    }
    sb.append("}");
    return sb.toString();
}

private static String escape(String str) {
    return str.replace("\\", "\\\\")
              .replace("\"", "\\\"")
              .replace("\r", "\\r")
              .replace("\n", "\\n")
              .replace("\t", "\\t")
              .replace("\b", "\\b")
              .replace("\f", "\\f")
              .replace(",","coma")
              .replace("=","igual");
}

public static void compactar() throws IOException{
    codificacion(FilesClass.abrirMensajeOriginal(),FilesClass.tamanioOriginal());
    File fileToDelete = new File("auxiliar");
    fileToDelete.delete();    
}
   
    public static List<Character> stringToList(String str) {
    List<Character> list = new ArrayList<>();
    for (char c : str.toCharArray()) {
        list.add(c);
    }
    return list;
}

}
