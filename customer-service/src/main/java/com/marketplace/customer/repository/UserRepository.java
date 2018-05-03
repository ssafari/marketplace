/**
 * 
 */
package com.marketplace.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.marketplace.customer.domains.UserEntity;

/**
 * @author sepehrsafari
 *
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	@Query("select u from UserEntity u where u.firstName = :firstName or u.lastName = :lastName")
	UserEntity find(@Param("lastName") String lastName, @Param("firstName") String firstName);
	
/*	@Query("select u from customers where u.first_name = :firstname and u.last_name = :lastname")
	UserEntity findByLastNameAndFirstName(@Param("lastname") String lastname, @Param("firstname") String firstname);
*/
}
