package lagou.test3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hunter
 * @date 2020/7/13
 **/

public class Test3 {

    public static void count(String[] strs){
        Map<String,Integer> map = new LinkedHashMap<>((int)(strs.length * 0.75 +1));
        for (String str : strs){
            int count = map.containsKey(str) ? map.get(str) + 1 : 1;
            map.put(str,count);
        }

        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " 出现了 " + entry.getValue() + " 次");
        }
    }

    public static void main(String[] args) {

        count(new String[]{"123","456","789","123","456"});
    }
}
