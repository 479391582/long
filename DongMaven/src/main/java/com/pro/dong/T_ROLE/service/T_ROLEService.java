package com.pro.dong.T_ROLE.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_MENU.entity.T_MENU;
import com.pro.dong.T_ROLE.entity.T_ROLE;
import com.pro.dong.page.PageBean;

public interface T_ROLEService {
							
							
	  
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

		//���������
		Object selectCount();
		//��ҳ
		PageBean<T_ROLE> findByPage(int currentPage);
					
							
							
							
}
