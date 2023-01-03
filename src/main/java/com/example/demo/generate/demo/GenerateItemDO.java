package com.example.demo.generate.demo;

import com.example.demo.generate.annotate.GenerateClassName;
import com.example.demo.generate.annotate.GenerateFieldName;
import lombok.Data;

/**
 * 测试生成商品DO
 *
 * @author zaochun.zjw
 * @date 2023/1/3
 */
@Data
@GenerateClassName(name = "商品数据展示：")
public class GenerateItemDO {

    /** 商品名称 */
    @GenerateFieldName(name = "商品名称",isNullShow = true)
    private String itemName;

    /** 商品价格 */
    @GenerateFieldName(name = "商品价格",isNullShow = true)
    private String dataPrice;

    /** 商品库存 */
    @GenerateFieldName(name = "商品库存",isNullShow = false)
    private String itemStock;
}
