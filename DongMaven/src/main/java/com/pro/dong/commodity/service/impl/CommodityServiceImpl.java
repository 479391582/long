package com.pro.dong.commodity.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dong.commodity.entity.Commodity;
import com.pro.dong.commodity.service.CommodityService;
import com.pro.dong.page.PageBean;
import com.pro.dong.share.ShareDao;
@Service("commodityService")
public class CommodityServiceImpl implements CommodityService {
						
	     @Autowired
		private ShareDao shareDao;
		 
		 /**
		  * ��ѯȫ��
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("com.commList");
	}
	
	/**
	 * �޸�
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("com.updateComm", object);
	}

	/**
	 * ɾ��
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("com.deleteComm", str);
	}
	
	/**
	 * ͨ��id��ѯ
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("com.getOne", stri);
	}
	
	/**
	 * ���
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("com.insertComm", object);
	}


	/**
	 * ��ѯ������
	 */
	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("com.selectCount");
	}
	
	
	/**
	 * ��ҳ
	 */
	@Override
	public PageBean<Commodity> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Commodity> pageBean = new PageBean<Commodity>();

        //��װ��ǰҳ��
        pageBean.setCurrPage(currentPage);

        //ÿҳ��ʾ������
        int pageSize=5;
        pageBean.setPageSize(pageSize);

       
        //��װ�ܼ�¼��
        int totalCount = (int) shareDao.selectCount("com.selectCount");
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
        List<?> lists = shareDao.findByPage("com.findByPage", map);
        pageBean.setLists((List<Commodity>) lists);
        return pageBean;
    }


	

	

}
