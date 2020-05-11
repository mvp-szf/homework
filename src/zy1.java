import java.util.Scanner;
public class zy1
{
    public static void main(String[] args)
    {
        int year,month,day,a=0,b=0;
        Scanner reader=new Scanner(System.in);
        System.out.println("请输入年份");
        year=reader.nextInt();
        System.out.println("请输入月份");
        month=reader.nextInt();
        System.out.println("请输入日");
        day=reader.nextInt();
        for(int i=1;i<month;i++)
        {
            switch(i)
            {   //根据月份给a赋值,a代表当前月份的天数
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    a=31;
                    break;
                case 2:
                    if(year%4==0&&year%100!=0||year%400==0)
                        a=29;
                    else
                        a=28;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    a=30;
                    break;
            }
            //将当前月份的天数加到总天数中
            b=b+a;
        }
        //将当前日加入到总天数中
        b=b+day;
        System.out.println("这是这一年的第"+b+"天");
    }
}
