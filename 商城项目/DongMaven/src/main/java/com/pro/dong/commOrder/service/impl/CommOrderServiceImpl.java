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
		  * 查询全部
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("cod.all");
	}
	
	/**
	 * 修改
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("cod.update", object);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("cod.delete", str);
	}
	
	/**
	 * 通过id查询
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("cod.getOne", stri);
	}
	
	/**
	 * 添加
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

		        //封装当前页数
		        pageBean.setCurrPage(currentPage);

		        //每页显示的数据
		        int pageSize=5;
		        pageBean.setPageSize(pageSize);

		        //封装总记录数
		        int totalCount = (int) shareDao.selectCount("cod.selectCount");
		        System.out.println("totalCount:"+totalCount);
		        pageBean.setTotalCount(totalCount);

		        int a=(currentPage+1)*pageSize;
		        int b= currentPage*pageBean.getPageSize()+1;
		        //封装总页数
		        double tc = totalCount;
		        Double num =Math.ceil(tc/pageSize);//向上取整
		        pageBean.setTotalPage(num.intValue());
		        map.put("start",b);
		        map.put("size",a);
		        System.out.println("map:"+map);
		        //封装每页显示的数据
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
