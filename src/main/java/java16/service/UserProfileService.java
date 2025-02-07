package java16.service;

import java16.entities.UserProfile;

import java.time.LocalDate;

public interface UserProfileService {
    void createUserProfile(UserProfile userProfile);

    void getUserProfileById(long id);

    void updateUserProfileEmail(long id, String email);

    void deleteUserProfileById(long id);

    void findUserByEmail(String email);

    String getUsersRegisteredAfterDate(LocalDate localDate);
}


