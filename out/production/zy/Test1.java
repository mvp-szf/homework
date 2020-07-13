package lagou.test3;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Hunter
 * @date 2020/7/13
 **/

public class Test1 {

    public static void count(String str){
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++){
            int count = map.containsKey(str.charAt(i)) ? map.get(str.charAt(i)) + 1 : 1;
            map.put(str.charAt(i),count);
        }

        for (Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " --  " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        count("ABCD123!@#$%ab3321!");
    }
}
