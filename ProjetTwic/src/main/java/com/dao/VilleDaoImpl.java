package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDaoImpl implements VilleDao {
	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Connection con = null;

		String requete = "SELECT * FROM ville_france";

		try {
			con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(requete);
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setNomCommune(rs.getString("Nom_commune"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne(rs.getString("Ligne_5"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
				villes.add(ville);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return villes;
	}

	public ArrayList<Ville> getInfoVilles(String param) {
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Ville ville = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = JDBCConfiguration.getConnection();
			stmt = con.prepareStatement("SELECT * FROM ville_france WHERE Code_postal = ?;");
			stmt.setString(1, param);
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				ville = new Ville();
				ville.setCodeCommune(rs.getString("Code_commune_INSEE"));
				ville.setCodePostal(rs.getString("Code_postal"));
				ville.setNomCommune(rs.getString("Nom_commune"));
				ville.setLibelleAcheminement(rs.getString("Libelle_acheminement"));
				ville.setLigne(rs.getString("Ligne_5"));
				ville.setLatitude(rs.getString("Latitude"));
				ville.setLongitude(rs.getString("Longitude"));
				villes.add(ville);
			}
			return villes;
		} catch (SQLException e) {
			System.out.println("Une erreur s'est produite.");
			return null;
		}
	}

	public String setVille(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE ) {
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate(
					"Insert into ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
							+ " values(" + Code_commune_INSEE + ",'" + Nom_commune + "','"
							+ Libelle_acheminement + "','" + Ligne_5 + "'," + Latitude
							+ "," + Code_postal + "," + Longitude + ")");
			return "Bravo, la création de votre ville a fonctionnée";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Echec, la création de votre ville n'a pas fonctionnée";
		}
	}

	
	public String mettreAJour(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE ) {
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("UPDATE ville_france SET Nom_commune=' " + Nom_commune + "', Code_postal='"
					+ Code_postal + "', Libelle_acheminement='" + Libelle_acheminement
					+ "', Ligne_5 = '" + Ligne_5 + "', Latitude='" + Latitude + "', Longitude='"
					+ Longitude + "'  WHERE Code_commune_INSEE=' " + Code_commune_INSEE + "'");
			return "Bravo, la mise à jour de votre ville a fonctionnée";

		} catch (SQLException e) {
			e.printStackTrace();
			return "Echec, la mise à jour de votre ville n'a pas fonctionnée";
		}
	}

	@Override
	public String supprimerLigne(String code_commune_INSEE) {
		try {
			Connection con = JDBCConfiguration.getConnection();
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE = '" + code_commune_INSEE + "'");
			return "Bravo, la suppression de votre ville a fonctionnée";
		} catch (SQLException e) {
			e.printStackTrace();
			return "Echec, la suppression de votre ville n'a pas fonctionnée";
		}
	}
}
