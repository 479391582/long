package com.pro.dong.T_user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.dong.T_ROLE.entity.T_ROLE;
import com.pro.dong.T_user.entity.T_user;
import com.pro.dong.T_user.service.T_userService;
import com.pro.dong.commodity.service.CommodityService;
import com.pro.dong.page.PageBean;
import com.pro.dong.share.ShareDao;
@Service("t_userService")
public class T_userServiceImpl implements T_userService {
						
	     @Autowired
		private ShareDao shareDao;
		 
	     /**
		  * 查询全部
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("tuser.all");
	}
	
	/**
	 * 修改
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("tuser.update", object);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("tuser.delete", str);
	}
	
	/**
	 * 通过id查询
	 */
	@Override
	public List oneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tuser.getOne", stri);
	}
	
	/**
	 * 添加
	 */
	@Override
	public void save(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("tuser.insert", object);
	}

	/**
	 * 登录
	 */
	@Override
	public Object getUserByUsernameAndPassword(Object object) {
		// TODO Auto-generated method stub
		return shareDao.getUserByUsernameAndPassword("tuser.getUserByUsernameAndPassword", object);
	}

	@Override
	public List<?> nameall(String strs) {
		// TODO Auto-generated method stub
		return shareDao.nameall("tuser.name", strs);
	}

	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("tuser.selectCount");
	}

	@Override
	public PageBean<Map<T_user,T_ROLE> > findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Map<T_user,T_ROLE> > pageBean = new PageBean<Map<T_user,T_ROLE> >();

        //封装当前页数
        pageBean.setCurrPage(currentPage);
        

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);
        
        int a=(currentPage+1)*pageSize;
        int b= currentPage*pageBean.getPageSize()+1;
        //封装总记录数
        int totalCount = (int) shareDao.selectCount("tuser.selectCount");
        System.out.println("totalCount:"+totalCount);
        pageBean.setTotalCount(totalCount);

        //封装总页数
        double tc = totalCount;
        Double num =Math.ceil(tc/pageSize);//向上取整
        pageBean.setTotalPage(num.intValue());
        map.put("start",b);
        map.put("size",a);
        System.out.println("map:"+map);
        //封装每页显示的数据
        List<?> lists = shareDao.findByPage("tuser.findByPage", map);
        pageBean.setLists((List<Map<T_user,T_ROLE> >) lists);
        return pageBean;
	}

	@Override
	public List rolemunelist(String str) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tuser.fiveall", str);
	}

	@Override
	public void mansave(Object object) {
		// TODO Auto-generated method stub
		shareDao.save("tuser.maninsert", object);
	}

	@Override
	public List turoneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tuser.turgetOne", stri);
	}

	@Override
	public void turupd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("tuser.turupdate", object);
	}

	@Override
	public List manoneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tuser.manfiveall", stri);
	}

	@Override
	public List dongoneall(String stri) {
		// TODO Auto-generated method stub
		return shareDao.oneall("tuser.mangetOne", stri);
	}

	

}
