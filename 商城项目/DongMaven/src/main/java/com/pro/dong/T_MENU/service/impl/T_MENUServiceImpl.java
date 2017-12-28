package com.pro.dong.T_MENU.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
import com.pro.dong.T_CUSTUMER.service.T_CUSTUMERService;
import com.pro.dong.T_MENU.entity.T_MENU;
import com.pro.dong.T_MENU.service.T_MENUService;
import com.pro.dong.commOrder.service.CommOrderService;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.service.RepairOrderService;
import com.pro.dong.share.ShareDao;
@Service("t_MENUService")
public class T_MENUServiceImpl implements T_MENUService {
						
	     @Autowired
		private ShareDao shareDao;
		 
		 /**
		  * ��ѯȫ��
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("tmm.all");
	}
	
	/**
	 * �޸�
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("tmm.update", object);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("tmm.delete", str);
	}
	
	/**
	 * ͨ��id��ѯ
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tmm.getOne", stri);
	}
	
	/**
	 * ���
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("tmm.insert", object);
	}

	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("tmm.selectCount");
	}

	@Override
	public PageBean<T_MENU> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<T_MENU> pageBean = new PageBean<T_MENU>();

        //��װ��ǰҳ��
        pageBean.setCurrPage(currentPage);

        //ÿҳ��ʾ������
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //��װ�ܼ�¼��
        int totalCount = (int) shareDao.selectCount("tmm.selectCount");
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
        List<?> lists = shareDao.findByPage("tmm.findByPage", map);
        pageBean.setLists((List<T_MENU>) lists);
        return pageBean;
	}

	/* (�� Javadoc) 
	* <p>Title: getrizhi</p> 
	* <p>Description: </p> 
	* @return 
	* @see com.pro.dong.T_MENU.service.T_MENUService#getrizhi() 
	* @date 2017��12��26������4:46:51
	*/
	@Override
	public List<?> getrizhi() {
		// TODO Auto-generated method stub
		return shareDao.all("rizhi.all");
	}

	

}
