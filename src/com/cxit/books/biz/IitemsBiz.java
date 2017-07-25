package com.cxit.books.biz;

import java.util.List;
import java.util.Map;


import com.cxit.books.model.Items;
import com.cxit.books.model.shopping;

/**
 * ����ҵ��ӿ�
 * @author ��ɭ��
 *
 */
public interface IitemsBiz {
  //��Ӷ���
  public int addItems(Items Item);
  //�޸Ķ���
  public int updateItems(Items Item);
  //ɾ����Ϣ
  public int deleteItems(int id);
  //ͨ�������ö�������
  public Items getItemsById(int id);
  //������ж�������
  public List<Items> getAllItems();
  //ͨ���û����ù��ﳵ�б�
  public List<Items> getItemsByName(String name);
  //ͨ���û����ȡ���ﳵ�б�
  public List<shopping> getShopByName(String name);
  //ͨ���û����ȡ�����б�
  public List<shopping> getBuyByName(String name);
  //ͨ���û����ύ����
  public int updateBuy(String name);
  //������ʼλ��
int countBeginPosition(int currentPage, int pageNum);
//����ҳ��
int countPage(int pageNum, String name);
//��÷�ҳ����
public List<shopping> itemsBuy(Map map);
  
}
