
package com.mycompany.huffmanm;
import java.io.*;
import java.nio.file.Paths;
import java.nio.file.Files;

public class FilesClass {
    
    public static String archivoEntrada="";
    public static String archivoCodificado="";
    public static String archivoDecodificado="";
    
    
    
    public static void setArchivoEntrada(String path){
        archivoEntrada = path;
    }
    
    public static String getArchivoEntrada(){
        return archivoEntrada;
    }
    
    public static void setArchivoCodificado(String path){
        archivoCodificado = path;
    }
    
     public static String getArchivoCodificado(){
        return archivoCodificado;
    }
    
    public static void setArchivoDecodificado(String path){
        archivoEntrada = path;
    }
    
    public static String getArchivoDecodificado(){
        return archivoDecodificado;
    }
    
    
      public static Boolean controlExtensionEntrada(String ext){ //Controla la extension sin errores
          
        return (ext.equals("txt") || ext.equals("docx") );
    }
      
      public static Boolean controlExtensionSalida(String ext){ //Controla la extension sin errores
          
        return (ext.equals("huf") || ext.equals("DC1") || ext.equals("DC2") || ext.equals("DC3") || ext.equals("DE1") || ext.equals("DE2") || ext.equals("DE3"));
    }
    
      
       public static String getExtensionFiles(String ruta){ //obtiene la extension de cualquier archivo
       
       String extension="";
       int indice = ruta.lastIndexOf(".");
       if(indice>0 && indice < ruta.length() -1){
           extension= ruta.substring(indice+1);
       }
    
       return extension;  
     }
      
    
    public static long tamanioOriginal() {
        File aLeer = new File(archivoEntrada);
        try {
            return Files.size(Paths.get(aLeer.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    
     public static File readFile(File path) {
        try {
            byte[] fileContents = Files.readAllBytes(Paths.get(path.getAbsolutePath()));
            File newFile = new File("auxiliar");
            FileWriter writer = new FileWriter(newFile);
            writer.write(new String(fileContents));
            writer.close();
            return newFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    

    public static String abrirMensajeOriginal() throws IOException {
        if(archivoEntrada.endsWith(".docx")){
          String mensaje = ReadDocxFile.readDocxFile(archivoEntrada);
          return mensaje;
        }
        else{
        File aLeeraux =new File(archivoEntrada);
        File aLeer = readFile(aLeeraux);
        try {
            byte[] mensaje = Files.readAllBytes(Paths.get(aLeer.getAbsolutePath()));
            return new String(mensaje);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        return "";
    }

    public static byte[] abrirMensajeCodificado() throws IOException {
        File aLeer = new File(archivoCodificado);
        byte[] mensaje2 = readBytesFromFile(archivoCodificado);
        try {
            byte[] mensaje3 = Files.readAllBytes(Paths.get(aLeer.getAbsolutePath()));
            return mensaje2;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static byte[] readBytesFromFile(String filePath) {
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            // Saltar las primeras 3 líneas
            for (int i = 0; i < 3; i++) {
                readLine(inputStream);
            }

            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            int byteValue;

            // Leer y almacenar los bytes restantes del archivo
            while ((byteValue = inputStream.read()) != -1) {
                byteStream.write(byteValue);
            }

            return byteStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void readLine(InputStream inputStream) throws IOException {
        int byteValue;
        do {
            byteValue = inputStream.read();
        } while (byteValue != -1 && byteValue != '\n');
    }
    
    public static long tamanioCodificado() {
        File aLeer = new File(archivoCodificado);
        try {
            return Files.size(Paths.get(aLeer.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    public static long tamanioDecodificado() {
        File aLeer = new File(archivoDecodificado);
        try {
            return Files.size(Paths.get(aLeer.getAbsolutePath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }
      
      //OBTIENE EL NOMBRE DEL ARCHIVO SIN SU EXTENSION, ME SIRVE PARA GENERAR EL ARCHIVO DECODIFICADO
   public static String obtenerNombre(String texto) {
    StringBuilder resultado = new StringBuilder();
    
    for (char c : texto.toCharArray()) {
        if (c == '.') {
            break;
        }
        resultado.append(c);
    }
    
    return resultado.toString();
}
    
}
