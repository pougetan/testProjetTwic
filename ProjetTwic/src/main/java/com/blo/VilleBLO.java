package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {
	public ArrayList<Ville> getInfoVille(String monParam);

	public String creerVille(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE);
	
	public String mettreAJour(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE);

	public String supprimerLigne(String code_commune_INSEE);

}