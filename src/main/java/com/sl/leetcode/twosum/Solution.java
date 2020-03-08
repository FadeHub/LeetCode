package com.sl.leetcode.twosum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LeetCode num1
 * 给定一个整型数组，要求返回两个数的下标，使得两数之和等于给定的目标值，要求同一个下标不能使用两次。
 * 数据保证有且仅有一组解。
 *
 * 样例：
 * 
 * 给定数组 nums = [2, 7, 11, 15]，以及目标值 target = 9，
 *
 * 由于 nums[0] + nums[1] = 2 + 7 = 9,
 * 所以 return [0, 1].
 *
 * @author shuliangzhao
 * @Title: Solution
 * @ProjectName LeetCode
 * @Description: TODO
 * @date 2020/3/8 16:39
 */
public class Solution {

    //暴力方法
    public static int[] twosum(int[] nums,int target) {
        for (int i = 0;i<nums.length;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {j,i};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    //哈希表
    public static int[] twosumMap(int[] nums,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        int[] nums = { 7,2,4, 11,2, 15};
        int[] twosum = twosumMap(nums, 4);
        System.out.println(Arrays.toString(twosum));
    }
}
