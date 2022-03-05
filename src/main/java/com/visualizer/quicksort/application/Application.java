package com.visualizer.quicksort.application;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@ComponentScan("com")
public class Application {

    private final Random random = new Random();


    public final void quickSort(final int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private void quicksort(final int[] array, int leftIndex, int rightIndex) {

        if (leftIndex >= rightIndex) {
            return;
        }

        int pivotIndex = random.nextInt(rightIndex - leftIndex) + leftIndex;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, rightIndex);

        int leftPointer = leftIndex;

        leftPointer = partition(array, rightIndex, pivot, leftPointer, rightIndex);


        quicksort(array, leftIndex, leftPointer - 1);
        quicksort(array, leftPointer + 1, rightIndex);
    }

    private int partition(int[] array, int rightIndex, int pivot, int leftPointer, int rightPointer) {
        while (leftPointer < rightPointer) {
            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, rightIndex);
        return leftPointer;
    }

    private void swap(int[] array, int leftIndex, int rightIndex) {
        int tmp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = tmp;
    }
}
