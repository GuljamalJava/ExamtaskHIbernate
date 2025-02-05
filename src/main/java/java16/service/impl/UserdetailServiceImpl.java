package java16.service.impl;

import java16.dao.UserDetailDao;
import java16.dao.impl.UserDetailDaoImpl;
import java16.entities.UserDetail;
import java16.service.UserdetailService;

public class UserdetailServiceImpl implements UserdetailService {
 private final UserDetailDao userDetailDao = new UserDetailDaoImpl();
    @Override
    public void createUserDetail(long user_id, UserDetail userDetails) {
        userDetailDao.createUserDetail(user_id, userDetails);
    }

    @Override
    public void getUserDetailsByID(long user_id) {
     userDetailDao.getUserDetailsByID(user_id);
    }

    @Override
    public void updateUserDetailsAddress(long user_id, String userDetails) {

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
