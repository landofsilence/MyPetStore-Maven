package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.LineItem;
import per.jxnflzc.util.DBUtil;
import per.jxnflzc.persistence.LineItemDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {

    public List<LineItem> getLineItemsByOrderId(int orderId){
        List<LineItem> lineItems = new ArrayList<LineItem>();
        try{
            final String GET_ITEM = "    SELECT\n" +
                    "      ORDERID,\n" +
                    "      LINENUM AS lineNumber,\n" +
                    "      ITEMID,\n" +
                    "      QUANTITY,\n" +
                    "      UNITPRICE\n" +
                    "    FROM LINEITEM\n" +
                    "    WHERE ORDERID = " + orderId;
        Connection connection = DBUtil.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
        ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                LineItem newLineItem = new LineItem();
                newLineItem.setOrderId(resultSet.getInt(1));
                newLineItem.setLineNumber(resultSet.getInt(2));
                newLineItem.setItemId(resultSet.getString(3));
                newLineItem.setQuantity(resultSet.getInt(4));
                newLineItem.setUnitPrice(resultSet.getBigDecimal(5));
                lineItems.add(newLineItem);
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

    } catch (Exception e){

    }
    return lineItems;
    }

    public void insertLineItem(LineItem lineItem){
        final String INSERT = "    INSERT INTO LINEITEM (ORDERID,  ITEMID, QUANTITY, UNITPRICE)\n" +
                "    VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,lineItem.getOrderId());
            preparedStatement.setString(2,lineItem.getItemId());
            preparedStatement.setInt(3,lineItem.getQuantity());
            preparedStatement.setBigDecimal(4,lineItem.getUnitPrice());
            preparedStatement.execute();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);


        }catch (Exception e){
            System.out.println(e.toString());
        }


    }
}
