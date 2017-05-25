package Dao;

import java.util.logging.Logger;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Configures and provides access to Hibernate sessions, tied to the current 
 * thread of execution. Follows the Thread Local Session pattern, see 
 */
@SuppressWarnings("deprecation")
public class HibernateSessionFactory
{
    /**
     * Location of hibernate.cfg.xml file. Location should be on the classpath 
     * as Hibernate uses #resourceAsStream style lookup for its configuration 
     * file. The default classpath location of the hibernate config file is in 
     * the default package. Use #setConfigFile() to update the location of the 
     * configuration file for the current session. 
     */
    private static  String configfile="/hibernate.cfg.xml";
    private static final ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
    private static Configuration config=new Configuration();
    private static org.hibernate.SessionFactory sessionFactory;

    //读取配置文件，创建一个会话工厂，这段代码为静态代码卡，编译后已经运行
    static
    {
        try
        {
            //      Configuration configuration = new Configuration();  
            //      configuration.configure();  
            //      ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder();  
            //      ServiceRegistry serviceRegistry = serviceRegistryBuilder.buildServiceRegistry();  
            //      sessionFactory = configuration.buildSessionFactory(serviceRegistry);  
            config.configure(configfile);
            sessionFactory = config.buildSessionFactory();
        }
        catch (HibernateException e)
        {
            //logger.error("buildSessionFactory");
            throw new HibernateException(e);
        }
    }



    /*重新创建一个会话工厂*/
    public static void rebuildSessionFactory()
    {
        synchronized (sessionFactory)
        {
            try
            {
                config.configure(configfile);
                sessionFactory = config.buildSessionFactory();
            }
            catch (HibernateException e)
            {
              //  logger.error("rebuildSessionFactory");
                throw new HibernateException(e);
            }
        }
    }
    /*通过会话工厂打开会话，就可以访问数据库了*/
    public static Session getSession() throws HibernateException
    {
        Session session = (Session) threadLocal.get();

            if (session == null || !session.isOpen())
            {
                if (sessionFactory == null)
                {
                    rebuildSessionFactory();
                }

                session = (sessionFactory != null) ? sessionFactory.openSession() : null;
                threadLocal.set(session);
            }


        return session;
    }

    /*关闭与数据库的会话*/
    public static void closeSession()
    {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);
        try
        {
            if (session != null && session.isOpen())
            {
                session.close();
            }
        }
        catch (HibernateException e)
        {
           // logger.error("close");
            throw new HibernateException(e);
        }
    }







}  