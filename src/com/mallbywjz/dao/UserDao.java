package com.mallbywjz.dao;

import java.util.List;

import com.mallbywjz.entity.Admins;
import com.mallbywjz.entity.Goods;
import com.mallbywjz.entity.Users;

public interface UserDao {
	public List login(Users user);	//�û���¼��֤
	public List login(Admins admin);	//����Ա��¼��֤
	public boolean register(Users user);  //�û�ע��
	public boolean register(Admins admin); //����Աע��
	public void modifyInfo(Users user);//�û��޸���Ϣ�����룩
	public void modifyInfo(Admins admin);//����Ա�޸���Ϣ�����룩
	public List userBySelect(Users user);//�û���ѯ
	public void deleteUser(Users user);//ɾ���û�
	public List allUsers();//ȡ�������û�
}
