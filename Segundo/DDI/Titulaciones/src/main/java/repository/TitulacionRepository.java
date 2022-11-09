package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.AbstractConnection;
import connection.H2Connection;
import model.Titulacion;

public class TitulacionRepository {

	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;";
	AbstractConnection manager = new H2Connection();

	public void insert(Titulacion titulacion) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO titulacion (titulo)" + "VALUES (?)");
			preparedStatement.setString(1, titulacion.getTitulo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}

	public List<Titulacion> listAll() {
		List<Titulacion> lista = new ArrayList<>();
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement("SELECT * FROM titulacion ");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				Titulacion titulacion = new Titulacion();
				titulacion.setId(resultSet.getInt("id"));
				titulacion.setTitulo(resultSet.getString("titulo"));
				lista.add(titulacion);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
		return lista;
	}
	
}