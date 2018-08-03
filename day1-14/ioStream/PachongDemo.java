package ioStream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PachongDemo {

	public static void main(String[] args) throws IOException {

		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		PrintStream out= System.out;
		//out.println("Enter a URL:");
		//String url = input.readLine();
		String url = "https://github.com/requests/httpbin";
		crawler(url);
	}

	public static void crawler(String StartingURL) {
		List<String> listOfPendingURLs = new ArrayList<>();
		List<String> listOfTraversedURLs = new ArrayList<>();

		listOfPendingURLs.add(StartingURL);
		while (!listOfPendingURLs.isEmpty() && listOfTraversedURLs.size() <= 100) {
			String urlString = listOfPendingURLs.remove(0);
			if (!listOfTraversedURLs.contains(urlString)) {
				listOfTraversedURLs.add(urlString);
				System.out.println("Crawl: " + urlString);
				
				for(String s : getSubURLs(urlString)){
					if(!listOfTraversedURLs.contains(urlString)){
						listOfPendingURLs.add(s);
					}
				}
			}
		}
	}

	private static List<String> getSubURLs(String urlString) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		try{
			URL url = new URL(urlString);
			@SuppressWarnings("resource")
			Scanner input = new Scanner(url.openStream());
			int current = 0;
			
			while(input.hasNext()){
				String line = input.nextLine();
				current = line.indexOf("https:", current);
				if(current > 0){
					int endIndex = line.indexOf("\"", current);
					if(endIndex > 0){
						list.add(line.substring(current, endIndex));
						current = line.indexOf("https:", endIndex);
					}
					else
						current = -1;
				}
			}
		}catch(Exception ex){
			System.out.println("Error:" + ex.getMessage());
		}
		for(String s: list){
			System.out.println("URL in Page:" + s);
		}
		return list;
	}
}
