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

class CategoryTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Category category;
	
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
		category = em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		category = null;
	}

	@Test
	@DisplayName("testing that category mapping work")
	void test1() {

		assertNotNull(category);
		assertEquals("Finance", category.getName());
		assertEquals(null, category.getLogo());
		assertEquals(null, category.getDescription());
		
		
	}

	// SELECT event.title FROM category JOIN event ON category.id = event.category_id WHERE category.id = 1;

	@Test
	@DisplayName("testing that category to event works")
	void test2() {
		assertNotNull(category);
		assertEquals("Why financial literacy matters", category.getEvents().get(0).getTitle()); // Need to figure out the query statement to test
		
	}
	
	
}
