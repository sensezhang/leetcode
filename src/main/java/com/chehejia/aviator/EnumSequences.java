package com.chehejia.aviator;

import cn.hutool.core.bean.BeanUtil;
import com.googlecode.aviator.runtime.type.Collector;
import com.googlecode.aviator.runtime.type.Sequence;
import com.googlecode.aviator.runtime.type.seq.ListCollector;

import java.util.*;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2024/2/5 10:14 PM
 **/
public class EnumSequences implements Sequence<Map<String, Object>> {

    private final List<MetaValueDetail> valueEnums;
    public EnumSequences(List<MetaValueDetail> valueEnums) {
        this.valueEnums = valueEnums;
    }

    @Override
    public Collector newCollector(int i) {
        return new ListCollector(false);
    }

    @Override
    public int hintSize() {
        return valueEnums.size();
    }

    @Override
    public Iterator<Map<String, Object>> iterator() {
        return new Iterator<Map<String, Object>>() {
            Iterator<MetaValueDetail> iterator = valueEnums.iterator();
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public Map<String, Object> next() {
                MetaValueDetail valueEnum = iterator.next();
                return BeanUtil.beanToMap(valueEnum);
            }
        };
    }
}
