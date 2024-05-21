package com.chehejia.aviator;

import cn.hutool.core.collection.ListUtil;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.AbstractVariadicFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.*;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2024/2/5 10:35 PM
 **/
public class SequencesTest {
    public static void main(String[] args) {
        List<MetaValueDetail> list = new ArrayList<>();
        Map<String, List<String>> configItem = new HashMap<>();
        configItem.put("seriesNo", Arrays.asList("X01", "X02"));
        MetaValueDetail valueEnum1 = new MetaValueDetail("before", "日出前", "2.0.0", configItem);
        MetaValueDetail valueEnum2 = new MetaValueDetail("after", "日出后", "", configItem);
        list.add(valueEnum1);
        list.add(valueEnum2);
        // 添加自定义函数
        AviatorEvaluator.addFunction(new NamesFunction());
        AviatorEvaluator.addFunction(new ParamDescFunction());
        AviatorEvaluator.addFunction(new MobParamBuildFunction());
        AviatorEvaluator.addFunction(new RangeListIntegerFunction());
        AviatorEvaluator.addFunction(new MapFunction());
        AviatorEvaluator.addFunction(new ListFunction());
        AviatorEvaluator.addFunction(new ListMergeFunction());
        AviatorEvaluator.addFunction(new RangeListFloatFunction());
        AviatorEvaluator.addFunction(new AddParamFunction());
        Expression exp = AviatorEvaluator.getInstance().compile("let a = into(seq.list(), valueEnums); return getNames(a);");
        Object obj = exp.execute(exp.newEnv("valueEnums", new EnumSequences(list)));
        System.out.println(obj);
        // 自定义的参数描述
        String expression = "seq.list(hour + ':' + minute)";
        exp = AviatorEvaluator.getInstance().compile(expression);
        obj = exp.execute(exp.newEnv("hour", "10","minute", "03"));
        System.out.println(obj);
        // 通用的参数描述,op指定获取字段
//        expression = "seq.list(getNameByValue(op, opValue),getNameByValue(duration, durationValue) + '分钟')";
//        exp = AviatorEvaluator.getInstance().compile(expression);
//        Map<Object, Object> opValueMap = new HashMap<>();
//        opValueMap.put("before", "日出前");
//        opValueMap.put("after", "日出后");
//        Map<Object, Object> durationValueMap = new HashMap<>();
//        durationValueMap.put(3, 3);
//        durationValueMap.put(4, 4);
//        obj = exp.execute(exp.newEnv("op", "before","duration", 3));
//        System.out.println(obj);
        // valueEnum
        expression = "seq.list(seq.map(\"value\", \"before\", \"name\", \"日出前\", \"sinceSotaVersion\", \"2.0.0\", \"configItem\", seq.map(\"seriesNo\", seq.list(\"X01\",\"X02\"))),seq.map(\"value\", \"before\", \"name\", \"日出后\", \"sinceSotaVersion\", \"2.0.0\", \"configItem\", seq.map(\"seriesNo\", seq.list(\"X01\",\"X02\"))))";
        exp = AviatorEvaluator.getInstance().compile(expression);
        obj = exp.execute();
        System.out.println(obj);
        // 带逻辑判断的paramDesc
        expression = "if rangeType == 'custom' {if ((hourStart > hourEnd) || (hourStart == hourEnd && minuteStart >= minuteEnd)) {return seq.list(hourStart + \":\" + minuteStart + \"-次日\" + hourEnd + \":\" + minuteEnd);} else {return seq.list(hourStart + \":\" + minuteStart + \"-\" + hourEnd + \":\" + minuteEnd);}} else {return seq.list(rangeType);}";
        exp = AviatorEvaluator.getInstance().compile(expression);
        obj = exp.execute(exp.newEnv("rangeType", "custom", "hourStart", "06", "hourEnd", "12", "minuteStart", "08", "minuteEnd", "20"));
        System.out.println(obj);
        obj = exp.execute(exp.newEnv("rangeType", "custom", "hourStart", "14", "hourEnd", "12", "minuteStart", "08", "minuteEnd", "20"));
        System.out.println(obj);
        obj = exp.execute(exp.newEnv("rangeType", "custom", "hourStart", "14", "hourEnd", "14", "minuteStart", "20", "minuteEnd", "20"));
        System.out.println(obj);
        obj = exp.execute(exp.newEnv("rangeType", "custom1", "hourStart", "14", "hourEnd", "14", "minuteStart", "20", "minuteEnd", "20"));
        System.out.println(obj);
        // 范围函数
        expression = "let list = seq.list(); for i in range(5, 105, 5) {if i == 100 {i = 99;} seq.add(list, i);} return list;";
        exp = AviatorEvaluator.getInstance().compile(expression);
        expression = "fn getRange5To100() {let list = seq.list(); for i in range(5, 105, 5) {if i == 100 {i = 99;} seq.add(list, i);} return list;}";
        exp = AviatorEvaluator.getInstance().compile(expression);
        expression = "fn getRange5To100() {let list = seq.list(); for i in range(5, 105, 5) {if i == 100 {i = 99;} seq.add(list, i);} return list;} return getRange5To100();";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        //
        expression = "if is_empty(param.positionList) {\n" +
                "  return getParamDesc('position', param.position);\n" +
                "} else {\n" +
                "  return getParamDesc('positionList', param.positionList);\n" +
                "}";
        exp = AviatorEvaluator.getInstance().compile(expression);
        Map<String, Object> param = new HashMap<>();
        param.put("position", "driver");
        param.put("positionList", ListUtil.of("driver", "copilot", "second_right"));
        List<MetaParam> metaParams = new ArrayList<>();
        MetaParam metaParam1 = new MetaParam();
        metaParam1.setKey("position");
        metaParam1.setDataType("String");
        metaParam1.setSelectorType("singleChoiceList");
        List<MetaValueDetail> valueDetails = new ArrayList<>();
        MetaValueDetail metaValueDetail1 = new MetaValueDetail();
        metaValueDetail1.setValue("driver");
        metaValueDetail1.setName("主驾上车");
        valueDetails.add(metaValueDetail1);
        MetaValueDetail metaValueDetail2 = new MetaValueDetail();
        metaValueDetail2.setValue("copilot");
        metaValueDetail2.setName("副驾上车");
        valueDetails.add(metaValueDetail2);
        MetaValueDetail metaValueDetail3 = new MetaValueDetail();
        metaValueDetail3.setValue("second_left");
        metaValueDetail3.setName("二排左上车");
        valueDetails.add(metaValueDetail3);
        MetaValueDetail metaValueDetail4 = new MetaValueDetail();
        metaValueDetail4.setValue("second_right");
        metaValueDetail4.setName("二排右上车");
        valueDetails.add(metaValueDetail4);
        metaParam1.setValueDetail(valueDetails);
        metaParams.add(metaParam1);
        MetaParam metaParam2 = new MetaParam();
        metaParam2.setKey("positionList");
        metaParam2.setDataType("List");
        metaParam2.setSelectorType("singleChoiceList");
        metaParam2.setValueDetail(valueDetails);
        metaParams.add(metaParam2);
        System.out.println(exp.execute(exp.newEnv("metaParam", metaParams, "param", param)));
        expression = "getParamDesc('position', param.position, 'positionList', param.positionList)";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute(exp.newEnv("metaParam", metaParams, "param", param)));
        expression = "return seq.list((param.minute == nil ? \"00\" : param.minute) + \"分钟\" + (param.second == nil ? \"00\" : param.second) + \"秒\");";
        exp = AviatorEvaluator.getInstance().compile(expression);
        param.put("minute", "10");
//        param.put("second", "5");
        System.out.println(exp.execute(exp.newEnv("param", param)));

