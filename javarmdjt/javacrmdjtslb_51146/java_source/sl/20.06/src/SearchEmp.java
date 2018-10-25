import java.sql.*;

public class SearchEmp {
	
	static Connection con;
	static Statement sql;
	static ResultSet res;
	
	public Connection getConnection() {
		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:jtds:sqlserver://localhost:1433/db_jdbc",
					"sa", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		SearchEmp c = new SearchEmp();
		con = c.getConnection();
		try {
			sql = con.createStatement();
			res = sql.executeQuery("select * from tb_emp where"
					+ " dapt = '���۲�'");
			while (res.next()) {
				String id = res.getString(1);
				String name = res.getString("name");
				String sex = res.getString("sex");
				String birthday = res.getString("birthday");
				System.out.print("��ţ�" + id);
				System.out.print(" ������" + name);
				System.out.print(" �Ա�:" + sex);
				System.out.println(" ���գ�" + birthday);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}