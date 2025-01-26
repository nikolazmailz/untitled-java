package ru.algorithms;

public class QuickSort {

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high); // Разделяем массив
            quickSort(arr, low, pivotIndex - 1);       // Сортируем левую часть
            quickSort(arr, pivotIndex + 1, high);      // Сортируем правую часть
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Опорный элемент
        int i = low - 1;       // Индекс для элементов, меньших pivot

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) { // Если текущий элемент <= pivot
                i++;
                swap(arr, i, j);   // Меняем местами
            }
        }
        swap(arr, i + 1, high);    // Ставим pivot в правильное место
        return i + 1;              // Возвращаем индекс pivot
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
//        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        sorter.quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
