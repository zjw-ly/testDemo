package com.example.demo.leetcode.types.stack.lc75.stack;

import java.util.*;

/**
 * 给定一个整数数组 asteroids，表示在同一行的小行星。
 * 对于数组中的每一个元素，其绝对值表示小行星的大小，正负表示小行星的移动方向（正表示向右移动，负表示向左移动）。每一颗小行星以相同的速度移动。
 * 找出碰撞后剩下的所有小行星。碰撞规则：两个小行星相互碰撞，较小的小行星会爆炸。如果两颗小行星大小相同，则两颗小行星都会爆炸。两颗移动方向相同的小行星，永远不会发生碰撞。
 * <p>
 * 示例 1：
 * 输入：asteroids = [5,10,-5]
 * 输出：[5,10]
 * 解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。
 * <p>
 * 示例 2：
 * 输入：asteroids = [8,-8]
 * 输出：[]
 * 解释：8 和 -8 碰撞后，两者都发生爆炸。
 * <p>
 * 示例 3：
 * 输入：asteroids = [10,2,-5]
 * 输出：[10]
 * 解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。
 *
 * //-2,-1,1,2
 *
 * @author zaochun.zjw
 * @date 2024/5/31
 */
public class Medium735小型星碰撞 {

    public static void main(String[] args) {
        Arrays.stream(asteroidCollision(new int[]{1,-2,-2,-2})).forEach(System.out::print);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> tmp = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if(tmp.isEmpty() || tmp.peek() < 0){
                tmp.push(asteroids[i]);
            }else{
                while (!tmp.isEmpty()) {
                    Integer peek = tmp.peek();
                    if ((peek < 0 && asteroids[i] < 0) || (peek > 0 && asteroids[i] > 0)) {
                        tmp.push(asteroids[i]);
                        break;
                    }else{
                        if(Math.abs(peek) > Math.abs(asteroids[i])){
                            break;
                        }else if(Math.abs(peek) == Math.abs(asteroids[i])){
                            tmp.pop();
                            break;
                        }else{
                            tmp.pop();
                            if(tmp.isEmpty()){
                                tmp.push(asteroids[i]);
                                break;
                            }
                            continue;
                        }
                    }
                }
            }
        }

        int[] resInt  = new int[tmp.size()];
        int i = 0;
        while (!tmp.isEmpty()){
            resInt[i] = tmp.pollLast();
            i++;
        }

        return resInt;
    }
}
