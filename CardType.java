package lagou;

public enum CardType {
    BIG_CARD(1,"大卡"),
    SMALL_CARD(2,"小卡"),
    TINY_CARD(3,"微型卡");

    CardType(int num,String name) {
        this.num = num;
        this.name = name;
    }
    private int num;
    private String name;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
