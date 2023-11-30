
package com.mycompany.huffmanm;
import static com.mycompany.huffmanm.FilesClass.archivoCodificado;
import static com.mycompany.huffmanm.FilesClass.getExtensionFiles;
import static com.mycompany.huffmanm.FilesClass.obtenerNombre;
import static com.mycompany.huffmanm.FilesClass.setArchivoCodificado;
import java.io.*;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Decodificar extends FilesClass {
    

    public static File archivoTabla;
  

    public static void descompactar() throws ClassNotFoundException, IOException {
        //decodificacion(FilesClass.abrirMensajeCodificado(),archivoTabla); //
        File a = new File(archivoCodificado); //
        decodificacion(FilesClass.abrirMensajeCodificado(),a); //
    }
    
    
  //SETS
    
 public static void setArchivoTabla(String ruta){
     
      String nombreArchivo= obtenerNombre(archivoCodificado);
      nombreArchivo = nombreArchivo.concat("_tabla.txt");
      archivoTabla= new File(nombreArchivo);
 }
 
  public static void setArchivoDecodificado(String ruta){
     archivoDecodificado = ruta;
 }
  
  
//SELECCIONAR ARCHIVO PARA DFSCOMPACTAR
    public static void SelectArchivo(){
        
        JFileChooser jf = new JFileChooser(); //crea objeto de tipo FileChooser
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.HUF,.DEx,.DCx","huf","DC1","DC2","DC3","DE1","DE2","DE3"); //crea filtro 
        jf.setFileFilter(filtro); //filtra archivos 
        int select = jf.showOpenDialog(jf); //abre ventana
        
        if(select == JFileChooser.APPROVE_OPTION){
            String ex = getExtensionFiles(jf.getSelectedFile().getAbsolutePath());
            
         
          if( !controlExtensionSalida(ex) ){ //Si igualmente se selecciona un archivo que no es .txt, muestra mensaje de error
              JOptionPane.showMessageDialog(null, "Debe seleccionar un archivo con extensión .huf", "Extensión inválida", JOptionPane.ERROR_MESSAGE);
              
          }else{
              String ruta = jf.getSelectedFile().getAbsolutePath();
              String nuevaRuta=ruta;
                 
              setArchivoCodificado(ruta);
              nuevaRuta=nuevaRuta.replace(".huf", ".dhu");
              nuevaRuta=nuevaRuta.replace(".DE1", ".dhu");
              nuevaRuta=nuevaRuta.replace(".DE2", ".dhu");
              nuevaRuta=nuevaRuta.replace(".DE3", ".dhu");
              nuevaRuta=nuevaRuta.replace(".DC1", ".dhu");
              nuevaRuta=nuevaRuta.replace(".DC2", ".dhu");
              nuevaRuta=nuevaRuta.replace(".DC3", ".dhu");
              
              setArchivoDecodificado(nuevaRuta);
              setArchivoTabla(archivoCodificado);
          }
        }else{
            JOptionPane.showMessageDialog(null, "No se seleccionó ningun archivo.", "", JOptionPane.ERROR_MESSAGE);
        }
        
    }  
 
    
//DESCOMPACTA EL ARCHIVO    
public static void decodificacion(byte[] mensajeCodificado,File filePath) throws ClassNotFoundException {
        try {
            int[] size ={0};
            FileOutputStream archivo = new FileOutputStream(archivoDecodificado);
            
            Map<Character,String> dictHuffman = leerDiccionario(filePath,size);
            Map<String,Character> dictHuffmanInv = invertirDiccionario(dictHuffman);
            String bit = "";
            long fileSizeCopy = 0;
            for (int i = 0; i < mensajeCodificado.length; i++) {
                char elemento =(char) mensajeCodificado[i];
            for (int j = 0; j < 8; j++) {
            fileSizeCopy = archivo.getChannel().position();
            if(size[0] > fileSizeCopy){
            int bitAux = elemento & 128;
            bitAux = bitAux >> 7;
            bit = bit + String.valueOf(bitAux);
            if (dictHuffmanInv.containsKey(bit)) {
                char byteArr = dictHuffmanInv.get(bit);
                archivo.write(byteArr);
                bit = "";
            }
            elemento = (char)(elemento & 127);
            elemento = (char)(elemento << 1);
            }
    }
}
            archivo.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File aBorrar = new File("auxiliar.txt");aBorrar.delete();  //  
}


    
    

public static Map<Character,String> leerDiccionario(File file,int[] size) throws IOException {
        Map<Character, String> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            size[0]= Integer.parseInt(reader.readLine());
            String line;
            String[] entry;
            if ((line = reader.readLine()) != null){
                line = line.substring(1, line.length() - 1);
                String[] keyValuePairs = line.split(",");
                for (String pair : keyValuePairs) {
                    entry = pair.split("=");
                    if (entry.length == 2) {
                        if(entry[0].trim().equals("")){
                        map.put(' ',entry[1].trim());}
                        else if(entry[0].trim().equals("\\\"")){
                        map.put('"',entry[1].trim());}
                        else if(entry[0].trim().equals("\\\\")){
                        map.put('\\',entry[1].trim());}
                        else if(entry[0].trim().equals("coma")){
                        map.put(',',entry[1].trim());}
                        else if(entry[0].trim().equals("igual")){
                        map.put('=',entry[1].trim());}
                        else if(entry[0].trim().equals("\\n")){
                        map.put('\n',entry[1].trim());}
                        else if(entry[0].trim().equals("\\r")){
                        map.put('\r',entry[1].trim());}
                        else if(entry[0].trim().equals("\\t")){
                        map.put('\t',entry[1].trim());}
                        else if(entry[0].trim().equals("\\b")){
                        map.put('\b',entry[1].trim());}
                        else if(entry[0].trim().equals("\\f")){
                        map.put('\f',entry[1].trim());}
                        else{
                        map.put(entry[0].trim().charAt(0),entry[1].trim());}
                    }
                }
        }
        return map;
    }
}
    
    
    private static Map<String, Character> invertirDiccionario(Map<Character,String> diccionario) {
        Map<String, Character> invertedDict = new HashMap<>();
        for (Map.Entry<Character, String> entry : diccionario.entrySet()) {
            invertedDict.put(entry.getValue(), entry.getKey());
        }
        return invertedDict;
    }

    
}
