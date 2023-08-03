package com.programmers.Lv1;

import java.util.HashSet;

public class Ponkemon {
    public int solution(int[] nums) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            set.add(num);
        }

        if(set.size() > nums.length / 2) {
            return nums.length / 2;
        }

        return set.size();
    }

    public static void main(String[] args) {
        Ponkemon ponkemon = new Ponkemon();


        int[] nums1 = {3, 1, 2, 3};
        System.out.println(ponkemon.solution(nums1)); // Output: 2

        int[] nums2 = {3, 3, 3, 2, 2, 4};
        System.out.println(ponkemon.solution(nums2)); // Output: 3

        int[] nums3 = {3, 3, 3, 2, 2, 2};
        System.out.println(ponkemon.solution(nums3)); // Output: 2
    }
}
