package com.pro.dong.T_CUSTUMER.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.entity.RepairOrder;

public interface T_CUSTUMERService {
							
							
	  //��¼��ѯ
			Object  getUserByUsernameAndPassword(Object object);
		//��ѯȫ��
		List<?> all();
		//�޸�
		void upd(Object object);
		//ɾ��
		void del(String str);
		//ͨ��id��ѯ
		List oneall(String stri);
		//���
		void save(Object object);
		//�����û�����ѯ
		List<?> nameall(String strs);
		//��ѯ��ɫȫ��
		List<?> manall();
		//�����ɫ
		void mansave(Object object);
		//�˵�
		List rolemunelist(String str);		
		//���������
				Object selectCount();
				//��ҳ
				PageBean<T_CUSTUMER> findByPage(int currentPage);	
				//ͨ���绰�Ų�ѯ
				List openoneall(String stri);
}
