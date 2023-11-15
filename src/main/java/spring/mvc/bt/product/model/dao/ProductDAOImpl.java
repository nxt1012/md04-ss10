package spring.mvc.bt.product.model.dao;

import spring.mvc.bt.product.model.entity.Product;
import spring.mvc.bt.product.model.utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements IGenericDAO<Product, Integer> {
    @Override
    public List<Product> getAll() {
        Connection connection = null;
        List<Product> productList = new ArrayList<>();
        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{call getAllProduct()}");
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return productList;
    }

    @Override
    public boolean save(Product product) {
        Connection connection = null;

        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{call addProduct(?, ?, ?, ?, ?)}");
            callableStatement.setString(1, product.getName());
            callableStatement.setDouble(2, product.getPrice());
            callableStatement.setString(3, product.getDescription());
            callableStatement.setInt(4, product.getCategoryId());
            callableStatement.setBoolean(5, product.isStatus());
            int check = callableStatement.executeUpdate();
            if (check > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public Product getById(Integer productId) {
        Product product = new Product();
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{call getProductById(?)}");
            callableStatement.setInt(1, productId);
            ResultSet resultSet = callableStatement.executeQuery();
            while (resultSet.next()) {
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setPrice(resultSet.getDouble("price"));
                product.setDescription(resultSet.getString("description"));
                product.setCategoryId(resultSet.getInt("category_id"));
                product.setStatus(resultSet.getBoolean("status"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return product;
    }

    @Override
    public boolean update(Product product, Integer entityId) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{call updateProductById(?, ?, ?, ?, ?, ?)}");
            callableStatement.setString(1, product.getName());
            callableStatement.setDouble(2, product.getPrice());
            callableStatement.setString(3, product.getDescription());
            callableStatement.setInt(4, product.getCategoryId());
            callableStatement.setBoolean(5, product.isStatus());
            callableStatement.setInt(6, entityId);
            int check = callableStatement.executeUpdate();
            if (check > 0) {
                return true;
            }        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }

    @Override
    public boolean delete(Integer productId) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            CallableStatement callableStatement = connection.prepareCall("{call deleteProductById(?)}");
            callableStatement.setInt(1, productId);
            int check = callableStatement.executeUpdate();
            if (check > 0) {
                return true;
            }        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectionDB.closeConnection(connection);
        }
        return false;
    }
}
