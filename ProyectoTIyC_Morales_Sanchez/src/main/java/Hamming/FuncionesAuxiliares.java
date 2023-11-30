
package Hamming;

import static com.mycompany.huffmanm.FilesClass.archivoEntrada;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.BitSet;


public abstract class FuncionesAuxiliares {
    
    
   
    
    
    public static boolean isPotenciaDeDos(int n) {
    return (n & (n - 1)) == 0;
    }

    public static BitSet repartirBitsInfo(BitSet input, int vectorSize){
    BitSet output = new BitSet(vectorSize);
    int j = 0;
    for(int i=0; i<vectorSize; i++){
        if(!isPotenciaDeDos(i+1)){
            output.set(i, input.get(j));
            j++;
        }
    }
    return output;
}
    

    public static byte binaryToAscii(BitSet bitset) {
    int valor = 0;
    for (int i = 0; i < 8; i++) {
        if (bitset.get(i)) {
            valor |= 1 << (7 - i);
        }
    }

    if (valor > 127) {
        valor -= 256;
    }

    return (byte) valor;
}
    

    
     public static boolean[] enteroBinario(int number, int longitud){
        boolean[] ret = new boolean[longitud];
        for(int i = longitud-1; i>=0; i--){
            int modulo = number % 2;
            if(modulo == 0)
                ret[i]=false;
            else
                ret[i]=true;
            
            number /= 2;
        }        
        return ret;
    }


    public static BitSet octalTo8bits(int ascii){
        BitSet bitset = new BitSet(8);
        
        if(ascii <0) ascii += 256;
        
        for(int i = 7; i>=0; i--){
            int modulo = ascii % 2;
            if(modulo == 0)
                bitset.set(i, false);
            else
                bitset.set(i, true);
            
            ascii /= 2;
        }        
        return bitset;
    }
    
    public static BitSet concatBits(BitSet receptorBits, BitSet bitsToAppend, int posInicial, int cantidad){        
        for(int i = 0; i<cantidad; i++)
            receptorBits.set(posInicial + i, bitsToAppend.get(i));
        
        return receptorBits;
    }
    
    
    
    public static BitSet shiftLeft(BitSet bitset, int sizeBitset, int shift){
        
        for(int i = 0; i < sizeBitset; i++)
            bitset.set(i, bitset.get(shift+i));
        
        return bitset;
    }
}
