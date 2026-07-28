import java.util.Scanner;
public class finalProjectTest6 {

	public static void main (String args[]) {
		
		char [][] theboard = {{' ','b',' ','b',' ','b',' ','b'},
                              {'b',' ','b',' ','b',' ','b',' '},
                              {' ','b',' ','b',' ','b',' ','b'},
                              {' ',' ',' ',' ',' ',' ',' ',' '},
                              {' ',' ',' ',' ',' ',' ',' ',' '},
                              {'w',' ','w',' ','w',' ','w',' '},
                              {' ','w',' ','w',' ','w',' ','w'},
                              {'w',' ','w',' ','w',' ','w',' '}};


//asking for mode of playing 
System.out.println("Choose your mode of playing");
System.out.println("1-Easy");
System.out.println("2-Medium");

int x=0;
Scanner xi= new Scanner(System.in);
x = xi.nextInt();

if (x==1) {
easymode(theboard);
}

if (x==2) {
mediummode(theboard);
}}

public static void easymode(char [][] theboard) {
	
	boolean GameFinished= false;
	do {
		//printing the board
		int [] selectedcoordinates = new int [2];
		int [] movetocoordinates = new int [2];
		 System.out.println("Blacks Move");
		 printing(theboard);
		//blackchoice of coordinates
		
		 selectedcoordinates=choiceofcoordinates();
		 //just declaration of selectedcoordinates in case unreadable 
		 // an entire g=funtion that decides wheather or not the piece can move
		
		 blackchoiceofcoordinates(theboard,selectedcoordinates,movetocoordinates);
		
		 
		if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='b') {
			theboard[selectedcoordinates[0]][selectedcoordinates[1]]=' ';
			normalblackmovements(theboard,selectedcoordinates,movetocoordinates);
		}
		
		
	
		 //whitesmove
		 System.out.println("white Move");
		 printing(theboard);
		//  white coice of coordinates
		 
		 //just to change value of selected coordinates 
		 int temp3[] = new int [2]; 
	     temp3 = choiceofcoordinates();
	     selectedcoordinates=temp3;
		 
		 whitechoiceofcoordinates(theboard,selectedcoordinates,movetocoordinates);
		 
		//whites movement
		 
		if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='w') {
			
			theboard[selectedcoordinates[0]][selectedcoordinates[1]]=' ';
			normalwhitemovements(theboard,selectedcoordinates,movetocoordinates);
		}
		
		 GameFinished=isGameFinished(theboard);  
		
	} while (!GameFinished);
	
	
}
	
public static void mediummode(char [][] theboard) {
	boolean GameFinished= false;
	
	do {
		//printing the board
		int [] selectedcoordinates = new int [2];
		int [] movetocoordinates = new int [2];
		 System.out.println("Blacks Move");
		 printing(theboard);
		//blackchoice of coordinates
		
		 selectedcoordinates=choiceofcoordinates();
		 //just declaration of selectedcoordinates in case unreadable 
		 // an entire g=funtion that decides wheather or not the piece can move
		 blackchoiceofcoordinates(theboard,selectedcoordinates,movetocoordinates);
		
     	 //if choosen piece is a king 
		 //different methods to evaluate movement 
		 if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='B'){
			 theboard[selectedcoordinates[0]][selectedcoordinates[1]]=' ';
			 blackkingsmovements(theboard,selectedcoordinates,movetocoordinates);
		 }
		 
		if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='b') {
			theboard[selectedcoordinates[0]][selectedcoordinates[1]]=' ';
			normalblackmovements(theboard,selectedcoordinates,movetocoordinates);
		}
		
		//asses if after movemets a piece can be crowned 
		 beKingBlack(theboard);
	
		 //whitesmove
		 System.out.println("white Move");
		 printing(theboard);
		//  white coice of coordinates
		 
		 //just to change value of selected coordinates 
		 int temp3[] = new int [2]; 
	     temp3 = choiceofcoordinates();
	     selectedcoordinates=temp3;
		 
		 whitechoiceofcoordinates(theboard,selectedcoordinates,movetocoordinates);
		 
		//whites movement
		 if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='W'){
			 
			 theboard[selectedcoordinates[0]][selectedcoordinates[1]]=' ';
			 whitekingmovement(theboard,selectedcoordinates,movetocoordinates);
		 }
		if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='w') {
			
			theboard[selectedcoordinates[0]][selectedcoordinates[1]]=' ';
			normalwhitemovements(theboard,selectedcoordinates,movetocoordinates);
		}
		
		 beKingWhite(theboard);
		 GameFinished=isGameFinished(theboard);  
		
	} while (!GameFinished);
}

private static void printing(char [][] theboard) {
	 int count=0, count1=0;
	    System.out.println("  0   1   2   3   4   5   6   7");
		System.out.println("_________________________________");
		for ( int i = 0 ; i < theboard.length ; i++) {
			for ( int j=0; j< theboard[i].length;j++) {
		System.out.print("| "+theboard[i][j]+ " " );
		count ++;
		if (count ==8) {

		count=0;
		System.out.print("|");
		System.out.print(count1);
		count1++;
		System.out.println("");
		
		}}}
	
}

public static void blackchoiceofcoordinates(char [][] theboard,int [] selectedcoordinates,int [] movetocoordinates) {
	 
     
	 boolean blackchoicevalid = isblackchoicevalid(theboard,selectedcoordinates,movetocoordinates);

    if (!blackchoicevalid) {
			do {
				System.out.println("This choice is invalid");
				int temp1[] = new int [2];
				//temp is necessary to change the value of coordinates
				temp1 = choiceofcoordinates();
				selectedcoordinates=temp1;
				blackchoicevalid = isblackchoicevalid(theboard,selectedcoordinates,movetocoordinates);
			} while (!blackchoicevalid);
			//line of code after true that choice is valid 
			
		
}
}
public static void whitechoiceofcoordinates(char [][] theboard,int [] selectedcoordinates,int [] movetocoordinates) {
	 
	 
     
    boolean whitechoicevalid = iswhitechoicevalid(theboard,selectedcoordinates);
     
    if (!whitechoicevalid) {
			do {
				System.out.println("This choice is invalid");
				int temp4[] = new int [2];
				//temp is necessary to change the value of coordinates
				temp4 = choiceofcoordinates();
				selectedcoordinates=temp4;
				whitechoicevalid = iswhitechoicevalid(theboard,selectedcoordinates);
			} while (!whitechoicevalid);
			//actions if choosen coordinates is movable 
			 
		} 
    
    
}


