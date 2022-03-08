package model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBaseDAO<VO> {
	public abstract void insert(VO entity) throws SQLException, Exception;
	public abstract void update(VO entity) throws SQLException, Exception;
	public abstract void delete(VO entity) throws SQLException;
	public abstract ResultSet findById(VO entity) throws SQLException;
}