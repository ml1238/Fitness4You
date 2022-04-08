// Mike Lopez III
// CS371 - Simple Scoreboard
// 04/06/2022

import java.util.*;

public class Student { 
   
   // Student Object has several parameters
   
   // Username, user can set any  custom username
   // default username is "Student"
   public static String username = "Student";
   // uni, user can set any University name
   // default uni is "NMSU"
   public static String university = "NMSU";
   // college, user can set any college
   // default college is "A&S"
   public static String college = "A&S";
   // dist, user distance is found from the form they submitted
   // default dist is 0.0
   public static double distance = 0.0;
   // anon, user can make their profile private
   // default privacy is "N"
   public static String privacy = "N";
   // friends[], user can add up to 100 friends
   // default friends array is empty
   public static String[] friends = new String[100];
   
   public Student( String username ) {
   
      System.out.printf("Hello %s! Please enter the following information.\n", username);
      System.out.printf("These values can always be changed later.\n\n");
      
      Scanner scan = new Scanner(System.in);
      
      setUni(university);
      getUni();
      
      setColl(college);
      getColl();
      
      setDist(distance);
      getDist();
      
      setPriv(privacy);
      getPriv();
      
      setFriends(friends);
      getFriends();
         
   } // end Student   
   
   // setUni
   public void setUni( String uni ) {
      
      Scanner scan = new Scanner(System.in);

      System.out.printf("Please enter your University: ");
      uni = scan.nextLine();
      if ( uni.equals("") ) {
         System.out.printf("No value entered, default selected\n");
         uni = university;
      } // end if
      System.out.printf("You entered %s, is that correct? (Y/N) ", uni);
      String ans = scan.next();
      if ( !ans.equalsIgnoreCase("Y") )
         setUni(uni);
      university = uni;
   } // end setUni
   
   // getUni
   public String getUni() {
      return university;
   } // end getUni
   
   // setColl
   public void setColl( String coll ) {
   
      Scanner scan = new Scanner(System.in);

      System.out.printf("Please enter your College: ");
      coll = scan.nextLine();
      if ( coll.equals("") ) {
         System.out.printf("No value entered, default selected\n");
         coll = college;
      } // end if
      System.out.printf("You entered %s, is that correct? (Y/N) ", coll);
      String ans = scan.next();
      if ( !ans.equalsIgnoreCase("Y") )
         setColl(coll);
      college = coll;
   
   } // end setColl
   
   // getColl
   public String getColl() {
      return college;
   } // end getUni
   
   // setDist
   public void setDist( double dist ) {
   
      Scanner scan = new Scanner(System.in);

      System.out.printf("Please enter your Distance: ");
      dist = scan.nextDouble();
      System.out.printf("You entered %.2f, is that correct? (Y/N) ", dist);
      String ans = scan.next();
      if ( !ans.equalsIgnoreCase("Y") )
         setDist(distance);
      distance = dist;
   
   } // end setDist
   
   // getDist
   public double getDist() {
      return distance;
   } // end getDistance
   
   // setPriv
   public void setPriv( String priv ) {
   
      Scanner scan = new Scanner(System.in);

      System.out.printf("Would you like to enable Privacy? (Y/N) ");
      priv = scan.nextLine().toUpperCase();
      if ( priv.equals("Y") )
         System.out.printf("Privacy enabled\n");
      else {
         System.out.printf("You entered %s, is that correct? (Y/N) ", priv);
         String ans = scan.next();
         if ( !ans.equalsIgnoreCase("Y") )
            setPriv(priv);
      } // end else
      privacy = priv;
   } // end setPriv
   
   // getDist
   public String getPriv() {
      return privacy;
   } // end getPriv
   
   // contains
   public boolean contains( String list[], String name ) {
      
      for ( int i = 0; i < list.length; i++ )
         if ( list[i] == null )
            return false;
            
      return true;
   } // end contains
   