private static int [] choiceofcoordinates() {
	System.out.println("Choose the coordinates of piece you would like to move");
	   Scanner xibefore= new Scanner(System.in);
	   int x1before = xibefore.nextInt();
	  Scanner yibefore= new Scanner(System.in);
	  int y1before = yibefore.nextInt();
	  int temp []= new int [2];
	  // these codes ensure that whatever value will be in range of board otherwise code will break
	  if ((x1before>7)||(y1before>7)) {
		  do {
			  System.out.println("The choice of coordinate should only be 1-7");
			  Scanner xiibefore= new Scanner(System.in);
			    x1before = xiibefore.nextInt();
			  Scanner yiibefore= new Scanner(System.in);
			   y1before = yiibefore.nextInt();
			  }while((x1before>7)||(y1before>7));
		  temp[0]= x1before; temp[1]= y1before; 
	  }else
     temp[0]= x1before; temp[1]= y1before; 
	  return temp; 
	
}
private static int [] moveto() {
	   System.out.println("Choose the coordinates you would like to move to" );
		   Scanner xiafter= new Scanner(System.in);
		   int x1after = xiafter.nextInt();
		  Scanner yiafter= new Scanner(System.in);
		  int y1after = yiafter.nextInt();
		  int temp []= new int [2];
		  // these codes ensure that whatever value will be in range of board otherwise code will break
		  if ((x1after>7)||(y1after>7)) {
			  do {
				  System.out.println("The choice of coordinate should only be 1-7");
				  Scanner xiiafter= new Scanner(System.in);
				    x1after = xiiafter.nextInt();
				  Scanner yiiafter= new Scanner(System.in);
				   y1after = yiiafter.nextInt();
				  }while((x1after>7)||(y1after>7));
			  temp[0]= x1after; temp[1]= y1after; 
		  }else
		  
		  temp[0]= x1after; temp[1]= y1after;
		  return temp;
	}  	




//methods of black choice
//already okay
private static boolean isblackchoicevalid(char [][] theboard, int [] selectedcoordinates,int [] movetocoordinates) {
	boolean condition1=false,condition2=false,condition3=false,condition4=false,possibleeatking=false,possiblemoveking=false;
	//selectedcoordinates and temp7 will be the input value of users
	int temp7 []= new int [2];
	temp7=selectedcoordinates;
	
	boolean possibleeat = existblack(theboard,temp7);
	
	//if selected coordinates contain a black piece
	if((theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='b')||(theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='B')){
		condition1=true;
	}
	//making sure piece is not stuck
	if ((selectedcoordinates[1]==7)&&(selectedcoordinates[0]!=7)) {
		if (theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1]==' ') {
		condition2=true;	
		}}	
	
	if ((selectedcoordinates[1]==0)&&(selectedcoordinates[0]!=7))  {
		if (theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1]==' ') {
			condition3=true;
		}}
	if((selectedcoordinates[1]!=7)&&(selectedcoordinates[1]!=0)&&(selectedcoordinates[0]!=7)){
  if ((theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1] == ' ')||(theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1] == ' ')) {
		condition4=true;
		}}
	//if there is
	
	if(theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='B') {
		possibleeatking=existblackking(theboard,temp7);
		possiblemoveking =existmoveblackking(theboard,temp7);
	}
	
	
	if((condition1)&&((condition2)||(condition3)||(condition4)||(possibleeat)||(possibleeatking)||(possiblemoveking))) {
		return true;
	} else return false;
}

//a class that checks that it is "stuck" but can get out of position by eating another piece

private static boolean existblack(char[][]theboard,int [] temp7) {
   boolean condition1=false, condition2=false,condition3=false,condition4=false;
    
   //at column 6 and 7 piece can only left eat  
  if (((temp7[1]==6)||(temp7[1]==7))&&((temp7[0]!=6)&&(temp7[0]!=7))) {
	//if there is a white piece diagonal to it
	if ((theboard[temp7[0]+1][temp7[1]-1]=='w')||(theboard[temp7[0]+1][temp7[1]-1]=='W')) {
	//if there as empty space diagonal to white piece 
	if (theboard[temp7[0]+2][temp7[1]-2]==' ') {
	condition1=true;	
	}}}  
//at column 0 and 1 it can only right eat
//kings at row 6 and 6 can no longer eat forwards
if(((temp7[1]==0)||(temp7[1]==1))&&((temp7[0]!=6)&&(temp7[0]!=7))) {
		//if there is a white piece diagonal to it
		if ((theboard[temp7[0]+1][temp7[1]+1]=='w')||(theboard[temp7[0]+1][temp7[1]+1]=='W')) {
		//if there as empty space diagonal to white piece 
		if (theboard[temp7[0]+2][temp7[1]+2]==' ') {
		condition2=true;	
 }}}  	
//can possibly right eat or left eat 
if ((temp7[1]!=6)&&(temp7[1]!=7)&&(temp7[1]!=1)&&
 (temp7[1]!=0)&&(temp7[0]!=6)&&(temp7[0]!=7)){
//checking for possibility left eat 
	 if (((theboard[temp7[0]+1][temp7[1]-1]=='w')||(theboard[temp7[0]+1][temp7[1]-1]=='W'))&&
	 (theboard[temp7[0]+2][temp7[1]-2]==' ')) {
		condition3=true; 
	 } 
//checking for possibility of right eat 
	 if  (((theboard[temp7[0]+1][temp7[1]+1]=='w')||(theboard[temp7[0]+1][temp7[1]+1]=='W'))&& 
			 (theboard[temp7[0]+2][temp7[1]+2]==' ')) {
		 condition4 = true;
		 
}}
	 
if ((condition1)||(condition2)||(condition3)||(condition4)) {
		 return true;
	 }
	 else return false;
}

