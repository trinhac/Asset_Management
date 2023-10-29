package Models;

import android.util.Log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Models.SQLServer.SQLServer;

public class Asset {
    private Connection connect;
    private String asset_id, asset_name, asset_category, quantity, status;

    public Asset(String asset_id, String asset_name, String asset_category, String quantity, String status) {
        this.asset_id = asset_id;
        this.asset_name = asset_name;
        this.asset_category = asset_category;
        this.quantity = quantity;
        this.status = status;
    }

    public Asset() {

    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(String asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getAsset_category() {
        return asset_category;
    }

    public void setAsset_category(String asset_category) {
        this.asset_category = asset_category;
    }

    public List<Asset> GetAllAsset() {
        List<Asset> listAsset = new ArrayList<>();
        try {
            SQLServer connection = new SQLServer();
            connect = connection.ConnectionSql();
            if (connect != null) {
                String query = "select [Asset_id],[Asset_Name],[Category_Name],[Quantity],[Status]" +
                        "from Asset a inner join [dbo].[Category] c on a.[Category_id] = c.Category_id ";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    String id = rs.getString("Asset_id");
                    String name = rs.getString("Asset_Name");
                    String categoryName = rs.getString("Category_Name");
                    String quantity = rs.getString("Quantity");
                    String status = rs.getString("Status");

                    if(status.equalsIgnoreCase("0"))
                        status = "Not Available";
                    else status = "Available";

                    Asset a = new Asset(id, name, categoryName, quantity, status);
                    listAsset.add((a));

                }
                return listAsset;

            }
        } catch (Exception e) {
            Log.e(e.getMessage(), "Log error");
        }
        return null;
    }

    public List<Asset> GetAssetByCategoryName(String categoryName) {
        List<Asset> listAsset = new ArrayList<>();
        try {
            SQLServer connection = new SQLServer();
            connect = connection.ConnectionSql();
            if (connect != null) {
                String query = "SELECT a.* " +
                        "FROM [dbo].[Asset] a " +
                        "INNER JOIN [dbo].[Category] c ON a.Category_id = c.Category_id " +
                        "WHERE c.Category_Name = ? AND a.Status = 1";
                PreparedStatement preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, categoryName);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("Asset_id");
                    String name = rs.getString("Asset_Name");
                    String categoryId = rs.getString("Category_id");
                    String quantity = rs.getString("Quantity");
                    String status = rs.getString("Status");
                    Asset a = new Asset(id,name,categoryId,quantity,status);
                    listAsset.add((a));

                }
                return listAsset;
            }
        } catch (Exception e) {
            Log.e(e.getMessage(), "Log error");
        }
        return null;
    }

    public void AddAsset(){
        try {
            SQLServer connection = new SQLServer();
            connect = connection.ConnectionSql();
            if (connect != null) {
                String query = "INSERT INTO [dbo].[Asset] ([Asset_Name],[Category_id],[Quantity],[Status])" +
                        "VALUES (?, ?, ?, ?)";
                PreparedStatement preparedStatement = connect.prepareStatement(query);
                preparedStatement.setString(1, asset_name);
                preparedStatement.setString(2, asset_category);
                preparedStatement.setString(3, quantity);
                preparedStatement.setString(4, status);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

