package java16.dao;

import java16.entities.UserProfile;

public interface UserDaoProfile {
    void createUserProfile(UserProfile userProfile) ;
    void getUserProfileById(long id) ;
    void updateUserProfileEmail(long id, String email);
     void deleteUserProfileById(long id);
     void findUserByEmail(String email);
     void getUsersRegisteredAfterDate();
}
