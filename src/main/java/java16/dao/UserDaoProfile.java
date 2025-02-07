package java16.dao;

import java16.entities.UserDetail;
import java16.entities.UserProfile;

import java.time.LocalDate;
import java.util.List;

public interface UserDaoProfile {

    void createUserProfile(UserProfile userProfile);

    void getUserProfileById(long id);

    void updateUserProfileEmail(long id, String email);

    void deleteUserProfileById(long id);

    void findUserByEmail(String email);

    List<UserDetail> getUsersRegisteredAfterDate(LocalDate date);

}
