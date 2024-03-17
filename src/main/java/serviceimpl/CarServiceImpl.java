package serviceimpl;
import entities.Car;
import configuration.HibernateUtil;
import services.CarServices;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import java.util.List;
import org.hibernate.HibernateException;

public class CarServiceImpl implements CarServices {

    @Override
    public void addCar(Car car) {
    	Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Begin transaction
            transaction = session.beginTransaction();
            // Save the accountant object
            session.save(car);
            // Commit transaction
            transaction.commit();
        } catch (HibernateException e) {
            // Rollback transaction if there's an exception
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void updateCar(Car car) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(car);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCar(long carId) {
        Transaction transaction = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Car car = session.get(Car.class, carId);
            session.delete(car);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }
    }

    @Override
    public Car getCarById(long carId) {
        Transaction transaction = null;
        Car car = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            car = session.get(Car.class, carId);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } 
        return car;
    }
    
    public List<Car> getCarsByBrand(String brand) {
        Transaction transaction = null;
        List<Car> cars = getAllCars();

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("FROM Car WHERE brand = :brand", Car.class);
            query.setParameter("brand", brand);
            cars = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }catch(Exception e) {
        	e.printStackTrace();
        }

        return cars;
    }


    @Override
    public List<Car> getAllCars() {
        Transaction transaction = null;
        List<Car> cars = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("FROM Car", Car.class);
            cars = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } catch(Exception e) {
        	e.printStackTrace();
        }
        return cars;
    }

    @Override
    public List<Car> getCarsByPriceRange(double minPrice, double maxPrice) {
        Transaction transaction = null;
        List<Car> cars = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<Car> query = session.createQuery("FROM Car WHERE price BETWEEN :minPrice AND :maxPrice", Car.class);
            query.setParameter("minPrice", minPrice);
            query.setParameter("maxPrice", maxPrice);
            cars = query.list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cars;
    }

}
