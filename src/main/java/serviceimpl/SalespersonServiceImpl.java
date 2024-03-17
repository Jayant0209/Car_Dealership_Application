package serviceimpl;
import entities.Salesperson;
import services.SalespersonService;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import configuration.HibernateUtil;

import java.util.List;

public class SalespersonServiceImpl implements SalespersonService {

    @Override
    public void addSalesperson(Salesperson salesperson) {
        Transaction transaction = null;
        
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(salesperson);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }

    @Override
    public void updateSalesperson(Salesperson salesperson) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(salesperson);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteSalesperson(long salespersonId) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Salesperson salesperson = session.get(Salesperson.class, salespersonId);
            session.delete(salesperson);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
    }

    @Override
    public Salesperson getSalespersonById(long salespersonId) {
        Transaction transaction = null;
        Salesperson salesperson = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            salesperson = session.get(Salesperson.class, salespersonId);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return salesperson;
    }

    @Override
    public List<Salesperson> getAllSalespersons() {
        Transaction transaction = null;
        List<Salesperson> salespersons = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Salesperson> query = session.createQuery("FROM Salesperson", Salesperson.class);
            salespersons = query.list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
        return salespersons;
    }
}
