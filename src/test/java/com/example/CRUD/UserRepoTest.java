//package com.example.CRUD;
//
//import com.example.CRUD.UserModel.User;
//import com.example.CRUD.UserModel.UserRepo;
//import org.junit.jupiter.api.Assertions;
//import org.hamcrest.MatcherAssert.*;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.Optional;
//
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJdbcTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(value = false)
//public class UserRepoTest {
//    @Autowired
//    private UserRepo repo;
//    @Test
//    public void testAddNew(){
//        User user = new User();
//        user.setName("Tyson");
//        user.setEmail("Tyson@gmail.com");
//        user.setAge(27);
//
//        User added = repo.save(user);
//
//
//    //   Assertions.assertThat(added).isNotNull
//      //  Assertions.assertThat(added.getId()).isGreaterThan(0);
//
//    }
//
//    @Test
//    public void testListAll(){
//
//        Iterable<User> users = repo.findAll();
//       // Assertions.assertAll(users).hasGreaterThan(0);
//
//        for(User user : users ){
//            System.out.println(user);
//        }
//
//
//
//
//    }
//
//    @Test
//    public void TestUpdate(){
//        Integer userId = 1;
//        Optional<User> optionalUser = repo.findById(userId);
//        User user = optionalUser.get();
//        user.setEmail("tyson@mail.com");
//        repo.save(user);
//
//        User Updated = repo.findById(userId).get();
//
//       org.assertj.core.api.Assertions.assertThat(Updated.getEmail()).isEqualTo("tyson@mail.com");
//    }
//
//
//    @Test
//    public void TestGet(){
//        Integer userId = 2;
//        Optional<User> optionalUser = repo.findById(userId);
//
//        //   Assertions.assertThat(optionalUser).isPresent();
//
//
//
//
//
//
//    }
//
//
//    @Test
//    public void TestDelete(){
//        Integer userId = 1;
//       repo.deleteById(userId);
//        Optional<User> optionalUser = repo.findById(userId);
//        //   Assertions.assertThat(optionalUser).isPresent()
//
//
//
//    }
//
//
//}
