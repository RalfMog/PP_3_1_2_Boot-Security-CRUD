package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }
    @Override
    public void updateUser(User user) {
         entityManager.merge(user);
    }
    @Override
    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("select a from User a", User.class);
        return query.getResultList();
    }
    @Override
    public void deleteById(Long id) {
        entityManager.remove(findById(id));
    }
    @Override
    public User findByUsername(String username) {
        return entityManager.createQuery
                ("SELECT user from User user where user.username=:username", User.class).setParameter("username", username).getSingleResult();
    }
}
