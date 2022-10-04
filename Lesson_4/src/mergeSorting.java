import java.util.Arrays;

/*
Принцип "Резделяй и властвуй"
 */
    public class mergeSorting {

    public static void main(String[] args) {
        int[] arr = {1,9,2,8,3,7,6,4,5};
        System.out.println("Original array:");
        printArray(arr);

        mergeSorting in = new mergeSorting();
        in.sort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        printArray(arr);
    }

        void mergeSort(int[] arr, int l, int m, int r) {

            // Вычислим длину двух субмассивов для слияния
            int n1 = m - l + 1;
            int n2 = r - m;

            // Создаем временный массив
            int[] left = new int[n1];
            int[] right = new int[n2];

            // Скопируем данные во временные массивы
            for (int i = 0; i < n1; ++i) {
                left[i] = arr[l + i];
            }
            for (int j = 0; j < n2; ++j) {
                right[j] = arr[m + 1 + j];
            }

            // Теперь инициация индексации и слияние субмассивов
            int i = 0, j = 0;
            int k = l;
            while (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    arr[k] = left[i];
                    i++;
                } else {
                    arr[k] = right[j];
                    j++;
                }
                k++;
            }

            // Копируем любый оставшиеся элементы левого и правого подмассивов
            while (i < n1) {
                arr[k] = left[i];
                i++;
                k++;
            }
            while (j < n2) {
                arr[k] = right[j];
                j++;
                k++;
            }
        }

        // Основная функция сортировки:

            void sort(int[] arr, int l, int r) {
                    if (l < r) {
                        int m = l + (r - l) / 2;
                        sort(arr, l, m);
                        sort(arr, m + 1, r);
                        mergeSort(arr, l, m, r);
                    }
            }
                // Вывод массива в консоль
            static void printArray(int[] arr) {
                String array = Arrays.toString(arr);
                System.out.println(array);
            }
    }