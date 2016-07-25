package in.redeemer.util;

import in.redeemer.alerts.Mail;
import in.redeemer.io.Content;
import in.redeemer.io.FileHandler;
import in.redeemer.io.ReadSubs;

import java.io.IOException;
import java.util.Date;


public class Task   {

	private static String path="";
	
	public Task(String p_path)
	{
		path=p_path;
	}
	public void run() {
		
		System.out.println("Executed "+new Date());
		System.out.println(path);
		String mesageContent="";
		FileHandler fh=new FileHandler();
		Content ct=new Content();
		try {
			mesageContent=ct.fetchData();
			if(mesageContent!=null&&mesageContent.length()>0&&fh.readLastSentLog())
			{
				if(Mail.sendMail(new ReadSubs().read(path),mesageContent))
				{
					
					fh.writeLastLog();
				}
				
			}
			else{
				System.out.println("Today's Task ended");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
