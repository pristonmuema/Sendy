/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sendy;

/**
 *
 * @author PRISTON
 */

import java.util.LinkedList;

public class SendyOrder {
    static class Order {
        int pickup;
        int dropOff;
        int distance;
        

        public Order(int source, int dropOff, int distance) {
            this.pickup = pickup;
            this.dropOff = dropOff;
            this.distance = distance;
        }
    }

    static class Graph {
        int orderLocation;
        double cost;
        LinkedList<Order> [] adjacencylist;

        Graph(int vertices) {
            this.orderLocation = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i <vertices ; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public void addOrder(int pickup, int dropOff, int distance) {
            Order edge = new Order(pickup, dropOff, distance);
            adjacencylist[pickup].addFirst(edge); //for directed graph
        }

        public void printGraph(){
            System.out.println("Possible combinations for 9 orders with their cost(Ksh30/km)");
            for (int i = 0; i <orderLocation ; i++) {
                LinkedList<Order> list = adjacencylist[i];
                for (int j = 0; j <list.size() ; j++) {
                    System.out.println("pick up at " + i + "  dropOff to " +
                            list.get(j).dropOff + " with distance " +  list.get(j).distance+"km"+ " Order Cost "+  list.get(j).distance*30 +" Ksh ");
                }
                
            }
        }
    }
      public static void main(String[] args) {
            int orderLocation = 6;
            Graph graph = new Graph(orderLocation);
            graph.addOrder(0, 1, 4);
            graph.addOrder(0, 2, 3);
            graph.addOrder(1, 3, 2);
            graph.addOrder(1, 2, 5);
            graph.addOrder(2, 3, 7);
            graph.addOrder(3, 4, 2);
            graph.addOrder(4, 0, 4);
            graph.addOrder(4, 1, 4);
            graph.addOrder(4, 5, 6);
            graph.printGraph();
        }
}