        expression = "true";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute(exp.newEnv("param", param)));
        expression = "if param.position == nil && !is_empty(param.positionList) {\n" +
                "  return buildMobParam(\"position\", param.positionList[0]);\n" +
                "}";
        exp = AviatorEvaluator.getInstance().compile(expression);
        List<MobParam> mobParams = (List<MobParam>) exp.execute(exp.newEnv("param", param));
        if (!CollectionUtils.isEmpty(mobParams)) {
            for (MobParam mobParam : mobParams) {
                System.out.println(mobParam.getKey() + ":" + mobParam.getValue());
            }
        }
        expression = "rangeListInteger(1, 10, 1, lambda(x) -> x + \"挡\" end)";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        expression = "toList(toMap(\"key\", \"gear\", \n" +
                "            \"dataType\", \"String\", \n" +
                "            \"selectorType\", \"singleChoiceList\", \n" +
                "            \"values\", toList(toMap(\"value\", \"p\", \"name\", \"P挡\"),\n" +
                "                             toMap(\"value\", \"d\", \"name\", \"D挡\"),\n" +
                "                             toMap(\"value\", \"r\", \"name\", \"R挡\"),\n" +
                "                             toMap(\"value\", \"n\", \"name\", \"N挡\", \"sinceSotaVersion\", \"2.0.0\"))))";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        expression = "toList(toMap(\"key\", \"brightness\",\n" +
                "             \"dataType\", \"Integer\",\n" +
                "             \"values\", rangeListInteger(0, 100, 1, lambda(x) -> x + \"%\" end)),\n" +
                "       toMap(\"key\", \"color\",\n" +
                "                    \"dataType\", \"Integer\",\n" +
                "                    \"values\", toList(toMap(\"value\", 0, \"name\", \"白色\"),\n" +
                "                                     toMap(\"value\", 1, \"name\", \"黄色\"),\n" +
                "                                     toMap(\"value\", 2, \"name\", \"红色\"),\n" +
                "                                     toMap(\"value\", 3, \"name\", \"紫色\"),\n" +
                "                                     toMap(\"value\", 4, \"name\", \"绿色\"),\n" +
                "                                     toMap(\"value\", 5, \"name\", \"青色\"),\n" +
                "                                     toMap(\"value\", 6, \"name\", \"蓝色\"),\n" +
                "                                     toMap(\"value\", 7, \"name\", \"橙色\")\n" +
                "                                     )\n" +
                "              ),\n" +
                "       toMap(\"key\", \"mode\",\n" +
                "                    \"dataType\", \"Integer\",\n" +
                "                    \"values\", toList(toMap(\"value\", 0, \"name\", \"固定模式\"),\n" +
                "                                     toMap(\"value\", 1, \"name\", \"呼吸模式\")\n" +
                "                                     )\n" +
                "             )\n" +
                ")";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        expression = "mergeList(rangeListInteger(5, 50, 5, lambda(x) -> x + \"km\" end), rangeListInteger(60, 200, 10, lambda(x) -> x + \"km\" end))";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        expression = "toList(toMap(\"key\",\"brightness\",\"dataType\",\"Float\",\"selectorType\",\"singleColumnSelector\",\"defaultValue\", 0.5,\"values\", rangeListFloat(0.0, 1.0, 0.01, lambda(x) -> long(x * 100) + \"%\" end)))";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        expression = "\"AirF\"";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute());
        expression = "if (isAllParam){return toList(toMap(\"key\",\"position\",\"dataType\",\"String\",\"selectorType\",\"singleChoiceList\",\"values\",toList(toMap(\"value\",\"driver\",\"name\",\"主驾上车\"),toMap(\"value\",\"copilot\",\"name\",\"副驾上车\"),toMap(\"value\",\"second_left\",\"name\",\"二排左上车\"),toMap(\"value\",\"second_right\",\"name\",\"二排右上车\"))),toMap(\"key\",\"positionList\",\"dataType\",\"List\",\"selectorType\",\"multiChoiceList\",\"values\",toList(toMap(\"value\",\"driver\",\"name\",\"主驾上车\"),toMap(\"value\",\"copilot\",\"name\",\"副驾上车\"),toMap(\"value\",\"second_left\",\"name\",\"二排左上车\"),toMap(\"value\",\"second_right\",\"name\",\"二排右上车\"))));}else{return toList(sotaVersionCompare(requestContext.sotaVersion,\"3.0.0\")>0?toMap(\"key\",\"positionList\",\"dataType\",\"List\",\"selectorType\",\"multiChoiceList\",\"values\",toList(toMap(\"value\",\"driver\",\"name\",\"主驾上车\"),toMap(\"value\",\"copilot\",\"name\",\"副驾上车\"),toMap(\"value\",\"second_left\",\"name\",\"二排左上车\"),toMap(\"value\",\"second_right\",\"name\",\"二排右上车\"))):toMap(\"key\",\"position\",\"dataType\",\"String\",\"selectorType\",\"singleChoiceList\",\"values\",toList(toMap(\"value\",\"driver\",\"name\",\"主驾上车\"),toMap(\"value\",\"copilot\",\"name\",\"副驾上车\"),toMap(\"value\",\"second_left\",\"name\",\"二排左上车\"),toMap(\"value\",\"second_right\",\"name\",\"二排右上车\"))));}";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute(AviatorEvaluator.newEnv("isAllParam", true)));
        expression = "if(param.locationType == \"home\"){return toList(\"家\");}elsif(param.locationType == \"company\"){return toList(\"公司\");}else{return toList(param.name);}";
        Map<String, String> map = new HashMap();
        map.put("locationType", "");
        map.put("name", "破地方");
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute(AviatorEvaluator.newEnv("param", map)));
        expression = "toList(toMap(\"key\",\"op\",\"dataType\",\"String\",\"selectorType\",\"singleChoiceList\",\"label\",\"PARAM_LABEL_SUNRISE\",\"defaultValue\",\"before\",\"values\",toList(toMap(\"value\",\"before\", \"name\",\"PARAM_BEFORE_SUNRISE\"),toMap(\"value\",\"after\", \"name\",\"PARAM_AFTER_SUNRISE\"))),toMap(\"key\",\"duration\",\"dataType\",\"Integer\",\"selectorType\",\"singleColumnSelector\",\"label\",\"PARAM_LABEL_TIME\",\"defaultValue\",0,\"values\", rangeListInteger(0, 59, 1, lambda(x) -> \"PARAM_MINUTE\" end)))";
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute(AviatorEvaluator.newEnv("param", map)));
        expression = "if param.appName==\"地图\"{return addParam(\"packageName\",\"com.liauto.onemap\");}if param.appName==\"充电管理\"{return addParam(\"packageName\",\"com.chehejia.car.chargemanagement\");}if param.appName==\"供电管理\"{return addParam(\"packageName\",\"com.lixiang.car.discharger\");}if param.appName==\"车辆中心\"{return addParam(\"packageName\",\"com.lixiang.car.carcenter\");}if param.appName==\"应用中心\"{return addParam(\"packageName\",\"com.lixiang.appstore\");}if param.appName==\"电子后视镜\"{return addParam(\"packageName\",\"com.lixiang.car.x.svm\");}if param.appName==\"全景影像\"{return addParam(\"packageName\",\"com.lixiang.car.x.svm\");}if param.appName==\"行车记录仪\"{return addParam(\"packageName\",\"com.lixiang.car.dvr\");}if param.appName==\"蓝牙电话\"{return addParam(\"packageName\",\"com.chehejia.car.btphone\");}if param.appName==\"蓝牙音乐\"{return addParam(\"packageName\",\"com.lixiang.car.bluetoothmusic\");}if param.appName==\"本地音乐\"{return addParam(\"packageName\",\"com.lixiang.car.localmusic\");}if param.appName==\"设置\"{return addParam(\"packageName\",\"com.chehejia.car.carsettings\");}if param.appName==\"QQ音乐\"{return addParam(\"packageName\",\"com.lixiang.car.qqmusic\");}if param.appName==\"喜马拉雅\"{return addParam(\"packageName\",\"com.ximalaya.ting.android.car.x01\");}if param.appName==\"网易云音乐\"{return addParam(\"packageName\",\"com.lixiang.neteasemusic\");}if param.appName==\"爱奇艺\"{return addParam(\"packageName\",\"com.lixiang.car.x.video\");}if param.appName==\"腾讯视频\"{return addParam(\"packageName\",\"com.lixiang.car.x.tencentvideo\");}if param.appName==\"咪咕视频\"{return addParam(\"packageName\",\"cn.cmvideo.car.play\");}if param.appName==\"哔哩哔哩\"{return addParam(\"packageName\",\"com.bilibili.bilithings\");}if param.appName==\"全民K歌\"{return addParam(\"packageName\",\"com.lixiang.car.kg\");}if param.appName==\"投屏\"{return addParam(\"packageName\",\"com.lixiang.sharescreen\");}if param.appName==\"帮助中心\"{return addParam(\"packageName\",\"com.lixiang.car.helpcenter\");}if param.appName==\"天气\"{return addParam(\"packageName\",\"com.lixiang.car.weather\");}if param.appName==\"FM\"{return addParam(\"packageName\",\"com.lixiang.fmradio\");}if param.appName==\"雷石KTV\"{return addParam(\"packageName\",\"com.thunder.carplay\");}\n";
        map.put("appName", "地图");
        exp = AviatorEvaluator.getInstance().compile(expression);
        System.out.println(exp.execute(AviatorEvaluator.newEnv("param", map)));
    }

    static class NamesFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env,
                                  AviatorObject arg1) {
            List<String> names = new ArrayList<>();
            // 获取 Sequence 参数
            EnumSequences enumSequences = (EnumSequences) env.get("valueEnums");
            enumSequences.forEach(r -> {
                names.add((String) r.get("name"));
            });
            // 返回结果
            return new AviatorRuntimeJavaType(names);
        }
        @Override
        public String getName() {
            return "getNames";
        }
    }

    static class ParamDescFunction extends AbstractVariadicFunction {
        @Override
        public AviatorObject variadicCall(Map<String, Object> env,
                                  AviatorObject... args) {
            // 如果参数长度小于2，或参数长度为奇数，提示错误
            // 遍历参数
            List<String> paramDesc = new ArrayList<>(args.length / 2);
            // 获取参数元数据
            List<MetaParam> metaParams = (List<MetaParam>) env.get("metaParam");
            Map<String, MetaParam> metaParamMap = metaParams.stream().collect(Collectors.toMap(MetaParam :: getKey, r-> r));

            for (int i = 0; i < args.length; i+=2) {
                String key = FunctionUtils.getStringValue(args[i], env);
                Object value = FunctionUtils.getJavaObject(args[i + 1], env);
                MetaParam metaParam = metaParamMap.get(key);
                List<MetaValueDetail> metaValueDetails = metaParam.getValueDetail();
                Map<Object, MetaValueDetail> metaValueDetailMap = metaValueDetails.stream().collect(Collectors.toMap(MetaValueDetail::getValue, r -> r));
                // 如果数据类型是集合
                if (Objects.equals(metaParam.getDataType(), "List")) {
                    List lists = (List) value;
                    for (Object obj : lists) {
                        paramDesc.add(metaValueDetailMap.get(obj).getName());
                    }
                } else {
                    paramDesc.add(metaValueDetailMap.get(value).getName());
                }
            }
            return AviatorRuntimeJavaType.valueOf(paramDesc);
        }

        @Override
        public String getName() {
            return "getParamDesc";
        }
    }

    static class SotaVersionCompareFunction extends AbstractFunction {

        @Override
        public AviatorObject call(Map<String, Object> env,
                                  AviatorObject arg1, AviatorObject arg2) {
            String sotaVersion1 = FunctionUtils.getStringValue(arg1, env);
            String sotaVersion2 = FunctionUtils.getStringValue(arg2, env);
            return AviatorNumber.valueOf(SotaVersionUtils.compareTo(sotaVersion1, sotaVersion2));
        }
        @Override
        public String getName() {
            return "sotaVersionCompare";
        }
    }

    static class MobParamBuildFunction extends AbstractVariadicFunction {
        @Override
        public AviatorObject variadicCall(Map<String, Object> env,
                                          AviatorObject... args) {
            // 如果参数长度小于2，或参数长度为奇数，提示错误
            // 遍历参数
            List<MobParam> mobParams = new ArrayList<>(args.length / 2);
            // 获取参数元数据
            for (int i = 0; i < args.length; i += 2) {
                String key = FunctionUtils.getStringValue(args[i], env);
                Object value = FunctionUtils.getJavaObject(args[i + 1], env);
                MobParam mobParam = new MobParam();
                mobParam.setKey(key);
                mobParam.setValue(value);
                mobParams.add(mobParam);
            }
            return AviatorRuntimeJavaType.valueOf(mobParams);
        }

        @Override
        public String getName() {
            return "buildMobParam";
        }
    }

    static class RangeListIntegerFunction extends AbstractFunction {

        @Override
        public AviatorObject call(Map<String, Object> env,
                                  AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
            List<Map<String, Object>> result = new ArrayList<>();
            Number start = FunctionUtils.getNumberValue(arg1, env);
            Number end = FunctionUtils.getNumberValue(arg2, env);
            Number step = FunctionUtils.getNumberValue(arg3, env);
            AviatorFunction nameFunction = FunctionUtils.getFunction(arg4, env, 1);
            int startValue = start.intValue();
            int stepValue = step.intValue();
            while (startValue <= end.intValue()) {
                Map<String, Object> map = new HashMap<>();
                map.put("value", startValue);
                map.put("name", nameFunction.call(env, AviatorRuntimeJavaType.valueOf(startValue)).getValue(env));
                result.add(map);
                startValue += stepValue;
            }
            return AviatorRuntimeJavaType.valueOf(result);
        }
        @Override
        public String getName() {
            return "rangeListInteger";
        }
    }
    static class RangeListFloatFunction extends AbstractFunction {

        @Override
        public AviatorObject call(Map<String, Object> env,
                                  AviatorObject arg1, AviatorObject arg2, AviatorObject arg3, AviatorObject arg4) {
            List<Map<String, Object>> result = new ArrayList<>();
            Number start = FunctionUtils.getNumberValue(arg1, env);
            Number end = FunctionUtils.getNumberValue(arg2, env);
            Number step = FunctionUtils.getNumberValue(arg3, env);
            AviatorFunction nameFunction = FunctionUtils.getFunction(arg4, env, 1);
            BigDecimal startValue = new BigDecimal(String.valueOf(start));
            BigDecimal stepValue = new BigDecimal(String.valueOf(step));
            while (startValue.compareTo(new BigDecimal(String.valueOf(end))) < 0) {
                Map<String, Object> map = new HashMap<>();
                map.put("value", startValue);
                map.put("name", nameFunction.call(env, AviatorNumber.valueOf(startValue)).getValue(env));
                result.add(map);
                startValue = startValue.add(stepValue);
            }
            // 把end包含进去,当startValue被加完之后等于endValue时，
            // 上面startValue < end.intValue()改为小于等于也可以实现，
            // 但是某些结尾的值可能小于end，就加不进去了，这里认为所有的end都会被加进去
            Map<String, Object> map = new HashMap<>();
            map.put("value", end.floatValue());
            map.put("name", nameFunction.call(env, AviatorNumber.valueOf(end.floatValue())).getValue(env));
            result.add(map);
            return AviatorRuntimeJavaType.valueOf(result);
        }
        @Override
        public String getName() {
            return "rangeListFloat";
        }
    }

    static class MapFunction extends AbstractVariadicFunction {

        @Override
        public AviatorObject variadicCall(Map<String, Object> map, AviatorObject... aviatorObjects) {
            // 如果参数长度小于2，或参数长度为奇数，提示错误
            if (aviatorObjects.length % 2 != 0) {
                throw new RuntimeException("参数个数必须为偶数");
            }
            Map<String, Object> result = new HashMap<>(aviatorObjects.length / 2);
            for (int i = 0; i < aviatorObjects.length; i += 2) {
                String key = FunctionUtils.getStringValue(aviatorObjects[i], map);
                AviatorType aviatorTypes = aviatorObjects[i + 1].getAviatorType();
                Object value = null;
                if (aviatorTypes == AviatorType.String) {
                    value = FunctionUtils.getStringValue(aviatorObjects[i + 1], map);
                } else if (aviatorTypes == AviatorType.Double || aviatorTypes == AviatorType.BigInt || aviatorTypes == AviatorType.Long) {
                    value = FunctionUtils.getNumberValue(aviatorObjects[i + 1], map);
                } else if (aviatorTypes == AviatorType.Boolean) {
                    value = FunctionUtils.getBooleanValue(aviatorObjects[i + 1], map);
                } else if (aviatorTypes == AviatorType.JavaType) {
                    value = FunctionUtils.getJavaObject(aviatorObjects[i + 1], map);
                }
                result.put(key, value);
            }
            return AviatorRuntimeJavaType.valueOf(result);
        }

        @Override
        public String getName() {
            return "toMap";
        }
    }
    static class ListFunction extends AbstractVariadicFunction {

        @Override
        public AviatorObject variadicCall(Map<String, Object> map, AviatorObject... aviatorObjects) {
            List<Object> result = new ArrayList<>(aviatorObjects.length);
            for (AviatorObject aviatorObject : aviatorObjects) {
                AviatorType aviatorTypes = aviatorObject.getAviatorType();
                if (aviatorTypes == AviatorType.String) {
                    result.add(FunctionUtils.getStringValue(aviatorObject, map));
                } else if (aviatorTypes == AviatorType.Double || aviatorTypes == AviatorType.BigInt || aviatorTypes == AviatorType.Long) {
                    result.add(FunctionUtils.getNumberValue(aviatorObject, map));
                } else if (aviatorTypes == AviatorType.Boolean) {
                    result.add(FunctionUtils.getBooleanValue(aviatorObject, map));
                } else if (aviatorTypes == AviatorType.JavaType) {
                    result.add(FunctionUtils.getJavaObject(aviatorObject, map));
                }
            }
            return AviatorRuntimeJavaType.valueOf(result);
        }

        @Override
        public String getName() {
            return "toList";
        }
    }

    // mergeList
    static class ListMergeFunction extends AbstractVariadicFunction {

        @Override
        public AviatorObject variadicCall(Map<String, Object> map, AviatorObject... aviatorObjects) {
            List<Object> result = new ArrayList<>();
            for (AviatorObject aviatorObject : aviatorObjects) {
                AviatorType aviatorTypes = aviatorObject.getAviatorType();
                Collection list = (Collection) FunctionUtils.getJavaObject(aviatorObject, map);
                result.addAll(list);
            }
            return AviatorRuntimeJavaType.valueOf(result);
        }

        @Override
        public String getName() {
            return "mergeList";
        }
    }
}
class AddParamFunction extends AbstractVariadicFunction {

