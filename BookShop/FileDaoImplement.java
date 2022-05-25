package BookShop;

import java.io.*;
import java.util.ArrayList;

/**
 * @date 2022/5/8 - 18:58
 */
@SuppressWarnings({"all"})
public class FileDaoImplement implements FileDAO {   //文件接口实现类
    public static String PATH = "C:\\Users\\何人不识卿\\Desktop\\test.txt";

    public void createFile() throws DaoException {  //创建文件
        try {
            File fp = new File(PATH);
            fp.createNewFile();
        } catch (Exception e) {
            throw new DaoException("文件创建出错!", e);
        }
    }

    public ArrayList<Book> readFile() throws DaoException { //读取文件
        ArrayList<Book> list = new ArrayList<Book>();
        try {
            BufferedReader fp = new BufferedReader(new FileReader(PATH));
            String[] str;
            String tmp;
            while ((tmp = fp.readLine()) != null) {
                str = tmp.split(" ");
                list.add(new Book(str[0], str[1], str[2], str[3], Integer.parseInt(str[4]), Integer.parseInt(str[5])));
            }
            fp.close();
        } catch (Exception e) {
            throw new DaoException("文件读取出错!", e);
        }
        list.trimToSize();  //目的是遍历读取list时不会读入空白信息
        return list;
    }

    public void writeFile(ArrayList<Book> list) throws DaoException {   //覆盖写入文件
        try {
            BufferedWriter fp = new BufferedWriter(new FileWriter(PATH));
            for (Book book : list) {
                fp.write(book.getAll());
                fp.write("\n");
            }
        } catch (Exception e) {
            throw new DaoException("文件写入出错!", e);
        }
    }

    public void addFile(Book book) throws DaoException {            //追加写入文件
        try {
            BufferedWriter fp = new BufferedWriter(new FileWriter(PATH, true));
            fp.write(book.getAll());
            fp.write("\n");
            fp.close();
        } catch (IOException e) {
            throw new DaoException("文件添加出错!", e);
        }
    }
}
