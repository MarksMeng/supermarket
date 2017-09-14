package mzh.dao;

import java.sql.*;
import java.util.ArrayList;

import mzh.connection.Connect;
import mzh.pojo.StockPojo;

/**
 * @author ������
 *
 */
public class StockDAO {
	Connection conn = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;

	// 
	/**
	 * �ж���Ʒ�Ƿ����
	 * @param id
	 * @return
	 */
	public boolean checkCargoID(String id) {
		String sql = "select Cargo_ID from cargo where Cargo_ID=?";
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;

	}


	/**
	 * ��Ʒ��Ϣ�����ڣ����¿�����Ϣ,��������Ϣ���뵽���ݿ���
	 * @param cargoID
	 * @param oldNum
	 * @param stockNum
	 * @param price
	 * @param proID
	 * @param manaID
	 */
	public void stockInf(String cargoID, int oldNum, int stockNum,
			double price, String proID, String manaID) {
		String updateStorage = "update storage set Storage_Num=? where Cargo_ID=?";
		String insertStock = "insert into stock(Cargo_ID,Stock_Num,Stock_Price,Stock_Date,Pro_ID,Mana_Name) values(?,?,?,?,?,?) ";
		try {
			conn = Connect.getConnection();
			conn.setAutoCommit(false);
			// ���¿�����Ϣ
			pstmt = conn.prepareStatement(updateStorage);
			pstmt.setInt(1, oldNum + stockNum);
			pstmt.setString(2, cargoID);
			pstmt.executeUpdate();
			// ��������Ϣ���뵽���ݿ���
			pstmt = conn.prepareStatement(insertStock);
			pstmt.setString(1, cargoID);
			pstmt.setInt(2, stockNum);
			pstmt.setDouble(3, price);
			pstmt.setDate(4, new Date(System.currentTimeMillis()));
			pstmt.setString(5, proID);
			pstmt.setString(6, manaID);
			pstmt.executeUpdate();

			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	//
	/**
	 *  ��Ʒ��Ϣ�����ڣ������Ʒ��Ϣ��cargo��storage��stock��
	 * @param cargoID
	 * @param cargoName
	 * @param cargoType
	 * @param stockNum
	 * @param stockPrice
	 * @param proID
	 * @param manaName
	 */
	public void newStockInf(String cargoID, String cargoName, String cargoType,
			int stockNum, double stockPrice, String proID, String manaName) {
		String insertCargo = "insert into cargo values(?,?,?)";
		String insertStorage = "insert into storage values(?,?)";
		String insertStock = "insert into stock(Cargo_ID,Stock_Num,Stock_Price,Stock_Date,Pro_ID,Mana_Name) values(?,?,?,?,?,?) ";
		try {
			conn = Connect.getConnection();
			conn.setAutoCommit(false);
			// �����ݲ��뵽cargo��
			pstmt = conn.prepareStatement(insertCargo);
			pstmt.setString(1, cargoID);
			pstmt.setString(2, cargoName);
			pstmt.setString(3, cargoType);
			pstmt.executeUpdate();
			// �����ݳ��뵽storage��
			pstmt = conn.prepareStatement(insertStorage);
			pstmt.setString(1, cargoID);
			pstmt.setInt(2, stockNum);
			pstmt.executeUpdate();
			// �����ݲ��뵽stock��
			pstmt = conn.prepareStatement(insertStock);
			pstmt.setString(1, cargoID);
			pstmt.setInt(2, stockNum);
			pstmt.setDouble(3, stockPrice);
			pstmt.setDate(4, new Date(System.currentTimeMillis()));
			pstmt.setString(5, proID);
			pstmt.setString(6, manaName);
			pstmt.executeUpdate();
			// �ύ����
			conn.commit();

		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	// 
	/**
	 * @return �����б���Ϣ
	 */
	public ArrayList stockListInf() {
		ArrayList list = new ArrayList();
		String sql = "select cargo.Cargo_ID,Cargo_Name,Cargo_Type,Stock_Num,Stock_Price,Stock_Date,Pro_ID,Mana_Name from cargo,stock  where cargo.Cargo_ID=stock.Cargo_ID";
		try {
			conn = Connect.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				StockPojo st = new StockPojo();
				st.setCargo_id(rs.getString(1));
				st.setCargo_name(rs.getString(2));
				st.setCargo_type(rs.getString(3));
				st.setStock_num(rs.getInt(4));
				st.setStock_price(rs.getDouble(5));
				st.setStock_date(rs.getDate(6));
				st.setPro_id(rs.getString(7));
				st.setMana_id(rs.getString(8));
		
				list.add(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;

	}
}