//when it becomes king it can eat backwards
private static boolean existblackking(char [][] theboard,int [] temp7) {
	
	boolean condition1=false, condition2=false,condition3=false,condition4=false;
  
	//at column 6 and 7 piece can only left eat  
  if (((temp7[1]==6)||(temp7[1]==7))&&((temp7[0]!=0)&&(temp7[0]!=1))) {
	//if there is a white piece diagonal to it
	if ((theboard[temp7[0]-1][temp7[1]-1]=='w')||(theboard[temp7[0]-1][temp7[1]-1]=='W')) {
	//if there as empty space diagonal to white piece 
	if (theboard[temp7[0]-2][temp7[1]-2]==' ') {
	condition1=true;	
	}}}  
//at column 0 and 1 it can only right eat
if(((temp7[1]==0)||(temp7[1]==1))&&((temp7[0]!=0)&&(temp7[0]!=1))) {
		//if there is a white piece diagonal to it
		if ((theboard[temp7[0]-1][temp7[1]+1]=='w')||(theboard[temp7[0]-1][temp7[1]+1]=='W')) {
		//if there as empty space diagonal to white piece 
		if (theboard[temp7[0]-2][temp7[1]+2]==' ') {
		condition2=true;	
 }}}  	
//can possibly right eat or left eat
//at first row it can no longer back eat
if ((temp7[1]!=6)&&(temp7[1]!=7)&&(temp7[1]!=1)&&
 (temp7[1]!=0)&&(temp7[0]!=0)&&(temp7[0]!=1)){
//checking for possibility left eat 
	 if (((theboard[temp7[0]-1][temp7[1]-1]=='w')||(theboard[temp7[0]-1][temp7[1]-1]=='W'))&&
	 (theboard[temp7[0]-2][temp7[1]-2]==' ')) {
		condition3=true; 
	 } 
//checking for possibility of right eat 
	 if  (((theboard[temp7[0]-1][temp7[1]+1]=='w')||(theboard[temp7[0]-1][temp7[1]+1]=='W'))&& 
			 (theboard[temp7[0]-2][temp7[1]+2]==' ')) {
		 condition4 = true;
	 }
}
if ((condition1)||(condition2)||(condition3)||(condition4)) {
			 return true;
		 }
		 else return false;
		 
}

//kingncan move backward
private static boolean existmoveblackking(char [][] theboard, int [] temp7) {
	boolean condition2=false,condition3=false,condition4=false;
	//making sure piece is not stuck
	
		if ((temp7[1]==7)&&(temp7[0]!=0)) {
			if (theboard[temp7[0]-1][temp7[1]-1]==' ') {
				condition2=true;	
			}}	
		
		if ((temp7[1]==0)&&(temp7[0]!=0)) {
			if (theboard[temp7[0]-1][temp7[1]+1]==' ') {
				condition3=true;
			}}
		//at first row cannot move back
		if((temp7[1]!=7)&&(temp7[1]!=0)&&(temp7[0]!=0)){
	  if ((theboard[temp7[0]-1][temp7[1]+1] == ' ')||(theboard[temp7[0]-1][temp7[1]-1] == ' ')) {
			condition4=true;
			}}
		if ((condition2)||(condition3)||(condition4)) {
			return true;
		}
		else return false;
}



//normal black movements
public static void normalblackmovements(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {

    movetocoordinates=moveto();
	boolean conditionmoveblack=istomoveblackvalid(theboard,selectedcoordinates,movetocoordinates);
     boolean conditioneatblack=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
   
     
     //if neither true then move is not a valid move 
    if ((!conditionmoveblack)&&(!conditioneatblack)) {
    	do {
    		System.out.println("This move is not valid.Please select another place");
    		   int temp2[] = new int [2];
    		   temp2 =moveto();
    		   movetocoordinates = temp2 ;
    		   conditionmoveblack=istomoveblackvalid(theboard,selectedcoordinates,movetocoordinates);
               conditioneatblack=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
    		    
    	}while ((!conditionmoveblack)&&(!conditioneatblack));
    }
    if (conditionmoveblack) {           	
    	
 	   tomoveblack(theboard,movetocoordinates,selectedcoordinates);
    	
    	
    }
    //is there a possiblity of more than one eat 
     boolean lefteatblack=lefteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
	 boolean righteatblack = righteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
   int [] current = new int [2];
	current=movetocoordinates;


  if (conditioneatblack) {
	
	  boolean possibleMultiple=isMultiplePosibleBlack(theboard,selectedcoordinates,current);
	  
	  toeatblack(theboard,movetocoordinates,selectedcoordinates,lefteatblack,righteatblack );
	 
	  
	  if (possibleMultiple) {
	   int x=0;
		do {
			 printing(theboard);
			   //the current piece will be lost(current)
			 
			  System.out.println("Would you like to Continue Movement");
			  System.out.println("1-Yes");
			  System.out.println("2-No"); 
			  
			  Scanner xi = new Scanner(System.in);
			  x=xi.nextInt();
			  //wil have multiple movements only if user chooses
			  
			  if (x==1) {
		     //change the variable so it can be assesed
			theboard[current[0]][current[1]]=' ';
		     current=multipleMoveBlack(theboard,current,selectedcoordinates,movetocoordinates);
		     possibleMultiple=isMultiplePosibleBlack(theboard,selectedcoordinates,current);
		     }
		  
	   }while ((possibleMultiple)&&(x==1));
	
}
  }
}
//movements of normal piece
private static boolean istomoveblackvalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {	
	boolean  condition2 = false, condition3 = false , condition4 =false , condition5 = false;
	
	//adding condition implying this ONLY MOVES
	if ((selectedcoordinates[1]==7)&&(selectedcoordinates[0]!=7)) {
		if ((movetocoordinates[0]==selectedcoordinates[0]+1)&&(movetocoordinates[1]==selectedcoordinates[1]-1)&&
		    (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition2=true;
		}}
	
	if ((selectedcoordinates[1]==0)&&(selectedcoordinates[0]!=7)) {
			if ((movetocoordinates[0]==selectedcoordinates[0]+1)&&(movetocoordinates[1]==1+selectedcoordinates[1])&&
			(theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
				condition3=true;
			}}
	if ((selectedcoordinates[1]!=0)&&(selectedcoordinates[1]!=7)&&(selectedcoordinates[0]!=7)){
		if((movetocoordinates[0]==selectedcoordinates[0]+1)&&((movetocoordinates[1]==selectedcoordinates[1]-1)||(movetocoordinates[1]==selectedcoordinates[1]+1))&&
		   (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition4=true;
		}}
			
		
  if ((condition2)||(condition3)||(condition4)){
	   return true;
  } else return false;
		}
//eating methods of normal piece
private static boolean toeatblackvalid (char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean condition1 = false , lefteatblack , righteatblack  ;
	
	if (theboard[movetocoordinates[0]][movetocoordinates[1]] ==' ' ) {
	 condition1= true;
}

//only one can be true at a time
	
lefteatblack=lefteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
righteatblack = righteatblackvalid(theboard,selectedcoordinates,movetocoordinates);

if ((condition1)&&((lefteatblack)||(righteatblack))) {
	return true;
}
else return false;
}

private static boolean lefteatblackvalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	    boolean condition1=true,condition2=false;
	   
	   //veto out pieces that cannot eat 
	   
	  if ((selectedcoordinates[1]!=1)&&(selectedcoordinates[1]!=0)&&(selectedcoordinates[0]!=6)&&(selectedcoordinates[0]!=7)) {
	 if ((movetocoordinates[0]==selectedcoordinates[0]+2)&&(movetocoordinates[1]==selectedcoordinates[1]-2)&&
			   ((theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1]== 'w')||
					   (theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1]== 'W'))){
		 condition2 = true;  
	   }}
	  
	   
	   if ((condition1)&&(condition2)) {
		   return true;
	   } else return false;}

private static boolean righteatblackvalid (char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
 
	boolean condition2=false;
  //veto out pieces that cant right eat 
if ((selectedcoordinates[1]!=7)&&(selectedcoordinates[1]!=6)&&(selectedcoordinates[0]!=6)&&(selectedcoordinates[0]!=7)) {
 if ((movetocoordinates[0]==selectedcoordinates[0]+2)&&(movetocoordinates[1]==selectedcoordinates[1]+2)&&
		   ((theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1]=='w')||(theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1]=='W'))) {
	  condition2=true;
	   
  }}
 if (condition2) {
	   return true;
  } else return false;
}
//class of movements other pieces 

