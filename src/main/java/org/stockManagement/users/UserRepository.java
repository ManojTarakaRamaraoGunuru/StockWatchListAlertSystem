package org.stockManagement.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Spring Data JPA automatically provides the implementation of this optional functions at runtime.
//  It uses method name conventions like findByX, countByX, existsByX etc.
//  Example:
//
// Method Name	                            Generated Query (JPQL)
// findByUsername(String u)	                SELECT u FROM User u WHERE u.username = ?1
// existsByEmail(String e)	                SELECT COUNT(u) > 0 FROM User u WHERE u.email = ?1

// if the method name is complex:
// @Query("SELECT u FROM User u WHERE u.username = :username AND u.status = true")
// User findActiveUserByUsername(@Param("username") String username);


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    // Optional: find by username
    User findByUsername(String username);
}
