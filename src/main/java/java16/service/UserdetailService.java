package java16.service;

import java16.entities.UserDetail;

public interface UserdetailService {
    void  createUserDetail  (long user_id, UserDetail userDetails);
    void getUserDetailsByID(long user_id);
    void updateUserDetailsAddress(long user_id, String userDetails);
    void deleteUserDetailsByID(long user_id);
    void getUserDetailByAddress();
    void sortUsersByDateOfBirth();
}
