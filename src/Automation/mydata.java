package Automation;

import java.util.Random;

public class mydata {
 Random rand= new Random();
 String [] firstName= {"majd","salsabeel","sara","ahmad","ayham"};
 String [] lastName= {"majed","naser","sari","mohamad","hayel"};
 int randomFN=rand.nextInt(firstName.length);
 int randomLN=rand.nextInt(lastName.length);
 String Domain= "@gmail.com";
 int rannumforgmail=rand.nextInt(4567890);//عشان اصنع اكبر عدد من اليوزر واضمن مايصير تكرار		
 String inputFn=firstName[randomFN];
	String inputLN=lastName[randomLN];
	String inputEmail=inputFn+inputLN+rannumforgmail+Domain;
	String inputPhonenum="0790315914";
	String inputFaxnum="123780";
	int stateindex=rand.nextInt(1704,1716);
	String loginNameInput=inputFn+inputLN+rannumforgmail;
	String passinput=""+rand.nextInt(1235856);
	int subscribebtn=rand.nextInt(2);
	


 
}
