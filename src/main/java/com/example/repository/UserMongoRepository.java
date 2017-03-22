package com.example.repository;

import com.example.domain.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Shaurav on 3/17/2017.
 */
public interface UserMongoRepository extends CrudRepository<User, String> {
     User findByUsername(String username);

}
