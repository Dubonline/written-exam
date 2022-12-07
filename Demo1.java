package com.example.writtenexam;

/**
 * @projectName: written-exam
 * @package: com.example.writtenexam
 * @className: demo1
 * @author: 杜博
 * @description: TODO
 * @date: 2022/12/7 10:03
 * @version: 1.0
 */
//编写一个递归版本的 reverse(s) 函数(或方法),以将字符串s倒置。
public class Demo1 {
    public static void main(String[] args) {
        String src = "HelloWorld";
        System.out.println(reverse(src));
    }
    
    public static String reverse(String src){
        return reverseTest(src,src.length()-1,"");
    }
    
    /*
    * str : 字符串
    * index: 字符串下标
    * temp: 空串
    * 从后往前
    * */
    public static String reverseTest(String src,int index,String temp){
        // 字符串取完结束直接返回
        if(index==-1){
            return temp;
        }
        // 取出对应位置字符
        temp += src.charAt(index);
        // 向前递归
        return reverseTest(src,--index,temp);
    }
}