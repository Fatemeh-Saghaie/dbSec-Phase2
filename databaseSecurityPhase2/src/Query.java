import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import net.Cryptor;
import net.MerkleTree;
import databaseSecurityPhase2.indexes;

public class Query {
	indexes index = new indexes();
	Cryptor crypt = new Cryptor();
	

	public Query() {
		// TODO Auto-generated constructor stub
		encInsert("users", "owner,1234,0,100,0,0,0,100");
	}

	public String encInsert(String table, String values) {

		String[] arr = values.split(",");
		if (arr.length > 0) {

			try (
					Connection connection = DriverManager.getConnection(
					"jdbc:postgresql://localhost:5432/hospital1", "postgres",
					"fa6121373")) {

				Statement statement = connection.createStatement();
				ResultSet rs = statement.executeQuery("SELECT * FROM " + table);
				List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
				ResultSetMetaData metaData = rs.getMetaData();

				int columnCount = metaData.getColumnCount();

				while (rs.next()) {
					Map<String, Object> columns = new LinkedHashMap<String, Object>();

					for (int i = 1; i <= columnCount; i++) {
						System.out.println(rs.getObject(i));
						columns.put(metaData.getColumnLabel(i), rs.getObject(i));
					}

					rows.add(columns);
				}

				for (int i = 0; i < rows.size(); i++) {
					for (String s : rows.get(i).keySet()) {
						System.out.println(s.toString() + " <---> "
								+ rows.get(i).get(s).toString());
					}

				}

				Object[] col = rows.get(0).keySet().toArray();
				Vector<Integer> indexes2 = new Vector<Integer>();

				for (int i = 0; i < arr.length; i++) {
					Method method = index.getClass().getDeclaredMethod(col[i].toString().trim()
							+ "_index",String.class);
					
					Integer tmp = (Integer) method.invoke(index,arr[i].toString().trim());
					indexes2.add(tmp);
				}

				String encValue = new String();
				String indxValue = new String();
				
				
				for (int i = 0; i < arr.length; i++) {
					encValue = encValue+"#"+ arr[i].trim();
					indxValue = indxValue+ indexes2.get(i).toString().trim()+",";
				}

				String my_crypt_result = crypt.encrypt("fatemehfaezeh123" , "RandomInitVector", encValue);

				
				MerkleTree merkleT = new MerkleTree(Arrays.asList(arr));
				String hash = merkleT.getRoot().sigAsString();
				
				Statement statement2 = connection.createStatement();
				int res = statement2.executeUpdate("INSERT INTO "+ table +" values ( " + indxValue + "\'"+ hash +"\',\'"+my_crypt_result+"\' ) ");
				System.out.println("inserted   "+ res+" values");
			} catch (SQLException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				System.out.println("Connection failure.");
				e.printStackTrace();
			}

		}

		return null;
	}

	public static void main(String[] args) {
		// CONNECTING TO POSTGRES DATABASE

		new Query();
	}
}
