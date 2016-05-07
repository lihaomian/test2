package com.lisong.rjkf.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.lisong.rjkf.bean.Customer;

public class CustomerDao {
	
	private String driver="com.mysql.jdbc.Driver";
	private String url="jdbc:mysql://localhost:3306/rjkf";
	private String name="root";
	private String password="123";
	public void save(Customer customer) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			try{
				//1.加载驱动
				Class.forName(driver);
				//2.获取连接
				conn = DriverManager.getConnection(url, name, password);
				//3.创建pstmt
				String sql = "insert into db_customer values(null,?,?,?,?)";
				pstmt=conn.prepareStatement(sql);
				//4.替换占位符
				pstmt.setString(1, customer.getName());
				pstmt.setString(2, customer.getPassword());
				pstmt.setString(3, customer.getTelephone());
				pstmt.setString(4, customer.getAddress());
				//5.如果有结果集处理结果集
				pstmt.executeUpdate();
			}finally{
				if(pstmt !=null){
					pstmt.close();
				}
				if(conn !=null){
					conn.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
	}
	//通过name查找顾客信息
	public Customer findByName(String name){
		
		Customer customer=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			try{
				//1.加载驱动
				Class.forName(driver);
				//2.获取连接
				conn = DriverManager.getConnection(url, this.name, password);
				//3.创建pstmt
				String sql = "select * from db_customer where name =?";
				pstmt=conn.prepareStatement(sql);
				//4.替换占位符
				pstmt.setString(1, name);
				//5.如果有结果集处理结果集
				rs= pstmt.executeQuery();
				//遍历结果集
				while(rs.next()){
					customer=new Customer();
					long id=rs.getLong("id");
					String password =rs.getString("password");
					String telephone =rs.getString("telephone");
					String address =rs.getString("address");
					customer.setId(id);
					customer.setName(name);
					customer.setPassword(password);
					customer.setTelephone(telephone);
					customer.setAddress(address);
					
					
				}
			}finally{
				if(rs !=null){
					rs.close();
				}
				if(pstmt !=null){
					pstmt.close();
				}
				if(conn !=null){
					conn.close();
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		return customer;
	}

}
