package sqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import _Test.bean.CarInEntity;

public class SqliteJDBC {
	static Connection c = null;
	static Statement sm = null;

	public static void Init() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:orders.db");

			sm = c.createStatement();
			String sql = "CREATE TABLE INPARKORDER" + "(" + "car_number TEXT," + "in_time LONG," + "car_type TEXT,"
					+ "c_type TEXT," + "uid TEXT," + "order_id TEXT," + "empty_plot INT," + "in_channel_id INT,"
					+ "worksite_id INT," + "remark TEXT" + ",prepay TEXT"+",coupon TEXT,coupon_type TEXT,couponid TEXT"+")";
			System.out.println("创建sql：" + sql);
			sm.executeUpdate(sql);
			sm.close();
			c.close();
		} catch (Exception e) {
			// e.printStackTrace();
		}
	}

	public static void Insert(CarInEntity carin) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:orders.db");
			c.setAutoCommit(false);

			sm = c.createStatement();
			String sql = "INSERT INTO INPARKORDER(car_number,in_time,car_type,c_type,uid,order_id,empty_plot,in_channel_id)"
					+ "VALUES('" + carin.getCar_number() + "'," + carin.getIn_time() + ",'" + carin.getCar_type()
					+ "','" + carin.getC_type() + "','" + carin.getUid() + "','" + carin.getOrder_id() + "',"
					+ carin.getEmpty_plot() + ",'" + carin.getIn_channel_id() + "');";
			System.out.println("插入sql：" + sql);
			sm.executeUpdate(sql);
			sm.close();
			c.commit();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static List<CarInEntity> Select() {
		List<CarInEntity> list = new ArrayList<>();
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:orders.db");
			c.setAutoCommit(false);

			sm = c.createStatement();
			ResultSet rs = sm.executeQuery("SELECT * FROM INPARKORDER;");
			while (rs.next()) {
				CarInEntity carin = new CarInEntity();
				carin.setC_type(rs.getString("c_type"));
				carin.setCar_number(rs.getString("car_number"));
				carin.setCar_type(rs.getString("car_type"));
				carin.setEmpty_plot(rs.getInt("empty_plot"));
				carin.setIn_channel_id(rs.getString("in_channel_id"));
				carin.setIn_time(rs.getLong("in_time"));
				carin.setOrder_id(rs.getString("order_id"));
				carin.setPrepay(rs.getString("prepay"));
				carin.setUid(rs.getString("uid"));
				list.add(carin);
			}
			rs.close();
			sm.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static void Delete(String orderid) {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:orders.db");
			c.setAutoCommit(false);

			sm = c.createStatement();
			String sql = "DELETE FROM INPARKORDER WHERE order_id='" + orderid+"';";
			sm.executeUpdate(sql);
			c.commit();

			sm.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void Update(String target,String value,String orderid){
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:orders.db");
			c.setAutoCommit(false);

			sm = c.createStatement();
			String sql = "UPDATE INPARKORDER SET "+target+"='" + value+"' where order_id='"+orderid+"';";
			sm.executeUpdate(sql);
			c.commit();

			sm.close();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static String Querry(String target,String value,String condition){
		String conditionvalue="";
		try{
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:orders.db");
			c.setAutoCommit(false);
			
			sm = c.createStatement();
			ResultSet rs = sm.executeQuery("SELECT * FROM INPARKORDER where "+target+" = '"+value+"';");
			while (rs.next()) {
				conditionvalue = rs.getString(condition);
			}
			rs.close();
			sm.close();
			c.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		return conditionvalue;
	}
}
