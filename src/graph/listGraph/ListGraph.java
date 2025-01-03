package graph.listGraph;

import java.util.ArrayList;
import java.util.Scanner;

public class ListGraph {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int size;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정점 개수: ");
        size = Integer.parseInt(sc.nextLine());
        initialize();

        while(true){
            String input = sc.nextLine();
            if(input.equals("/")) break;

            String[] inputR = input.split(" ");
            add(Integer.parseInt(inputR[0]), Integer.parseInt(inputR[1]));
        }

        System.out.println(getPrint());
    }


    public static void add(int from, int to){
        graph.get(from-1).add(to-1);
        graph.get(to-1).add(from-1);
    }

    public static String getPrint(){
        StringBuilder print = new StringBuilder();
        for (int i = 0; i < size; i++) {
            ArrayList<Integer> node = graph.get(i);
            print.append(i+1).append("번 노드: ");
            for (int j = 0; j < node.size(); j++) {
                print.append(node.get(j) + 1);
                if (j < node.size()-1) {
                    print.append(" -> ");
                }
            }
            print.append("\n");
        }

        return print.toString();
    }

    public static void initialize(){
        for (int i = 0; i < size; i++) {
            graph.add(new ArrayList<>());
        }
    }
}
