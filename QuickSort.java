/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class QuickSort {
     int[] scores;
    int iteration = 1;

    public QuickSort(int[] numbers) {
        this.scores = numbers;
    }

    public void sort() {
        quickSort(0, scores.length - 1);
    }

    private void quickSort(int low, int high) {

        if (low < high) {

            int pivotIndex = partition(low, high);

            System.out.println("Iteration " + iteration);
            display();
            iteration++;

            quickSort(low, pivotIndex - 1);
            quickSort(pivotIndex + 1, high);
        }
    }

    private int partition(int low, int high) {

        int pivot = scores[high];
        int i = low - 1;

        System.out.println();
        System.out.printf("partition [%d..%d] : pivot a[%d]=%d%n", low, high, high, pivot);

        for (int j = low; j < high; j++) {

            System.out.printf("a[%d]=%d < %d : ", j, scores[j], pivot);

            if (scores[j] < pivot) {
                i++;

                int temp = scores[i];
                scores[i] = scores[j];
                scores[j] = temp;

                System.out.printf("yes : a[%d] <-> a[%d]", i, j);

                if (i != j) {
                    System.out.print(" : ");
                    display();
                } else {
                    System.out.println();
                }
            } else {
                System.out.println("no");
            }
        }

        int temp = scores[i + 1];
        scores[i + 1] = scores[high];
        scores[high] = temp;

        System.out.printf("a[%d] <-> a[%d]", i + 1, high);

        if (i + 1 != high) {
            System.out.print(" : ");
            display();
        } else {
            System.out.println();
        }

        return i + 1;
    }

    public void display() {

        for (int number : scores) {
            System.out.print(number + " ");
        }

        System.out.println();
    }
}
