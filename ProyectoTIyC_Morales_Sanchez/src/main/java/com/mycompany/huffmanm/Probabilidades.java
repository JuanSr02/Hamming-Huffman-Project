
package com.mycompany.huffmanm;
import java.util.*;
/**
 *
 * @author juan_
 */
public class Probabilidades {
    
    
    public static List<Object[]> probabilidad(List<Character> li) {
        List<Object[]> listaProbabilidades = new ArrayList<>();
        int totalDeLetras = li.size();
        for (int i = 0; i < li.size(); i++) {
            if (Collections.frequency(li, li.get(i)) != 0) {
                listaProbabilidades.add(new Object[]{(double)Collections.frequency(li, li.get(i))/totalDeLetras,li.get(i)});
            }
        }
        Collections.sort(listaProbabilidades, new Comparator<Object[]>() {
            public int compare(Object[] o1, Object[] o2) {
                Double p1 = (Double)o1[0];
                Double p2 = (Double)o2[0];
                return p2.compareTo(p1);
            }
        });
        listaProbabilidades=borrarDuplicados(listaProbabilidades);
        return listaProbabilidades;
    }

    
    public static List<Object[]> borrarDuplicados(List<Object[]> listaProbabilidades) {
    List<Object[]> uniqueProbabilidades = new ArrayList<>();

    for (Object[] prob : listaProbabilidades) {
        if (!containsProb(uniqueProbabilidades, prob)) {
            uniqueProbabilidades.add(prob);
        }
    }

    return uniqueProbabilidades;
}

public static boolean containsProb(List<Object[]> probList, Object[] prob) {
    for (Object[] p : probList) {
        if (p[1].equals(prob[1])) {
            return true;
        }
    }

    return false;
}


}
