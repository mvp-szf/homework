package lagou.test3;

import org.apache.jmeter.functions.RandomString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Hunter
 * @date 2020/7/13
 **/

public class Poker {

    private String[] pk = {"大王","小王","2","1","K","Q","J","10","9","8","7","6","5","4","3"};
    private String[] all = new String[54];
    private String[] dipai = new String[3];
    private List<String[]> list = new ArrayList();


    /**
     * 初始化扑克牌
     * all(i) 2 3 4 5  6 7 8 9  10 11 12 13  14 15 16 17
     * pk     2 2 2 2  3 3 3 3  4  4  4  4   5  5  5  5
     */
    public Poker(){
        for (int i = 0; i < all.length; i++){
            if (i == 0 || i == 1){
                all[i] = pk[i];
            }else {
                //表示对应pk中的索引号
                // ((i - 2)/4) % 13 +2
                int index = ((i - 2)/4) % 13 +2;
                all[i] = pk[index];
            }
        }

        shuffle();
        //print();
        //printAll();

    }

    /**
     * 洗牌
     */
    private void shuffle(){
        //Random  random = new Random();
        for (int i = 0 ; i < all.length *  4; i ++){
            for (int j = 0; j < all.length; j ++){
                int index = getRandom(53);
                String tmp = "";
                tmp = all[j];
                all[j] = all[index];
                all[index] = tmp;
            }
        }
    }

    public List<String[]> distribution(){
        int i;
        List<String> collect = null;
        for (i = 0; i < all.length - 3; i += 17){
            collect = Arrays.stream(all).skip(i).limit(17).collect(Collectors.toList());
            //整理完牌在发牌
            if (i > 48){
                collect = Arrays.stream(all).skip(i).limit(3).collect(Collectors.toList());
            }
            arrangement(collect);
            list.add(collect.toArray(new String[0]));
        }


        return list;

    }

    private void arrangement(List<String> list){
        list.sort((o1, o2) -> {
            List<String> strings = Arrays.asList(pk);
            int i = strings.indexOf(o1);
            int j = strings.indexOf(o2);
            return i > j ? 1 : (i == j ? 0 : -1);
        });
    }

    public int getRandom(int num){
        Random random = new Random();
        return random.nextInt(num);
    }



    /**
     * 显示牌
     */
    private void print(){
        for (int i = 0; i < all.length; i++){
            if (i == 0 || i == 1){
                System.out.println(all[i]);
            }else {
                System.out.print(all[i] + "  ");
                if ((i-1) % 4 == 0){
                    System.out.println();
                }
            }
        }
    }

    private void printAll(){
        System.out.println(Arrays.toString(all));
    }

    public static void main(String[] args) throws InterruptedException {
        Poker poker = new Poker();
        //String[] strings = {"1","2","3","4","5","6","7","8","9","10"};
        //List<String> collect = Arrays.stream(strings).skip(0).limit(5).collect(Collectors.toList());
        //System.out.println(collect);
        List<String[]> distribution = poker.distribution();
        distribution.forEach(strings -> System.out.println(Arrays.toString(strings)));
    }
}
