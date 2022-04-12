package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryDAO implements DAO<Category>{
    private final String GET_ALL = "select * from category;";
    private final String GET_BY_ID = "select * from category where id = ?";

    @Override
    public ArrayList<Category> getAll() throws SQLException {
        ArrayList<Category> categories = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(GET_ALL);
        ResultSet rS = pS.executeQuery();
        while(rS.next()){
            int id = rS.getInt("id");
            String name = rS.getString("name");
            Category category = new Category(id,name);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Category getById(int id) throws SQLException {
        Category category = new Category();
        PreparedStatement pS = connection.prepareStatement(GET_BY_ID);
        pS.setInt(1,id);
        ResultSet rS = pS.executeQuery();
        while(rS.next()){
            String name = rS.getString("name");
            category = new Category(id,name);
        }
        return category;
    }

    @Override
    public void insertRecord(Category object) {

    }

    @Override
    public void editRecord(int idTarget, Category value) {

    }

    @Override
    public void deleteRecord(Category object) {

    }
}
