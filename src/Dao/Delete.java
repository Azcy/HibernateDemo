package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import sourse.StudentsEntity;

/**
 * Created by zcy on 2017/5/22.
 */
public class Delete {
    public  Delete(int id)
    {
        Session session=HibernateSessionFactory.getSession();
        /*通过id查找待删除记录*/
        StudentsEntity student=session.get(StudentsEntity.class,id);
        Transaction tran=session.beginTransaction();
        session.delete(student);
        tran.commit();
    }
}
