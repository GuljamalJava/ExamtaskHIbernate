package java16.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java16.config.HibernateConfig;
import java16.dao.UserDaoProfile;
import java16.entities.UserDetail;
import java16.entities.UserProfile;

import java.time.LocalDate;
import java.util.List;

public class UserProfileDaoImpl implements UserDaoProfile {

    private final EntityManager entityManager =  HibernateConfig.getEntityManagerFactory().createEntityManager();

    @Override
    public void createUserProfile(UserProfile userProfile) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(userProfile);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new IllegalArgumentException (e.getMessage());
        }
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
        UserProfile userProfile = entityManager.find(UserProfile.class,id);
        UserProfile merge = entityManager.merge(userProfile);
        merge.setEmail(email);
        entityManager.getTransaction().commit();
    }


    @Override
    public void deleteUserProfileById(long id) {
        entityManager.getTransaction().begin();
        UserProfile userProfile = entityManager.find(UserProfile.class, id);
        entityManager.remove(userProfile);
        entityManager.getTransaction().commit();
    }

    @Override
    public void findUserByEmail(String email) {
        entityManager.getTransaction().begin();
        Query nativeQuery =entityManager.createQuery("SELECT u FROM UserProfile u WHERE u.email = :email").setParameter("email", email);
        if(nativeQuery.getSingleResult() != null) {
            System.out.println(nativeQuery.getSingleResult()+email);
        }else {
            System.out.println("No user found with email " + email);
        }

        entityManager.getTransaction().commit();

    }

    @Override
    public List<UserDetail> getUsersRegisteredAfterDate(LocalDate date) {
        entityManager.getTransaction().begin();
        List query = entityManager.createQuery
                        ("select u from UserProfile u where u.registrationDate > :date", UserProfile.class)
                .setParameter("date", date).setMaxResults(3).getResultList();
      if(!query.isEmpty()) {
          for (Object o : query) {
              System.out.println(o);
          }
      }else {
          System.out.println("No user found with date");
      }

     entityManager.getTransaction().commit();
      return query;
    }
}
