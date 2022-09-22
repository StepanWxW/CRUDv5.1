package repository.implementation;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.Event;
import org.hibernate.Session;
import repository.EventRepository;
import util.SessionUtil;

import java.sql.Timestamp;
import java.util.List;

public class EventRepositoryImpl implements EventRepository {
    SessionUtil sessionUtil = new SessionUtil();
    @Override
    public Event create(Event event) {
        Session session = sessionUtil.openTransactionSession();
        event.setCreate(new Timestamp(System.currentTimeMillis()));
        event.setUpdate(new Timestamp(System.currentTimeMillis()));
        session.save(event);
        session.getTransaction().commit();
        session.close();
        return event;
    }

    @Override
    public List<Event> getAll() {
        List<Event> eventList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Event> cq = cb.createQuery(Event.class);
        cq.from(Event.class);
        eventList = session.createQuery(cq).getResultList();
        session.close();
        return eventList;
    }

    @Override
    public Event getById(Long id) {
        Session session = sessionUtil.openSession();
        Event event = session.get(Event.class, id);
        session.close();
        return event;
    }

    @Override
    public Event update(Event event) {
        try(Session session = sessionUtil.openTransactionSession()) {
            Event eventBase = session.get(Event.class, event.getId());
            eventBase.setUpdate(new Timestamp(System.currentTimeMillis()));
            eventBase.setStatus(event.getStatus());
            eventBase.setUser(event.getUser());
            eventBase.setFile(event.getFile());
            session.saveOrUpdate(eventBase);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Event whit id: " + event.getId() + " is missing.");
        }
        return event;
    }

    @Override
    public void remove(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
            Event event = session.load(Event.class, id);
            session.delete(event);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Event whit id: " + id + " is missing.");
        }
    }
}
