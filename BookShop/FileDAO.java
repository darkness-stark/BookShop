package BookShop;

import java.util.ArrayList;

@SuppressWarnings({"all"})
public interface FileDAO {
    public void createFile() throws Exception;                                //创建文件

    public ArrayList<Book> readFile() throws DaoException;                    //读取文件

    public void writeFile(ArrayList<Book> list) throws DaoException;          //写入文件

    public void addFile(Book book) throws DaoException;                       //追加写入

}
