package com.chehejia.aviator;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @description:
 * @author: zhangwenbin1
 * @create: 2024-02-05 17:23
 **/
@Getter
@Setter
public class MetaParam {

    /**
     * 参数名称
     */
    private String key;

    /**
     * 标签
     */
    private String label;

    /**
     * 数据类型:支持String/Integer/Float/List
     */
    private String dataType;

    /**
     * 选择器类型
     */
    private String selectorType;

    /**
     * 默认值
     */
    private Object defaultValue;

    /**
     * 参数枚举值
     */
    private List<MetaValueDetail> valueDetail;
}
