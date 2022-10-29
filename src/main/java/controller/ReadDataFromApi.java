package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ReadDataFromApi {

	public static void main(String[] args) {
		 try {
			    URL url = new URL("https://www.fruityvice.com//api/fruit/all");
	            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	            if (connection.getResponseCode() == 200) {
	                InputStream inputStream = connection.getInputStream();
	                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	                FileWriter fileWriter=new FileWriter("E://dp.json");
	                BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
	                String line = bufferedReader.readLine();
	                while (line != null) {
	                    System.out.println(line);
	                    bufferedWriter.write(line);
	                    bufferedWriter.newLine();
	                    line = bufferedReader.readLine();
	                }
	                bufferedWriter.close();
	            }
		 } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	}


