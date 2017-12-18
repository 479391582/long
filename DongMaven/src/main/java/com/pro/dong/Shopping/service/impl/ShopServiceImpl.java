package com.pro.dong.Shopping.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dong.Shopping.entity.Shop;
import com.pro.dong.Shopping.service.ShopService;
import com.pro.dong.T_CUSTUMER.service.T_CUSTUMERService;
import com.pro.dong.T_MENU.service.T_MENUService;
import com.pro.dong.T_ROLE.service.T_ROLEService;
import com.pro.dong.commOrder.service.CommOrderService;
import com.pro.dong.page.PageBean;
import com.pro.dong.repairOrder.entity.RepairOrder;
import com.pro.dong.repairOrder.service.RepairOrderService;
import com.pro.dong.share.ShareDao;
@Service("shopService")
public class ShopServiceImpl implements ShopService {
						
	     @Autowired
		private ShareDao shareDao;
		 
		 /**
		  * 查询全部
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("shop.all");
	}
	
	/**
	 * 修改
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("shop.update", object);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("shop.delete", str);
	}
	
	/**
	 * 商品表通过id查询
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("com.getOne", stri);
	}
	
	/**
	 * 添加
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("shop.insert", object);
	}

	/**
	 * 根据用户名名字查询
	 */
	@Override
	public List nameall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.nameall("shop.nameall", stri);
	}

	/**
	 * 购物车表id查询
	 */
	@Override
	public List shoponeall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("shop.getOne", stri);
	}

	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("shop.selectCount");
	}

	@Override
	public PageBean<Shop> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Shop> pageBean = new PageBean<Shop>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

        //封装总记录数
        int totalCount = (int) shareDao.selectCount("shop.selectCount");
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
        List<?> lists = shareDao.findByPage("shop.findByPage", map);
        pageBean.setLists((List<Shop>) lists);
        return pageBean;
	}

	@Override
	public void alldel(String str) {
		// TODO Auto-generated method stub
		shareDao.alldel("shop.alldelete",str);
	}



	

}
