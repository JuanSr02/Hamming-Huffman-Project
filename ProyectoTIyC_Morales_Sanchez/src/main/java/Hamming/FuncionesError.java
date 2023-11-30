package Hamming;

import java.io.IOException;
import java.util.BitSet;
import java.util.Random;

public abstract class FuncionesError {
    
    
    public static int lugarDeError(int hamming) {
        int num = new Random().nextInt(hamming - 1);
        return num;
    }
    
    
    public static void algoritmoDeIntroduccionDeError(int hamming,BitSet output,int cant) throws IOException {
        int i;
        if(cant==1){
        i = new Random().nextInt(10);
        if(i==0){
            output.flip(lugarDeError(hamming));
        }
        }else{
            if(true){
                output.flip(lugarDeError(hamming-1));
                output.flip(lugarDeError(hamming-1));
            }     
        }
    }

    }
