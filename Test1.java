package lagou;

/**
 * @author Hunter
 * @date 2020/6/28
 **/

public class Test1 {
    private static int[][] arr = new int[16][16];

    public static void init(int[][] arr){
        //若有初始化则使用自定义，若无则自动随机生成
        if (arr != null && arr.length > 0){
            Test1.arr = arr;
        }else {
            arr = new int[16][16];
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    arr[i][j] = (int) (Math.random() * 10);
                }
            }
            Test1.arr = arr;
        }
    }

    public static void print(){
        if (arr == null || arr.length == 0){
            return;
        }

        System.out.println("获得二维数组: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //获取每行每列总和
    public static int countAll(){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[0].length; j++){
                sum += arr[i][j];
            }
        }
        return sum;
    }

    public static int countDiagonal(){
        int sum = 0;
        for (int i = 0 , len = arr.length; i < arr.length; i++){
            //获取的值与行数有关
            sum += (arr[i][i] + arr[i][len - i - 1]);
        }
        return sum;
    }
    public static void main(String[] args) {

        init(null);
        print();
        System.out.println("\n\n 行列全部累加数值: " + countAll() + "\n\n");
        System.out.println("\n\n 对角线累加数值: " + countDiagonal() + "\n\n");
    }
}
