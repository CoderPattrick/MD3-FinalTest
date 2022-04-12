package dao;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {
    public static Connection connection = DAOConnection.getConnection();

    ArrayList<T> getAll() throws SQLException;
    T getById(int id) throws SQLException;
    void insertRecord(T object) throws SQLException;
    void editRecord(int idTarget,T value);
    void deleteRecord(T object);
}
