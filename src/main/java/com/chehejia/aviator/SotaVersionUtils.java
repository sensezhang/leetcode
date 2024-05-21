package com.chehejia.aviator;

import com.googlecode.aviator.annotation.Import;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * @description:
 * @author: zhangwenbin1
 * @create: 2023-10-26 09:41
 **/
@Import(ns = "sotaVersionUtils")
public final class SotaVersionUtils {

    private SotaVersionUtils() {
    }

    /**
     * 车端sota版本长度为3
     */
    private static final int LENGTH = 3;

    private static final long BIG_VERSION_CODE = 10000000L;

    private static final long MID_VERSION_CODE = 10000L;

    private static final int MAX_ITEM = 1000;



    /**
     * 检查sota版本是否合法
     * @param sotaVersion sota版本
     * @return 合法：true；不合法：false
     */
    public static boolean checkSotaVersion(String sotaVersion) {
        if (StringUtils.isEmpty(sotaVersion)) {
            return false;
        }
        String[] sotaVersionArr = sotaVersion.split("\\.");
        if (sotaVersionArr.length != LENGTH) {
            return false;
        }
        for (String item : sotaVersionArr) {
            if (Integer.parseInt(item) >= MAX_ITEM) {
                return false;
            }
        }
        return true;
    }

    /**
     * 将sota版本转换成整数
     * 定义每个版本数字不超过三位。第一位大版本，第二位中版本，第三位小版本
     * 版本号转换规则 大版本*10000000+中版本*10000+小版本
     * 例如123.456.789转换之后是1234560789
     *
     * @param sotaVersion sota版本
     * @return sota版本对应的整数
     */
    public static long convert(String sotaVersion) {

        String[] sotaVersionArr = sotaVersion.split("\\.");
        if (sotaVersionArr.length != LENGTH) {
            System.out.println("error");
        }
        return Integer.parseInt(sotaVersionArr[0]) * BIG_VERSION_CODE +
                Integer.parseInt(sotaVersionArr[1]) * MID_VERSION_CODE +
                Integer.parseInt(sotaVersionArr[2]);
    }

    /**
     * 比较两个sotaVersion，如果sotaVersion1大于sotaVersion2，返回1，相等返回0，小于放回-1
     *
     * @param sotaVersion1 第一个sota版本
     * @param sotaVersion2 第二个sota版本
     * @return -1/0/1
     */
    public static int compareTo(String sotaVersion1, String sotaVersion2) {
        long version1 = convert(sotaVersion1);
        long version2 = convert(sotaVersion2);
        return Long.compare(version1, version2);
    }

}
