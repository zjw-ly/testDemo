package com.example.demo.aviator;

import com.googlecode.aviator.AviatorEvaluator;

import java.util.HashMap;
import java.util.Map;

/**
 * 规则引擎表达式
 *
 * @author zaochun.zjw
 * @date 2023/2/6
 */
public class AviatorDemo {

    /**
     * 算数表达式
     */
    public void test1(){
        Long sum = (Long) AviatorEvaluator.execute("1+2+3");
        System.out.println(sum);
    }

    /**
     * 逻辑表达式
     */
    public void test2(){
        Boolean result = (Boolean) AviatorEvaluator.execute("3>1 && 2!=4 ||true");
        System.out.println(result);
    }

    /**
     * 往表达式传入值
     */
    public void test3() {
        Map<String, Object> env = new HashMap<>();
        env.put("name", "ruilin.shao");
        String str = "'hello ' + name";
        String result = (String) AviatorEvaluator.execute(str, env);
        System.out.println(result);
        //写法二
        String result2 = (String)AviatorEvaluator.exec(str, "便利蜂");
        System.out.println(result2);
    }
    /**
     * 三元表达式
     */
    public void test4() {
        String result = (String)AviatorEvaluator.execute("3 > 0 ? yes : no");
        System.out.println(result);
    }
    /**
     * 函数调用
     */
    public void test5() {
        System.out.println("string.length('hello') = " + AviatorEvaluator.execute("string.length('hello')"));//求字符串长度,不能用String.length();
        System.out.println("string.contains('hello', 'h') = " + AviatorEvaluator.execute("string.contains('hello', 'h')"));//判断字符串中是否包含某个字符串
        System.out.println("math.pow(-3, 2) = " + AviatorEvaluator.execute("math.pow(-3, 2)"));
        System.out.println("math.sqrt(9.0) = " + AviatorEvaluator.execute("math.sqrt(9.0)"));
    }
}
