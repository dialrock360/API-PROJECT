package com.yemmback.store.repository;

import com.yemmback.store.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    @Query("SELECT u FROM User u WHERE u.username = ?1 OR u.email = ?1")
    User findBylogin(String name);


    @Query("SELECT v FROM User v where v.flag = :flaguser ")
    List<User> findUsers(@Param("flaguser") int flaguser);

    @Query("SELECT v FROM User v where v.id = :id and v.flag = :flaguser")
    User findUser(@Param("id") Long id, @Param("flaguser") int flaguser);

    User findUserByPeopleid(Long peopleid);
}
