

import java.util.Arrays;

import java.util.Random;

public class zy3 {
    public static void main(String[] args) {


        int[] redArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
        int[] blueArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        Random random = new Random();

        int[] redBall = new int[6];
        //标记数组
        boolean[] flag = new boolean[33];
        //遍历red数组，放入选择的红球号码
        for (int i = 0; i < redBall.length; i++) {
            //先随机选择一个位置
            //再判断是否要重复再选另一个位置
            int j;
            do {
                j = new Random().nextInt(redArray.length);
            }
            while (flag[j]);
            //选择j位置的值，存入结果数组
            redBall[i] = redArray[j];
            flag[j] = true;//标记j位置已选过
        }
        System.out.println("本次红球号码为：" + Arrays.toString(redBall));

        int blueBall = random.nextInt(blueArray.length);
        System.out.println("本次蓝球号码为：" + blueBall);

    }

}