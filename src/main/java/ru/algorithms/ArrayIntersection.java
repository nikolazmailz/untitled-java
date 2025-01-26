package ru.algorithms;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntersection {
    public static List<Integer> intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                result.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 3, 4};
        int[] nums2 = {2, 2, 4, 6};
        List<Integer> intersection = intersect(nums1, nums2);
        System.out.println("Intersection: " + intersection); // Output: [2, 2, 4]
    }
}
