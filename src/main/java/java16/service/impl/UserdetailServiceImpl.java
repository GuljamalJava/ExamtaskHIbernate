package java16.service.impl;

import java16.dao.UserDetailDao;
import java16.dao.impl.UserDetailDaoImpl;
import java16.entities.UserDetail;
import java16.service.UserdetailService;

import java.time.LocalDate;

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
        userDetailDao.updateUserDetailsAddress(user_id, userDetails);
    }

    @Override
    public void deleteUserDetailsByID(long user_id) {

        userDetailDao.deleteUserDetailsByID(user_id);
    }

    @Override
    public void getUserDetailByAddress(String address) {

        userDetailDao.getUserDetailByAddress(address);
    }

    @Override
    public void sortUsersByDateOfBirth() {
        userDetailDao.sortUsersByDateOfBirth();
    }
}
