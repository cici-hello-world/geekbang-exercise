package org.geektimes.projects.user.service.impl;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.repository.DatabaseUserRepository;
import org.geektimes.projects.user.repository.UserRepository;
import org.geektimes.projects.user.service.UserService;
import org.geektimes.projects.user.sql.DBConnectionManager;

import java.util.logging.Logger;

public class UserServiceImp implements UserService {
    private UserRepository databaseUserRepository=new DatabaseUserRepository();
    private static Logger logger = Logger.getLogger(UserServiceImp.class.getName());
    @Override
    public boolean register(User user) throws Throwable{
        //查询手机号是否已注册过
        User existUser =databaseUserRepository.getByMobile(user.getPhoneNumber());
        if (existUser!=null){
            logger.info("电话为"+user.getPhoneNumber()+"的用户已经存在");
            throw new Exception("电话为"+user.getPhoneNumber()+"的用户已经存在");
        }
        databaseUserRepository.save(user);
        return true;
    }

    @Override
    public boolean deregister(User user) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User queryUserById(Long id) {
        return null;
    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        return null;
    }
}
