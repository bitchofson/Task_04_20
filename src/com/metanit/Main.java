package com.metanit;

/*
20. Дан массив/список целых чисел размера n, где все числа лежат в диапазоне от 0 до m-1
(m намного меньше, чем n). Реализовать специальную сортировку, которая упорядочит
данный массив за O(n + m) (т.к. m много меньше m, то фактически за O(n)).
Подсказка: Завести новый массив размера m, в нем подсчитать, сколько каждое значение
встречается в исходном массиве (в созданном массиве индекс принимаем в качестве
значения). Потом в исходный массив просто выпишем по порядку, сколько раз какое
значение встречалось.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n, m, k = 0;
        System.out.print("Размер массива (n): ");
        n = scan.nextInt();
        System.out.print("Верхняя граница (m): ");
        m = scan.nextInt();

        if (m > n || m < 2) {
            System.out.println("Введенные значение не попадают в условие!");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++)
            arr[i] = (int) (Math.random() * m);


            System.out.println("Исходный массив:        " + Arrays.toString(arr));


        int[] helpArr = new int[m];
        for (int i = 0; i < arr.length; i++)
            helpArr[arr[i]]++;

        System.out.println("Вспомогательный массив: " + Arrays.toString(helpArr));


        for (int i = 0; i < helpArr.length; i++) {
            for (int j = 0; j < helpArr[i]; j++)
                arr[k + j] = i;
            k += helpArr[i];
        }
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
        scan.close();

    }
}
