
package com.mycompany.huffmanm;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


public class TablaHuffman {
    

    public static Map<Character, String> MaketablaHuffman(List<Object[]> li) {
        // Crear una cola de prioridad para los nodos del árbol de Huffman
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(li.size(), new HuffmanComparator());
        boolean entre=false;
        // Crear nodos para cada elemento en la lista y agregarlos a la cola de prioridad
        for (Object[] item : li) {
            double probability = (double) item[0];
            char character = (char) item[1];
            pq.add(new HuffmanNode(probability, character));
        }

        // Construir el árbol de Huffman
        while (pq.size() > 1) {
            entre=true;
            // Tomar los dos nodos de menor probabilidad
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();

            // Crear un nuevo nodo interno con la suma de las probabilidades
            double sumProbabilities = left.probability + right.probability;
            HuffmanNode parent = new HuffmanNode(sumProbabilities, '\0');

            // Establecer los hijos izquierdo y derecho del nuevo nodo
            parent.left = left;
            parent.right = right;

            // Agregar el nuevo nodo a la cola de prioridad
            pq.add(parent);
        }

        // Obtener el nodo raíz del árbol de Huffman
        HuffmanNode root = pq.peek();

        // Crear la tabla de Huffman
        Map<Character, String> huffmanTable = new HashMap<>();
        if(entre==false){
            buildHuffmanTable(root, "1", huffmanTable);
        }else{
            buildHuffmanTable(root, "", huffmanTable);}

        return huffmanTable;
    }

    // Clase interna para representar un nodo del árbol de Huffman
    private static class HuffmanNode {
        double probability;
        char character;
        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(double probability, char character) {
            this.probability = probability;
            this.character = character;
            this.left = null;
            this.right = null;
        }
    }

    // Clase interna para comparar los nodos del árbol de Huffman por probabilidad
    private static class HuffmanComparator implements Comparator<HuffmanNode> {
        public int compare(HuffmanNode node1, HuffmanNode node2) {
            return Double.compare(node1.probability, node2.probability);
        }
    }

    // Método recursivo para construir la tabla de Huffman
    private static void buildHuffmanTable(HuffmanNode node, String code, Map<Character, String> table) {
        if (node.left == null && node.right == null) {
            // Es un nodo hoja, agregar el código de Huffman al caracter correspondiente
            table.put(node.character, code);
        } else {
            // Recursivamente construir el código de Huffman para los hijos izquierdo y derecho
            buildHuffmanTable(node.left, code + "0", table);
            buildHuffmanTable(node.right, code + "1", table);
        }
    }


}

