package com.chehejia.aviator;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorRuntimeJavaElementType;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2024/2/5 10:00 PM
 **/
public class JavaStaticFunctionTest {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        AviatorEvaluator.getInstance().addModule(SotaVersionUtils.class);
        // 定义参数
        Map<String, Object> params = new HashMap<>();
        params.put("sinceSotaVersion", "2.0.0");
        params.put("vehSotaVersion", "2.0.0");

        // 调用 SotaVersionUtils.compareTo 方法
        String expression = "let sotaVersionUtils = require('sotaVersionUtils'); sotaVersionUtils.compareTo(sinceSotaVersion, vehSotaVersion)";
        // 执行表达式，并传递参数 map
        Object result = AviatorEvaluator.execute(expression, params);

        // 输出结果
        System.out.println("Result: " + result);
    }
}
