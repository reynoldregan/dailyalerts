package in.redeemer.io;

import in.redeemer.dto.Subs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadSubs {

	public String read(String file)
	{
		StringBuilder sb=new StringBuilder();
		try {
			FileReader fr=new FileReader(file+"\\Subs");
			BufferedReader br=new BufferedReader(fr);
			
			String temp="";
			while((temp=br.readLine())!=null)
			{
				sb.append(temp);
				
			}
			
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	
}
