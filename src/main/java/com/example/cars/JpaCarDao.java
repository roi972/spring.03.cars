package com.example.cars;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaCarDao implements CarDao {

    EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Car save(Car car) {
       entityManager.persist(car);
       return car;
    }

    @Override
    public void delete(Car car) {
        entityManager.remove(car);
    }

    @Override
    public Car findOne(String registration) {

        Car car = entityManager.createNamedQuery("CarGetByRegistration", Car.class)
                .setParameter("registration", registration)
                .getSingleResult();

        return car;
    }

    @Override
    public List<Car> findAll(int size, int page) {
        return
                entityManager.createNamedQuery("CarFindAll", Car.class)
                .setMaxResults(size)
                .setFirstResult(size * page)
                .getResultList();
    }

    @Override
    public List<Car> findAllCarsByColor(ColorType colorType, int size, int page) {
        return
                entityManager.createNamedQuery("CarGetAllByColor", Car.class)
                .setParameter("colorType", colorType)
                .setMaxResults(size)
                .setFirstResult(size * page)
                .getResultList();
    }
}
