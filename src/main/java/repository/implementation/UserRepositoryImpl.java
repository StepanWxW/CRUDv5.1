package repository.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.User;
import org.hibernate.Session;
import repository.UserRepository;
import util.SessionUtil;

import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    SessionUtil sessionUtil = new SessionUtil();
    @Override
    public User create(User user) {
        Session session = sessionUtil.openTransactionSession();
        session.persist(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> usersList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        cq.from(User.class);
        usersList = session.createQuery(cq).getResultList();
        session.close();
        return usersList;
    }

    @Override
    public User getById(Long id) {
        Session session = sessionUtil.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    @Override
    public User update(User user) {
        try(Session session = sessionUtil.openTransactionSession()) {
            session.saveOrUpdate(user);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("User whit id: " + user.getId() + " is missing.");
        }
        return user;
    }

    @Override
    public void remove(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
            User user = session.load(User.class, id);
            session.delete(user);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("User whit id: " + id + " is missing.");
        }
    }
}