    private static final String ADD_PARAM = "addParam";
    @Override
    public AviatorObject variadicCall(Map<String, Object> env,
                                      AviatorObject... args) {
        // 遍历参数
        List<ParamObj> paramObjs = new ArrayList<>(args.length / 2);
        // 获取参数元数据
        for (int i = 0; i + 2 <= args.length; i += 2) {
            String key = FunctionUtils.getStringValue(args[i], env);
            AviatorObject valueObj = args[i + 1];
            ParamObj paramObj = new ParamObj();
            paramObj.setKey(key);
            Object value = null;
            switch (valueObj.getAviatorType()) {
                case String:
                    value = FunctionUtils.getStringValue(valueObj, env);
                    break;
                case Boolean:
                    value = FunctionUtils.getBooleanValue(valueObj, env);
                    break;
                case Double:
                case BigInt:
                case Long:
                    value = FunctionUtils.getNumberValue(valueObj, env);
                    break;
                case JavaType:
                    value = FunctionUtils.getJavaObject(valueObj, env);
                    break;
                default:
                    value = valueObj;
            }
            paramObj.setValue(value);
            paramObjs.add(paramObj);
        }
        return AviatorRuntimeJavaType.valueOf(paramObjs);
    }

    @Override
    public String getName() {
        return ADD_PARAM;
    }
}
