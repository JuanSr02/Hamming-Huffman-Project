package Hamming;


import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.BitSet;

public abstract class Archivos {
    
    public static File archivoSeleccionado;
    public static String extension;
    public static boolean dobleError = false;
 
    
 
    public static boolean getDobleError(){
        return dobleError;
    }
    
    public static void resetDobleError(){
        dobleError = false;
    }

    
    
    public static void EscribirProtegido(BitSet bitset, int hammingNumber, OutputStream outputStream) throws IOException {

    int bufferSize = hammingNumber / 8;
    DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

    for (int i = 0; i < bufferSize; i++) {
        dataOutputStream.writeByte(FuncionesAuxiliares.binaryToAscii(bitset.get(i*8, (i+1)*8)));
    }
}
    
    
    
    //GETS
    public File Archivos2(){
        return this.archivoSeleccionado;
    }
    public String getExtension(){
        return this.extension;
    }
     public  String readFile(){
          String texto="";
          String linea="";
           try{
            FileReader fr= new FileReader(this.archivoSeleccionado);
            BufferedReader br = new BufferedReader(fr);
       
            while(((linea=br.readLine())!=null)){
                texto+=linea+"\n";
            } 
        }catch(Exception e){    
        }   
            return texto;
    }
     
     public int getCantBitsControl(String bloque){
         int bitsControl=0;
         if(bloque.equals("32")){
             bitsControl = 6;
         }else if(bloque.equals("2048")){
             bitsControl = 12;
         }else{
             bitsControl = 17;
         }
         
         return bitsControl;
     }
     
     public int getCantBitsInfo(String bloque){
         int bitsInfo=0;
         if(bloque.equals("32")){
             bitsInfo = 26;
         }else if(bloque.equals("2048")){
             bitsInfo = 2036;
         }else{
             bitsInfo= 65519;
         }
         
         return bitsInfo;
     }
     
     public long getCantModulos(String bloque, File ar){
         int bloqueB = Integer.parseInt(bloque);
         long cantModulos=0;
         long sizeFile = ar.length();
         int result =0;
         cantModulos = (sizeFile*8)/bloqueB;
         result = (int) Math.ceil(cantModulos);
         
         return  result;
     }

     
   //CONTROL DE EXTENSIONES  
      public String getExtensionFiles(String ruta){ //obtiene la extension de cualquier archivo
       
       int indice = ruta.lastIndexOf(".");
       if(indice>0 && indice < ruta.length() -1){
           extension= ruta.substring(indice+1);
       }
    
       return extension;  
     }
      
      public Boolean controlExtensionHA(){ //Controla la extension sin errores
          String ex = this.extension;
        return (ex.equals("HA1") || ex.equals("HA2") || ex.equals("HA3") );
    }
    
    public  Boolean controlExtensionHE(){ //Controla la extension con errores
        String ex = this.extension;
        return (ex.equals("HE1") || ex.equals("HE2") || ex.equals("HE3") || ex.equals("HE2048")); //HE2048 ES DE PRUEBA
    }
    
     public  Boolean controlExtensiontxt(String ex){ 
        return (ex.equals("txt") || ex.equals("huf"));
    }
   
    public abstract File SelectArchivo();
    

//ORDENA EL ARREGLO DE BYTES PARA QUE CADA BYTE ESTE ALMACENADO EN BIG ENDIAN
    /* Si por ejemplo el archivo tiene una letra H que en ascii es 01001000
       lo que se guarda en el arreglo es esa cadena pero invertida: 00010010 (little endian)
       Para guarda en big endian invertimos la cadena */
    public static byte[] invertirBitsArregloBytes(byte[] arreglo) {
        byte[] nuevoArreglo = new byte[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) { 
            byte b = arreglo[i];
            byte nuevoByte = 0;
            for (int j = 0; j < 8; j++) {
                nuevoByte <<= 1;
                nuevoByte |= (b & 1);
                b >>= 1;
            }
            nuevoArreglo[i] = nuevoByte;
        }
        return nuevoArreglo;
    }


//LEE UN ARCHIVO Y LO GUARDA EN UN ARREGLO DE BYTES EN BIG ENDIAN 
    public static byte[] leerArchivo(String nombreArchivo) throws IOException {
        int bytesRead;
        File archivo = new File(nombreArchivo);                          
        byte[] buffer;
        try (InputStream inputStream = new FileInputStream(archivo)) {
            buffer = new byte[(int) archivo.length()];
            bytesRead = inputStream.read(buffer);
        }
        return invertirBitsArregloBytes(buffer);
    }
    
