package test.controller;

import java.util.*;

/**
 * @author Administrator
 * @version 1.0
 * @date 2021/1/26 15:42
 */
public class test {

    public static Stack<Integer> stack = new Stack<>();

    public static void perm(int[] arr, int p, int q){
        if(p == q){
            System.out.println(stack);
        }
        for(int j : arr){
            if(!stack.contains(j)){
                stack.add(j);
                perm(arr,p+1,q);
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        perm(arr,0,3);
    }
}
