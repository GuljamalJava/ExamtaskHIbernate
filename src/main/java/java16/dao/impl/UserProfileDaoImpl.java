package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.HibernateConfig;
import java16.dao.UserDaoProfile;
import java16.entities.UserProfile;

public class UserProfileDaoImpl implements UserDaoProfile {
    private final EntityManager entityManager =  HibernateConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void createUserProfile(UserProfile userProfile) {
        entityManager.getTransaction().begin();
        entityManager.persist(userProfile);
        entityManager.getTransaction().commit();
    }

    @Override
    public void getUserProfileById(long id) {
    entityManager.getTransaction().begin();
    entityManager.find(UserProfile.class,id);
    entityManager.getTransaction().commit();
    }

    @Override
    public void updateUserProfileEmail(long id, String email) {
        entityManager.getTransaction().begin();

        entityManager.getTransaction().commit();

    }

    @Override
    public void deleteUserProfileById(long id) {

    }

    @Override
    public void findUserByEmail(String email) {

    }





    @Override
    public void getUsersRegisteredAfterDate() {

    }
}