  //Me DICE SI UN NUMERO ES POTENCIA DE 2
   private static boolean esPotenciaDeDos(int n) {
       return (n & (n - 1)) == 0;
   }  
   
 //GUARDA LOS BITS DE INFORMACION EN UN BITSET
   public static BitSet obtenerBitsInfo(BitSet input){
       int tam = input.length();
       BitSet output = new BitSet();
       int j = 0;
       for(int i=0; i<tam; i++){
           if(!esPotenciaDeDos(i+1)){
               output.set(j, input.get(i));
               j++;
           }
       }
       return output;
   }

 //GUARDA LOS BITS DE CONTROL EN UN BITSET
   public static BitSet obtenerBitsControl(BitSet input){
   int tam = input.length();
       BitSet output = new BitSet();
       int j = 0;
       for(int i=0; i<tam; i++){
           if(esPotenciaDeDos(i+1)){
               output.set(j, input.get(i));
               j++;
           }

       }
       return output;
   }

  //CONVIERTE UN ARREGLO DE BYTES A BITSET
   public static BitSet convertToBitSet(byte[] bytes) {
       BitSet bits = new BitSet(bytes.length * 8);
       int bitIndex = 0;
       for (int i = 0; i < bytes.length; i++) {
           for (int j = 0; j < 8; j++) {
               boolean bit = ((bytes[i] >> j) & 1) == 1;
               bits.set(bitIndex++, bit);
           }
       }

       return bits;
   }   
   
//ME RETORNA UN ARREGLO BIDIMENSIONAL DONDE CADA POSICION ES UN BLOQUE DE HAMMING
public static byte[][] convertToHA(byte[] inputBytes, int bloque) {
    int numElements = (int) Math.ceil((double) inputBytes.length / bloque);
    byte[][] outputArray = new byte[numElements][bloque];

    for (int i = 0; i < inputBytes.length; i++) {
        int elementIndex = i / bloque;
        int byteIndex = i % bloque;
        outputArray[elementIndex][byteIndex] = inputBytes[i];
    }

    return outputArray;
}

 //CONVIERTE UN BITSET EN UN ARREGLO DE BYTES
   public static byte[] convertToByteArray(BitSet bits) {
       byte[] bytes = new byte[(bits.length() + 7) / 8];
       for (int i = 0; i < bits.length(); i++) {
           int byteIndex = i / 8;
           int bitIndex = i % 8;
           if (bits.get(i)) {
               bytes[byteIndex] |= (1 << bitIndex);
           }
       }

       return bytes;
   }


 //CONCATENA DOS CADENAS DE BITS
     public static BitSet concatBits(BitSet receptorBits, BitSet bitsToAppend, int posInicial, int cantidad){
        
        for(int i = 0; i<cantidad; i++)
            receptorBits.set(posInicial + i, bitsToAppend.get(i));
        
        return receptorBits;
    }
 
   
  
  
  //shift
  public static BitSet shiftLeft(BitSet bitSet, int numBits) {
        BitSet newBitSet = new BitSet(bitSet.length() + numBits);
        for (int i = 0; i < bitSet.length(); i++) {
            newBitSet.set(i + numBits, bitSet.get(i));
        }
        return newBitSet;
    }
  
