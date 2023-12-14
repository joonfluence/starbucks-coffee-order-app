package com.joonfluence.starbucks.domain.user.auth.repository;

import com.joonfluence.starbucks.domain.user.auth.entity.RefreshToken;
import com.joonfluence.starbucks.global.utils.UuidGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class RefreshTokenRepositoryTest {

    @Autowired
    RefreshTokenRepository repository;

<<<<<<< HEAD
<<<<<<< HEAD
=======
    @BeforeEach
    void setUp() {
    }

>>>>>>> 3d44ca5 (feat(Auth) : Redis에 RefreshToken 정보 저장)
=======
>>>>>>> b211f2e (test(Auth) : 회원가입 통합테스트)
    @DisplayName("생성된 Repository RefreshToken 값과 조회된 값은 서로 일치해야 한다.")
    @Test
    void test(){
        // given
        String generated = UuidGenerator.generate();
        RefreshToken refreshToken = RefreshToken.builder().uuid(generated).build();
        // when
        RefreshToken saved = repository.save(refreshToken);
        RefreshToken foundedUuid = repository.findById(saved.getUuid()).orElseThrow();

        System.out.println("generated = " + generated);
        System.out.println("foundedUuid.getUuid() = " + foundedUuid.getUuid());;

        // then
        Assertions.assertEquals(saved.getUuid(), foundedUuid.getUuid());
        Assertions.assertEquals(saved.getUuid(), refreshToken.getUuid());
    }
}