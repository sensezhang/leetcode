package com.chehejia.aviator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: zhangwenbin1
 * @create: 2024-02-05 17:31
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MetaValueDetail {

    private Object value;

    private String name;

    private String sinceSotaVersion;

    private Map<String, List<String>> configItem;
}
