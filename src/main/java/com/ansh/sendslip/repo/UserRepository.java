package com.ansh.sendslip.repo;

import com.ansh.sendslip.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User,String> {
    Optional<User>findByClerkId(String clerkId);
    boolean existsByClerkId(String clerkId);
}