public static void tomoveblack (char[][] theboard,int [] movetocoordinates,int [] selectedcoordinates) {
	theboard[movetocoordinates[0]][movetocoordinates[1]] = 'b';	
	  }
public static void toeatblack (char[][] theboard,int [] movetocoordinates,int [] selectedcoordinates, boolean lefteat , 
		   boolean righteat) {
	  
	  if (lefteat) {
		   
		  theboard [selectedcoordinates[0]+1][selectedcoordinates[1]-1]=' ';
		  theboard [movetocoordinates[0]][movetocoordinates[1]] = 'b';
	  }
		if (righteat) {
			theboard [selectedcoordinates[0]+1][selectedcoordinates[1]+1]=' ';
			theboard [movetocoordinates[0]][movetocoordinates[1]] = 'b';
		}  
		
		}

private static boolean isMultiplePosibleBlack(char[][] theboard,int [] selectedcoordinates, int [] current) {
int [] temp7 = new int [2];
temp7 = current;
boolean possibleeat = existblack(theboard,temp7);
if(possibleeat) {
	return true;
}
else return false;
}
private static int [] multipleMoveBlack(char [][] theboard, int [] current,int []selectedcoordinates,int[] movetocoordinates) {
	 int [] temp,temp2 = new int [2];
	     
		  movetocoordinates =moveto(); 
		  selectedcoordinates = current;
	//movetocoordinates is next state . selected coordinates = current state;		  
		  boolean conditioneatblack=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
		  boolean lefteatblack=lefteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
	     boolean righteatblack = righteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
		 
	     if (!conditioneatblack) {
			 do {
			  System.out.println("You can not move here"); 
			  temp2=moveto();
			  movetocoordinates =moveto(); 
			  conditioneatblack=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
			  lefteatblack=lefteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
			  righteatblack = righteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
			 }while (!conditioneatblack);
		  }
	     
	     toeatblack(theboard,movetocoordinates,selectedcoordinates,lefteatblack,righteatblack );
	     
	     return movetocoordinates;
		 

	 }

//special classes of kings movements
public static void blackkingsmovements(char [][] theboard,int [] selectedcoordinates,int [] movetocoordinates) {

	movetocoordinates=moveto();	
	
	 boolean conditionmoveking= isToMoveBlackKingValid(theboard,selectedcoordinates,movetocoordinates);
     boolean conditioneatking = isToEatBlackKingValid(theboard,selectedcoordinates,movetocoordinates);
     
     if ((!conditionmoveking)&&(!conditioneatking)) {
    	 do {
        		System.out.println("This move is not valid.Please select another place");
        		   int temp2[] = new int [2];
        		   temp2 =moveto();
        		   movetocoordinates = temp2 ;
        		   conditionmoveking=istomoveblackvalid(theboard,selectedcoordinates,movetocoordinates);
                   conditioneatking=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
        		    
        	}while ((!conditionmoveking)&&(!conditioneatking));
     }
     if (conditionmoveking) {
    	 movekingblack(theboard,selectedcoordinates,movetocoordinates);
     }
     
    
    
     if (conditioneatking) {
    	
    	 eatkingblack(theboard,selectedcoordinates,movetocoordinates);
   	 
   }
}
//boolean function to asses if king can move
private static boolean isToMoveBlackKingValid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	//it can move like a normal piece 
	boolean normalmovement=istomoveblackvalid(theboard,selectedcoordinates,movetocoordinates);
	boolean condition2=false, condition3=false,condition4=false,movementking=false;
	//it has the option of moving "backward"

	//condition where the king moves backward;
	if ((selectedcoordinates[1]==7)&&(selectedcoordinates[0]!=0)) {
		if ((movetocoordinates[0]==selectedcoordinates[0]-1)&&(movetocoordinates[1]==selectedcoordinates[1]-1)&&
		    (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition2=true;
		}}
	
	if ((selectedcoordinates[1]==0)&&(selectedcoordinates[0]!=0)) {
			if ((movetocoordinates[0]==selectedcoordinates[0]-1)&&(movetocoordinates[1]==1+selectedcoordinates[1])&&
			(theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
				condition3=true;
			}}
	if ((selectedcoordinates[1]!=0)&&(selectedcoordinates[1]!=7)&&(selectedcoordinates[0]!=0)){
		if((movetocoordinates[0]==selectedcoordinates[0]-1)&&((movetocoordinates[1]==selectedcoordinates[1]-1)||(movetocoordinates[1]==selectedcoordinates[1]+1))&&
		   (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition4=true;
		}}
	
	if ((condition2)||(condition3)||(condition4)) {
		movementking=true;
	}
	
	if ((normalmovement)||(movementking)){
		return true;
	}else return false;
	
}

//boolean funtions to asses if king can eat
private static boolean isToEatBlackKingValid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	//has same eating conditions as normal piece
	boolean normaleat = toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
	 
   boolean  lefteatblack =false, righteatblack=false  ;
	

//only one can be true at a time
	
lefteatblack=lefteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
righteatblack = righteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);


if ((normaleat)||(lefteatblack)||(righteatblack))  {
	
	return true;
}else return false;
}


