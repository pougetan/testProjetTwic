package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDao;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {
	@Autowired
	private VilleDao villeDao;

	public ArrayList<Ville> getInfoVille(String param) {
		ArrayList<Ville> ville = null;
		if (param != null) {
			ville = villeDao.getInfoVilles(param);
		} else {
			ville = villeDao.getInfoVille();
		}
		return ville;
	}

	public String creerVille(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE) {
		String msgc = villeDao.setVille(Nom_commune, Code_postal, Libelle_acheminement,
				Ligne_5, Latitude, Longitude, Code_commune_INSEE);
		return msgc;
	}

	
	public String mettreAJour(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE) {
		String msgu = villeDao.mettreAJour(Nom_commune, Code_postal, Libelle_acheminement,
				Ligne_5, Latitude, Longitude, Code_commune_INSEE);
		return msgu;
				
	}

	public String supprimerLigne(String code_commune_INSEE) {
		String msgd = villeDao.supprimerLigne(code_commune_INSEE);
		return msgd;
	}

}
