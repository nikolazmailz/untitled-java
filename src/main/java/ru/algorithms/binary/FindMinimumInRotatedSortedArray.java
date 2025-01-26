package ru.algorithms.binary;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        // Указатели для начала и конца массива
        int left = 0, right = nums.length - 1;

        // Если массив не сдвинут (например, [1, 2, 3, 4, 5])
        if (nums[left] < nums[right]) {
            return nums[left];
        }

        // Модифицированный бинарный поиск
        while (left < right) {
            int mid = left + (right - left) / 2;

            // Если средний элемент больше последнего, значит минимум справа
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                // Иначе минимум находится в левой части или это mid
                right = mid;
            }
        }

        // В конце left и right укажут на минимальный элемент
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
//        int[] nums = {5, 6, 7, 0, 1, 2, 4};
        System.out.println("Минимальный элемент: " + findMin(nums));
    }
}
