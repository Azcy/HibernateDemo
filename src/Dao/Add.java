package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sourse.StudentsEntity;

import java.sql.Date;

/**
 * Created by zcy on 2017/5/22.
 */
public class Add {
    private Integer sid;
    private String sname;
    private String gender;
    private String birthday;
    private String address;
    private StudentsEntity student;
    public  Add(StudentsEntity student)
    {
        this.sid=student.getSid();
        this.sname=student.getSname();
        this.gender=student.getGender();
        this.birthday=student.getBirthday();
        this.address=student.getAddress();
        insert();
    }

    public void insert() {
        //创建个Sessionduix
        Session session = HibernateSessionFactory.getSession();
        Transaction tran=session.beginTransaction();
        StudentsEntity st = new StudentsEntity(sid, sname, gender, birthday, address);
        session.save(st);
        tran.commit();

    }

}
