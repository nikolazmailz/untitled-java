package ru.algorithms.slidingwindow;

public class Sol2 {

    public static void main(String[] args) {

        System.out.println(
                new Sol2().find2(
//                        new int[]{2, -8, 3, -2, 4, -10}
                        new int[]{4, -7, 5, -1, 8}
                )
        );

    }

    public MaxSumRange find(int[] nums){
        int left = 0;
        int right = 0;
        int max=nums[0];

        for(int i = 0; i < nums.length; i++){
            int s = nums[i];
            int j = i+1;

            while (j < nums.length){
                s += nums[j];
                if(max < s){
                    left = i;
                    right = j;
                    max = s;
                }
                j++;
            }
        }

        return new MaxSumRange(
                left, right, max
        );
    }

    public MaxSumRange find2(int[] nums){
        MaxSumRange max = null;
        int startIndex = 0;
        int currentSum = 0;

        for(int i = 0; i < nums.length; i++){
            currentSum += nums[i];
            if(max == null || currentSum > max.sum){
                max = new MaxSumRange(startIndex, i, currentSum);
            }

            if(currentSum < 0){
                startIndex = i+1;
                currentSum = 0;
            }

        }

        return max;
    }

    public class MaxSumRange{
        public int left, right, sum;

        public MaxSumRange(){}

        public MaxSumRange(int left, int right, int sum){
            this.left = left;
            this.right = right;
            this.sum = sum;
        }

        @Override
        public String toString(){
            return "left: " + left + " right " + right + " max " + sum;
        }
    }
}
