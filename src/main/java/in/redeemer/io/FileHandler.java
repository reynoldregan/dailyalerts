package in.redeemer.io;

import in.redeemer.constants.Constants;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileHandler {

	public void writeLastLog()
	{
		try {
			FileWriter fw=new FileWriter(Constants.LAST_SENT_LOG_LOCATION,false);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			
			fw.write(sdf.format(new Date()));
			fw.close();
			
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public boolean readLastSentLog()
	{
		boolean send_state=true;
		String Last_sent_date="";
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		String today=sdf.format(new Date());
		try {
			FileReader fr=new FileReader(Constants.LAST_SENT_LOG_LOCATION);
			BufferedReader br=new BufferedReader(fr);
			while((Last_sent_date=br.readLine())!=null)
			{
				if(Last_sent_date.equals(today))
				{
					send_state=false;
				}
			}
			
		} catch (FileNotFoundException e) {
			send_state=false;
			e.printStackTrace();
		} catch (IOException e) {
			send_state=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return send_state;
		
	}
	public static void main(String[]args) throws ParseException
	{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf.format(new Date()));
	}
}
