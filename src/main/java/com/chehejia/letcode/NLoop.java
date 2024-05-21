package com.chehejia.letcode;

/**
 * @Description
 * @Author zhangwenbin1
 * @Date 2022/1/26 8:48 AM
 **/
public class NLoop {

    public static void main(String[] args) {
        NLoop nLoop = new NLoop();
        int[] num = {2,2,2};
        nLoop.loop(num, "", 0);
    }
    public void loop(int[] num, String str, int index){
        int value = num[index];
        int tempIndex = index;
        for(int i=0; i<value; i++){
            String temp = str + i + ",";
            if(++index < num.length){
                loop(num, temp, index);
            }else{
                System.out.println(temp.substring(0, temp.length() - 1));
            }
            index = tempIndex;
        }
    }
}

