import Dao.Add;
import Dao.Delete;
import Dao.Select;
import Dao.Update;
import sourse.StudentsEntity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by zcy on 2017/5/22.
 */
public class HibernateTest {
    public static void main(String[] args) {

        /*
        //插入操作
        StudentsEntity student=new StudentsEntity(4,"xsw","20","1995-11-14","珠海");
        Add ad=new Add(student);

        System.out.println("查询操作：");
        //查询操作
        Select se=new Select(3);

        System.out.println("删除id:1");

       Delete d=new Delete(1);

        Select s1=new Select(3);
        */
        //Update
        Update up=new Update(4);
        up.UpdateName("hwl");
        Select s1=new Select(3);

    }
}
