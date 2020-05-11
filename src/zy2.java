public class zy2 {
    public static void main(String[] args){
             {
                        int i,j,k;
                      for(i=1;i<1000;i++)
                            {
                                 int sum=0;
                                 for(j=1;j<i;j++)
                                     {
                                         //判断j是否是i的因子
                                       if(i%j==0){
                                           //计算因子和
                                                 sum=sum+j;
                                             }
                                    }
                                if(sum==i){
                                      System.out.println(i);
                                    }
                    }
                   }
           }
}
