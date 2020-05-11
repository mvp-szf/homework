

public class zy5 {
    public static void main(String[] args) {
        //数组定义
        char [][] qp=new char[16][16];
        //数组赋值
        for(int i=0;i<16;i++)
            for (int j=0;j<16;j++){
            qp[i][j]='+';
            }
            //打印棋盘
        for(int i=0;i<16;i++){
            for (int j=0;j<16;j++){
                System.out.print( qp[i][j]);
            }
            //输出一行后换行
        System.out.print("\n");
        }
    }

}
