package HomeWork;

import java.util.*;

public class Problem4_1 {
    public static void main(String[] args) {

        //新建scanner类，获取输入的字符串
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一串字符串");
        String str=sc.next();
        //转化为小写
        str=str.toLowerCase(Locale.ROOT);
        //建立一个Map来储存字符和出现的次数
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            if(!map.containsKey(str.charAt(i)))
                map.put(str.charAt(i),1);
            else
                map.put(str.charAt(i),map.get(str.charAt(i))+1);
        }
        System.out.println("结果如下");
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        for (Map.Entry<Character,Integer> entry:entries
             ) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
