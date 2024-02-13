package com.sinan.userservice;

import com.sinan.userservice.model.User;
import com.sinan.userservice.repository.UserRepository;
import com.sinan.userservice.test.testCrud;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceApplicationTests implements testCrud {

	@MockBean
	private UserRepository userRepository;
	@Autowired
	UserServiceApplicationTests(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Test
	@Override
	public void testCreate() {
		User user = User
				.builder()
				.username("Sinan test")
				.password("test123")
				.role("ADMIN test")
				.build();

		userRepository.save(user);

		assertNotNull(userRepository.findById("1L")
				.stream()
				.findAny().isPresent());
	}

	@Test
	@Override
	public void testList() {

	}
	@Test
	@Override
	public void testFindById() {
		Optional<User> userOptional = userRepository.findById("1L");

		if (userOptional.isPresent()) {
			User user = userOptional.get();
			assertEquals("Sinan test", user.getUsername());
		} else {
			fail("Kullanıcı bulunamadı");
		}
	}


	@Test
	@Override
	public void testUpdate() {
		User user = userRepository.findById("1L").get();
		user.setUsername("Sinan 33 Test");

		userRepository.save(user);

		assertNotEquals("Sinan Test", userRepository.findById("1L").get().getUsername());

	}
	@Test
	@Override
	public void testDelete() {
		userRepository.deleteById("1L");

		assertThat(userRepository.existsById("1L")).isFalse();

	}
}
