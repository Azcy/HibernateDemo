import Dao.dao;
import sourse.StudentsEntity;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * Created by zcy on 2017/5/22.
 */
public class HibernateTest {
    public static void main(String[] args) {



        dao dao=new dao();

        System.out.println("1.插入数据  2.查询数据  3.删除数据  4.更新数据");
        Scanner in=new Scanner(System.in);

        while (true) {
            int num = in.nextInt();
            switch (num) {
                case 1:
                    System.out.println("请依次输入学号、姓名、年龄、生日、住址");
                    int sid = in.nextInt();
                    String sname = in.nextLine();
                    String gender = in.nextLine();
                    String birthdaty = in.nextLine();
                    String address = in.nextLine();
                    //插入操作
                    StudentsEntity student = new StudentsEntity(sid, sname, gender, birthdaty, address);
                    dao.insert(student);
                    break;

                case 2:
                    System.out.println("输入指定的id：");
                    int id1 = in.nextInt();
                    dao.Select(id1);
                    break;
                case 3:
                    System.out.println("请输入删除的id");
                    int id = in.nextInt();
                    dao.Delete(id);
                    break;
                case 4:

            }
        }
    }
}
