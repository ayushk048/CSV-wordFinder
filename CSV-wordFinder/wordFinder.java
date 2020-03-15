import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class wordFinder {

	public static void main(String[] args) {

	    {
	        Scanner scanner = new Scanner(System.in);
	        BufferedReader br = null;
	        Keyword keyword ; 
	        System.out.print("Enter character : ");
	        String string = scanner.next();
	        int count = 0 ;
            	        boolean flag = false;
	        
	        try
	        {
	        	br = new BufferedReader(new FileReader("keywords.csv"));
	           
	           	final List<Keyword> list = new ArrayList<Keyword>();
	           	String line = "";
	      
	           	br.readLine();
	            
	            while ((line = br.readLine()) != null) 
	            {
	                final String[] KeywordDetails = line.split(",");
	                
	                if(KeywordDetails.length > 0 )
	                {
	                	keyword  = new Keyword(KeywordDetails[0] , Integer.parseInt(KeywordDetails[1]));
	                	list.add(keyword);
	                }
	            }
	            
	            Comparator<Keyword> comparatorScore = new Comparator<Keyword>() {
	            	public int compare(Keyword o1, Keyword o2) {
	            		if(o1.getScore() > o2.getScore()) {
	            			return 1;
	            		}
	            		else if (o1.getScore()< o2.getScore()) {
	            			return -1;
	            		}
	            		else {			
	            			return 0;
	            		}
	            	}
	            };
	            //sort list based on score
	            Collections.sort(list , comparatorScore);
				//reverse orderList
				Collections.reverse(list);

				for (Keyword string1 : list) {
	            	if(string1.getKeyword().startsWith(string) && count < 10) {
	            		System.out.println(string1.getKeyword() + " (" + string1.getScore()+")" );
	            		count++;
	            		flag = true ;
	            	}
				}
				if (!flag) {
					System.out.println("Sorry word not Found...");
				}
	            
//	            scanner close
				scanner.close();
	        }
	        catch(final Exception ee)
	        {
	            ee.printStackTrace();
	        }
	        finally
	        {
	            try
	            {
	                br.close();
	            }
	            catch(final IOException ie)
	            {
	                System.out.println("Error occured while closing the BufferedReader");
	                ie.printStackTrace();
	            }
	        }
	    }
	}
}