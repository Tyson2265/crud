package com.example.CRUD.UserModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User ,Integer> {
    public Long countById (Integer id);



}
