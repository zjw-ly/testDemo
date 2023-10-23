package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * 删除有序数组中的重复项
 * <p>
 * 给你一个 非严格递增排列 的数组 nums ，请你原地删除重复出现的元素，
 * 使每个元素只出现一次，返回删除后数组的新长度。元素的相对顺序应该保持一致。然后返回nums中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * 判题标准:
 * <p>
 * 系统会用下面的代码来测试你的题解:
 * <p>
 * int[] nums = [...]; // 输入数组
 * int[] expectedNums = [...]; // 长度正确的期望答案
 * <p>
 * int k = removeDuplicates(nums); // 调用
 * <p>
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * 如果所有断言都通过，那么您的题解将被 通过。
 *
 * @author zaochun.zjw
 * @date 2023/10/19
 */
public class Easy26删除有序数组中的重复项 {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0,0}));
    }

    public static int removeDuplicates(int[] nums) {
        int index = 1;

        for (int i = 0; i < nums.length;) {
            int pointer = i;
            while (pointer < nums.length -1 && nums[i] == nums[++pointer]) ;
            if(pointer == nums.length - 1 && nums[i] == nums[pointer]){
                break;
            }
            nums[index++] = nums[pointer];
            i = pointer;
        }

        Arrays.stream(nums).forEach(it -> System.out.print(it + ","));
        return index;
    }
}
