package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sourse.StudentsEntity;

import java.sql.Date;

/**
 * Created by zcy on 2017/5/22.
 */
public class Update {
    Session session=HibernateSessionFactory.getSession();
    Transaction tran;
    StudentsEntity student;
    //通过查找id，进行修改
    public  Update(int id){

         student=session.get(StudentsEntity.class,id);

    }
    //修改名字
    public void UpdateName(String name){
        tran=session.beginTransaction();
     student.setSname(name);
     session.saveOrUpdate(student);
     tran.commit();
    }
    //修改地址
    public  void  UpdateAdress(String address){
        tran=session.beginTransaction();
        student.setAddress(address);
        session.saveOrUpdate(student);
        tran.commit();
    }

    public void UpdateBirthday(String Birthday){
        tran=session.beginTransaction();
        student.setBirthday(Birthday);
        session.saveOrUpdate(student);
        tran.commit();
    }

    public void  UpdateGender(String Gender){
        tran=session.beginTransaction();
        student.setGender(Gender);
        session.saveOrUpdate(student);
        tran.commit();
    }

}
