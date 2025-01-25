package ru.leetcode.algorithms.distance_between_bus_stops_1184;

/**
 * 1184 https://leetcode.com/problems/distance-between-bus-stops/description/
 * */
class Solution {

    public static void main(String[] args) {
        System.out.println(
        new Solution().distanceBetweenBusStops(
                new int[]{14,21,8,35,30,21,28,19,10,25,16,23,14,13,0,3,30,9}, 12, 3
        ));

        System.out.println(
                new Solution().distanceBetweenBusStops2(
                        new int[]{14,21,8,35,30,21,28,19,10,25,16,23,14,13,0,3,30,9}, 12, 3
                ));
    }

    public int distanceBetweenBusStops2(int[] distance, int start, int destination) {
        int a = 5;
        int b = 12;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);

        int frontSum=0;
        int backSum=0;
        for(int i=start;i!=destination;i=(i+1)%distance.length) {
            frontSum+=distance[i];
        }
        for(int i=destination;i!=start;i=(i+1)%distance.length) backSum+=distance[i];
        return Math.min(frontSum,backSum);
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {


        int left = 0;
        int right = 0;


        if(start > destination){
            for( int i = 0; i < destination; i++){
                right += distance[i];
            }
            for( int i = start; i < distance.length; i++){
                right += distance[i];
            }
        } else {
            for( int i = start; i < destination; i++) {
                right += distance[i];
            }
        }

        if(start < destination) {
            for(int i = distance.length-1; i >= destination; i--) {
                left += distance[i];
            }

            for( int i = start; i > 0; i--) {
                left += distance[i-1];
            }

        } else {
            for( int i = start; i > destination; i--) {
                left += distance[i-1];
            }
        }


        System.out.println(left);
        System.out.println(right);
        return Math.min(left, right);

    }
}