  //OBTENER SINDROME
  public static BitSet getBloqueCorregido(BitSet bloqueEntrada, int tamBloque, int bitsControl){
    
      BitSet bloqueCorregido=  bloqueEntrada;
     
      boolean acum = false;
      String sindrome="";
      int pos =0; //para reccorer los pasos y cant
       int[] paso= new int[bitsControl]; //= {0, 2, 4, 8, 16, 32,64,128,256,512,1024}; //S1, S2, S3, S4, S5,s6,s7,s8,s9,s10
      int [] cant= new int[bitsControl]; //= {0,1,3,7,15,31,63,127,255,511,1023};
      int bitParidad=0;
      int fin=0;
      
      //Saltos y posiciones
      paso[0]=0;
      cant[0]=0;
      for(int i=1; i<bitsControl; i++){
      int aux=(int) Math.pow(2, i); 
      paso[i]=aux;
      cant[i]=aux-1;
    }


     for(int a=1; a < bitsControl; a++){ //cantidad de controles
         acum=false; 
       
            for(int b=cant[pos];b<tamBloque-1;b += paso[pos+1]){ //salta al inicio de cada bloque en el que hay que hacer XOR
               
                for(int c=b; c< (b+(cant[pos]+1)); c++){ //Hace el xor con los bits correspondientes
                    
                    if(bloqueEntrada.get(c)){
                        acum ^= true;
                    }else{
                        acum ^= false;   
                    }
                }
            }
            if(acum){
                sindrome +="1";
            }else{
                sindrome +="0";
            }
          
           pos++;
   
        }
     
        //se supone que todo lo anterior me va a devolver una cadena con la posicion donde esta el error pero la tengo que invertir
        StringBuffer buffer = new StringBuffer(sindrome);
        sindrome = buffer.reverse().toString();
        int posicion= Integer.parseInt(sindrome, 2);
        
        if(posicion!=0){
            bloqueCorregido.flip(posicion-1);
    
        }
        acum=false;
     
         for(int i=0; i<tamBloque;i++){ //Controlo el bit de paridad
         
      
             if(bloqueCorregido.get(i)){
                        acum ^= true;
                    }else{
                        acum ^= false;   
                    }
        }
        if(acum){
             bitParidad=1;
         }
           
       if(bitParidad !=0){
            dobleError = true;
        }
            return bloqueCorregido;
  }
  
  //DECODIFICA TODOS LOS BLOQUES Y LOS GUARDA EN UN NUEVO BUFFER
  
  public static byte[] decodeHA(byte[] buffer, int bloque,int info,int controles, boolean corregir) throws FileNotFoundException, IOException { // Esta puede ser (matar en la conversion)
    byte[][] bloques = convertToHA(buffer, bloque);
    byte[] bufferDecodificado = new byte[info*bloques.length];
    BitSet bitsetFinal=new BitSet(bloques.length * bloque * 8);
    BitSet bitSet = new BitSet(info);
    int shiftSize = 0;
    int lengthAux=0;
    boolean shiftAnterior = false;
    
  
    for (int i = 0; i < bloques.length; i++) {
          if(corregir){
        bitSet = obtenerBitsInfo(getBloqueCorregido(convertToBitSet(bloques[i]),bloque*8,controles));   
        }else{
         bitSet = obtenerBitsInfo(convertToBitSet(bloques[i]));    
        }
        lengthAux=bitSet.length(); //necesito guardar el tamaño original para saber si al bitset actual tambien tengo que hacerle un shift
        /*
        Si tengo que hacerle un shift al anterior entonces
            hago el shift
            luego lo concateno
        Sino
            lo concateno así
        */
        if(shiftAnterior){
            bitSet = shiftLeft(bitSet,shiftSize);
        }
        bitsetFinal=concatBits(bitsetFinal,bitSet,bitsetFinal.length(),bitSet.length());
        if(lengthAux<info){
            shiftAnterior=true;
            shiftSize = info - lengthAux;
        }else{
            shiftAnterior=false;
        }   
    }

    byte[] bufferDecodificado1=convertToByteArray(bitsetFinal);

    return bufferDecodificado1;
}
   
