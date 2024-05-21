package com.chehejia.aviator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @description: 手机端参数返回
 * @author: zhangwenbin1
 * @create: 2023-06-19 16:15
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MobParam<T> {

    private String key;

    private T value;

}
