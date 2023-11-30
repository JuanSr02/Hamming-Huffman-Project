
package Hamming;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Random;

public abstract class ProtegerHamming {
    //Hamming 32
    public static final int BITS_CONTROL_H32 = 5;
    public static final int BITS_INFO_H32 = 26;
    public static final int TOTAL_H32 = 32;
    //Hamming 2048
    public static final int BITS_CONTROL_H2048 = 11;
    public static final int BITS_INFO_H2048 = 2036;
    public static final int TOTAL_H2048 = 2048;
    //Hamming 65536
    public static final int BITS_CONTROL_H65536 = 16;
    public static final int BITS_INFO_H65536 = 65519;
    public static final int TOTAL_H65 = 65536;
    
    public static boolean doubleError=false;

    
    public static File protegerArchivo(int hamming, String aProteger,int errores) throws IOException {
    String archivo = aProteger;
    if(errores ==0){
    if (hamming == 32) {
    archivo=archivo.replace(".txt", ".HA1");
    archivo=archivo.replace(".huf", ".HA1");
    }
    if (hamming == 2048) {
    archivo=archivo.replace(".txt", ".HA2");
    archivo=archivo.replace(".huf", ".HA2");
    }
    if (hamming == 65536) {
    archivo=archivo.replace(".txt", ".HA3");
    archivo=archivo.replace(".huf", ".HA3");
    }
    }else{
    if (hamming == 32) {
    archivo=archivo.replace(".txt", ".HE1");
    archivo=archivo.replace(".huf", ".HE1");
    }
    if (hamming == 2048) {
    archivo=archivo.replace(".txt", ".HE2");
    archivo=archivo.replace(".huf", ".HE2");
    }
    if (hamming == 65536) {
    archivo=archivo.replace(".txt", ".HE3");
    archivo=archivo.replace(".huf", ".HE3");
    }
    }
    File archivoProtegido = new File(archivo);
    File archivoOriginal = new File(aProteger);
    protegerCadenas(archivoOriginal, archivoProtegido, hamming,errores);
    return archivoProtegido;
    }


    public static void protegerCadenas(File original, File protegido, int hamming,int errores) throws IOException,FileNotFoundException {
        int bitsInfo = 0, bitsControl=0,contadorBitsAgregados=0;int contadorBloques = 0;FileInputStream inputStream = new FileInputStream(original); OutputStream outputStream = new FileOutputStream(protegido); byte[] buffer = new byte[1];
        switch(hamming){
            case 32 -> {
                bitsInfo = BITS_INFO_H32;
                bitsControl = BITS_CONTROL_H32;
            }
            case 2048 -> {
                bitsInfo = BITS_INFO_H2048;
                bitsControl = BITS_CONTROL_H2048;
            }
            case 65536 -> {
                bitsInfo = BITS_INFO_H65536;
                bitsControl = BITS_CONTROL_H65536;
            }
        }
        boolean[][] matrizG = Matrices.MatrizG(bitsInfo, bitsControl, hamming);BitSet principal = new BitSet(bitsInfo);int sizePrincipal = 0;BitSet auxiliar = new BitSet(8);int sizeAuxiliar = 0;
        while (inputStream.read(buffer) != -1) {
            if (sizeAuxiliar != 0) {
                principal = FuncionesAuxiliares.concatBits(principal, auxiliar, 0, sizeAuxiliar);
                sizePrincipal += sizeAuxiliar;
                auxiliar.clear();
                sizeAuxiliar = 0;
            }
            if (sizePrincipal + 8 <= bitsInfo) {
                principal = FuncionesAuxiliares.concatBits(principal, FuncionesAuxiliares.octalTo8bits(buffer[0]), sizePrincipal, 8);
                sizePrincipal += 8;
            }
            else {
                auxiliar = FuncionesAuxiliares.octalTo8bits(buffer[0]);
                sizeAuxiliar = 8;
                principal = FuncionesAuxiliares.concatBits(principal, auxiliar, sizePrincipal, bitsInfo - sizePrincipal);
                auxiliar = FuncionesAuxiliares.shiftLeft(auxiliar, 8, bitsInfo - sizePrincipal);
                sizeAuxiliar -= (bitsInfo - sizePrincipal);
                sizePrincipal = bitsInfo;
            }
            if (sizePrincipal == bitsInfo) {
                contadorBloques++;
                codificar(principal, outputStream, hamming, errores, matrizG,contadorBloques);
                contadorBitsAgregados += (bitsControl+1);
                principal.clear();
                sizePrincipal = 0;
            }
        }
        if (sizeAuxiliar != 0 || sizePrincipal != 0) {
            if (sizeAuxiliar != 0) 
                principal = FuncionesAuxiliares.concatBits(principal, auxiliar, 0, sizeAuxiliar);

            contadorBitsAgregados += (hamming-(sizeAuxiliar + sizePrincipal));
            contadorBloques++;
            codificar(principal, outputStream, hamming, errores, matrizG,contadorBloques);
        }
        inputStream.close();
        outputStream.close();
    }
   
    public static void codificar(BitSet input, OutputStream outputStream, int hamming, int cantidadErrores, boolean[][] matrizG,int contadorBloques) throws IOException {
        
        int bitsControl = 0 , bitsInfo = 0;
        switch(hamming){
            case 32 -> {
                bitsInfo = BITS_INFO_H32;
                bitsControl = BITS_CONTROL_H32;
            }
            case 2048 -> {
                bitsInfo = BITS_INFO_H2048;
                bitsControl = BITS_CONTROL_H2048;
            }
            case 65536 -> {
                bitsInfo = BITS_INFO_H65536;
                bitsControl = BITS_CONTROL_H65536;
            }
        }
        BitSet output = new BitSet(hamming);
        output = FuncionesAuxiliares.repartirBitsInfo(input, hamming);
        boolean[] aux = new boolean[bitsInfo];
        
        for(int i = 0; i<bitsControl; i++){
            boolean result = false;
            int pos = (int) Math.pow(2, i);
            for(int j = 0; j<bitsInfo; j++){
                aux[j] = input.get(j) && matrizG[j][i];
                result = result ^ aux[j];
            }
            output.set(pos-1, result);
        }
        boolean result = false;
        for(int i=0;i<(hamming-1);i++)
            result = result ^ output.get(i);
        
        output.set(hamming-1, result);
        if(cantidadErrores == 1){
            FuncionesError.algoritmoDeIntroduccionDeError(hamming,output,1);
        }
        else if(cantidadErrores == 2){
            if(!doubleError){
                int i = new Random().nextInt(10);
                if(i==0){
                FuncionesError.algoritmoDeIntroduccionDeError(hamming,output,2);
                doubleError=true;}
            }else{
                FuncionesError.algoritmoDeIntroduccionDeError(hamming,output,1);
            }
        }
        
        Archivos.EscribirProtegido(output,hamming,outputStream);
    }
    
}
