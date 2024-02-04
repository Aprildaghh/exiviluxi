package com.aprildaghh.exiviluxi.Service;

import com.aprildaghh.exiviluxi.Dao.UserDao;
import com.aprildaghh.exiviluxi.Model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public void addUser(UserEntity user)
    {
        userDao.create(user);
    }

    public void deleteUser(int id)
    {
        userDao.deleteById(id);
    }

    public void putUser(UserEntity user)
    {
        userDao.put(user);
    }

    public UserEntity getUser(int id)
    {
        return userDao.readById(id);
    }

}
