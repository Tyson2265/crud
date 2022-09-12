package com.example.CRUD.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {
    @Autowired
    private UserRepo repo;

    public List<User> ListAll(){
        return (List<User>) repo.findAll();
    }


    public void save(User user) {

        repo.save(user);

    }

    public User getById(Integer id) throws UserNotFoundException {
       Optional<User> results = repo.findById(id);
       if(results.isPresent()){
           return results.get();

       }
       throw new UserNotFoundException("No User with that ID "+ id);

    }

    public void deleteById(Integer id){
        Long count = repo.countById(id);

        if(count == null || count ==0){
            try {
                throw new UserNotFoundException("No User with that ID "+ id);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        repo.deleteById(id);

    }
}
