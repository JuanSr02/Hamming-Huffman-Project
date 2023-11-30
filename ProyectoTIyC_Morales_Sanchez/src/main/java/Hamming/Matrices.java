
package Hamming;


public abstract class Matrices {
    
    public static boolean[][] MatrizG(int BitsI,int BitsC, int hamming){
        boolean[][] matriz = new boolean[BitsI][BitsC];
	int j;
	for(int i=0; i<BitsC; i++){		
            j=0;
            for (int k=0; k<hamming; k++){
                if(!FuncionesAuxiliares.isPotenciaDeDos(k+1)){
                    matriz[j][i] = FuncionesAuxiliares.enteroBinario(k+1,BitsC)[BitsC-i-1];
                    j++;
                }
            }
	}
	return matriz;
    }
  
}
