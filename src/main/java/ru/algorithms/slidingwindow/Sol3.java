package ru.algorithms.slidingwindow;

public class Sol3 {

    public static void main(String[] args) {
        System.out.println(
                new Sol3().getSum(
                        new int[]{1,2,3,4,5,6}, 3
                )
        );
    }

    public int getSum(int[] nums, int window){
        int sum = 0;

        for(int i = 0; i < nums.length ; i++){

            if(i + window > nums.length){
                continue;
            }

            int localSum = 0;
            int j = i;

            while ( j < i + window){
                localSum += nums[j];
                j++;
            }

            if (localSum > sum){
                sum = localSum;
            }
        }


        return sum;
    }
}
