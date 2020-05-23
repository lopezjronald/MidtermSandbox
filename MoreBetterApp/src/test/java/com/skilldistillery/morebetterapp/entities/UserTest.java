package com.skilldistillery.morebetterapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

	@Test // select article.title from article join user on article.mentor_id = user.id
			// where user.id =1;
	@DisplayName("testing that userAuthor to article mapping work")
	void test2() {

		assertNotNull(user);
		assertNotNull(user.getWrittenArticles());
		assertTrue(user.getWrittenArticles().size() > 0);
		assertEquals("Do you have a long-term plan ", user.getWrittenArticles().get(0).getTitle());
	}

	@Test
	@DisplayName("testing that user to category mapping work")
	void test3() {

		assertNotNull(user);
		assertNotNull(user.getCategories());
		assertTrue(user.getCategories().size() > 0);
		assertEquals("Finance", user.getCategories().get(0).getName());

	}

	@Test
	@DisplayName("testing that user to event thru event_participant mapping work")
	void test4() {
		// select event.title from event join event_participant on
		// event_participant.event_id = event.id
		// join user on event_participant.user_id = user.id where user.id = 1;

		assertNotNull(user);
		assertNotNull(user.getEventsAttended()); // get events to eventsAttended
		assertTrue(user.getEventsAttended().size() > 0);
		assertEquals("Why financial literacy matters", user.getEventsAttended().get(0).getTitle());

	}

	@Test
	@DisplayName("testing that userOwner to eventOwned mapping work")
	void test5() {
		assertNotNull(user);
		assertNotNull(user.getEventsOwned());
		assertTrue(user.getEventsOwned().size() > 0);

	}

	@Test
	@DisplayName("testing that userReader to readArticles thru article_comment mapping work")
	void test6() {

		assertNotNull(user);
		assertNotNull(user.getReadArticles());
		assertTrue(user.getReadArticles().size() > 0);
		assertEquals("Do you have a long-term plan ", user.getReadArticles().get(0).getTitle());

	}

}