   // setFriends
   public void setFriends( String friendList[] ) {
   
      Scanner scan = new Scanner(System.in);
      
      System.out.printf("Please enter your Friends: ");
      String friend = scan.nextLine();
      if ( friend.equals("") )
         System.out.printf("No value entered, do you have no friends?\n");
      
      System.out.printf("You entered %s, is that correct? (Y/N) ", friend);
      String ans = scan.nextLine().toUpperCase();
      if ( !ans.equalsIgnoreCase("Y") )
         setFriends(friendList);
      
      if ( !contains(friendList, friend) ) {
         
         System.out.printf("%s added to friend list!\n", friend);
         for ( int i = 0; i < friendList.length; i++ )
            if ( friendList[i] == null && i != friendList.length - 1) {
               friendList[i] = friend;
               friends = friendList;
               break;
            } // end if
            else
               System.out.printf("Max number of friends reached");
            
      } // end if
      
      else
         System.out.printf("%s is already on your friend list\n", friend);
         
      System.out.printf("Do you want to add more friends? (Y/N) ");
      ans = scan.nextLine().toUpperCase();
      if ( ans.equals("Y") )
         setFriends(friendList);
      
   } // end setFriends
   
   // getFriends
   public String[] getFriends() {
      return friends;
   } // end getFriends
   
   
   
   
   // Quicksort
   // sorts an array using quicksort algorithm
   // accepts an unsorted int array, returns a sorted int array
   // low is the index of the first element, high is the index of the last element
   // the time complexity of this is O(nlogn)
   public static void quicksort ( int[] array, int low, int high ) {
      
      // base case
      if ( low >= high )
         return;
      
      // calculate a pivot value for each new array
      int pivotIndex = (int)(Math.random() * (high - low + 1) ) + low;
      int pivot = array[pivotIndex];
      
      // swap pivot to the last value
      int temp = array[high];
      array[high] = array[pivotIndex];
      array[pivotIndex] = temp;
      
      // assign i to low and j to high
      int i = low, j = high;
      
      // while loop for sorting
      while ( i < j ) {
         
         // increase i until value at array[i] is less than pivot
         while ( array[i] <= pivot && i < j )
            i++;
         // decrease j until value at array[j] is greater than pivot
         while ( array[j] >= pivot && i < j )
            j--;
         
         // swap the array values at i and j
         temp = array[i];
         array[i] = array[j];
         array[j] = temp;
         
      } // end while
      
      // swap pivot to correct and final position
      temp = array[i];
      array[i] = array[high];
      array[high] = temp;
     
      // recursively quicksort left partition
      quicksort(array, low, i - 1);
      // recursively quicksort right partition
      quicksort(array, (i+1), high);
      
   } // end quickSort
   
   // Leaderboard Method
   // PRE: a sorted array
   // POST: a printed leaderboard
   public static void leaderboard( int array[] ) {
      
      // Print out leaderboard title
      System.out.printf("%10s\n", "A Simple Leaderboard");
      for ( int i = 0; i < array.length; i++ ) {
         // case #1: first "st"
         if ( i+1 == 1 )
            System.out.printf("%2d%s", i+1, "st");
         // case #2: second "nd"
         else if ( i+1 == 2 )
            System.out.printf("%2d%s", i+1, "nd");
         // case #3: third "rd"
         else if ( i+1 == 3 )
            System.out.printf("%2d%s", i+1, "rd");
         // case #4: "th"
         else
            System.out.printf("%2d%s", i+1,"th");
         System.out.printf("%7d\n", array[array.length - 1 - i]);
      } // end for
   } // end leaderboard method

   public static void main ( String args[] ) {
      
      // Declare an array the size of the input scores
      int intArray[] = new int[10];
      
      for ( int i = 0; i < intArray.length; i++ )
         intArray[i] = (int)(Math.random()*(100-1+1)+1);
      
      System.out.println("initial array" + Arrays.toString(intArray));
      quicksort(intArray, 0, intArray.length - 1);
      System.out.println("sorted array" + Arrays.toString(intArray));
      System.out.println();
      
      leaderboard(intArray);
      
      System.out.println("\n\n");
      
      Scanner scan = new Scanner(System.in);
      System.out.printf("Please enter a username to begin setup: ");
      String name = scan.nextLine();
      if ( name.equals("") ) {
         System.out.printf("No username selected, using default\n");      
         name = username;
      } // end if
      Student newStudent = new Student( name );
   
   } // end main
   
} // end SimpleScoreboard