private static boolean lefteatblackkingvalid(char[][] theboard,int [] selectedcoordinates,int [] movetocoordinates ) {
	
	boolean condition2=false;
	   
	   //veto out pieces that cannot eat 
	   
	  if ((selectedcoordinates[1]!=1)||(selectedcoordinates[1]!=0)||(selectedcoordinates[0]!=0)||(selectedcoordinates[0]!=1)) {
	 if ((movetocoordinates[0]==selectedcoordinates[0]-2)&&(movetocoordinates[1]==selectedcoordinates[1]-2)&&
			   ((theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1]== 'w')||
					   (theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1]== 'W'))){
		 condition2 = true;  
	   }}
	  
	   
	   if (condition2) {
		   return true;
	   } else return false;}


private static boolean righteatblackkingvalid(char[][] theboard,int [] selectedcoordinates,int [] movetocoordinates) {
	boolean condition2=false;
	  //veto out pieces that cant right eat 
	if ((selectedcoordinates[1]!=7)&&(selectedcoordinates[1]!=6)&&(selectedcoordinates[0]!=1)&&(selectedcoordinates[0]!=0)) {
	 if ((movetocoordinates[0]==selectedcoordinates[0]-2)&&(movetocoordinates[1]==selectedcoordinates[1]+2)&&
			   ((theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1]=='w')||(theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1]=='W'))) {
		  condition2=true;
		   
	  }}
	 if (condition2) {
		   return true;
	  } else return false;
	}

//function that moves the black king
private static void movekingblack(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	theboard[movetocoordinates[0]][movetocoordinates[1]] = 'B';		
}
//function that allows black king to eat
private static void eatkingblack(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	
	boolean lefteat =lefteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
	boolean righteat =righteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
	
	if (lefteat) {
		   
		  theboard [selectedcoordinates[0]+1][selectedcoordinates[1]-1]=' ';
		  theboard [movetocoordinates[0]][movetocoordinates[1]] = 'B';
	  }
		if (righteat) {
			theboard [selectedcoordinates[0]+1][selectedcoordinates[1]+1]=' ';
			theboard [movetocoordinates[0]][movetocoordinates[1]] = 'B';
		}  
		
	
	
	boolean lefteatking=lefteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
	boolean righteatking=righteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
	
	if (lefteatking) {
		theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1] = ' ';
		theboard[movetocoordinates[0]][movetocoordinates[1]] = 'B';
	}
	
	if (righteatking) {
		theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1] = ' ';
		theboard[movetocoordinates[0]][movetocoordinates[1]] = 'B';  
	}
}

//a funtion that checks if possible for black king to eat multiply
private static boolean isMultipleEatBlackKingPosible(char[][] theboard, int[] current) {
	int [] temp7 = new int [2];
	temp7 = current;
	//normal eat
	boolean possibleeat = existblack(theboard,temp7);
	boolean possiblekingeat = existblackking(theboard,temp7);
	
	if((possibleeat)||(possiblekingeat)) {
		return true;
	}
	else return false;
	}

private static int [] multipleEatKing (char[][] theboard, int[] current,int [] movetocoordinates,int [] selectedcoordinates) {
	int [] temp1,temp2 = new int [2];
    
	  temp1 =moveto(); 
	  
	  movetocoordinates=temp1;
	  selectedcoordinates=current;
//movetocoordinates is next state . selected coordinates = current state;		 
	  
	  boolean conditioneatblackking=isToEatBlackKingValid(theboard,selectedcoordinates,movetocoordinates);
	  boolean lefteatblack=lefteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
      boolean righteatblack = righteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
	 
   if (!conditioneatblackking) {
		 do {
		  System.out.println("You can not move here"); 
		  temp2=moveto();
		  movetocoordinates=temp2;
		  conditioneatblackking=isToEatBlackKingValid(theboard,selectedcoordinates,movetocoordinates);
		  lefteatblack=lefteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
	     righteatblack = righteatblackkingvalid(theboard,selectedcoordinates,movetocoordinates);
		 }while (!conditioneatblackking);
	  }
   eatkingblack(theboard,movetocoordinates,selectedcoordinates);
   
   return movetocoordinates;
}

private static boolean iswhitechoicevalid(char [][] theboard, int [] selectedcoordinates) {
	boolean condition1=false,condition2=false,condition3=false,condition4=false,possibleeatking=false,possiblemoveking=false;
	int[] temp8= new int [2]; 
    temp8=selectedcoordinates;
	boolean possibleeat=existwhite(theboard,temp8);
	//ensures that coordinates actually contain a white piece 
	if((theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='w')||(theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='W')){
		condition1=true;
	}
	
	//making sure piece is not stuck
	if ((selectedcoordinates[1]==7)&&(selectedcoordinates[0]!=0)) {
		if (theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1]==' ') {
		condition2=true;	
		}}	
	
	if ((selectedcoordinates[1]==0)&&(selectedcoordinates[0]!=0))  {
		if (theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1]==' ') {
			condition3=true;
		}}
	
	if((selectedcoordinates[1]!=7)&&(selectedcoordinates[1]!=0)&&(selectedcoordinates[0]!=0)){
  if ((theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1] == ' ')||(theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1] == ' ')) {
		condition4=true;
		}}
	
	if (theboard[selectedcoordinates[0]][selectedcoordinates[1]]=='W') {
		possibleeatking=existwhiteking(theboard,temp8);
		possiblemoveking=existmovewhiteking(theboard,temp8);
	}
	if ((condition1)&&((condition2)||(condition3)||(condition4)||(possibleeat)||(possibleeatking)||(possiblemoveking))) {
		return true;

	} else return false;
	
}
//extensions of white choice valid 
private static boolean existwhite(char[][]theboard,int [] temp8) {
	//temp 8 is selectedcoordinates   
	boolean condition1=false, condition2=false,condition3=false,condition4=false,condition5=true;
	   //at column 6 and 7 piece can only left eat  
	 if (((temp8[1]==6)||(temp8[1]==7))&&((temp8[0]!=1)&&(temp8[0]!=0))) {
		//if there is a white piece diagonal to it
		if ((theboard[temp8[0]-1][temp8[1]-1]=='b')||(theboard[temp8[0]-1][temp8[1]-1]=='B')) {
		//if there as empty space diagonal to white piece 
		if (theboard[temp8[0]-2][temp8[1]-2]==' ') {
		condition1=true;	
		}}}  
	//at column 0 and 1 it can only right eat
	if (((temp8[1]==0)||(temp8[1]==1))&&((temp8[0]!=1)&&(temp8[0]!=0))) {
			//if there is a white piece diagonal to it
			if ((theboard[temp8[0]-1][temp8[1]+1]=='b')||(theboard[temp8[0]-1][temp8[1]+1]=='B')) {
			//if there as empty space diagonal to white piece 
			if (theboard[temp8[0]-2][temp8[1]+2]==' ') {
			condition2=true;	
	 }}}  	
	//can possibly right eat or left eat 
	 if ((temp8[1]!=0)&&(temp8[1]!=1)&&(temp8[1]!=6)&&
	(temp8[1]!=7)&&(temp8[0]!=1)&&(temp8[0]!=0)){
	//checking for possibility left eat 
		 if (((theboard[temp8[0]-1][temp8[1]-1]=='b')||(theboard[temp8[0]-1][temp8[1]-1]=='B'))&&
		 (theboard[temp8[0]-2][temp8[1]-2]==' ')) {
			condition3=true; 
		 } 
	//checking for possibility of right eat 
		 if  (((theboard[temp8[0]-1][temp8[1]+1]=='b')||(theboard[temp8[0]-1][temp8[1]+1]=='B'))&& 
				 (theboard[temp8[0]-2][temp8[1]+2]==' ')) {
			 condition4 = true;
			 }
	}
		 
	if (((condition1)||(condition2)||(condition3)||(condition4))&&(condition5)) {
			 return true;
		 }
		 else return false;
	}
