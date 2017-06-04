import sourse.StudentsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

/**
 * Created by zcy on 2017/5/22.
 */
public class StudentTest {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;


    public void test(){

        System.out.println("test....");
        /*创建一个配置对象，读取配置文件*/
        String configfile="/hibernate.cfg.xml";
        Configuration config=new Configuration();
        config.configure(configfile);
        /*通过配置对象产生一个会话实例*/
        SessionFactory sessionFactory=config.buildSessionFactory();
        /*通过会话工厂类产生一个会话实例*/
        Session session=sessionFactory.openSession();
        /*通过会话产生一个查询对象Query*/
        Query query=session.createQuery("from sourse.StudentsEntity");
        /*进行查询返回一个集合List*/
        List<StudentsEntity> studentTestList=query.list();
        /*遍历输出集中中的元素*/
        for (StudentsEntity st:studentTestList){
        System.out.println(st.getSid()+" ,"+st.getAddress()+" ,"+st.getBirthday()+" ,"+st.getGender()+" ,"+st.getSname()+" ,"+st.getClass());
    }

}

    public static void main(String[] args) {
        new StudentTest().test();
    }
}
