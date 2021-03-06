package com.pozarycki.travelerr.repository;

import com.pozarycki.travelerr.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneByUserName(String userName);

    Optional<User> findOneByEmail(String email);

}
