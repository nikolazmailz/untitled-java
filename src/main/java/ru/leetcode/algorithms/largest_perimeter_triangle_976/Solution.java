package ru.leetcode.algorithms.largest_perimeter_triangle_976;

class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().largestPerimeter(
//                        new int[]{2,1,2}
                        new int[]{3,4,15,2,9,4}
//                        new int[]{1,2,1,10}
//                        new int[]{1,2,2,4,18,8}
                )
        );
    }

    public int largestPerimeter(int[] nums) {
        int maxPerimeter = 0;
        Triangle maxTriangle = new Triangle();
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = left + 1;

//            while ( (left < nums.length - 1 || right < nums.length) && (left != right) )  {
            while ( left < right)  {
                int a = nums[i];
                int b = nums[left];
                int c = nums[right];
                int s = a + b + c;
                System.out.println(s);
                if (validateTriangle(a, b, c)) {
                    if (a + b + c > maxPerimeter) {
                        maxPerimeter = a + b + c;
                        maxTriangle = new Triangle(nums[i], nums[left], nums[right], maxPerimeter);
                        System.out.println(maxTriangle);
                    }
                    if(right - left > 1 && right == nums.length - 1){
                        left++;
                    } else if(right < nums.length - 1){
                        right++;
                    } else {
                        left++;
                    }
                } else {
                    if (right < nums.length - 1) {
                        right++;
                    } else if (left < nums.length - 2) {
                        left++;
                        right = left + 1;
                    } else {
                        break;
                    }
                }
            }

        }
        return maxPerimeter;
    }

    private boolean validateTriangle(int a, int b, int c) {
        if (a + b > c && b + c > a && a + c > b) return true;
        return false;
    }


//    public int largestPerimeter(int[] nums) {
//        int maxPerimeter = 0;
//        Triangle maxTriangle = new Triangle();
//        for(int i=0; i < nums.length - 2; i++){
//            int left = i+1;
//            while (left < nums.length - 1){
//                int right = left+1;
//                while(right < nums.length){
//                    int aa = nums[i];
//                    int bb = nums[left];
//                    int cc = nums[right];
//
//                    if(nums[i] + nums[left] <= nums[right]) {
//                        right++;
//                        continue;
//                    }
//                    if(nums[right] + nums[left] <= nums[i]) {
//                        right++;
//                        continue;
//                    }
//                    if(nums[i] + nums[right] <= nums[left]) {
//                        right++;
//                        continue;
//                    }
//
//                    int localMax = nums[i] + nums[left] + nums[right];
//                    if(localMax > maxPerimeter){
//                        maxPerimeter = localMax;
//                        maxTriangle = new Triangle(nums[i],nums[left],nums[right], maxPerimeter);
//                        System.out.println(maxTriangle);
//                    }
//                    right++;
//                }
//                left++;
//            }
//
//        }
//        return maxPerimeter;
//    }
}

class Triangle {
    int a, b, c;
    int perimeter;

    public Triangle() {
    }

    public Triangle(int a, int b, int c, int perimeter) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.perimeter = perimeter;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", perimeter=" + perimeter +
                '}';
    }
}