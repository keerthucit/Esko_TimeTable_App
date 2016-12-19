package eskotimetableapp;

import java.io.*;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.File;
public class main {

   public static void main(String args[]) throws Exception {          
          int count=0;
         String line;
         BufferedWriter bw = null;
 		FileWriter fw = null;

         try (        	      		 
    
     FileReader fr = new FileReader("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/timetable.txt");
     BufferedReader br = new BufferedReader(fr);
      //OutputStream outputStream = new FileOutputStream("c:/wamp/www/eskotimetableapp/src/eskotimetableapp/ttable.txt");
  FileOutputStream fos = new FileOutputStream("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/ttable.txt");
 BufferedWriter bw1 = new BufferedWriter(new OutputStreamWriter(fos));
        				
         ) {
        	 try {        		                                                 
             while ((line = br.readLine()) != null) {
            	 count++;
           	  String[] words = line.split(" ");
           	 if(words.length > 1)
           	 {
           	String time1 = words[1]+":00";
           	String time2 = words[2]+":00";
           	SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
           	Date date1 = format.parse(time1);
           	Date date2 = format.parse(time2);
           	long diff = date2.getTime() - date1.getTime(); 
           	 if(diff > 3600000)
           	 { }
           	 else 
           		 bw1.write(line+" ");
           	// bw1.write("\n");
             }//end if words length
           	 else
           		 bw1.write(line);
           	 bw1.write("\n");
             }
           	 
             }catch (ParseException e) {
            	  
            	  e.printStackTrace();
            	}//end inner try 
         }//end wwhile
  
         
        String line111,line222,name1,name2; 
        long x1=0,x2=0,y1=0,y2=0,flag=123;
         StringBuffer s1 = new StringBuffer();
         StringBuffer s2 = new StringBuffer();
                                     
              String f="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/ttable.txt";
              File ff=new File("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/ttable.txt");
              System.out.println(ff.length() + "\t"+ count);
             
              s1=new StringBuffer();
           BufferedReader brr=new BufferedReader(new FileReader(f));
              
              while((line111 = brr.readLine()) != null)  
                 { //System.out.println(line111);
            	  String[] words = line111.split(" "); 
         
         if(words.length == 3){ System.out.println(line111);
        	 				    name1=words[0];
         					if(name1.equals("Veeru")){break; }
                    	String time111 = words[1]+":00";
                    	String time222 = words[2]+":00";
                    	try
                    	{
                    		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                    	
                    	Date date111 = format.parse(time111);
                    	Date date222 = format.parse(time222);
                    	 x1=date111.getTime();
                    	 x2=date222.getTime();
                    	}catch (ParseException e) {                	  
                       	  e.printStackTrace();
                     	}                  
                    	
         
        try{ String g="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/ttable.txt";
         RandomAccessFile raf = new RandomAccessFile("g", "rwd");
             
          BufferedReader br2 = new BufferedReader (new FileReader(g));   
              while((line222 = br2.readLine()) != null)
         { raf.readLine();
            	
            	  String[] wordsnext = line222.split(" "); 
         if(wordsnext.length > 1)
                    	 { 
          name2=wordsnext[0];
         if(name2.equals("Veeru"))
        		 { System.out.println("compare"+line222);
                    	String time11 = wordsnext[1]+":00";
                    	String time22 = wordsnext[2]+":00";
                    	try
                    	{
                    	SimpleDateFormat format1 = new SimpleDateFormat("HH:mm:ss");
                    
                    		Date date11 = format1.parse(time11);
                    	
                    	Date date22 = format1.parse(time22);
                    	 y1 = date11.getTime();
                    	 y2 = date22.getTime();
                    	}catch (ParseException e) {                	  
                       	  e.printStackTrace();
                     	}
                    	

      
                    	//jai x1-Dt x2 -At veeru y1-Dt y2-AT
                    	if( x1 == y1 ){
                    		
                    		if(x2==y2){
                    			//bothdep at sametime arriv at sametime jai
                    			 flag=1;
                    			s1.append(line111+"\n");
                    		raf.seek(0);raf.writeUTF("NULL");
                    		}                  		
                    		
                    		//bothdep at sametime earlier arriv 
                    		if(x2<y2){ flag=2;s1.append(line111+"\n");raf.seek(0);raf.writeUTF("NULL");}
                    		else if(y2<x2){ flag=3;s2.append(line222+"\n");}
                    	
                    	}//jaiselctions
                    	
                    	if(x2==y2)
                    	{
                    		//who is starting later and reaches same time
                    		if(x1>y1){ flag=2;s1.append(line111+"\n");raf.seek(0);raf.writeUTF("NULL");}
                    		else if(x1<y1){ flag=3;s2.append(line222+"\n");}
                    		
                    	}
                    	if((x1 > y1)&&(x2 < y2)){
                    	 
                    	 //starts later and reaches earlier
                    		 flag=2;s1.append(line111+"\n");raf.seek(0);raf.writeUTF("NULL");
                    		
                    	}else if((y1 > x1)&&(y2 < x2)){ flag=3;s2.append(line222+"\n");}
                    	
                    	//if(flag==123){s1.append(line111);}
                        	
                    		                	
        
         }//if veeru
         }//if wordsnext
         }//while veeru
                  
      
       raf.close();}catch (IOException ex) {
           ex.printStackTrace();
           }//end try raf
   
         }//end if outer
                 }//end while outer
             
              
              String f1="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/output1.txt";
              String f2="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/inter.txt";

              BufferedWriter bwr = new BufferedWriter(new FileWriter(new File("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/output1.txt")));
              
              //write contents of StringBuffer to a file
              bwr.write(s1.toString());
              bwr.flush();              
              //close the stream
              bwr.close();
 BufferedWriter bwr1 = new BufferedWriter(new FileWriter(new File("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/inter.txt")));
              
              //write contents of StringBuffer to a file
              bwr1.write(s2.toString());  
              bwr1.flush();              
              //close the stream
              bwr1.close();
         //---
         
              
         
         //To get the remaining jai veeru records   
               
                        
              
              StringBuffer n1 = new StringBuffer();
              String nline;
              
            String fnew="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/ttable.txt";
         BufferedReader brn=new BufferedReader(new FileReader(fnew));
            
            while((nline = brn.readLine()) != null)  
               { //System.out.println(nline);
          	  String[] nwords = nline.split(" "); 
       
       if(nwords.length == 3){ 
           n1.append(nline+"\n");}
               }//end while brn

            BufferedWriter bwr2 = new BufferedWriter(new FileWriter(new File("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/output.txt")));
            
            //write contents of StringBuffer to a file
            bwr2.write(n1.toString());
            bwr2.flush();              
            //close the stream
            bwr2.close();  
              
            
        //compare and write new file    
            

            String nline1,nline2;
            //int flagx=0;
          StringBuffer buffer1 = new StringBuffer();                                        
        String fout1="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/output1.txt";

          StringBuffer buffer2 = new StringBuffer();                                        
        String finter="c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/inter.txt";

     BufferedReader brout1=new BufferedReader(new FileReader(fout1));
     BufferedReader brinter=new BufferedReader(new FileReader(finter));
     buffer1.append("<Jai-Service>"+"\n");
        while((nline1 = brout1.readLine()) != null)  
           { 
      	         	buffer1.append(nline1+"\n");
        	 buffer1.append("<Jai-Service>"+"\n");
           }
        	
        buffer1.append("<Veeru-Service>"+"\n");
        while((nline2 = brinter.readLine()) != null)  
           { 
        	buffer1.append(nline2+"\n");
       	 buffer1.append("<Veeru-Service>"+"\n");
           }
       // buffer1.append("<Veeru-Service>"+"\n");
        System.out.println(buffer1);
      	
        BufferedWriter bwout = new BufferedWriter(new FileWriter(new File("c:/Users/sysfore/workspace/eskotimetableapp/eskotimetableapp/src/eskotimetableapp/output.txt")));
        
        //write contents of StringBuffer to a file
        bwout.write(buffer1.toString());  
        bwout.flush();              
        //close the stream
        bwout.close();       
            
                        
     
         
   }
   }