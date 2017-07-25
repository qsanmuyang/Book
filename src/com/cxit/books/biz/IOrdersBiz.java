package com.cxit.books.biz;

import java.util.List;

import com.cxit.books.model.Orders;


/**
 * 订单业务接口
 * @author 钟森阳
 *
 */
public interface IOrdersBiz {
  //添加订单
  public int addOrders(Orders Orders);
  //修改订单
  public int updateOrders(Orders Orders);
  //删除订单信息
  public int deleteOrders(int id);
  //通过主键获得订单对象
  public Orders getOrdersById(int id);
  //获得所有订单集合
  public List<Orders> getAllOrders();
  //通过用户名获得订单集合
  public List<Orders> getOrderByName(String name);
  //取得最大订单编号
  public int getMaxOid();
}
