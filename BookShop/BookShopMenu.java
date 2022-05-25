package BookShop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @date 2022/5/2 - 9:57
 */
@SuppressWarnings({"all"})
public class BookShopMenu { //主页面
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean loop = true;


        FileDaoImplement fdi = new FileDaoImplement();
        BookDaoImplement bdi = new BookDaoImplement();

        do {
            System.out.println("""
                    ------欢迎使用书店购物系统------
                            1.图 书 销 售
                            2.图 书 添 加
                            3.图 书 查 询
                            4.图书信息修改
                            5.图书信息删除
                            6.图书信息统计
                            7.图书信息保存
                            8.图书信息读取
                            9.退 出 系 统
                    ----------------------------
                    """);
            switch (sc.nextInt()) {
                case 1 -> { //图书销售
                    System.out.println("请输入要销售的图书的ISBN号：");
                    try {
                        bdi.sellBook(sc.next());
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书销售出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }

                }
                case 2 -> { //图书添加
                    try {
                        bdi.addBook();
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书添加出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }

                }
                case 3 -> { //图书查询
                    System.out.println("请输入要查询的图书的书名或ISBN号：");
                    try {
                        System.out.println(bdi.getBook(sc.next()));
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书查询出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }

                }
                case 4 -> { //图书信息修改
                    System.out.println("请输入要修改的图书的书名或ISBN号：");
                    try {
                        bdi.updateBook(sc.next());
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书信息修改出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }
                }
                case 5 -> { //图书信息删除
                    System.out.println("请输入要删除的图书的书名或ISBN号");
                    try {
                        bdi.deleteBook(sc.next());
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书信息删除出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }
                }
                case 6 -> { //图书信息统计
                    System.out.println("""
                                     1.按价格排序
                                     2.按库存量排序
                                     3.按作者排序
                                     4.按出版社排序       
                            """);
                    try {
                        switch (sc.nextInt()) {
                            case 1 -> {
                                ArrayList<Book> l = bdi.getAllBooks();
                                l.sort(new Comparator<Book>() {
                                    @Override
                                    public int compare(Book o1, Book o2) {
                                        return o2.getPrice() - o1.getPrice();
                                    }
                                });
                                for (Book book : l) {
                                    System.out.println(book);
                                }
                            }
                            case 2 -> {
                                ArrayList<Book> l = bdi.getAllBooks();
                                l.sort(new Comparator<Book>() {
                                    @Override
                                    public int compare(Book o1, Book o2) {
                                        return o2.getStockNumber() - o1.getStockNumber();
                                    }
                                });
                                for (Book book : l) {
                                    System.out.println(book);
                                }
                            }
                            case 3 -> {
                                ArrayList<Book> l = bdi.getAllBooks();
                                l.sort(new Comparator<Book>() {
                                    @Override
                                    public int compare(Book o1, Book o2) {
                                        return o2.getAuthor().compareTo(o1.getAuthor());
                                    }
                                });
                                for (Book book : l) {
                                    System.out.println(book);
                                }
                            }
                            case 4 -> {
                                ArrayList<Book> l = bdi.getAllBooks();
                                l.sort(new Comparator<Book>() {
                                    @Override
                                    public int compare(Book o1, Book o2) {
                                        return o2.getPublisher().compareTo(o1.getPublisher());
                                    }
                                });
                                for (Book book : l) {
                                    System.out.println(book);
                                }
                            }
                            default -> System.out.println("输入错误");
                        }
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书信息统计出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }
                }
                case 7 -> { //图书信息保存
                    System.out.println("保存成功");
                }
                case 8 -> { //图书信息读取
                    try {
                        ArrayList<Book> l = bdi.getAllBooks();
                        for (Book book : l) {
                            System.out.println(book);
                        }
                    } catch (DaoException e) {
                        DaoException t = new DaoException("图书信息读取出错：" + e.getMessage(), e.getCause());
                        t.printStackTrace();
                    }
                }
                case 9 -> loop = false;
                default -> System.out.println("错误输入，请重新选择");
            }
        } while (loop);

        System.out.println("系统已退出，欢迎再次使用");
    }
}
