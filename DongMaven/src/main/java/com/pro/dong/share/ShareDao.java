package com.pro.dong.share;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;

import com.pro.dong.commodity.entity.Commodity;

public interface ShareDao {

	       //��¼��ѯ
			Object  getUserByUsernameAndPassword(String str,Object object);
			//��ѯȫ��
			List<?> all(String str);
			//�޸�
			void upd(String str,Object object);
			//ɾ��
			void del(String stri,String str);
			//allɾ��
			void alldel(String stri,String str);
			//ͨ��id��ѯ
			List oneall(String str,String stri);
			//���
			void save(String str,Object object);
			//���β˵�
			List<?> login(String str);
			//�����û�����ѯ
			List<?> nameall(String str,String strs);
			//ͨ��id��ѯ
			Object objectall(String str,String stri);
			//ͨ��id��ѯ
			void voidall(String str,String stri);
			//ͨ��id��ѯ
			Map mapall(String str,String stri);
			//
			List<Object> alist(String str,String stri);
			   /**
		     * ��ѯ�û���¼����
		     * @return
		     */
			Object selectCount(String str);
		    /**
		     * ��ҳ����������findByPage limit��ҳ����
		     * @param map
		     * @return
		     */
		    List<?> findByPage(String str,HashMap<String,Object> map);
		
			
			
			
			
}
