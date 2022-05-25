package BookShop;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @date 2022/5/8 - 19:45
 */
@SuppressWarnings({"all"})
public class BookDaoImplement implements BookDao {
    public void addBook() throws DaoException {    //添加图书信息
        FileDaoImplement val = new FileDaoImplement();
        ArrayList<Book> l = new ArrayList<Book>();
        ArrayList<String> NAMES = new ArrayList<String>();
        ArrayList<String> ISBNS = new ArrayList<String>();

        try {
            l = val.readFile();
            for (Book book : l) {
                NAMES.add(book.getName());
                ISBNS.add(book.getISBN());
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入书名：");
            boolean f = true;
            String Name = " ";
            while (f) {
                Name = sc.next();
                if (NAMES.contains(Name)) {
                    System.out.println("书名重复,请重新输入书名号");
                } else {
                    f = false;
                }
            }
            System.out.println("请输入出版社：");
            String Publisher = sc.next();
            System.out.println("请输入ISBN号：");
            f = true;
            String ISBN = "";
            while (f) {
                ISBN = sc.next();
                if (ISBNS.contains(ISBN)) {
                    System.out.println("ISBN号重复,请重新输入ISBN号");
                } else {
                    f = false;
                }
            }
            System.out.println("请输入作者名：");
            String Author = sc.next();
            System.out.println("请输入库存量：");
            int StockNumber = sc.nextInt();
            System.out.println("请输入价格：");
            int Price = sc.nextInt();
            val.addFile(new Book(Name, Publisher, ISBN, Author, StockNumber, Price));
            System.out.println("添加图书信息成功");
        } catch (DaoException e) {
            val.createFile();
            throw new DaoException("添加图书信息功能出错", e);
        }
    }

    public void updateBook(String BookInfo) throws DaoException { //修改图书信息
        FileDaoImplement val = new FileDaoImplement();
        ArrayList<Book> list = new ArrayList<Book>();
        ArrayList<String> ISBNS = new ArrayList<String>();
        ArrayList<String> NAMES = new ArrayList<String>();

        try {
            list = val.readFile();
            for (Book book : list) {
                NAMES.add(book.getName());
                ISBNS.add(book.getISBN());
            }
            Scanner sc = new Scanner(System.in);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(BookInfo) || list.get(i).getISBN().equals(BookInfo)) {
                    System.out.println("请输入书名：");
                    boolean f = false;
                    String Name = " ";
                    while (f) {
                        Name = sc.next();
                        if (NAMES.contains(Name)) {
                            System.out.println("书名重复,请重新输入书名号");
                        } else {
                            f = false;
                        }
                    }
                    list.get(i).setName(Name);
                    System.out.println("请输入出版社：");
                    list.get(i).setPublisher(sc.next());
                    System.out.println("请输入ISBN号：");
                    f = true;
                    String ISBN = "";
                    while (f) {
                        ISBN = sc.next();
                        if (ISBNS.contains(ISBN)) {
                            System.out.println("ISBN号重复,请重新输入ISBN号");
                        } else {
                            f = false;
                        }
                    }
                    list.get(i).setISBN(ISBN);
                    System.out.println("请输入作者名：");
                    list.get(i).setAuthor(sc.next());
                    System.out.println("请输入库存量：");
                    list.get(i).setStockNumber(sc.nextInt());
                    System.out.println("请输入价格：");
                    list.get(i).setPrice(sc.nextInt());
                    val.writeFile(list);
                    System.out.println("图书信息修改成功");
                    return;
                }
            }
            System.out.println("图书信息修改失败");
        } catch (DaoException e) {
            val.createFile();
            throw new DaoException("修改图书信息功能出错", e);
        }

    }

    public void deleteBook(String BookInfo) throws DaoException {    //删除图书信息
        FileDaoImplement val = new FileDaoImplement();
        ArrayList<Book> list = new ArrayList<Book>();
        try {
            list = val.readFile();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getName().equals(BookInfo) || list.get(i).getISBN().equals(BookInfo)) {
                    list.remove(i);
                    val.writeFile(list);
                    System.out.println("删除成功");
                    return;
                }
            }
            System.out.println("查无此书");
        } catch (DaoException e) {
            val.createFile();
            throw new DaoException("删除图书信息功能出错", e);
        }
    }

    public Book getBook(String BookInfo) throws DaoException {     //获取图书信息(根据书名或ISBN号搜索书本)
        FileDaoImplement val = new FileDaoImplement();
        ArrayList<Book> list = new ArrayList<Book>();
        Book book = new Book();
        try {
            list = val.readFile();
            for (Book value : list) {
                if (value.getName().equals(BookInfo) || value.getISBN().equals(BookInfo)) {
                    book = value;
                    System.out.println("获取图书信息成功");
                    break;
                }
            }
        } catch (DaoException e) {
            val.createFile();
            throw new DaoException("获取图书信息功能出错", e);
        }
        return book;
    }

    public ArrayList<Book> getAllBooks() throws DaoException {      //获取全部图书信息
        FileDaoImplement val = new FileDaoImplement();
        try {
            return val.readFile();
        } catch (DaoException e) {
            val.createFile();
            throw new DaoException("获取全部图书信息功能出错", e);
        }
    }

    public void sellBook(String ISBN) throws DaoException {      //销售图书
        FileDaoImplement val = new FileDaoImplement();
        ArrayList<Book> list = new ArrayList<Book>();
        try {
            list = val.readFile();
            for (Book book : list) {
                if (book.getISBN().equals(ISBN) && book.getStockNumber() > 0) {
                    System.out.println("请输入销售数量");
                    int i = new Scanner(System.in).nextInt();
                    if (i > book.getStockNumber()) {
                        System.out.println("库存不够");
                        return;
                    } else {
                        book.setStockNumber(book.getStockNumber() - i);
                        for (Book book1 : list) {
                            System.out.println(book1);
                        }
                        System.out.println("销售成功");
                        val.writeFile(list);
                        return;
                    }
                }
            }
            System.out.println("查无此书");
        } catch (DaoException e) {
            val.createFile();
            throw new DaoException("销售功能出错", e);
        }
    }
}
