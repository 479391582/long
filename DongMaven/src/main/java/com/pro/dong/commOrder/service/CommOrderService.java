package com.pro.dong.commOrder.service;

import java.util.List;
import java.util.Map;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.commOrder.entity.CommOrder;
import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.page.PageBean;

public interface CommOrderService {
							
							
	  
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
		//���ﳵͨ��id��ѯ
		List shopall(String stri);
	
		//���������
				Object selectCount();
				//��ҳ
				PageBean<Map<CommOrder,T_CUSTUMER> >findByPage(int currentPage);

				//ͨ��name��ѯ
				List nameall(String stri);	
							
							
							
}
