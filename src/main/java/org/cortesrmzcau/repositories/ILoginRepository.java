package org.cortesrmzcau.repositories;

import org.cortesrmzcau.models.entity.UsersEntity;
import org.springframework.data.repository.CrudRepository;

import java.math.BigInteger;
import java.util.Optional;

public interface ILoginRepository extends CrudRepository<UsersEntity, BigInteger> {
    Optional<UsersEntity> findByEmail(String tuEmail);
}
