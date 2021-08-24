package HomeWork;

import java.util.Random;

public class Problem4_2 {
    public static void main(String[] args) {
        //定义两个用于拼接字符串的字符串，然后用随机数加下标的方式来获取随机的字符
        String sample_char="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String sample_num="01234567890";
        //保存5个车牌
        String[] arr=new String[5];
        //random类的定义
        Random r=new Random();
        for(int i=0;i<5;i++){
            //若flag为true则将车牌添加到数组中，否则重新生成
            boolean flag=true;
            //用StringBuilder类实现字符串拼接
            StringBuilder temp=new StringBuilder();
            for(int j=0;j<3;j++){
                temp.append(sample_char.charAt(r.nextInt(sample_char.length())));
            }
            for(int k=0;k<4;k++){
                temp.append(sample_num.charAt(r.nextInt(sample_num.length())));
            }
            //转换为String
            String result=new String(temp);
            //若车牌有重复则重新生成
            for (String s : arr) {
                if (result.equals(s)) {
                    flag = false;
                }
            }
            if(flag)
                arr[i]=result;
            else
                i--;
        }
        //打印车牌
        for (String s:arr
             ) {
            System.out.println(s);
        }
    }
}
