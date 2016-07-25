package in.redeemer.io;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import in.redeemer.alerts.Mail;
import in.redeemer.constants.Constants;
public class Content {
	
	public String fetchData() throws IOException
	{
		  Document doc = Jsoup.connect(Constants.SITE_URL).get();  
         
          Element verse=doc.getElementsByClass(Constants.SITE_CLASS).get(0);
         
          String verseText[]=verse.text().split("—");
          
          //Mail.sendMail("reynoldregan94@gmail.com,medicus.live@gmail.com",title ,verseText[0]+Constants.BR+"-"+verseText[1] );
          
          //img id tv-image
          //Thought thought
          Element thought=doc.getElementById(Constants.THOUGHT);
          System.out.println(thought.toString());
          
          Element verse_img=doc.getElementById(Constants.IMG);
          System.out.println(verse_img.toString());
          
          return Constants.MESSAGE_TAG_START+Constants.CENTER+verse_img.toString()+Constants.CCENTER+Constants.BR+Constants.MESSAGE_TAG_P_START+thought.toString()+Constants.MESSAGE_TAG_P_END;
		
	}

}