    //TOMA UN ARREGLO DE BYTES Y CONVIERTE CADA BYTE A CARACTER ASCII Y LUEGO LO GUARDA EN UN ARCHIVO
   /*Es necesario volver a dejar el arreglo en la convencion original que utiliza java, porque las funciones que provee
   estan pensadas para ese orden especifico, es por eso que se vuelve a invertir cada byte*/

   private static File bytesToAsciiFile1(byte[] bytes, String fileName) throws IOException { // Esta puede ser
       // Crea un BufferedOutputStream para escribir en el archivo
       try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {
           // Invierte los bits de los bytes utilizando el método "invertirBitsArregloBytes"
           byte[] aux = invertirBitsArregloBytes(bytes);
           // Recorre el arreglo de bytes invertido y escribe cada byte como un caracter ASCII en el archivo
           for (int i = 0; i < aux.length; i++) {
               //out.write(aux[i]);
               out.write((char) (aux[i] & 0xFF));
           }
       }
       // Retorna un objeto File del archivo creado
       return new File(fileName);
   }
   
 

   
   //OBTIENE EL NOMBRE DEL ARCHIVO SIN SU EXTENSION, ME SIRVE PARA GENERAR EL ARCHIVO DECODIFICADO
   public static String obtenerNombre(String nombreArchivo) {
       File archivo = new File(nombreArchivo);
       String nombreCompleto = archivo.getName();
       int puntoPosicion = nombreCompleto.lastIndexOf(".");
       if (puntoPosicion > 0) {
           return nombreCompleto.substring(0, puntoPosicion);
       } else {
           return nombreCompleto;
       }
   }
   
   //ME DEVUELVE EL ARCHIVO DESPROTEGIDO
   public static File desprotegido (byte[] buffer,String nombreArchivo, String nuevaExtension){
       File archivoDesprotegido = new File(nombreArchivo);
       String name = obtenerNombre(nombreArchivo).concat(nuevaExtension);
       String aux = nombreArchivo;
       String aux2 = archivoDesprotegido.getName();
       aux=aux.replace(aux2, name);
           try {
               archivoDesprotegido = bytesToAsciiFile1(buffer,aux);
           } catch (IOException ex) {
               ex.getStackTrace().toString();
           }

       return archivoDesprotegido;
   }
   


  //FUNCIONES DE PRUEBA

    //ME IMRPIME UN ARREGLO BIDIMENSIONAL 
    public static void printBits(byte[][] byteArrays) {
        for (int i = 0; i < byteArrays.length; i++) {
            for (int j = 0; j < byteArrays[i].length; j++) {
                byte currentByte = byteArrays[i][j];
                for (int k = 0; k < 8; k++) {
                    System.out.print((currentByte >> k) & 1);
                }

            }
            System.out.print(" ");
        }
    }

    //IMPRIME UN BITSET
    public static void imprimirBitSet(BitSet bits) {
        System.out.println(bits.length());
        int j=0;
        for (int i = 0; i < bits.length(); i++) {
            System.out.print(bits.get(i) ? "1" : "0");
            j++;
            if(j%8 == 0){
                System.out.print(" ");
            }

        }
        System.out.println();
    }


  //IMPRIME UN ARREGLO EN EL ORDEN EXACTO EN EL QUE ESTAN ALCAMENADOS LOS BYTES
    public static void printByteArrayBits(byte[] array) {
        for (int i = 0; i < array.length; i++) { //accedo a cada posicion del arreglo
            for (int j = 0; j < 8; j++) {        //recorro los 8 bits de cada posicion
                /*Acá lo que hace es un shiftear a la derecha j posiciones para que el bit quiero obtener me quede 
                en el bit mas significativo, luego hago un AND con 1 para obtenerlo*/
                System.out.print((array[i] >> j) & 1); 
            }
            System.out.print("\n ");
        }
    
    }
    
}
