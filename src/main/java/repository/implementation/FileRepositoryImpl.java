package repository.implementation;

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
        return null;
    }

    @Override
    public File getById(Long id) {
        return null;
    }

    @Override
    public File update(File file) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}
