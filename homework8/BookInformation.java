package homework8;
import java.util.*;

/**
 * @author _britney_ 
 * @date 2021/5/31
 * request：
 * 使用List和Map存放多个图书信息，遍历并输出。
 * 其中商品属性：编号，名称，单价，出版社;
 * 使用商品编号作为Map中的key。
 */
public class BookInformation {
    public static void main(String[] args) {
        //new几个Books对象
        Books books1 = new Books(1, "格林童话", 25.0, "人民出版社");
        Books books2 = new Books(2, "安徒生童话", 32.0, "科学出版社");
        Books books3 = new Books(3, "一千零一夜", 28.0, "高等教育出版社");

        //然后放进HashMap中,Key是图书的编号,value是图书对象
        HashMap<Integer, Books> booksHashMap = new HashMap<>();
        booksHashMap.put(books1.getNum(), books1);
        booksHashMap.put(books2.getNum(), books2);
        booksHashMap.put(books3.getNum(), books3);

        /**
         * 也可以不用创建Books类,直接用HashMap集合存储图书的属性
         * 然后放进list集合中,这里是为了让 图书编号作为key
         */
        List<HashMap<Integer, Books>> booksList = new ArrayList<>();
        booksList.add(booksHashMap);
        
        System.out.println("编号\t名称\t单价\t出版社");
        for (HashMap<Integer, Books> h : booksList) {
            //获取key
            Set<Integer> key = h.keySet();
            for (Integer i : key) {
                //再通过key找value
                System.out.println(i
                        + "\t" + h.get(i).getName()
                        + "\t" + h.get(i).getPrice()
                        + "\t" + h.get(i).getPress());
            }
        }
    }
}

/**
 * Books(图书类)
 * 用于存放图书的属性
 */
class Books {
    /**
     * num 编号
     * name 名称
     * price 价格
     * press 出版社
     */
    private int num;
    private String name;
    private double price;
    private String press;

    public Books() {

    }

    Books(int num, String name, double price, String press) {
        super();
        this.num = num;
        this.name = name;
        this.price = price;
        this.press = press;
    }

    int getNum() {
        return num;
    }

    String getName() {
        return name;
    }

    double getPrice() {
        return price;
    }

    String getPress() {
        return press;
    }


}
