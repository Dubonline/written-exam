package com.example.writtenexam;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Arrays;
/*
* 编写程序 expr，以计算从命令行输入的逆波兰表达式的值，其中每个运算符或操作数用一个单独的参数表示。
* 例如，命令 expr 2 3 4 + *
* */
public class Demo2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
//		String src = "2 3 4 + *";
//		String[] strs = src.split(" ");
        Stack<String> stack = new Stack<>();
        for (String str : args) {
            stack.push(str);
        }
        String x = caculate(stack);
        System.out.println(x);

    }

    /**
     * 计算后缀表达式的值
     * @param suffix 存有后缀表达式的栈
     * @return double
     */
    private static String caculate(Stack<String> suffix){
        //将栈转为集合方便遍历
        List<String> list = new LinkedList<>(suffix);
        Stack<String> stack = new Stack<>();
        for(String s:list){
            try {
                //转为数字，如果不出错，说明是数字
                Double.parseDouble(s);
                //入栈
                stack.push(s);
            } catch (Exception e) {
                //若出异常，说明是运算符
                String d1 = stack.pop();
                String d2 = stack.pop();
                stack.push(caculate(d2, d1, s));
            }
        }
        return stack.pop();
    }

    /**
     * 计算两个数的结果，这里使用BigDecimal做精确运算
     */
    private static String caculate(String d1,String d2,String c){
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        switch (c){
            case "+":
                return b1.add(b2).toString();
            case "-":
                return b1.subtract(b2).toString();
            case "*":
                return b1.multiply(b2).toString();
            case "/":
                //除法能会有无限小数，四舍五入保留4位小数
                return b1.divide(b2, 4, BigDecimal.ROUND_HALF_UP).toString();
        }
        return null;
    }

}
