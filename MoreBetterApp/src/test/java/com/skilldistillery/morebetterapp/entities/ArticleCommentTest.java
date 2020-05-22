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

class ArticleCommentTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private ArticleComment articleComment;
	
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
		articleComment = em.find(ArticleComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		articleComment = null;
	}

	@Test
	@DisplayName("Testing That ArticleComment class mapping is work")
	void test1() {
		assertNotNull(articleComment);
		assertEquals("Great article", articleComment.getContent());
		assertEquals(2020, articleComment.getCreatedAt().getYear());
		assertEquals(5, articleComment.getCreatedAt().getMonthValue());
		assertEquals(22, articleComment.getCreatedAt().getDayOfMonth());
	}

}
