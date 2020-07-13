package lagou.test3;

/**
 * @author Hunter
 * @date 2020/7/13
 **/

public class Test2 {
    public static String getMaxStr(String s1, String s2){

        String max = "";
        String min = "";
        max = (s1.length() > s2.length()) ? s1 : s2;
        min = (max == s1) ? s2 : s1;

        for(int x = 0; x < min.length(); x++){
            for(int y = 0,z = min.length()-x; z != min.length()+1; y++, z++){
                String temp=min.substring(y, z);

                if(max.contains(temp)) {
                    return temp;
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println(getMaxStr("asdafghjka","aaasdfghjka"));

    }
}
