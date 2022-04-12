package dao;

import model.Category;
import model.Product;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDAO implements DAO<Product>{
    public static final String INSERT_RECORD = "insert into product (name,price,quantity,color,description,category_id) values (?,?,?,?,?,?)";
    private final String GET_ALL_SQL = "select p.id as product_id,p.name as product_name,price,quantity,color,description,category_id,c.name as category from product p join category c on c.id = p.category_id;";

    @Override
    public ArrayList<Product> getAll() throws SQLException {
        ArrayList<Product> list = new ArrayList<>();
        PreparedStatement pS = connection.prepareStatement(GET_ALL_SQL);
        ResultSet rS = pS.executeQuery();
        while (rS.next()){
            int product_id = rS.getInt("product_id");
            String product_name = rS.getString("product_name");
            double price = rS.getDouble("price");
            int quantity = rS.getInt("quantity");
            String color = rS.getString("color");
            String description = rS.getString("description");
            int category_id = rS.getInt("category_id");
            String category = rS.getString("category");

            Category category1 = new Category(category_id,category);
            Product product = new Product(product_id,product_name,price,quantity,color,description,category1);
            list.add(product);
        }
        return list;
    }

    @Override
    public Product getById(int id) {
        return null;
    }

    @Override
    public void insertRecord(Product object) throws SQLException {
        PreparedStatement pS = connection.prepareStatement(INSERT_RECORD);
        pS.setString(1,object.getName());
        pS.setDouble(2,object.getPrice());
        pS.setInt(3,object.getQuantity());
        pS.setString(4,object.getColor());
        pS.setString(5,object.getDescription());
        pS.setInt(6,object.getCategory().getId());
        pS.execute();
    }

    @Override
    public void editRecord(int idTarget, Product value) {

    }

    @Override
    public void deleteRecord(Product object) {

    }
}
