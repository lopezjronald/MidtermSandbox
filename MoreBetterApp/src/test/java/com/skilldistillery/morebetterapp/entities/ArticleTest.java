package com.skilldistillery.morebetterapp.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArticleTest {

	private static EntityManagerFactory emf;
	private EntityManager em;

	private Article article;

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
		article = em.find(Article.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		article = null;
	}

	@Test
	@DisplayName("testing that address mapping work")
	void test1() {
		assertNotNull(article);
		assertEquals("Do you have a long-term plan", article.getTitle());
		assertEquals("Despite the recent recovery in the market, stocks remain down by more than 12% from the February peak, and about 9% year-to-date. Meanwhile, the story for the first three weeks of May has been one of running in place.", article.getContents());
		assertEquals("2020-04-10 10:25:30", article.getCreated());

	}

}
