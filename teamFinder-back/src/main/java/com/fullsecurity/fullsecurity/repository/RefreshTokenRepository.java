package com.fullsecurity.fullsecurity.repository;

import com.fullsecurity.fullsecurity.models.RefreshToken;
import com.fullsecurity.fullsecurity.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    @Modifying  //enhance the @Query so we can execute select, insert,update,delete
    int deleteByUser(User user);
}
