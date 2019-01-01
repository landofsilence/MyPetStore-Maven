package per.jxnflzc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import per.jxnflzc.domain.Item;
import per.jxnflzc.domain.LineItem;
import per.jxnflzc.domain.Order;

import per.jxnflzc.persistence.ItemDAO;
import per.jxnflzc.persistence.LineItemDAO;
import per.jxnflzc.persistence.OrderDAO;
import per.jxnflzc.persistence.impl.*;


public class OrderService {


  private ItemDAO itemMapper;

  private OrderDAO orderMapper;


  private LineItemDAO lineItemMapper;

  public OrderService(){
    lineItemMapper = new LineItemDAOImpl();
    orderMapper = new OrderDAOImpl();
    itemMapper = new ItemDAOImpl();


  }
  public void insertOrder(Order order) {
    order.setStatus("ready");
    order.setCourier("shunfeng");
    order.setLocale("#");
    orderMapper.insertOrder(order);
    orderMapper.insertOrderStatus(order);

    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);
      lineItemMapper.insertLineItem(lineItem);
    }
  }

  public Order getOrder(int orderId) {
    Order order = orderMapper.getOrder(orderId);
    order.setLineItems(lineItemMapper.getLineItemsByOrderId(orderId));
    System.out.println("number" + order.getLineItems().size());
    for (int i = 0; i < order.getLineItems().size(); i++) {
      LineItem lineItem = (LineItem) order.getLineItems().get(i);

      Item item = itemMapper.getItem(lineItem.getItemId());
      item.setQuantity(itemMapper.getInventoryQuantity(lineItem.getItemId()));
      lineItem.setItem(item);
    }

    return order;
  }

  public int getNewId(){
    return orderMapper.getNewId();

  }

  public List<Order> getOrdersByUsername(String username) {
    return orderMapper.getOrdersByUsername(username);

  }



}
