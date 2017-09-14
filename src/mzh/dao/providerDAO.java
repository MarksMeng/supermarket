package mzh.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import mzh.connection.Connect;
import mzh.pojo.*;
import mzh.pojo.provider;

/**
 * 2007-12-3
 * @author 孟振华
 *
 */
public class providerDAO {
	Connection con = null;

	/**
	 *
	 * @param type
	 * @param comp
	 * @param value
	 * @return
	 */
	public ArrayList seletepro(String type, String comp, String value) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		provider pro;
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		if(!comp.equals("like")){
			System.out.print(comp.equals("like"));
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider where "+type+"=?");
			pstmt.setString(1, value);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}else{
			try {
				PreparedStatement pstmt = con
						.prepareStatement("select * from provider where "+type+" like ?");
				value="%"+value+"%";
				pstmt.setString(1, value);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					pro = new provider();
					pro.setPro_Id(rs.getString(1));
					pro.setPro_Name(rs.getString(2));
					pro.setPro_Tel(rs.getString(3));
					pro.setPro_Address(rs.getString(4));
					pro.setCargo_Type(rs.getString(5));
					pro.setPro_Date(rs.getString(6));
					lt.add(pro);
				}
				return lt;
			} catch (SQLException ex) {
				return null;
			} finally {
				try {
					if (con != null) {
						con.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
//
	/**
	 * ��������ָ�����͵Ĺ�Ӧ����Ϣ
	 * @param type
	 * @return
	 */
	public ArrayList type(String type) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		provider pro;
		try {
			con = Connect.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from provider where Cargo_Type=?");
			pstmt.setString(1, type);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				System.out.println(pro.getPro_Id()+"meng");
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//
	/**
	 *
	 * @param pro
	 * @throws SQLException
	 */
	public void newpro(provider pro)throws SQLException {
		try {
			con = Connect.getConnection();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {

			PreparedStatement pstmt = con
					.prepareStatement("insert into provider (Pro_ID,Pro_Name,Pro_Tel,Pro_Address,Cargo_Type,Pro_Date) VALUES (?,?,?,?,?,?)");

			pstmt.setString(1, pro.getPro_Id());
			pstmt.setString(2, pro.getPro_Name());
			pstmt.setString(3, pro.getPro_Tel());
			pstmt.setString(4, pro.getPro_Address());
			pstmt.setString(5, pro.getCargo_Type());			
			pstmt.setDate(6, new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
		} catch (SQLException eb) {
			throw eb;
		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
//
	/**
	 * �����޸Ĺ�����Ϣ
	 * @param pro
	 * @param id
	 */
	public void update(provider pro, String id) {
		ResultSet rs;

		// provider pro = new provider();
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {

			PreparedStatement pstmt = con
					.prepareStatement("update provider set Pro_Name=?,Pro_Tel=?,Pro_Address=?,Cargo_Type=?,Pro_Date=?  where Pro_ID=? ");

			pstmt.setString(1, pro.getPro_Name());
			pstmt.setString(2, pro.getPro_Tel());
			pstmt.setString(3, pro.getPro_Address());
			pstmt.setString(4, pro.getCargo_Type());
			pstmt.setString(5, pro.getPro_Date());
			pstmt.setString(6, id);

			// pstmt.executeUpdate();
			// pstmt.execute();
			//			
			int c = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
	}
//����Ҫ�޸õĹ�Ӧ����Ϣ
	public ArrayList edit(String id) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		provider pro;
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider where Pro_ID=?");
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
//delectPro
	public void delectPro(provider pro) {
		try {
			con = Connect.getConnection();
		} catch (Exception ex) {

		}
		try {
			PreparedStatement pstmt = con.prepareStatement("delete From provider Where Pro_ID=?");
			System.out.println(pro.getPro_Id()+"providerdao");
			pstmt.setString(1, pro.getPro_Id());
			pstmt.execute();
		} catch (SQLException eb) {
			eb.printStackTrace();

		} finally {
			try {
				if (con != null)
					con.close();
			} catch (Exception e2) {
			}
		}
	}

	// ��ʾ���й�Ӧ����Ϣ
	public ArrayList login(provider pro) {
		ResultSet rs;
		ArrayList lt = new ArrayList();
		try {
			con = Connect.getConnection();
		} catch (Exception e) {

		}
		try {
			PreparedStatement pstmt = con
					.prepareStatement("select * from provider");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				pro = new provider();
				pro.setPro_Id(rs.getString(1));
				pro.setPro_Name(rs.getString(2));
				pro.setPro_Tel(rs.getString(3));
				pro.setPro_Address(rs.getString(4));
				pro.setCargo_Type(rs.getString(5));
				pro.setPro_Date(rs.getString(6));
				lt.add(pro);
			}
			return lt;
		} catch (SQLException ex) {
			return null;
		}

	}
}
