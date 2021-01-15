package JsonManipulate.JsonManipulate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class FileRead2 {

	public static void main(String[] args) {
		try {
			int serialNumber = 0;
			InputStream res = FileRead2.class.getResourceAsStream("/test.txt");
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

			System.out.println("Enter appName:");
			Scanner sc = new Scanner(System.in);
			String appName = sc.next();
			for (int i = 0; i < array1.size(); i++) {

				JSONObject obj1 = (JSONObject) array1.get(i);

				if (appName.equals(obj1.get("appName"))) {

					System.out.println("timeStamp:");

					System.out.println(obj1.get("timeStamp"));

				}
			}

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
