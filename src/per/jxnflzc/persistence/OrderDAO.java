package per.jxnflzc.persistence;

import java.util.List;

import per.jxnflzc.domain.Order;

public interface OrderDAO {

  List<Order> getOrdersByUsername(String username);

  Order getOrder(int orderId);
  
  void insertOrder(Order order);
  
  void insertOrderStatus(Order order);

    List<Order> getNewId();
}
