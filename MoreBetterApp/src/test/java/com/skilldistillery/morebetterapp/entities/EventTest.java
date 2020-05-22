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

class EventTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Event event;

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
		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		event = null;
	}

	@Test
	@DisplayName("testing that event mappings work")
	void test1() {

		assertNotNull(event);
		assertEquals("Why financial literacy matters", event.getTitle());
		assertEquals("Financial literacy cannot predict or remedy a crisis, but financial education will play a pivotal role in the economic recovery of our country.", event.getDescription());
	}
	
	// SELECT category.name FROM category JOIN event ON category.id = event.category_id WHERE event.id = 1;
	@Test
	@DisplayName("testing that event to category works")
	void test2() {
		assertNotNull(event);
		assertEquals("Finance", event.getCategory().getName());
	}

}