private static boolean existwhiteking(char[][] theboard, int [] temp8) {
	//taking into account king can eat backwards
	boolean condition1=false, condition2=false,condition3=false,condition4=false;
	
	//at column 6 and 7 piece can only left eat  
	 if (((temp8[1]==6)||(temp8[1]==7))&&((temp8[0]!=7)&&(temp8[0]!=6))) {
		//if there is a white piece diagonal to it
		if ((theboard[temp8[0]+1][temp8[1]-1]=='b')||(theboard[temp8[0]+1][temp8[1]-1]=='B')) {
		//if there as empty space diagonal to white piece 
		if (theboard[temp8[0]+2][temp8[1]-2]==' ') {
		condition1=true;	
		}}}  
	//at column 0 and 1 it can only right eat
	if (((temp8[1]==0)||(temp8[1]==1))&&((temp8[0]!=7)&&(temp8[0]!=6))) {
			//if there is a white piece diagonal to it
			if ((theboard[temp8[0]+1][temp8[1]+1]=='b')||(theboard[temp8[0]+1][temp8[1]+1]=='B')) {
			//if there as empty space diagonal to white piece 
			if (theboard[temp8[0]+2][temp8[1]+2]==' ') {
			condition2=true;	
	 }}}  	
	//can possibly right eat or left eat 
	 if ((temp8[1]!=0)&&(temp8[1]!=1)&&(temp8[1]!=6)&&
	(temp8[1]!=7)&&(temp8[0]!=7)&&(temp8[0]!=6)){
	//checking for possibility left eat 
		 if (((theboard[temp8[0]+1][temp8[1]-1]=='b')||(theboard[temp8[0]+1][temp8[1]-1]=='B'))&&
		 (theboard[temp8[0]+2][temp8[1]-2]==' ')) {
			condition3=true; 
		 } 
	//checking for possibility of right eat 
		 if  (((theboard[temp8[0]+1][temp8[1]+1]=='b')||(theboard[temp8[0]+1][temp8[1]+1]=='B'))&& 
				 (theboard[temp8[0]+2][temp8[1]+2]==' ')) {
			 condition4 = true;
			 }
	}
		 
	if ((condition1)||(condition2)||(condition3)||(condition4)) {
			 return true;
		 }
		 else return false;
	}
private static boolean existmovewhiteking(char[][] theboard, int [] temp8) {
	boolean condition2=false,condition3=false,condition4=false;
	
	//making sure piece king  is not stuck
	if ((temp8[1]==7)&&(temp8[0]!=7)) {
		if (theboard[temp8[0]+1][temp8[1]-1]==' ') {
		condition2=true;	
		}}	
	
	if ((temp8[1]==0)&&(temp8[0]!=7)) {
		if (theboard[temp8[0]+1][temp8[1]+1]==' ') {
			condition3=true;
		}}
	
	if((temp8[1]!=7)&&(temp8[1]!=0)&&(temp8[0]!=7)){
  if ((theboard[temp8[0]+1][temp8[1]+1] == ' ')||(theboard[temp8[0]+1][temp8[1]-1] == ' ')) {
		condition4=true;
		}}
	if ((condition2)||(condition3)||(condition4)) {
		return true;
	}else return false;
}

public static void normalwhitemovements(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	//temp is just to change the value of movetocoordinates
	int temp5[] =moveto();
    movetocoordinates=temp5;
    //only one of these conditions can be true at a time 
    boolean conditionmovewhite=istomovewhitevalid(theboard,selectedcoordinates,movetocoordinates);
    boolean conditioneatwhite=toeatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
    
    if ((!conditionmovewhite)&&(!conditioneatwhite)) {
    	do {
    		System.out.println("This move is not valid.Please select another place");
    		   int temp1[] = new int [2];
    		   temp1 =moveto();
    		   movetocoordinates = temp1 ;
    		   conditionmovewhite=istomovewhitevalid(theboard,selectedcoordinates,movetocoordinates);
               conditioneatwhite=toeatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
    		
    	}while ((!conditionmovewhite)&&(!conditioneatwhite));
    }
    if (conditionmovewhite) {
    	tomovewhite(theboard,movetocoordinates,selectedcoordinates);
    }

	 boolean leftEatWhite=lefteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
	 boolean rightEatWhite = righteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
  int [] current =movetocoordinates;
    
  	
  	if (conditioneatwhite) {
  		
  		toeatwhite(theboard,movetocoordinates,selectedcoordinates,leftEatWhite,rightEatWhite );
  	    boolean possibleMultipleWhite=isMultiplePossibleWhite(theboard,selectedcoordinates,current);
	  
  	    if (possibleMultipleWhite) {
  	    	int x=0;
    		do {
    			   //the current piece will be lost(current)
    			printing(theboard);
    			   theboard[current[0]][current[1]]=' ';
    			  System.out.println("Would you like to Continue Movement");
    			  System.out.println("1-Yes");
    			  System.out.println("2-No"); 
    			  
    			  Scanner xi = new Scanner(System.in);
    			  x=xi.nextInt();
    			  
    			  if (x==1) {
    		     current=multipleMoveWhite(theboard,current,selectedcoordinates,movetocoordinates);
    		     possibleMultipleWhite=isMultiplePossibleWhite(theboard,selectedcoordinates,current);
    		     
    			  }
    		  
    	   }while ((possibleMultipleWhite)&&(x !=1));
  	    }}
}
//conditions for whitemovement
private static boolean istomovewhitevalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean  condition2 = false, condition3 = false , condition4 =false , condition5 = false;
	
	//adding condition implying this ONLY MOVES
	if ((selectedcoordinates[1]==7)&&(selectedcoordinates[0]!=0)) {
		if ((movetocoordinates[0]==selectedcoordinates[0]-1)&&(movetocoordinates[1]==selectedcoordinates[1]-1)&&
		    (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition2=true;
		}}
	
	if ((selectedcoordinates[1]==0)&&(selectedcoordinates[0]!=0)) {
			if ((movetocoordinates[0]==selectedcoordinates[0]-1)&&(movetocoordinates[1]==selectedcoordinates[1]+1)&&
			(theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
				condition3=true;
			}}
	if ((selectedcoordinates[1]!=0)&&(selectedcoordinates[1]!=7)&&(selectedcoordinates[0]!=0)){
		
		if ((movetocoordinates[0]==selectedcoordinates[0]-1)&&((movetocoordinates[1]==selectedcoordinates[1]-1)||(movetocoordinates[1]==selectedcoordinates[1]+1))&&
		
				(theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition4=true;
		}}
			
		
  if ((condition2)||(condition3)||(condition4)){
	   return true;
  } else return false;
}

public static void tomovewhite (char[][] theboard,int [] movetocoordinates,int [] selectedcoordinates) {
	  theboard[movetocoordinates[0]][movetocoordinates[1]] = 'w';	
	  }

//conditions for white eats
private static boolean toeatwhitevalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean condition1 = false , lefteatwhite , righteatwhite ;
	
	if (theboard[movetocoordinates[0]][movetocoordinates[1]] ==' ' ) {
	 condition1= true;
}
//one should necessarily be true
lefteatwhite=lefteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
righteatwhite = righteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);

if ((condition1)&&((lefteatwhite)||(righteatwhite))) {
	return true;
}
else return false;	
}


