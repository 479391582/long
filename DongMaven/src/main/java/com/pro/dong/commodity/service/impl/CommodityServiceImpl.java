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
		  * 查询全部
		  */
	@Override
	public List<?> all() {
		// TODO Auto-generated method stub
		return shareDao.all("com.commList");
	}
	
	/**
	 * 修改
	 */
	@Override
	public void upd(Object object) {
		// TODO Auto-generated method stub
		shareDao.upd("com.updateComm", object);
	}

	/**
	 * 删除
	 */
	@Override
	public void del(String str) {
		// TODO Auto-generated method stub
		shareDao.del("com.deleteComm", str);
	}
	
	/**
	 * 通过id查询
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
		shareDao.save("com.insertComm", object);
	}


	/**
	 * 查询总条数
	 */
	@Override
	public Object selectCount() {
		// TODO Auto-generated method stub
		return shareDao.selectCount("com.selectCount");
	}
	
	
	/**
	 * 分页
	 */
	@Override
	public PageBean<Commodity> findByPage(int currentPage) {
		// TODO Auto-generated method stub
		HashMap<String,Object> map = new HashMap<String,Object>();
        PageBean<Commodity> pageBean = new PageBean<Commodity>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);

        //每页显示的数据
        int pageSize=5;
        pageBean.setPageSize(pageSize);

       
        //封装总记录数
        int totalCount = (int) shareDao.selectCount("com.selectCount");
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
        List<?> lists = shareDao.findByPage("com.findByPage", map);
        pageBean.setLists((List<Commodity>) lists);
        return pageBean;
    }


	

	

}
