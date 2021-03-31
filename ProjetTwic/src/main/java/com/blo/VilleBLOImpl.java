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

	public void creerVille(Ville ville) {
		villeDao.setVille(ville);
	}

	public void mettreAJour(Ville ville) {
		villeDao.mettreAJour(ville);
	}

	public void supprimerLigne(String code_commune_INSEE) {
		villeDao.supprimerLigne(code_commune_INSEE);
	}

}
