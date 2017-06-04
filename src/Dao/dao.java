package Dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import sourse.StudentsEntity;

import java.util.List;

/**
 * Created by zcy on 2017/6/4.
 */
public class dao {
    Session session=null;
    StudentsEntity student=null;
    Transaction tran=null;
    public dao(){
        session=HibernateSessionFactory.getSession();
         tran=session.beginTransaction();
    }
    //通过id进行删除
    public void Delete(int id)
    {

        /*通过id查找待删除记录*/
        StudentsEntity student=session.get(StudentsEntity.class,id);
        Transaction tran=session.beginTransaction();
        session.delete(student);
        tran.commit();
    }
    //通过id进行查询
    public void Select(int id){

        Query query=session.createQuery("from StudentsEntity where sid="+id);
        List list=query.list();
        for (int i=0;i<list.size();i++)
        {
            StudentsEntity st= (StudentsEntity) list.get(i);
            System.out.println(st.getSid()+" ,"+st.getAddress()+" ,"+st.getBirthday()+" ,"+st.getGender()+" ,"+st.getSname()+" ,"+st.getClass());
        }
    }

    //插入student对象
    public void insert(StudentsEntity student) {
        //创建个Sessionduix


        StudentsEntity st = student;
        session.save(st);
        tran.commit();

    }


    //通过查找id，进行修改
    public void Update(int id){

        student=session.get(StudentsEntity.class,id);

    }
    //修改名字
    public void UpdateName(String name){
        Transaction tran=session.beginTransaction();
        student.setSname(name);
        session.saveOrUpdate(student);
        tran.commit();
    }
    //修改地址
    public  void  UpdateAdress(String address){
        Transaction tran=session.beginTransaction();
        student.setAddress(address);
        session.saveOrUpdate(student);
        tran.commit();
    }

    public void UpdateBirthday(String Birthday){
        Transaction tran=session.beginTransaction();
        student.setBirthday(Birthday);
        session.saveOrUpdate(student);
        tran.commit();
    }

    public void  UpdateGender(String Gender){
        Transaction tran=session.beginTransaction();
        student.setGender(Gender);
        session.saveOrUpdate(student);
        tran.commit();
    }
}
