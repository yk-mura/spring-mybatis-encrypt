package com.ykmura.springmybatisencrypt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.ykmura.springmybatisencrypt.AbstractTest;
import com.ykmura.springmybatisencrypt.model.User;

public class UserRepositoryTest extends AbstractTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DatabaseSetup("/db/user.xml")
    public void findById() {
        User user = userRepository.findById(1);

        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("NAME");
        assertThat(user.getEmail()).isEqualTo("name@example.com");
    }

    @Test
    @DatabaseSetup("/db/user.xml")
    public void findByIdWithoutDecipher() {
        User user = userRepository.findByIdWithoutDecipher(1);

        assertThat(user.getId()).isEqualTo(1);
        assertThat(user.getName()).isEqualTo("QDPH");
        assertThat(user.getEmail()).isEqualTo("qdph@hadpsoh.frp");
    }

    @Test
    @DatabaseSetup("/db/empty.xml")
    public void insert() {
        User user1 = new User("name", "name@example.com");
        userRepository.insert(user1);

        User user2 = userRepository.findById(user1.getId());

        assertThat(user2).usingRecursiveComparison().ignoringFields("id").isEqualTo(user1);
    }
}
