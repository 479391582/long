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
		  * 查询全部
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("tcu.all");
	}
	
	/**
	 * 修改
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("tcu.update", object);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("tcu.delete", str);
	}
	
	/**
	 * 通过id查询
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tcu.getOne", stri);
	}
	
	/**
	 * 添加
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("tcu.insert", object);
	}

	/**
	 * 登录
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

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = (int) shareDao.selectCount("tcu.selectCount");
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
