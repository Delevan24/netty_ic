package com.leecode;

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

         

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]*/

import com.google.common.collect.Maps;

import java.util.HashMap;

public class LeeTest1 {

    public static int[] intSum1(int[] num, int target) {
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                if (target - num[j] == num[i]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }


    public static int[] intSum2(int[] num, int target) {
        HashMap<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < num.length; i++) {
            int n = target - num[i];
            if (map.containsKey(n)) {
                return new int[]{map.get(n), i};
            }
            map.put(num[i], i);
        }
        return null;
    }


    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ints = intSum2(nums, target);

        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
