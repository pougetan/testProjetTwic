package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDao {
	public ArrayList<Ville> getInfoVille();

	public String setVille(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE);

	public ArrayList<Ville> getInfoVilles(String param);

	
	public String mettreAJour(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE);

	public String supprimerLigne(String code_commune_INSEE);
}
