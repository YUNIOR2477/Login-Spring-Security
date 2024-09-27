package com.app.persistence;

import com.app.entity.User.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserDAO {
    //Metodo para obtener la lista completa de usuarios
    List<UserEntity> findAll();

    //Metodo para obtener un usuario por su id
    Optional<UserEntity> findById(Long id);

    //Metodo para obtener un usuario por su nombre de usuario
    Optional<UserEntity> findByUserName(String userName);

    //Metodo para guardar un usuario
    void save(UserEntity userEntity);

    //Metodo para eliminar un usuario
    void deleteById(Long id);
}
