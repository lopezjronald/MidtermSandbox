package com.skilldistillery.morebetterapp.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("MoreBetterPU");

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		user = null;
	}

	@Test
	@DisplayName("testing that user mapping work")
	void test1() {

		assertNotNull(user);
		assertEquals("Joe", user.getFirstName());
		assertEquals("Mama", user.getLastName());
		assertEquals("joe.mama@user.mail", user.getEmail());
		assertEquals("STANDARD", user.getRole());
		assertEquals(35, user.getAge());
		assertEquals("joemama", user.getUsername());
		assertEquals("joemama", user.getPassword());
		assertEquals(1, user.getEnabled());
		assertEquals(null, user.getPicture());
		assertEquals(null, user.getBiography());
		
	}

}
