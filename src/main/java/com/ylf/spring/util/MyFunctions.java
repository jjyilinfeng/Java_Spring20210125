package com.ylf.spring.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * @author Administrator
 * @version 1.0
 * @date 2021/1/27 14:40
 */
public class MyFunctions {


        public static final String DATE_STYLE = "yyyy-MM-dd HH:mm:ss";

        /**************************************
         函数名：Typeof()
         形参：Object a
         返回值：String
         描述：返回a变量的数值类型
         ***************************************/
        public static String typeof(Object a) {
            return a.getClass().toString();
        }


        /**************************************
         函数名：range()
         形参：int length
         返回值：int[]
         描述：返回一个0-length的数组
         ***************************************/
        public static int[] range(int length){
            int[] result=new int[length];
            for(int i = 0; i< length; i++){
                result[i]=i;
            }
            return result;
        }

        public static int[] range(int start, int end){
            int[] result=new int[end-start];
            for(int i = 0; i< end-start; i++){
                result[i]=i+start;
            }
            return result;
        }

        public static int[] range(int start, int end,int step){
            int sz =(end-start)/step;
            int[] result=new int[sz];
            for(int i=start;i<end;i++){
                result[i]=i*step + start;
            }
            return result;
        }

        public static void sort(int[] arr){
            Arrays.sort(arr);
        }

        /**************************************
         函数名：Format_Color
         形参：String format, String color
         返回值：String format
         描述：输入字符转换成带颜色的字符，format输入字符，color输入颜色
         ***************************************/
        public static String Format_Color(String format, String color){
            switch (color) {
                case "red":
                    return "\033[" + "91" + ";1m" + format + "\033[0m";
                case "green":
                    return "\033[" + "92" + ";1m" + format + "\033[0m";
                case "yellow":
                    return "\033[" + "93" + ";1m" + format + "\033[0m";
                case "blue":
                    return "\033[" + "94" + ";1m" + format + "\033[0m";
                case "pink":
                    return "\033[" + "95" + ";1m" + format + "\033[0m";
                case "lightblue":
                    return "\033[" + "96" + ";1m" + format + "\033[0m";
                case "black":
                    return "\033[" + "97" + ";1m" + format + "\033[0m";
                default:
                    break;
            }
            return format;
        }
        /**************************************
         函数名：Factorial()
         形参：int n
         返回值：int
         描述：返回n的阶乘
         ***************************************/
        public static int Factorial(int n){
            if (n == 1){
                return 1;
            }
            else {
                return Factorial(n-1) * n;
            }
        }



        /**************************************
         函数名：NumArray
         形参：int[] arr, int tag, int cur
         返回值：ArrayList<ArrayList<Integer>>
         描述：将arr的数组各个组合的情况返回，tag是数组长度，cur默认为0
         ***************************************/
        public static Stack<Object> stack = new Stack<>();
        public static ArrayList<ArrayList<Integer>> Number_Array_data = new ArrayList<>();
        public static ArrayList<ArrayList<Integer>> NumArray(int[] arr, int tag, int cur){
            NumArray_Fun(arr,tag,cur);
            return Number_Array_data;
        }

        public static ArrayList<ArrayList<Integer>> NumArray(int n){
            int[] arr = range(1,n+1);
            NumArray_Fun(arr,n,0);
            return Number_Array_data;
        }

        public static void NumArray_Fun(int[] arr, int tag, int cur){
            if(cur == tag){
                ArrayList<Integer> current = new ArrayList<>();
                for(int i:range(tag)){
                    current.add((int) stack.get(i));
                }
                Number_Array_data.add(current);
            }
            for (int j : arr) {
                if (!stack.contains(j)) {
                    stack.add(j);
                    System.out.println(j);
                    NumArray(arr, tag, cur + 1);
                    stack.pop();
                }
            }
        }

        /**************************************
         函数名：StringDate()
         形参：String str, String pattern
         返回值： String
         描述：输入str字符串和pattern时间的格式，返回字符串+自身的时间
         ***************************************/
        public static String StringDate(String str, String pattern){
            DateFormat dateFormat = new SimpleDateFormat(pattern);
            Date date = new Date();
            return str+dateFormat.format(date);
        }

        /**************************************
         函数名：GetFileSuffix()
         形参：String str
         返回值： String
         描述：返回str文件名字符串的后缀名（最后一个点以及后面的字符）
         ***************************************/
        public static String GetFileSuffix(String str){
            return str.substring(str.lastIndexOf('.'));
        }

        public static String GetFileDirs(String str){
            return str.substring(0,str.lastIndexOf("/")+1);
        }
        /**************************************
         函数名：RandomNumber
         形参：Integer n,Integer m
         返回值： Integer
         描述：返回一个n和m直接的一个随机数
         ***************************************/
        public static Integer RandomNumber(Integer n, Integer m){
            Random rand = new Random();
            return rand.nextInt(m-n+1)+n;
        }

}
