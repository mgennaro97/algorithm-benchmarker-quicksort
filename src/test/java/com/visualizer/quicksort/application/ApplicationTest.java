package com.visualizer.quicksort.application;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ApplicationTest {

    @InjectMocks
    private Application application;

    final int[] testArray = new int[100];

    @BeforeEach
    void setUp() {
        Random random = new Random();
        for(int i = 0; i < testArray.length; i++){
            testArray[i] = random.nextInt(1000);
        }
    }

    @Test
    public void isArraySortedCorrectly() {
        application.quickSort(testArray);
        assertThat(testArray).isSorted();
    }
}