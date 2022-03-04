import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class readHealthData {

   // Instance variables
   private String date;
   private int steps;
   private double miles;
   
   // constructor
   readHealthData() {
   
      date = "";
      steps = 0;
      miles = 0;
   
   }  // close constructor

	// Given an export.xml file. Code will read in that file and store every record date
	// that has either a miles or step value into an array called userData. 
	// Each object in userData will contain a date and its corresponding
	// steps and/or miles value. End of main prints userData out.
   public static void main (String args[]) throws FileNotFoundException {
   
      readHealthData userData[] = new readHealthData[1];
      readHealthData readData = new readHealthData();
      
      userData[0] = readData;
      
      // these are debug variables
      int debug = 1;
		
		String tempDate = "";
		int tempValueInt = 0;
		double tempValueDouble = 0;
		boolean fileFound = false;
		int dataCount = 0;
		
      try {
      
         // file to read
         File f = new File("export_J.xml");
      
         // Scanner is looking at file f
         Scanner scan = new Scanner(f);
         
         fileFound = true;
         
         // if there is a line to read, loop
         while (scan.hasNext()) {
         
            String line;
            // read in a line from the file
            line = scan.nextLine();
            // check if we care about that line
            line = parseData(line);
            
            // parseData returned data we care about, process it
            if (line != "") {
            
               // we are at first input so set the date
               if (tempDate == "")
                  tempDate = line.substring(0,line.indexOf("\n"));
            
            	//System.out.println("\nLine: " + line);
            	
            	// line has a step value
            	if (line.contains("s:"))
            
                  // this is NOT a new date (compared to the previous one)
               	if (tempDate.equals(line.substring(0,line.indexOf("\n"))))
               
                     // add the value
                  	tempValueInt = tempValueInt + Integer.parseInt(line.substring(line.indexOf(" ") + 1));
               	
               	// This is a new date (compared to the previous one)
               	else {
               	
               	   // add the old data (if there is any)
               		if (tempValueInt > 0) {
               		
                        userData = addData(userData, tempDate, 0, tempValueInt);
                        dataCount++;
                        
               		} // close if
               		
                  	// replace old date with new one
                  	tempDate = line.substring(0,line.indexOf("\n"));
                  	// reset steps to new one
                  	tempValueInt = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
               
               	} // close else
               	
               // line has a double value	
            	else
            	
            	   // this is NOT a new date (compared to the previous one)
               	if (tempDate.equals(line.substring(0,line.indexOf("\n"))))
                     
               		tempValueDouble = tempValueDouble + Double.parseDouble(line.substring(line.indexOf(" ") + 2));
               	
            		// This is a new date (compared to the previous one)
               	else {
               
               		// data to add so add it
                     if (tempValueDouble > 0) {
               		   userData = addData(userData, tempDate, tempValueDouble, 0);
               		   dataCount++;
                     } // close if
                  	
                  	// get the new date
                  	tempDate = line.substring(0,line.indexOf("\n"));
                  	// reset value for new date
                  	tempValueDouble = Double.parseDouble(line.substring(line.indexOf(" ") + 2));
               
               	} // close else   
               	
               if (debug == 0) {
         		   System.out.println(userData[dataCount].date);
         		   
               } // close debug
         	
            } // close if
         
         } // close while

			// close scanner
         scan.close();	
      
      } // close try
      
      // error handling for when export.xml file not found
      catch (FileNotFoundException ie) {
      
         System.out.println("Error: File Not Found");
         // exit main
         return;
      
      } // close catch
      
      finally {
      
         // if there was no error handling, print
         if (fileFound)
            System.out.println("File Read");

      } // close finally
      
      // loops for all indexes of userData
      for (int index = 0; index < userData.length; index++)
         // print all elements for each object in userData
         System.out.println(userData[index].date + "\nSteps: " + 
         	userData[index].steps + "\nMiles: " + userData[index].miles + "\n");
   
   } // close main
   
   // takes in a line string and determines if we care about it
   // IF we care, then is thins down the line to the what we specifically care about
   // the date and its value (either miles or steps) and returns that
   // When we don't care about the line returns an empty string
   public static String parseData (String s) {
   
      String tempValue, date;
      
      // line is a record of steps
      if (s.contains("HKQuantityTypeIdentifierStepCount")) {
      
         int valueIndex = s.indexOf("value");
         int creationDateIndex = s.indexOf("creationDate");
         int startDateIndex = s.indexOf("startDate");
         
         // get the steps 
         tempValue = s.substring(valueIndex);
         tempValue = tempValue.substring(tempValue.indexOf("\"") + 1,tempValue.lastIndexOf("\""));
         
         // get the date
         date = s.substring(creationDateIndex, startDateIndex);
         date = date.substring(date.indexOf('\"') + 1, date.indexOf('\"') + 11);
      
         return date + "\ns: " + tempValue;
      
      } // close if

      // line is a record of miles
      else if (s.contains("HKQuantityTypeIdentifierDistanceWalkingRunning")) {
      
      	int valueIndex = s.indexOf("value");
         int creationDateIndex = s.indexOf("creationDate");
         int startDateIndex = s.indexOf("startDate");
         
         // get the miles
         tempValue = s.substring(valueIndex);
         tempValue = tempValue.substring(tempValue.indexOf("\"") + 1,tempValue.lastIndexOf("\""));
         
         // get the date
         date = s.substring(creationDateIndex, startDateIndex);
         date = date.substring(date.indexOf('\"') + 1, date.indexOf('\"') + 11);
      
         return date + "\nm: " + tempValue;
      
      } // close if else
      
      // line is info we don't care about throw it away
      return "";
   
   } // close parseData
   
   // Given a date (string d) and either miles (double valueD) or steps (int valueI) inputs miles or steps
   // into its correct date in the userData array
   public static readHealthData[] addData (readHealthData[] userData, String d, double valueD, int valueI) {
   /* THIS IS MY ATTEMPT TO FIX 1st INDEX PROBLEM DOSENT WORK
      if (userData[1].date == "" && userData[1].miles == 0 && userData[1].steps == 0) {
      	userData[1].date = d;
      	userData[1].miles = valueD;
      	userData[1].steps = valueI;
      } // close if
   */
   
      // check if this date exists in the user data already
      for (int index = 0; index < userData.length; index++) {
      
         // the date exists in userData
         if (userData[index].date.equals(d)) {
         
            // check if input is double or int
            // input is int
            if (valueD == 0)
            
               // check if steps is empty
               // steps is empty
               if (userData[index].steps == 0) {
               
                  userData[index].steps = valueI;
                  return userData;
                  
               } // close if
               
               // steps is not empty
               else
         			// something already in steps
                  return null;
            
            // input is double
            else if (valueI == 0)
            
               // check if steps is empty
               // miles is empty
               if (userData[index].miles == 0) {
               
                  userData[index].miles = valueD;
                  return userData;
                  
               } // close if
               
               // miles is not empty
               else
         			// something already in miles
                  return null;
            
         } // close if
         
         // date does not exists at current index, empty statement to check next index
         else if (index < userData.length - 1)
         
            ;
            
         // date does not exists and we checked every index, add the date
         else {
         
            readHealthData[] biggerArray = new readHealthData[userData.length + 1];
            
            for (int transferIndex = 0; transferIndex < userData.length; transferIndex++)
               biggerArray[transferIndex] = userData[transferIndex];
            
            biggerArray[userData.length] = new readHealthData();   
            biggerArray[userData.length].date = d;
            
            // recursive call
            return addData(biggerArray, d, valueD, valueI);
            
         } // close else
      
      } // close for
   
      return userData;
   
   } // close addDate

} // close class