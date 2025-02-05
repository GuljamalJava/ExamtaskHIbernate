package java16.dao.impl;

import jakarta.persistence.EntityManager;
import java16.config.HibernateConfig;
import java16.dao.UserDetailDao;
import java16.entities.UserDetail;
import java16.entities.UserProfile;

public class UserDetailDaoImpl implements UserDetailDao {
    private final EntityManager entityManager =  HibernateConfig.getEntityManagerFactory().createEntityManager();
    @Override
    public void createUserDetail(long user_id, UserDetail userDetails) {
     entityManager.getTransaction().begin();
        UserProfile userProfile = entityManager.find(UserProfile.class, user_id);
        userProfile.setUserDetail(userDetails);
        entityManager.getTransaction().commit();
    }

    @Override
    public void getUserDetailsByID(long user_id) {
      entityManager.getTransaction().begin();
      entityManager.find(UserProfile.class, user_id);
      entityManager.find(UserDetail.class, user_id);
      entityManager.getTransaction().commit();
    }


    @Override
    public void updateUserDetailsAddress(long user_id, String address) {
       entityManager.getTransaction().begin();
       entityManager.find(UserProfile.class, user_id);
       entityManager.find(UserDetail.class, user_id);
       entityManager.getTransaction().commit();



    }

    @Override
    public void deleteUserDetailsByID(long user_id) {

    }

    @Override
    public void getUserDetailByAddress() {

    }

    @Override
    public void sortUsersByDateOfBirth() {

    }
}
