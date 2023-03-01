package com.zac.johnson.katas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class TwoSumTest {

    TwoSum testTwoSum;

    @BeforeEach
    public void beforeEach() {
        testTwoSum = new TwoSum();
    }

    @Test
    public void twoSum_test_1() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] result = new int[]{0, 1};

        assertArrayEquals(testTwoSum.twoSum(nums, target), result);
    }

    @Test
    public void twoSum_test_2() {
        int[] nums = new int[]{3,2,4};
        int target = 6;

        int[] result = new int[]{1,2};

        assertArrayEquals(testTwoSum.twoSum(nums, target), result);
    }

    @Test
    public void twoSum_test_3() {
        int[] nums = new int[]{3,3};
        int target = 6;

        int[] result = new int[]{0, 1};

        assertArrayEquals(testTwoSum.twoSum(nums, target), result);
    }
}


