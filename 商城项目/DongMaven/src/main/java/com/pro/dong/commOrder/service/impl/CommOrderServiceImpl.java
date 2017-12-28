package com.pro.dong.commOrder.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.commOrder.entity.CommOrder;
import com.pro.dong.commOrder.service.CommOrderService;
import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.service.RepairOrderService;
import com.pro.dong.share.ShareDao;
@Service("commOrderServiceService")
public class CommOrderServiceImpl implements CommOrderService {
						
	     @Autowired
		private ShareDao shareDao;
		 
		 /**
		  * ��ѯȫ��
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("cod.all");
	}
	
	/**
	 * �޸�
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("cod.update", object);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("cod.delete", str);
	}
	
	/**
	 * ͨ��id��ѯ
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("cod.getOne", stri);
	}
	
	/**
	 * ���
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("cod.insert", object);
	}

	@Override
	public List shopall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("shop.nameall", stri);
	}

	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("cod.selectCount");
	}

	@Override
	public PageBean<Map<CommOrder,T_CUSTUMER> > findByPage(int currentPage) {
		// TODO Auto-generated method stub
				HashMap<String,Object> map = new HashMap<String,Object>();
		        PageBean<Map<CommOrder,T_CUSTUMER> > pageBean = new PageBean<Map<CommOrder,T_CUSTUMER> >();

		        //��װ��ǰҳ��
		        pageBean.setCurrPage(currentPage);

		        //ÿҳ��ʾ������
		        int pageSize=5;
		        pageBean.setPageSize(pageSize);

		        //��װ�ܼ�¼��
		        int totalCount = (int) shareDao.selectCount("cod.selectCount");
		        System.out.println("totalCount:"+totalCount);
		        pageBean.setTotalCount(totalCount);

		        int a=(currentPage+1)*pageSize;
		        int b= currentPage*pageBean.getPageSize()+1;
		        //��װ��ҳ��
		        double tc = totalCount;
		        Double num =Math.ceil(tc/pageSize);//����ȡ��
		        pageBean.setTotalPage(num.intValue());
		        map.put("start",b);
		        map.put("size",a);
		        System.out.println("map:"+map);
		        //��װÿҳ��ʾ������
		        List<?> lists = shareDao.findByPage("cod.findByPage", map);
		        pageBean.setLists((List<Map<CommOrder,T_CUSTUMER> >) lists);
		        return pageBean;
		    }

	@Override
	public List nameall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.nameall("cod.nameall", stri);
	}


			



	
	

}
