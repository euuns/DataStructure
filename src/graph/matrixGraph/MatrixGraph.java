package graph.matrixGraph;

import java.util.Scanner;

public class MatrixGraph {

    static int size;
    static int[][] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정점 개수: ");
        size = Integer.parseInt(sc.nextLine());

        graph = new int[size][size];

        while(true){
            String input = sc.nextLine();
            if(input.equals("/")) break;

            String[] inputR = input.split(" ");
            add(Integer.parseInt(inputR[0]), Integer.parseInt(inputR[1]));
        }

        String printResult = printGraph();
        System.out.println(printResult);

    }

    public static void add(int from, int to){
        graph[from-1][to-1] = 1;
        graph[to-1][from-1] = 1;
    }

    public static String printGraph(){
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                print.append(graph[i][j]).append(" ");
            }
            print.append("\n");
        }
        return print.toString();
    }

}
