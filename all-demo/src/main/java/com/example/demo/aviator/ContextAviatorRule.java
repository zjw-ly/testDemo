package com.example.demo.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 规则表达式核对
 *
 * @author zaochun.zjw
 * @date 2023/2/6
 */
public class ContextAviatorRule {

    /** 参数上下文 */
    private Map<String, Object> paramContext;

    /** 规则表达式 */
    private String ruleExp;


    /**
     * 规则上下文
     *
     * @param paramContext
     * @param ruleExp
     * @return
     */
    public static ContextAviatorRule build(Map<String, Object> paramContext, String ruleExp) {
        return new ContextAviatorRule(paramContext, ruleExp);
    }

    /**
     * 规则上下文
     *
     * @param paramContext
     * @param ruleExp
     */
    public ContextAviatorRule(Map<String, Object> paramContext, String ruleExp) {
        this.paramContext = paramContext;
        this.ruleExp = ruleExp;
    }


    /**
     * 规则校验
     *
     * @return
     */
    public Boolean executeBoolean() {

        if (StringUtils.isEmpty(ruleExp)) {
            return true;
        }

        // 预编译表达式
        String key = DigestUtils.md5Hex(ruleExp);
        Expression compile = AviatorEvaluator.getInstance().compile(key, ruleExp, true);
        return (Boolean) compile.execute(paramContext);
    }

    public static void main(String[] args) {
        Map<String, Object> ruleContext = new HashMap<>(8);
        ruleContext.put("appName", "alihealth-member-fund");
        ruleContext.put("operateUserId", 0);
        ruleContext.put("operateNick", "测试");
        ruleContext.put("handlerType", "invoke");
        ruleContext.put("fuse", true);

        // 满足规则 即为规则引擎校验
        String ruleExp = "operateUserId == 0 && operateNick == '测试' && fuse";

        Boolean executeRuleBoolean = ContextAviatorRule.build(ruleContext, ruleExp).executeBoolean();
        System.out.println("result = " + executeRuleBoolean);
    }
}
