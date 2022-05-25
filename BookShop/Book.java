package BookShop;

@SuppressWarnings({"all"})
public class Book {   //实体类
    private String Name;        //书名
    private String Publisher;   //出版社
    private String ISBN;        //ISBN 号
    private String Author;      //作者
    private int StockNumber;    //库存量
    private int Price;          //价格

    public Book() {
    }

    public Book(String name, String publisher, String ISBN, String author, int stockNumber, int price) {
        this.Name = name;
        this.Publisher = publisher;
        this.ISBN = ISBN;
        this.Author = author;
        this.StockNumber = stockNumber;
        this.Price = price;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        this.Publisher = publisher;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public int getStockNumber() {
        return StockNumber;
    }

    public void setStockNumber(int stockNumber) {
        this.StockNumber = stockNumber;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        this.Price = price;
    }

    //返回全部信息
    public String getAll() {
        String s = Name + " " + Publisher + " " + ISBN + " " + Author + " " + StockNumber + " " + Price;
        return s;
    }

    @Override
    public String toString() {
        return "Book{" +
                "书名：'" + Name + '\'' +
                ", 出版社：'" + Publisher + '\'' +
                ", ISBN号：'" + ISBN + '\'' +
                ", 作者：'" + Author + '\'' +
                ", 库存量：" + StockNumber +
                ", 价格：" + Price +
                '}';
    }

}

