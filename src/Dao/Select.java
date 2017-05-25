package Dao;

import org.hibernate.Session;
import org.hibernate.query.Query;
import sourse.StudentsEntity;

import java.util.List;

/**
 * Created by zcy on 2017/5/22.
 */
public class Select {
    public Select(int id){
        Session session=HibernateSessionFactory.getSession();
        Query query=session.createQuery("from StudentsEntity ");
        List list=query.list();
        for (int i=0;i<list.size();i++)
        {
            StudentsEntity st= (StudentsEntity) list.get(i);
            System.out.println(st.getSid()+" ,"+st.getAddress()+" ,"+st.getBirthday()+" ,"+st.getGender()+" ,"+st.getSname()+" ,"+st.getClass());
        }
    }
}
