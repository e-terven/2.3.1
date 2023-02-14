package web.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    public UserDaoImpl(){

    }
    @Override
    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();

        try (Session session = getSessionFactory().openSession()) {

            transaction = session.beginTransaction();
            list = session.createQuery("from User").list();
            transaction.commit();
            System.out.println('\n' + "Users list:");

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return list;
    }
}
