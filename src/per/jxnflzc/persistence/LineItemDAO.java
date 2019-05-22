package per.jxnflzc.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import per.jxnflzc.domain.LineItem;

public interface LineItemDAO {

  List<LineItem> getLineItemsByOrderId(@Param("orderId") int orderId);

  void insertLineItem(LineItem lineItem);

}
