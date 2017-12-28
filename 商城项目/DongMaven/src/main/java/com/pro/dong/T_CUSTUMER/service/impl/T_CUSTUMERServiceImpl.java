package com.pro.dong.T_CUSTUMER.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dong.T_CUSTUMER.service.T_CUSTUMERService;
import com.pro.dong.commOrder.service.CommOrderService;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.entity.RepairOrder;
import com.pro.dong.repairOrder.service.RepairOrderService;
import com.pro.dong.share.ShareDao;
import com.pro.dong.T_CUSTUMER.entity.T_CUSTUMER;
@Service("t_CUSTUMERServiceService")
public class T_CUSTUMERServiceImpl implements T_CUSTUMERService {
						
	     @Autowired
		private ShareDao shareDao;
		 
		 /**
		  * ��ѯȫ��
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("tcu.all");
	}
	
	/**
	 * �޸�
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("tcu.update", object);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("tcu.delete", str);
	}
	
	/**
	 * ͨ��id��ѯ
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tcu.getOne", stri);
	}
	
	/**
	 * ���
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("tcu.insert", object);
	}

	/**
	 * ��¼
	 */
	@Override
	public Object getUserByUsernameAndPassword(Object object) {
		// TODO Auto-generated method stub
		return shareDao.getUserByUsernameAndPassword("tcu.getUserByUsernameAndPassword", object);
	}

	@Override
	public List<?> nameall(String strs) {
		// TODO Auto-generated method stub
		return shareDao.nameall("tcu.name", strs);
	}

	@Override
	public List<?> manall() {
		// TODO Auto-generated method stub
		return shareDao.all("tcu.manall");
	}

	@Override
	public void mansave(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("tcu.maninsert", object);
	}

	@Override
	public List rolemunelist(String str) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tcu.fiveall", str);
	}

	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("tcu.selectCount");
	}

	@Override
	public PageBean<T_CUSTUMER> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<T_CUSTUMER> pageBean = new PageBean<T_CUSTUMER>();

        //��װ��ǰҳ��
        pageBean.setCurrPage(currentPage);

        //ÿҳ��ʾ������
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //��װ�ܼ�¼��
        int totalCount = (int) shareDao.selectCount("tcu.selectCount");
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
        List<?> lists = shareDao.findByPage("tcu.findByPage", map);
        pageBean.setLists((List<T_CUSTUMER>) lists);
        return pageBean;
	}

	@Override
	public List openoneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tcu.getOneOPen", stri);
	}

	

}
