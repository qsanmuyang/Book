package com.cxit.books.model;

import java.util.List;
/**
 * ����ʵ����
 * @author ��ɭ��
 * һ������ �����˶��������
 */
public class Orders {
	//�������
	private int oid;
    //�û���
	private String userName;
	//��һ��һ�� ������һ������
	private List<Items> oitems;
	public Orders() {
	}
	public Orders(int oid, String userName) {
		super();
		this.oid = oid;
		this.userName = userName;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Items> getOitems() {
		return oitems;
	}
	public void setOitems(List<Items> oitems) {
		this.oitems = oitems;
	}
	@Override
	public String toString() {
		return "Orders [oid=" + oid + ", userName=" + userName + "]";
	}
	

}
