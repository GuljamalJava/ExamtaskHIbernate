package java16.dao;

import java16.entities.UserDetail;

import java.time.LocalDate;

public interface  UserDetailDao {
    void  createUserDetail  (long user_id, UserDetail userDetails);
    void getUserDetailsByID(long user_id);
    void updateUserDetailsAddress(long user_id, String address);
    void deleteUserDetailsByID(long user_id);
    void getUserDetailByAddress(String address);
    void sortUsersByDateOfBirth();



}
