package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.PreparedStatement;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import org.springframework.stereotype.Repository;

import java.beans.Customizer;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDaoImpl implements VilleDao {
	private static final Logger LOGGER = Logger.getLogger(Customizer.class);
	private JDBCConfiguration jdbcConfiguration;
	
	public VilleDaoImpl(JDBCConfiguration jdbcConfiguration) {
		this.jdbcConfiguration = jdbcConfiguration;
	}
	
	public ArrayList<Ville> getInfoVille() {
		Ville ville = null;
		ArrayList<Ville> villes = new ArrayList<Ville>();
		Statement stmt = null;
		ResultSet rs = null;
		Connection con = null;

		String requete = "SELECT * FROM ville_france";

		try {
			con = jdbcConfiguration.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(requete);
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
			LOGGER.log(Level.ERROR, e);
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, e);
			} // Multiple streams were opened. Only the last is closed.
			finally {
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					LOGGER.log(Level.ERROR, e);
				} 
			}
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
			con = jdbcConfiguration.getConnection();
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
			LOGGER.log(Level.ERROR, e);
			return null;
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, e);
			} 
			finally {
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					LOGGER.log(Level.ERROR, e);
				} 
			}
		}
	}

	public String setVille(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE ) {
		Statement stmt = null;
		Connection con = null;
		try {
			con = jdbcConfiguration.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate(
					"Insert into ville_france(Code_commune_INSEE,Nom_commune,Libelle_acheminement,Ligne_5,Latitude,Code_postal,Longitude)"
							+ " values(" + Code_commune_INSEE + ",'" + Nom_commune + "','"
							+ Libelle_acheminement + "','" + Ligne_5 + "'," + Latitude
							+ "," + Code_postal + "," + Longitude + ")");
			return "Bravo, la création de votre ville a fonctionnée";
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, e);
			return "Echec, la création de votre ville n'a pas fonctionnée";
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, e);
			} 
		}
	}

	
	public String mettreAJour(String Nom_commune, String Code_postal, String Libelle_acheminement, String Ligne_5,
			String Latitude, String Longitude , String Code_commune_INSEE ) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = jdbcConfiguration.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate("UPDATE ville_france SET Nom_commune=' " + Nom_commune + "', Code_postal='"
					+ Code_postal + "', Libelle_acheminement='" + Libelle_acheminement
					+ "', Ligne_5 = '" + Ligne_5 + "', Latitude='" + Latitude + "', Longitude='"
					+ Longitude + "'  WHERE Code_commune_INSEE=' " + Code_commune_INSEE + "'");
			return "Bravo, la mise à jour de votre ville a fonctionnée";

		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, e);
			return "Echec, la mise à jour de votre ville n'a pas fonctionnée";
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, e);
			} // Multiple streams were opened. Only the last is closed.
		}
	}  

	@Override
	public String supprimerLigne(String code_commune_INSEE) {
		Connection con = null;
		Statement stmt = null;
		try {
			con = jdbcConfiguration.getConnection();
			stmt = con.createStatement();
			stmt.executeUpdate("DELETE FROM ville_france WHERE Code_commune_INSEE = '" + code_commune_INSEE + "'");
			return "Bravo, la suppression de votre ville a fonctionnée";
		} catch (SQLException e) {
			LOGGER.log(Level.ERROR, e);
			return "Echec, la suppression de votre ville n'a pas fonctionnée";
		} finally {

			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				LOGGER.log(Level.ERROR, e);
			} // Multiple streams were opened. Only the last is closed.
		}
	}
}
