package lagou;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author Hunter
 * @date 2020/6/28
 **/

public class Test2 {

    private static String[][] arr = new String[17][17];
    private static final String[] all = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    //使用flag标志使得轮流下棋
    private static boolean flag = true;

    //标志是否获胜
    private static boolean win = false;

    //构建棋盘
    public static void init(){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                //第一行
                if (i == 0 && j > 0){
                    arr[i][j] = all[j - 1];
                }else if (j == 0 && i > 0){
                    arr[i][j] = all[i - 1];
                }else {
                    arr[i][j] = "+";
                }
            }
        }

        arr[0][0] = " ";
    }

    //下棋，输入坐标
    public static void done(String x,  String y){
        List<String> collect = Arrays.stream(all).collect(Collectors.toList());
        if (!collect.contains(x) || !collect.contains(y)){
            System.out.println("输入有误,请重新输入! ");
            return;
        }

        int i = collect.indexOf(x);
        int j = collect.indexOf(y);
        if (arr[i + 1][j + 1] != "+"){
            System.out.println("该位置无法修改,请重新选择!");
            return;
        }

        //用1表示第一个人下的，0表示第二个人下的
        if (flag){
            arr[i + 1][j + 1] = "*";
        }else {
            arr[i + 1][j + 1] = "@";
        }

        //判断是否获胜,若获胜则结束游戏输出获胜者，若没有则继续下棋
        win = judge(i + 1, j + 1);
        if (win){
            if (flag){
                System.out.println("恭喜第一位选手获胜~~~!");
            }else{
                System.out.println("恭喜第二位选手获胜~~~!");
            }
            return;
        }


        flag = !flag;

    }

    //判断是否获胜,每下一步判断其对角线，横竖上是否已经连续5个
    public static boolean judge(int x, int y){
        //第一位选手

        String s = "*";
        if (flag){
            s = "-";
        }

        //判断横向是否满足
        int sum = 0;
        int i = 1;
        int j = 1;
        while (i < arr[0].length){
            if (arr[i++][y].equals(s)){
                if (++sum >= 5){
                    return true;
                }
            }else {
                sum = 0;
            }
        }

        sum = 0;
        while (j < arr.length){
            if (arr[x][j++].equals(s)){
                if (++sum >= 5){
                    return true;
                }
            }else {
                sum = 0;
            }
        }


        //判断对角线
        if (x - y >= 0){
            //左斜
            i = 1;
            j = x - y + 1;
            while (j < arr[0].length){
                if (arr[j++][i++].equals(s)){
                    if (++sum >= 5){
                        return true;
                    }
                }else {
                    sum = 0;
                }
                //arr[j++][i++] = "%";
            }

            //右斜
            j = x+y+1 >= arr.length ? arr.length - 1 : x+y-1;
            i = (j == arr.length - 1 ? x+y-j : 1);
            while (j >= 1 && i < arr.length){
                if (arr[j--][i++].equals(s)){
                    if (++sum >= 5){
                        return true;
                        //success
                    }
                }else {
                    sum = 0;
                }

                //arr[j--][i++] = "@";
            }
        }else {

            //左侧
            i = x+y-1 > arr.length - 1 ? arr.length - 1 : x+y-1;
            j = (i == arr.length - 1 ? x+y-i : 1);
            while (i >= 1 && j < arr.length){
                if (arr[i--][j++].equals(s)){

                    if (++sum >= 5){
                        return true;
                        //arr[i--][j++] = "@";

                    }

                }
            }

            i = 1;
            j = y - x + 1;
            while (j < arr[0].length && i < arr.length){
                if (arr[i++][j++].equals(s)){
                    if (++sum >= 5){
                        return true;
                    }
                }else {
                    sum = 0;
                }
                //arr[i++][j++] = "%";
            }
        }


        return false;
    }

    //打印棋盘
    public static void print(){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static void main(String[] args) {
        init();
        print();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.print("请输入横坐标值x:  ");
            String x = sc.next();
            System.out.print("请输入纵坐标值y:  ");
            String y = sc.next();
            done(y,x);
            print();
            if (win){
                break;
            }

        }
    }
}
