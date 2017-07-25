package com.cxit.books.biz;

import java.util.List;

import com.cxit.books.model.Orders;


/**
 * ����ҵ��ӿ�
 * @author ��ɭ��
 *
 */
public interface IOrdersBiz {
  //��Ӷ���
  public int addOrders(Orders Orders);
  //�޸Ķ���
  public int updateOrders(Orders Orders);
  //ɾ��������Ϣ
  public int deleteOrders(int id);
  //ͨ��������ö�������
  public Orders getOrdersById(int id);
  //������ж�������
  public List<Orders> getAllOrders();
  //ͨ���û�����ö�������
  public List<Orders> getOrderByName(String name);
  //ȡ����󶩵����
  public int getMaxOid();
}
