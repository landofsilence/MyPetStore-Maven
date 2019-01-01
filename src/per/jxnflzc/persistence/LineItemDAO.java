package per.jxnflzc.persistence;

import java.util.List;

import per.jxnflzc.domain.LineItem;

public interface LineItemDAO {

  List<LineItem> getLineItemsByOrderId(int orderId);

  void insertLineItem(LineItem lineItem);

}
