package com.mutuelle.application.testing;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

import com.mutuelle.application.dao.ClientDAO;

public class ClientDAOTest {
	ClientDAO clientDAO = new ClientDAO();
	List<String> test = new ArrayList<>();
	@Test
	public void testFiltreWithCompany() {
		//select * where nameCompany = ?
		int s = clientDAO.filtreWithCompany("YouCode").size();
		System.out.println(clientDAO.filtreWithCompany("YouCode").size());
		assertEquals(11, s);
	}
	@Test
	public void testFiltre() {
		//select where firstname = ? or lastname = ?  identite = ? or email = ?
		assertNotEquals(test, clientDAO.filtre("amal"));
	}
	@Test
	public void testSearch() {
		//select where identite = ? OR numeroBadge = ?
		assertNotEquals(test, clientDAO.search("QP7999927","K12"));
	}
	@Before
	public void testBuildData() {
		assertNotNull(clientDAO.buildData());
		assertNotNull(clientDAO.getNameCompany());
	}
}
