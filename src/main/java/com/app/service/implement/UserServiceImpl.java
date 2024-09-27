package com.app.service.implement;

import com.app.entity.User.UserEntity;
import com.app.persistence.IUserDAO;
import com.app.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public List<UserEntity> findAll() {
        return userDAO.findAll();
    }

    @Override
    public Optional<UserEntity> findById(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Optional<UserEntity> findByUserName(String userName) {
        return userDAO.findByUserName(userName);
    }

    @Override
    public void save(UserEntity userEntity) {
        userDAO.save(userEntity);
    }

    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
