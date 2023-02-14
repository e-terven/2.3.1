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

        list.add(new User("Name 1", 10));
        System.out.println('\n' + "Users list:");
        return list;
    }
}
