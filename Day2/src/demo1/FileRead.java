package demo1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileRead {

	public static void main(String[] args) {
		try {
			int serialNumber = 0;
			InputStream res = FileRead.class.getResourceAsStream("/test.txt");

			BufferedReader reader = new BufferedReader(new InputStreamReader(res));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (line.contains("INSERT")) {
					StringBuilder builder = new StringBuilder();
					String[] values = line.split(" ");
					serialNumber++;
					String name = values[5].replace(",", "");
					String time = values[1];
					builder.append(serialNumber).append(" ").append(name).append(" ").append(time);
					System.out.println(builder);

				}

			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

}
