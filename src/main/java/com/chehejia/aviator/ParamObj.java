package com.chehejia.aviator;

import lombok.*;

/**
 * @description:
 * @author: zhangwenbin1
 * @create: 2024-03-05 09:24
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ParamObj {

    /**
     * 参数key
     */
    private String key;

    /**
     * 参数值
     */
    private Object value;
}
