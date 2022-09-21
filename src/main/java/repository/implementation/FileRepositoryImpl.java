package repository.implementation;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import model.File;
import org.hibernate.Session;
import repository.FileRepository;
import util.SessionUtil;

import java.util.List;

public class FileRepositoryImpl implements FileRepository {
    SessionUtil sessionUtil = new SessionUtil();
    @Override
    public File create(File file) {
        Session session = sessionUtil.openTransactionSession();
        session.persist(file);
        session.getTransaction().commit();
        session.close();
        return file;
    }

    @Override
    public List<File> getAll() {
        List<File> filesList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<File> cq = cb.createQuery(File.class);
        cq.from(File.class);
        filesList = session.createQuery(cq).getResultList();
        session.close();
        return filesList;
    }

    @Override
    public File getById(Long id) {
        Session session = sessionUtil.openSession();
        File file = session.get(File.class, id);
        session.close();
        return file;
    }

    @Override
    public File update(File file) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
