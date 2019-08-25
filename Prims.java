/**
@Author: Rohit Mitra
Step: Applying Prims MinimalSpanning Tree

**Prim’s Algorithm**
Prim’s Algorithm also use Greedy approach to find the minimum spanning tree. 
In Prim’s Algorithm we grow the spanning tree from a starting position. 
Unlike an edge in Kruskal's, we add vertex to the growing spanning tree in Prim's.

Algorithm Steps:
* Maintain two disjoint sets of vertices.
* One containing vertices that are in the growing spanning tree and other that are not in the growing spanning tree.
* Select the cheapest vertex that is connected to the growing spanning tree and is not in the growing spanning tree and add it into the 
growing spanning tree. 
* This can be done using Priority Queues. Insert the vertices, that are connected to growing spanning tree, into the Priority Queue.
* Check for cycles. To do that, mark the nodes which have been already selected and insert only those nodes in the Priority Queue that are 
not marked.
*/

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.lang.*;

class Prims {
    public static void main(String[] args) {  //main method
        long startTime = System.nanoTime();
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int k = 1;
        while(T-->0){
            int N = sc.nextInt();
            int M = sc.nextInt();
            long E = N * (N-1)/2;
            Graph graph = new Graph(N, E);
            boolean input[][] = new boolean[N][N];
            for(int i = 0; i<M; i++){
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph.addEdge(x-1, y-1, 1);  //Each node is being added in the graph with edge weight 1.
                input[x-1][y-1] = true;
            }
            for(int i = 0; i<N; i++){
                for(int j = i+1; j<N; j++){
                    if(input[i][j]==false){
                        graph.addEdge(i, j, 2); //Each node is being added in the graph with edge weight 2.
                        input[i][j] = true;
                    }
                }
            }
            System.out.print("Case #" + k++ + ": ");
            graph.Prims(graph,0);
        }
        System.err.println("Time: " + ((double)(System.nanoTime() - startTime))/(1e+9) + "s");  //Displays Execution time of the Program.

    }

//Creation of the Graph
    static class Graph {
        int V;
        long E;
        LinkedList<AdjNode> adj[];

        Graph(int V, long E) {  
            this.V = V;
            this.E = E;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
// method for adding new node to the graph
        void addEdge(int a, int b, int w) {
            adj[a].addLast(new AdjNode(b, w));
            adj[b].addLast(new AdjNode(a,w));
        }

        void Prims(Graph g, int s){
            long count=0;
            boolean[] visited = new boolean[g.V];
            visited[s]=true;
                  
            Queue<Node> q = new PriorityQueue(weightComparator); //Implementation of the Priority Queue
            q.add(new Node(s,0));

            visited[s]=true;

            while (!q.isEmpty()){ //Evaluation of Safe and cheapest Node

                Node n = q.poll();
                int temp=n.data;
                count+=n.dist;
                visited[temp]=true;

                for(AdjNode x : adj[temp]){
                    int num = x.data;
                    int w = x.weight;
                    
                  
                    if(visited[num]) {
                        for (Node a:q ) {
                            if(a.data==num && a.dist>w){
                                a.dist=w;
                            }
                        }
                    }
                 
                    else{
                        q.add(new Node(num,w));
                        visited[num] = true;
                    }
                    
                }
            }

            System.out.println(count); //Displays the minimum weight of the Spanning Tree
        }

        public static Comparator<Node> weightComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist-o2.dist;
            }
        };
    }

    static class AdjNode{
        int data;
        int weight;
        AdjNode(int data,int weight){
            this.data=data;
            this.weight=weight;
        }
    }

    static class Node{
        int data;
        int dist;
        Node(int data,int dist){
            this.data=data;
            this.dist=dist;
        }
    }

}
