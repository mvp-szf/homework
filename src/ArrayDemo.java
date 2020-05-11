
import java.math.BigDecimal;
import java.util.Arrays;


public class ArrayDemo<E> {
    //容量阀值
    private static final float DEFAULT_LOAD_FACTOR = 0.8f;
    //初始容量
    private static final int DEFAULT_CAPACITY = 10;

    //存储单元
    transient java.lang.Object[] elementData;


    //已占容量
    private int size;



    private static final java.lang.Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};


    public ArrayDemo() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public int getLength(){
        return this.size;
    }

    public ArrayDemo(int initCapacity){
        if(initCapacity < 0){
            throw new IllegalArgumentException("capacity is illegeal : " + initCapacity);
        }else if (initCapacity == 0){
            this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
        }else{
            this.elementData = new Object[initCapacity];
        }
    }

    public boolean add(E data){
        boolean flag = checkCapacity(size + 1);
        //成功则插入到末尾
        if(flag){
            this.elementData[size] = data;
            size++;
            return true;
        }
        return false;
    }

    /**
     *
     * @param i i表示加入数组后的容量
     * @return
     */
    private boolean checkCapacity(int i) {
        if (i == 1){
            initArrayDemo();
            return true;
        }else {
            //Math.floorDiv()
            BigDecimal b1 = new BigDecimal(Double.toString(i)); //被除数
            BigDecimal b2 = new BigDecimal(Double.toString(elementData.length)); //除数
            double value = 0;
            if (b2 != null && !b2.equals(BigDecimal.ZERO)) {
                value = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).doubleValue();
            }

            boolean successFlag = true;
            //需要扩容
            if (value >= DEFAULT_LOAD_FACTOR) {
                successFlag = resize(i);
            }


            return successFlag;
        }
    }

    private void initArrayDemo() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    private boolean resize(int size) {
        try {
            if(size <= 0){
                throw new IllegalArgumentException("capacity is illegeal : " + size);
            }
            int newCapacity = elementData.length + (elementData.length >> 1);
            Object[] newElementDate = new Object[newCapacity];

            for (int i = 0; i < size - 1; i++){
                newElementDate[i] = this.elementData[i];
            }
            this.elementData = newElementDate;
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public String toString(){

        return Arrays.toString((this.elementData));
    }

    public static void main(String[] args) {
        ArrayDemo demo = new ArrayDemo();
        for(int i = 0; i < 9; i++){
            demo.add(i);
        }

        System.out.println(demo.toString());
    }

}
