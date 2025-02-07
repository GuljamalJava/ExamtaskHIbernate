package java16.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java16.config.HibernateConfig;
import java16.dao.UserDetailDao;
import java16.entities.UserDetail;
import java16.entities.UserProfile;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
      entityManager.find(UserDetail.class, user_id);
      entityManager.getTransaction().commit();
    }


    @Override
    public void updateUserDetailsAddress(long user_id, String address) {
       entityManager.getTransaction().begin();
        UserDetail userDetail = entityManager.find(UserDetail.class, user_id);
        userDetail.setAddress(address);
        entityManager.getTransaction().commit();
    }

    @Override
    public void getUserDetailByAddress(String address) {
      entityManager.getTransaction().begin();
        TypedQuery<UserDetail> query = entityManager.createQuery(
                "SELECT u FROM UserDetail u WHERE u.address = :address", UserDetail.class);
        query.setParameter("address", address);
        if (query != null) {
            System.out.println("UserDetail found: " + query.getSingleResult());
        } else {
            System.out.println("No user found with the address: " + address);
        }

        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteUserDetailsByID(long user_id) {
        try {
            entityManager.getTransaction().begin();
            UserDetail userDetail = entityManager.find(UserDetail.class, user_id);
            if (userDetail != null) {
                entityManager.remove(userDetail);
                System.out.println("User with ID " + user_id + " has been deleted.");
            } else {
                System.out.println("User with ID " + user_id + " not found.");
            }
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void sortUsersByDateOfBirth() {
        try {

            List<UserDetail> userDetails = entityManager.createNativeQuery("SELECT * from user_details u order by u.dateofbirth desc ", UserDetail.class)
                    .getResultList();
            for (UserDetail userDetail : userDetails) {
                System.out.println(" get all: " + userDetail);
            }

        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

    }
}
