package BookShop;

import java.util.ArrayList;

/**
 * @date 2022/4/29 - 14:16
 */
@SuppressWarnings({"all"})
public interface BookDao {  //DAO接口
    public void addBook() throws DaoException;                        //添加图书信息

    public void updateBook(String BookInfo) throws DaoException;      //修改图书信息

    public void deleteBook(String BookInfo) throws DaoException;      //删除图书信息

    public Book getBook(String BookInfo) throws DaoException;         //获取图书信息

    public ArrayList<Book> getAllBooks() throws DaoException;         //读取全部图书信息

    public void sellBook(String ISBN) throws DaoException;            //销售功能

}