private static boolean lefteatwhitevalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
   boolean condition2=false;
  
  //veto out pieces that cannot left eat 
  
 if ((selectedcoordinates[1]!=0)&&(selectedcoordinates[1]!=1)&&(selectedcoordinates[0]!=0)&&(selectedcoordinates[0]!=1)) {
if ((movetocoordinates[0]==selectedcoordinates[0]-2)&&(movetocoordinates[1]==selectedcoordinates[1]-2)&&
		   ((theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1]=='b')||
				   (theboard[selectedcoordinates[0]-1][selectedcoordinates[1]-1]=='B'))){
	 condition2 = true;  
  }}
 
  
  if (condition2) {
	   return true;
  } else return false;}

public static boolean righteatwhitevalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
  boolean condition1=true,condition2=false; 
  
 if((selectedcoordinates[1]!=6)&&(selectedcoordinates[1]!=7)&&(selectedcoordinates[0]!=0)&&(selectedcoordinates[0]!=1)) {
 if ((movetocoordinates[0]==selectedcoordinates[0]-2)&&(movetocoordinates[1]==selectedcoordinates[1]+2)&&
		   ((theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1]=='b')||(theboard[selectedcoordinates[0]-1][selectedcoordinates[1]+1]=='B'))) {
	  condition2=true;}
	   
  }
 if (condition2) {
	   return true;
  } else return false;
}

public static void toeatwhite (char[][] theboard,int [] movetocoordinates,int [] selectedcoordinates, boolean leftEat , 
		   boolean rightEat) {
	  
	  if (leftEat) {
		  theboard [selectedcoordinates[0]-1][selectedcoordinates[1]-1]=' ';
		  theboard [movetocoordinates[0]][movetocoordinates[1]] = 'w';
	  }
		if (rightEat) {
			theboard [selectedcoordinates[0]-1][selectedcoordinates[1]+1]=' ';
			theboard [movetocoordinates[0]][movetocoordinates[1]] = 'w';
		}}

//white functions of multiple eats
private static boolean isMultiplePossibleWhite(char[][] theboard,int [] selectedcoordinates, int [] current) {
	 int [] temp8 = new int [2];
	   temp8 = current;
	   boolean possibleeat = existwhite(theboard,temp8);
	   if(possibleeat) {
	   	return true;
	   }
	   else return false; 
	 
	}
private static int [] multipleMoveWhite(char [][] theboard, int [] current,int []selectedcoordinates,int[] movetocoordinates) {
	 int [] temp,temp2 = new int [2];
	     
		  movetocoordinates =moveto(); 
		  selectedcoordinates = current;
	//movetocoordinates is next state . selected coordinates = current state;		  
		  boolean conditioneatwhite=toeatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
		  boolean lefteatwhite=lefteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
	     boolean righteatwhite = righteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
		 
	     if (!conditioneatwhite) {
			 do {
			  System.out.println("You can not move here"); 
			  temp2=moveto();
			  movetocoordinates =moveto(); 
			  conditioneatwhite=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
			  lefteatwhite=lefteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
			  righteatwhite = righteatblackvalid(theboard,selectedcoordinates,movetocoordinates);
			 }while (!conditioneatwhite);
		  }
	     
	     toeatwhite(theboard,movetocoordinates,selectedcoordinates,lefteatwhite,righteatwhite);
	     
	     return movetocoordinates;
		 

	 }


public static void whitekingmovement (char [][] theboard,int [] selectedcoordinates,int [] movetocoordinates) {
	movetocoordinates=moveto();	
	
	 boolean conditionmoveking= isToMoveWhiteKingValid(theboard,selectedcoordinates,movetocoordinates);
    boolean conditioneatking = isToEatWhiteKingValid(theboard,selectedcoordinates,movetocoordinates);
    
    if ((!conditionmoveking)&&(!conditioneatking)) {
   	 do {
       		System.out.println("This move is not valid.Please select another place");
       		   int temp2[] = new int [2];
       		   temp2 =moveto();
       		   movetocoordinates = temp2 ;
       		   conditionmoveking=istomoveblackvalid(theboard,selectedcoordinates,movetocoordinates);
                  conditioneatking=toeatblackvalid(theboard,selectedcoordinates,movetocoordinates);
       		    
       	}while ((!conditionmoveking)&&(!conditioneatking));
    }
    if (conditionmoveking) {
   	 movekingwhite(theboard,selectedcoordinates,movetocoordinates);
    }
    
    if (conditioneatking) {
   	 eatkingwhite(theboard,selectedcoordinates,movetocoordinates);
    }
    
}


