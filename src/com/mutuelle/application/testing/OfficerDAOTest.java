package com.mutuelle.application.testing;

import static org.junit.Assert.*;

import org.junit.Test;

import com.mutuelle.application.dao.ClientDAO;
import com.mutuelle.application.dao.OfficerDAO;

public class OfficerDAOTest {

	@Test
	public void testAuth() {
		OfficerDAO officerDAO = new OfficerDAO();
		assertTrue(officerDAO.validateLogin("amal@gmail.com", "123"));

	}

}
