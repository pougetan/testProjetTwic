package com.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
//@RequestMapping("/path")
class VilleController {

	@Autowired
	VilleBLO villeService;

	// Methode GET
	@RequestMapping(value = "/ville/get", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false, value = "codePostal") String monParam)
			throws ClassNotFoundException, SQLException {
		System.out.println("Appel GET");
		System.out.println("param = " + monParam);
		ArrayList<Ville> ville = villeService.getInfoVille(monParam);
		return ville;
	}

	// Methode POST
	@RequestMapping(value = "/ville/post", method = RequestMethod.POST)
	@ResponseBody
	public String appelPost(
			@RequestParam(value = "Nom_commune") String Nom_commune,
			@RequestParam(value = "Code_postal") String Code_postal,
			@RequestParam(value = "Libelle_acheminement") String Libelle_acheminement,
			@RequestParam(value = "Ligne_5") String Ligne_5,
			@RequestParam(value = "Latitude") String Latitude,
			@RequestParam(value = "Longitude") String Longitude,
			@RequestParam(value = "Code_commune_INSEE") String Code_commune_INSEE) throws ClassNotFoundException, SQLException {
		System.out.println("Appel POST");
		String msgc1 = villeService.creerVille(Nom_commune, Code_postal, Libelle_acheminement,
				Ligne_5, Latitude, Longitude, Code_commune_INSEE);
		return msgc1;
	}
	
	// Methode PUT
		@RequestMapping(value = "/ville/put", method = RequestMethod.PUT)
		@ResponseBody
		public String appelPut(
				@RequestParam(value = "Nom_commune") String Nom_commune,
				@RequestParam(value = "Code_postal") String Code_postal,
				@RequestParam(value = "Libelle_acheminement") String Libelle_acheminement,
				@RequestParam(value = "Ligne_5") String Ligne_5,
				@RequestParam(value = "Latitude") String Latitude,
				@RequestParam(value = "Longitude") String Longitude,
				@RequestParam(value = "Code_commune_INSEE") String Code_commune_INSEE) throws ClassNotFoundException, SQLException {
			System.out.println("Appel PUT");
			String msgu1 = villeService.mettreAJour(Nom_commune, Code_postal, Libelle_acheminement,
					Ligne_5, Latitude, Longitude, Code_commune_INSEE);
			return msgu1;
		}

	// Methode DELETE
	@RequestMapping(value = "/ville/delete", method = RequestMethod.DELETE)
	public String appelDelete(@RequestParam(value = "Code_commune_INSEE") String Code_commune_INSEE) throws Exception {
		System.out.println("Appel DELETE");
		String msgd1 = villeService.supprimerLigne(Code_commune_INSEE);
		return msgd1;
	}
}
