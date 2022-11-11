package com.greateLearning.groupG1AB6;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class FloorConstructionPlanning {
    public static final String TEXT_RED = "\u001B[31m";

    public static void main(String[] args) {

        int numFloor;
        int[] floorOrderByDay;
        PriorityQueue<Integer> pastOrder = new PriorityQueue<>(Comparator.reverseOrder()),
                                futureOrder = new PriorityQueue<>(Comparator.reverseOrder());
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the total no of floors in the building");
        numFloor = sc.nextInt();
        if (numFloor < 0) {
            System.out.println(TEXT_RED + "A negative value as no of floors is no possible.\n" +
                    "Sorry exiting the program............");
            return;
        }
        floorOrderByDay = new int[numFloor];

        System.out.println("Enter the floor size for each day:=");
        for(int i=0; i<numFloor; i++){
            System.out.println("enter the floor size given on day : " + (i+1));
            int floorSize = sc.nextInt();
            if (floorSize < 0) {
                System.out.println(TEXT_RED + "A negative value as floor size is no possible.\n" +
                        "Sorry exiting the program............");
                return;
            }
            floorOrderByDay[i] = floorSize;
            futureOrder.add(floorSize);
        }

        System.out.println("\nThe order of construction is as follows");
        for(int i=0; i<floorOrderByDay.length; i++){
            int floorSize = floorOrderByDay[i];
            pastOrder.add(floorSize);

            if ((pastOrder.size() > 0 && futureOrder.size() > 0 && pastOrder.peek() >= futureOrder.peek())){
                System.out.println("Day: "+ (i+1));
                while (pastOrder.size() > 0 && futureOrder.size() > 0 && pastOrder.peek() >= futureOrder.peek()) {
                    System.out.print(pastOrder.poll() +" ");
                    futureOrder.poll();
                }
            }
            else System.out.println("Day: "+ (i+1));
            System.out.println();
        }
    }
}
