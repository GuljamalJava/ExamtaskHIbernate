package java16.service.impl;

import java16.dao.UserDaoProfile;
import java16.dao.impl.UserProfileDaoImpl;
import java16.entities.UserProfile;
import java16.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService {
UserDaoProfile userDaoProfile = new UserProfileDaoImpl();

    @Override
    public void createUserProfile(UserProfile userProfile) {
        userDaoProfile.createUserProfile(userProfile);
    }

    @Override
    public void getUserProfileById(long id) {
       userDaoProfile.getUserProfileById(id);
    }

    @Override
    public void updateUserProfileEmail(long id, String email) {
         userDaoProfile.updateUserProfileEmail(id, email);
    }

    @Override
    public void deleteUserProfileById(long id) {
      userDaoProfile.deleteUserProfileById(id);
    }

    @Override
    public void findUserByEmail() {

    }

    @Override
    public void getUsersRegisteredAfterDate() {

    }
}
