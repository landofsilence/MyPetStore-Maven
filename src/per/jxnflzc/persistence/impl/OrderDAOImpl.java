package per.jxnflzc.persistence.impl;

import per.jxnflzc.domain.Order;
import per.jxnflzc.util.DBUtil;
import per.jxnflzc.persistence.LineItemDAO;
import per.jxnflzc.persistence.OrderDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    public  List<Order> getOrdersByUsername(String username){
        List <Order> theList = new ArrayList<Order>();

        try{
            LineItemDAO S = new LineItemDAOImpl();
            final String GET_ITEM = "  SELECT\n" +
                    "      BILLADDR1 AS billAddress1,\n" +
                    "      BILLADDR2 AS billAddress2,\n" +
                    "      BILLCITY,\n" +
                    "      BILLCOUNTRY,\n" +
                    "      BILLSTATE,\n" +
                    "      BILLTOFIRSTNAME,\n" +
                    "      BILLTOLASTNAME,\n" +
                    "      BILLZIP,\n" +
                    "      SHIPADDR1 AS shipAddress1,\n" +
                    "      SHIPADDR2 AS shipAddress2,\n" +
                    "      SHIPCITY,\n" +
                    "      SHIPCOUNTRY,\n" +
                    "      SHIPSTATE,\n" +
                    "      SHIPTOFIRSTNAME,\n" +
                    "      SHIPTOLASTNAME,\n" +
                    "      SHIPZIP,\n" +
                    "      CARDTYPE,\n" +
                    "      COURIER,\n" +
                    "      CREDITCARD,\n" +
                    "      EXPRDATE AS expiryDate,\n" +
                    "      LOCALE,\n" +
                    "      ORDERDATE,\n" +
                    "      ORDERS.ORDERID,\n" +
                    "      TOTALPRICE,\n" +
                    "      USERID AS username,\n" +
                    "      STATUS\n" +
                    "    FROM ORDERS, ORDERSTATUS\n" +
                    "    WHERE ORDERS.USERID = ?\n" +
                    "      AND ORDERS.ORDERID = ORDERSTATUS.ORDERID\n" +
                    "    ORDER BY ORDERDATE";
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Order order = new Order();
                order.setOrderId(resultSet.getInt("orderId"));
                order.setBillAddress1(resultSet.getString("billAddress1"));
                order.setBillAddress2(resultSet.getString("billAddress2"));
                order.setBillCity(resultSet.getString("billCity"));
                order.setBillCountry(resultSet.getString("billCountry"));
                order.setBillState(resultSet.getString("billState"));
                order.setBillToFirstName(resultSet.getString("billToFirstName"));
                order.setBillToLastName(resultSet.getString("billToLastName"));
                order.setBillZip(resultSet.getString("billZip"));
                order.setCardType(resultSet.getString("cardType"));
                order.setCourier(resultSet.getString("courier"));
                order.setCreditCard(resultSet.getString("creditCard"));
                order.setTotalPrice(resultSet.getBigDecimal("totalPrice"));
                order.setUsername(resultSet.getString("userName"));
                order.setLocale(resultSet.getString("locale"));
                order.setExpiryDate(resultSet.getString("expiryDate"));
                order.setShipZip(resultSet.getString("shipZip"));
                order.setOrderDate(new Date(resultSet.getTimestamp("orderDate").getTime()));
                order.setShipToFirstName(resultSet.getString("shipToFirstName"));
                order.setShipAddress1(resultSet.getString("shipAddress1"));
                order.setShipAddress2(resultSet.getString("shipAddress2"));
                order.setShipCountry(resultSet.getString("shipCountry"));
                order.setShipToLastName((resultSet.getString("shipToLastName")));
                order.setShipState(resultSet.getString("shipState"));
                order.setShipCity(resultSet.getString("shipCity"));
                order.setStatus(resultSet.getString("status"));
                order.setLineItems(S.getLineItemsByOrderId(order.getOrderId()));
                theList.add(order);
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (Exception e){

        }
        return theList;

    }

    public Order getOrder(int orderId){
    Order order = new Order();
    LineItemDAO S = new LineItemDAOImpl();

        try{
            final String GET_ITEM = "select\n" +
                    "      BILLADDR1 AS billAddress1,\n" +
                    "      BILLADDR2 AS billAddress2,\n" +
                    "      BILLCITY,\n" +
                    "      BILLCOUNTRY,\n" +
                    "      BILLSTATE,\n" +
                    "      BILLTOFIRSTNAME,\n" +
                    "      BILLTOLASTNAME,\n" +
                    "      BILLZIP,\n" +
                    "      SHIPADDR1 AS shipAddress1,\n" +
                    "      SHIPADDR2 AS shipAddress2,\n" +
                    "      SHIPCITY,\n" +
                    "      SHIPCOUNTRY,\n" +
                    "      SHIPSTATE,\n" +
                    "      SHIPTOFIRSTNAME,\n" +
                    "      SHIPTOLASTNAME,\n" +
                    "      SHIPZIP,\n" +
                    "      CARDTYPE,\n" +
                    "      COURIER,\n" +
                    "      CREDITCARD,\n" +
                    "      EXPRDATE AS expiryDate,\n" +
                    "      LOCALE,\n" +
                    "      ORDERDATE,\n" +
                    "      ORDERS.ORDERID,\n" +
                    "      TOTALPRICE,\n" +
                    "      USERID AS username,\n" +
                    "      STATUS\n" +
                    "    FROM ORDERS, ORDERSTATUS\n" +
                    "    WHERE ORDERS.ORDERID = ?\n" +
                    "      AND ORDERS.ORDERID = ORDERSTATUS.ORDERID";

            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
            preparedStatement.setInt(1,orderId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()){
                    order.setOrderId(orderId);
                    order.setBillAddress1(resultSet.getString("billAddress1"));
                    order.setBillAddress2(resultSet.getString("billAddress2"));
                    order.setBillCity(resultSet.getString("billCity"));
                    order.setBillCountry(resultSet.getString("billCountry"));
                    order.setBillState(resultSet.getString("billState"));
                    order.setBillToFirstName(resultSet.getString("billToFirstName"));
                    order.setBillToLastName(resultSet.getString("billToLastName"));
                    order.setBillZip(resultSet.getString("billZip"));
                    order.setCardType(resultSet.getString("cardType"));
                    order.setCourier(resultSet.getString("courier"));
                    order.setCreditCard(resultSet.getString("creditCard"));
                    order.setTotalPrice(resultSet.getBigDecimal("totalPrice"));
                    order.setUsername(resultSet.getString("userName"));
                    order.setLocale(resultSet.getString("locale"));
                    order.setExpiryDate(resultSet.getString("expiryDate"));
                    order.setShipZip(resultSet.getString("shipZip"));
                    order.setOrderDate(new Date(resultSet.getTimestamp("orderDate").getTime()));
                    order.setShipToFirstName(resultSet.getString("shipToFirstName"));
                    order.setShipAddress1(resultSet.getString("shipAddress1"));
                    order.setShipAddress2(resultSet.getString("shipAddress2"));
                    order.setShipCountry(resultSet.getString("shipCountry"));
                    order.setShipToLastName((resultSet.getString("shipToLastName")));
                    order.setShipState(resultSet.getString("shipState"));
                    order.setShipCity(resultSet.getString("shipCity"));
                    order.setStatus(resultSet.getString("status"));
                    order.setLineItems(S.getLineItemsByOrderId(orderId));
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (Exception e){

        }
        return order;
    }

    public void insertOrder(Order order){
        final String INSERT = "INSERT INTO ORDERS (ORDERID, USERID, ORDERDATE, SHIPADDR1, SHIPADDR2, SHIPCITY, SHIPSTATE,\n" +
                "      SHIPZIP, SHIPCOUNTRY, BILLADDR1, BILLADDR2, BILLCITY, BILLSTATE, BILLZIP, BILLCOUNTRY,\n" +
                "      COURIER, TOTALPRICE, BILLTOFIRSTNAME, BILLTOLASTNAME, SHIPTOFIRSTNAME, SHIPTOLASTNAME,\n" +
                "      CREDITCARD, EXPRDATE, CARDTYPE, LOCALE)\n" +
                "    VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,order.getOrderId());
            preparedStatement.setString(2,order.getUsername());
            preparedStatement.setTimestamp(3,new Timestamp(order.getOrderDate().getTime()));;
            preparedStatement.setString(4,order.getShipAddress1());
            preparedStatement.setString(5,order.getShipAddress2());
            preparedStatement.setString(6,order.getShipCity());
            preparedStatement.setString(7,order.getShipState());
            preparedStatement.setString(8,order.getShipZip());
            preparedStatement.setString(9,order.getShipCountry());
            preparedStatement.setString(10,order.getBillAddress1());
            preparedStatement.setString(11,order.getBillAddress2());
            preparedStatement.setString(12,order.getBillCity());
            preparedStatement.setString(13,order.getBillState());
            preparedStatement.setString(14,order.getBillZip());
            preparedStatement.setString(15,order.getBillCountry());
            preparedStatement.setString(16,order.getCourier());
            preparedStatement.setBigDecimal(17,order.getTotalPrice());
            preparedStatement.setString(18,order.getBillToFirstName());
            preparedStatement.setString(19,order.getBillToLastName());
            preparedStatement.setString(20,order.getShipToFirstName());
            preparedStatement.setString(21,order.getShipToLastName());
            preparedStatement.setString(22,order.getCreditCard());
            preparedStatement.setString(23,order.getExpiryDate());
            preparedStatement.setString(24,order.getCardType());
            preparedStatement.setString(25,order.getLocale());

            preparedStatement.execute();
            System.out.println("zhixing");
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);


        }catch (Exception e){
            System.out.println(e.toString());
        }






    }

    public void insertOrderStatus(Order order){
        final String INSERT = "INSERT INTO ORDERSTATUS (ORDERID, LINENUM, TIMESTAMP, STATUS)\n" +
                "    VALUES (?,?,?,?)";
        try {
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setInt(1,order.getOrderId());
            preparedStatement.setInt(2,order.getLineItems().size());
            preparedStatement.setTimestamp(3,new Timestamp(order.getOrderDate().getTime()));
            preparedStatement.setString(4,order.getStatus());

            preparedStatement.execute();
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);


        }catch (Exception e){
            System.out.println(e.toString());
        }

    }

    public int getNewId(){
        int num = 0;
        try{
            LineItemDAO S = new LineItemDAOImpl();
            final String GET_ITEM = "SELECT orderId FROM ORDERS";
            Connection connection = DBUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ITEM);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                num++;
            }

            DBUtil.closeResultSet(resultSet);
            DBUtil.closePreparedStatement(preparedStatement);
            DBUtil.closeConnection(connection);

        } catch (Exception e){

        }
        return num;


    }

}
