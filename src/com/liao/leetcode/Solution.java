package com.liao.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * </p>
 *
 * @author LiAo
 * @since 2021/2/26
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 15, 11, 7};
        int target = 9;

        System.out.println(Arrays.toString(twoSum(nums, target)));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] sun = new int[2];

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // 判断当前map是否存在key 是返回true
            // 说明当前下标的值和target - nums[i]的key相加等于target
            if (map.containsKey(target - nums[i])) {
                // 所以值的下标和maptarget - nums[i] 的value即为答案
                return new int[]{map.get(target - nums[i]), i};
            }

            // 把数组值作为key 下标作为value
            map.put(nums[i], i);
        }
        return sun;
    }
}
