import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileRead3 {

	public static void main(String[] args) {
		try {
			int serialNumber = 0;
			InputStream res = FileRead3.class.getResourceAsStream("/test.txt");
			JSONArray array1 = new JSONArray();

			BufferedReader reader = new BufferedReader(new InputStreamReader(res));
			String line = null;
			while ((line = reader.readLine()) != null) {
				JSONObject obj1 = new JSONObject();
				if (line.contains("INSERT")) {
					StringBuilder builder = new StringBuilder();
					String[] values = line.split(" ");
					serialNumber++;
					String name = values[5].replace(",", "");
					String time = values[1];
					obj1.put("id", serialNumber);
					obj1.put("appName", name);
					obj1.put("timeStamp", time);

					array1.add(obj1);
				}
			}

			JSONObject obj1 = new JSONObject();
			obj1.put("studies", array1);
			System.out.println(obj1);

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
