package soliddesign.singleResponsibility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Employee {

	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSal() {
		return sal;
	}

	public void setSal(int sal) {
		this.sal = sal;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	int id;
	int sal;
	int deptno;

	public final Connection getcon() {
		Connection conn = null;
		try {
			String url = "jdbc:sqlite:path-to-db/ankit/ankit.db";
			conn = DriverManager.getConnection(url);

			System.out.println("Got it!");
			return conn;
		} catch (SQLException e) {
			throw new Error("Problem", e);
		}
	}

	public void save(Employee emp) {
		try {
			
			//Statement stmt=getcon().createStatement();
			Statement stmt=ConnectionDB.getConnection().createStatement();//ConnectionDB is single responsibiltity
			stmt.execute("Insert into Employee values(emp)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
