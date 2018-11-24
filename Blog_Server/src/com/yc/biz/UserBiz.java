package com.yc.biz;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import com.yc.bean.User;
import com.yc.dao.DBHelper;

public class UserBiz {
	
	/**
	 * 登录方法
	 * @param username
	 * @param userpwd
	 * @return
	 */
/*	public Map<String, String> login(String username,String userpwd){
		//查询数据库判断用户是否存在
		DBHelper dbHelper=new DBHelper();
		List<Object> params=new ArrayList<Object>();
		params.add(username);
		params.add(userpwd);
		String sql=" select * from user where account=? and pwd=? ";
		Map<String, String> user=dbHelper.findMap(sql, params);		
		return user ;
*/		
	public User login(String username,String userpwd) throws BizException{
		
		if( username == null || username.trim().isEmpty()){
			throw new BizException("请填写用户名！！");
		}
		if (userpwd == null || userpwd.trim().isEmpty()) {
			throw new BizException("请填写密码");
		}
		
		String sql=" select * from user where account=? and pwd=? ";
		return DBHelper.unique(sql, User.class,username,userpwd);

	}

	public List<User> findAll() {
		return DBHelper.select("select * from user", User.class);
	}

	public User findByid(String id) {
		return DBHelper.unique("select * from user where id=?", User.class,id);
	}

	public void add(User user) throws BizException {
		if ( user.getName() == null || user.getName().trim().isEmpty()) {
			throw new BizException("请填写用户名!!");
		}else if( user.getAccount() == null || user.getAccount().trim().isEmpty()) {
			throw new BizException("请填写账号!!");
		}	
			
		String sql="insert into user (name,account,tel,pwd) values(?,?,?,?)";
		DBHelper.insert(sql, user.getName(),user.getAccount(),user.getTel(),user.getPwd());
	}

	public Object find(User user) {
		String sql="select *from user where 1=1";
		ArrayList<Object> params=new ArrayList<Object>();
		if (user.getAccount() !=null && user.getAccount().trim().isEmpty() ==false) {
			sql += " and account like concat('%',?,'%')";
			params.add(user.getAccount());
		}
		
		if (user.getName() !=null && user.getName().trim().isEmpty() ==false) {
			sql += " and name like ?";
			params.add("%"+user.getName()+"%");  //采用这种拼接比较好
		}
		if (user.getTel() !=null && user.getTel().trim().isEmpty() ==false) {
			sql += " and tel like ?";
			params.add("%"+user.getTel()+"%");  //采用这种拼接比较好
		}
		
		return DBHelper.select(sql, params);
		
		
	}
	
	
}
