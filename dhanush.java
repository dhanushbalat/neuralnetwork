import java.util.Scanner;

class Graph {
    private int[][] weights;

    public Graph(int layers, int[] nodes) {
        weights = new int[layers - 1][];
        for (int i = 0; i < layers - 1; i++) {
            weights[i] = new int[nodes[i] * nodes[i + 1]];
        }
    }

    public void setEdgeWeights(Scanner scanner) {
        for (int i = 0; i < weights.length; i++) {
            System.out.println("Enter weights for edges between layer " + (i + 1) + " and layer " + (i + 2) + ":");
            for (int j = 0; j < weights[i].length; j++) {
                weights[i][j] = scanner.nextInt();
            }
        }
    }

    public int getWeight(int layer, int node1, int node2) {
        int index = (node1 - 1) * (layer - 1) + (node2 - 1);
        return weights[layer - 1][index];
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of layers:");
        int layers = scanner.nextInt();

        int[] nodes = new int[layers];
        for (int i = 0; i < layers; i++) {
            System.out.println("Enter the number of nodes in layer " + (i + 1) + ":");
            nodes[i] = scanner.nextInt();
        }

        Graph graph = new Graph(layers, nodes);
        graph.setEdgeWeights(scanner);

        System.out.println("Enter the layer number, source node, and destination node to get the weight:");
        int layer = scanner.nextInt();
        int sourceNode = scanner.nextInt();
        int destinationNode = scanner.nextInt();

        int weight = graph.getWeight(layer, sourceNode, destinationNode);
        System.out.println("Weight of the edge from node " + sourceNode + " to node " + destinationNode + " in layer " + layer + " is: " + weight);

        scanner.close();
    }
}