private static boolean isToMoveWhiteKingValid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean normalmovement=istomovewhitevalid(theboard,selectedcoordinates,movetocoordinates);
	boolean condition2=false, condition3=false,condition4=false,movementking=false;
	//it has the option of moving "backward"

	//condition where the king moves backward;
	if ((selectedcoordinates[1]==7)&&(selectedcoordinates[0]!=7)) {
		if ((movetocoordinates[0]==selectedcoordinates[0]+1)&&(movetocoordinates[1]==selectedcoordinates[1]-1)&&
		    (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition2=true;
		}}
	
	if ((selectedcoordinates[1]==0)&&(selectedcoordinates[0]!=7)) {
			if ((movetocoordinates[0]==selectedcoordinates[0]+1)&&(movetocoordinates[1]==1+selectedcoordinates[1])&&
			(theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
				condition3=true;
			}}
	if ((selectedcoordinates[1]!=0)&&(selectedcoordinates[1]!=7)&&(selectedcoordinates[0]!=7)){
		if((movetocoordinates[0]==selectedcoordinates[0]+1)&&((movetocoordinates[1]==selectedcoordinates[1]-1)||(movetocoordinates[1]==selectedcoordinates[1]+1))&&
		   (theboard[movetocoordinates[0]][movetocoordinates[1]]==' ')) {
			condition4=true;
		}}
	
	if ((condition2)||(condition3)||(condition4)) {
		movementking=true;
	}
	
	if ((normalmovement)||(movementking)){
		return true;
	}else return false;
	
}

private static boolean isToEatWhiteKingValid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean normaleat = toeatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
	 
	   boolean  lefteatwhite =false, righteatwhite=false  ;
		

	//only one can be true at a time
		
	lefteatwhite=lefteatwhitekingvalid(theboard,selectedcoordinates,movetocoordinates);
	righteatwhite = righteatwhitekingvalid(theboard,selectedcoordinates,movetocoordinates);


	if ((normaleat)||(lefteatwhite)||(righteatwhite))  {
		
		return true;
	}else return false;
	}

private static boolean lefteatwhitekingvalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean condition2=false;
	   
	   //veto out pieces that cannot eat 
	   
	  if ((selectedcoordinates[1]!=1)||(selectedcoordinates[1]!=0)||(selectedcoordinates[0]!=6)||(selectedcoordinates[0]!=7)) {
	 if ((movetocoordinates[0]==selectedcoordinates[0]+2)&&(movetocoordinates[1]==selectedcoordinates[1]-2)&&
			   ((theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1]== 'b')||
					   (theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1]== 'B'))){
		 condition2 = true;  
	   }}
	  
	   
	   if (condition2) {
		   return true;
	   } else return false;}

private static boolean righteatwhitekingvalid(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates){
	boolean condition2=false;
	  //veto out pieces that cant right eat 
	if ((selectedcoordinates[1]!=7)&&(selectedcoordinates[1]!=6)&&(selectedcoordinates[0]!=6)&&(selectedcoordinates[0]!=7)) {
	 if ((movetocoordinates[0]==selectedcoordinates[0]+2)&&(movetocoordinates[1]==selectedcoordinates[1]+2)&&
			   ((theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1]=='b')||(theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1]=='B'))) {
		  condition2=true;
		   
	  }}
	 if (condition2) {
		   return true;
	  } else return false;	
	
	
}

private static void movekingwhite(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	
	theboard[movetocoordinates[0]][movetocoordinates[1]] = 'W';		
}

private static void eatkingwhite(char [][] theboard , int [] selectedcoordinates , int [] movetocoordinates) {
	boolean leftEat=lefteatwhitevalid(theboard,selectedcoordinates,movetocoordinates);
	boolean rightEat=righteatwhitevalid(theboard,selectedcoordinates,movetocoordinates) ;
	if (leftEat) {
		  theboard [selectedcoordinates[0]-1][selectedcoordinates[1]-1]=' ';
		  theboard [movetocoordinates[0]][movetocoordinates[1]] = 'w';
	  }
		if (rightEat) {
			theboard [selectedcoordinates[0]-1][selectedcoordinates[1]+1]=' ';
			theboard [movetocoordinates[0]][movetocoordinates[1]] = 'w';
		}
	
	boolean lefteatking=lefteatwhitekingvalid(theboard,selectedcoordinates,movetocoordinates);
	boolean righteatking=righteatwhitekingvalid(theboard,selectedcoordinates,movetocoordinates);
	
	if (lefteatking) {
		theboard[selectedcoordinates[0]+1][selectedcoordinates[1]-1] = ' ';
		theboard[movetocoordinates[0]][movetocoordinates[1]] = 'W';
	}
	if (righteatking) {
		theboard[selectedcoordinates[0]+1][selectedcoordinates[1]+1] = ' ';
		theboard[movetocoordinates[0]][movetocoordinates[1]] = 'W';
	}
}




private static void beKingBlack(char[][] theboard) {
	//if there exist a piece at end it becomes king ;
		for (int j=0; j<theboard[7].length;j++) {
			if (theboard[7][j]=='b') {
				theboard[7][j] ='B';}} }
private static void beKingWhite(char [][] theboard) {
	//if exist piece at the end it becomes king 
	for (int j=0; j<theboard[0].length;j++) {
		if (theboard[0][j]=='w') {
			theboard[0][j] ='W';
		}}}


private static boolean isGameFinished(char [][] theboard) {
  boolean WhiteWins= hasWhiteWon(theboard);
  boolean BlackWins= hasBlackWon(theboard);
  
  if ((WhiteWins)||(BlackWins)){
	   return true;
  }
  else return false;
}
private static boolean hasWhiteWon(char[][] theboard) {
	  //there are no black pieces
	  int count = 0;
	  for (int i = 0; i<theboard.length;i++) {
		   for(int j=0 ;j<theboard[i].length;j++) {
			   if((theboard[i][j]=='b')||(theboard[i][j]=='B')) {
				   count ++;
			   }}}
	if (count==0) {
	  return true;}
	else return false;
	}
	private static boolean hasBlackWon(char[][]theboard) {
	//there are no white pieces
	int count = 0;
	  for (int i = 0; i<theboard.length;i++) {
		   for(int j=0 ;j<theboard[i].length;j++) {
			   if((theboard[i][j]=='w')||(theboard[i][j]=='W')) {
				   count ++;
			   }}}
	if (count==0) {
	  return true;}
	else return false;
	}
}
