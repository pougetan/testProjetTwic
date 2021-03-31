package com.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class VilleTest {

	@Test
	public void testgetCodeCommune() {
		Ville ville = new Ville();
		ville.setCodeCommune("code");
		assertEquals(ville.getCodeCommune(), "code");
	}

	@Test
	public void testgetNomCommune() {
		Ville ville = new Ville();
		ville.setNomCommune("nom");
		assertEquals(ville.getNomCommune(), "nom");
	}

	@Test
	public void testgetCodePostal() {
		Ville ville = new Ville();
		ville.setCodePostal("codePostal");
		assertEquals(ville.getCodePostal(), "codePostal");
	}

	@Test
	public void testgetLibelleAcheminement() {
		Ville ville = new Ville();
		ville.setLibelleAcheminement("libelle");
		assertEquals(ville.getLibelleAcheminement(), "libelle");
	}

	@Test
	public void testgetLigne() {
		Ville ville = new Ville();
		ville.setLigne("ligne");
		assertEquals(ville.getLigne(), "ligne");
	}
	
	@Test
	public void testgetLongitude() {
		Ville ville = new Ville();
		ville.setLongitude("longitude");
		assertEquals(ville.getLongitude(), "longitude");
	}
	
	@Test
	public void testgetLatitude() {
		Ville ville = new Ville();
		ville.setLatitude("latitude");
		assertEquals(ville.getLatitude(), "latitude");
	}

}
