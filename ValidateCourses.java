package validation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCourses {

	public static void main(String[] args) throws IOException {
		try {
            List<Course> course = new ArrayList<Course>(); //creates array list of course objects
			File f = new File("courses.txt"); //locates file
            Scanner s = new Scanner(f); //creates scanner object
            s.nextLine(); //tell scanner to skip first line in input file containing column headings
            while(s.hasNextLine()){ //start while loop to scan all input file until no more lines
                String line = s.nextLine(); //put each line of data into a string
                checkPipeCountPerLine(line);
                String[] details = line.split("\\|"); //split each string of data between pipes | in the line and put them into an array
                String courseNum = details[0]; //put each string from the array into a string
                String department = details[1];
                String callNum = details[2];
                String days = details[3];
                String time = details[4];
                String instructor = details[5];
                String roomNum = details[6];
                String building = details[7];
                String enrolledNum = details[8];
                String absence = details[9];

                //int count = 1;
                
                isNotEmpty(courseNum, department, callNum, days, time, instructor, roomNum, building, enrolledNum, absence);
                Course c = new Course(courseNum, department, callNum, days, time, instructor, roomNum, building, enrolledNum, absence); //add those strings into the room object
        		course.add(c); //add that room object to the array of rooms created earlier
        		//count++;               
            }
            s.close();
            
        	for(Course c: course){
        		isValidInteger(c.getCourseNum());
        		isValidInteger(c.getCallNum());
        		checkRange(c.getCourseNum());
        		isCharacter(c.getDepartment());
        		isCharacter(c.getBuilding());
        		checkLength(c.getCallNum());
        		checkDays(c.getDays());
        		checkFormat(c.getInstructor());
        		checkEnrolledNum(c.getEnrolledNum());
        		checkAbsence(c.getAbsence());
        	}
            
            printInput(course); //call method to print the input stored in list of room objects          
        } catch (FileNotFoundException e) { //if file not found throw error message
            e.printStackTrace();
        }
	}
	
	//Method printing the Course object
    private static void printInput(List<Course> c1) { //method that accepts list of room objects and prints them
        List<Course> course = c1;
        System.out.printf("\t\t" +  "CourseNum"		//print statement to print details of each line
                +  " Department"
                +  " CallNum"
                +  " Days"
                +  " Time"
                +  " Instructor"
                +  " RoomNum"
                +  " Building"
                +  " EnrolledNum"
                +  " Absence" + "\n");
        int count1 = 1; 
        for(Course c: course){ 
            System.out.printf("Line " + count1 + ": "
                    + "\t" +  c.getCourseNum() 
                    + "\t" + c.getDepartment()
                    + "\t " + c.getCallNum()
                    + "\t  " + c.getDays()
                    + "\t  " + c.getTime()
                    + "\t" + c.getInstructor()
                    + "\t\t  " + c.getRoomNum()
                    + "\t  " + c.getBuilding()
                    + "\t" + c.getEnrolledNum()
                    + "\t  " + c.getAbsence() + "\n");
            count1++; 
        }
    }
    
	//Method checking for correct number of fields per line
    public static boolean checkPipeCountPerLine(String s1){
    	int pipeCount = 0;
    	for (int i=0; i<s1.length(); i++){
    		if ('|' == s1.charAt(i)){
    			pipeCount++;
    		}
    	}
    	if (pipeCount == 6){
    		return true;
    	} else {
    		return false;
    	}
    }
	
    //Method to test for empty values
    public static boolean isNotEmpty(String i1, String i2, String i3, String i4, String i5, String i6, String i7, String i8, String i9, String i10) { 
        String[] inputs = {i1, i2, i3, i4, i6, i7, i8, i9, i10};
        for(String test : inputs) {	
            if (test == null || test.trim().isEmpty()) { 
                System.out.println("Input cannot be empty"); 
                break;
            } else {return false;}
        } return true;
    }
	
    //Method to test string to see if it is a valid integer
    public static boolean isValidInteger(String num) {	
        try{
            Integer.parseInt(num);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }

    //Method checking if courseNum values range from 001 through 999
    public static boolean checkRange(String num)
    {
        int i = Integer.parseInt(num);
    	if (i > 0 && i < 100);  
    	return true;
    }
    
    //Method checking if a string consists of alphabets
    public static void isCharacter(String input){
	   Pattern p = Pattern.compile("([a-zA-Z])");
	   Matcher m = p.matcher(input);
	   if (!m.matches()) {
		   System.out.println("Input should consist of alphabetical characters");
	   }
   }
    
    //Method checking if a string is five-characters-long 
    public static boolean checkLength(String input){
	   int length = input.length();
	   if (length <= 5){
		   return true;
	   }else {return false;}
   }
    
    //Method checking if days consist of '10100', '01010', or '10101'
    public static boolean checkDays(String input){
    	String [] days = { "10100", "10101", "01010" };
    	for (String d : days){
    		if (input.equals(d)){
    			break;
    		} else {
    			System.out.println("Input must match the valid patterns.");
    		}
    	} return true;
    	
    }
    
    //Method checking the right format for instructor name (alphabet, alphabet alphabet.) no special characters
    public static boolean checkFormat(String input){
    	Pattern p = Pattern.compile("([a-zA-Z]|\\.|\\,)+");
    	Matcher m = p.matcher(input);
    	if (m.matches()) {
    	  return true;
    	}else {return false;}
    }
    
    //Method checking enrolledNum is between 0 and 1000
    public static boolean checkEnrolledNum(String num)
    {
        int i = Integer.parseInt(num);
    	if (i >= 0 && i <= 1000);  
    	return true;
    }
    
    //Method checking absence is either 'YES' or 'No'
    public static boolean checkAbsence(String input){
    	String [] absence = { "YES", "NO"};
    	for (String a : absence){
    		if (input.equals(a)){
    			break;
    		} else {
    			System.out.println("Input must be either 'YES' or 'NO'.");
    		}
    	} return true;
    	
    }
}
