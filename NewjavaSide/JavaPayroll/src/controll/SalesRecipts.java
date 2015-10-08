package controll;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SalesRecipts extends ArrayList<SalesRecipt>{
	
	private static final long serialVersionUID = -8415958976030989903L;

	public SalesRecipts() {}
	
	public SalesRecipts(ResultSet table) {
		try {
			while (table.next()) {
				SalesRecipt sr = new SalesRecipt(table.getInt("id"), table.getInt("employee"), table.getString("date"), table.getFloat("amount"));
				add(sr);
			}
		} catch(SQLException e) {
			JOptionPane.showMessageDialog(null,e,"Error:", JOptionPane.ERROR_MESSAGE);
		}
	}
	

}
