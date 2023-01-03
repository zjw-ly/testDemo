package com.example.demo.generate.demo;

import com.example.demo.generate.annotate.GenerateMethodName;
import com.example.demo.generate.assembler.GenerateToolAssembler;

/**
 * 代码生成自定义格式数据
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
public class GenerateMarkDownDemo {

    @GenerateMethodName(title = "商品展示")
    public String getItemMarkDown(String test){
        GenerateItemDO generateItemDO = new GenerateItemDO();

        generateItemDO.setItemName("测试品1");
        generateItemDO.setDataPrice("120");
        generateItemDO.setItemStock("10000");

        return GenerateToolAssembler.objectToString(generateItemDO,this.getClass(),test.getClass());
    }

    public static void main(String[] args) {
        GenerateMarkDownDemo generateMarkDownDemo  = new GenerateMarkDownDemo();

        System.out.println(generateMarkDownDemo.getItemMarkDown("test"));
    }
}
