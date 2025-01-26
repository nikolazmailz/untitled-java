package ru.algorithms;

public class MergeSort {

    public void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Середина массива

            mergeSort(arr, left, mid);          // Сортируем левую часть
            mergeSort(arr, mid + 1, right);     // Сортируем правую часть
            merge(arr, left, mid, right);       // Объединяем части
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // Определяем размеры двух временных массивов
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Создаем временные массивы
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Копируем данные во временные массивы
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        // Индексы для временных массивов и основного массива
        int i = 0, j = 0, k = left;

        // Слияние временных массивов обратно в основной
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы (если есть)
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        int[] arr = {8, 3, 1, 7, 0, 10, 2};
        sorter.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
