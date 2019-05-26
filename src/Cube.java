import java.util.ArrayList;

public class Cube {

	private ArrayList<int[][]> sides; 
	
	private final static int white = 0;
	private final static int red = 1;
	private final static int blue = 2;
	private final static int green = 3;
	private final static int orange = 4;
	private final static int yellow = 5;
	
	private final static int w = 0;
	private final static int r = 1;
	private final static int b = 2;
	private final static int g = 3;
	private final static int o = 4;
	private final static int y = 5;
	
	public Cube() {

		sides = new ArrayList<int[][]>();
		
		int[][] white = {{-1,-1,-1},{-1,0,-1,},{-1,-1,-1}}; //index 0
		int[][] red = {{-1,-1,-1},{-1,1,-1,},{-1,-1,-1}};  //1
		int[][] blue = {{-1,-1,-1},{-1,2,-1,},{-1,-1,-1}}; //2
		int[][] green = {{-1,-1,-1},{-1,3,-1,},{-1,-1,-1}};//3
		int[][] orange = {{-1,-1,-1},{-1,4,-1,},{-1,-1,-1}};//4
		int[][] yellow = {{-1,-1,-1},{-1,5,-1,},{-1,-1,-1}};//5
	
		sides.add(white);
		sides.add(red);
		sides.add(blue);
		sides.add(green);
		sides.add(orange);
		sides.add(yellow);
	
		}
	
	public void setSide(int index, int one, int two, int three, int four, int five, int six, int seven, int eight) {
		int[][] target = sides.get(index);
		target[0][0] = one;
		target[0][1] = two;
		target[0][2] = three;
		target[1][0] = four;
		target[1][2] = five;
		target[2][0] = six;
		target[2][1] = seven;
		target[2][2] = eight;
		sides.set(index, target);
	}	
	
	public int[][] getSide(int index){//May be uneccessary
		return sides.get(index);
	}
	
	public void displaySide(int index) {
		int[][] target = this.getSide(index);
		System.out.println("Side " +index +":");
		
		for(int x = 0; x < 3; x++)
			for(int y = 0; y < 3; y++)
				if (y==2)
					System.out.println(target[x][y]);
				else
					System.out.print(target[x][y] +",");
	}
	
	public void displayAllSides() {
		for(int i = 0; i < 6; i++) {
			displaySide(i);
			System.out.println();
		}
	}

	public void displayNet() {
	int[][] white = this.getSide(0);
	int[][] yellow = this.getSide(5);
	int[][] blue = this.getSide(2);
	int[][] green = this.getSide(3);
	int[][] red = this.getSide(1);
	int[][] orange = this.getSide(4);
		
	System.out.println("Net of all Sides:");
	System.out.println("     ___    ");
	System.out.println("    |" +orange[2][2] +orange[2][1] +orange[2][0] +"|    ");
	System.out.println("    |" +orange[1][2] +orange[1][1] +orange[1][0] +"|    ");
	System.out.println("    |" +orange[0][2] +orange[0][1] +orange[0][0] +"|    ");
	System.out.println(" ---------- ");
	System.out.println("|" +green[2][0] +green[1][0] +green[0][0] +"|" +white[0][0] + white[0][1] + white[0][2] +"|" +blue[0][2] +blue[1][2] +blue[2][2] +"|");
	System.out.println("|" +green[2][1] +green[1][1] +green[0][1] +"|" +white[1][0] + white[1][1] + white[1][2] +"|" +blue[0][1] +blue[1][1] +blue[2][1] +"|");
	System.out.println("|" +green[2][2] +green[1][2] +green[0][2] +"|" +white[2][0] + white[2][1] + white[2][2] +"|" +blue[0][0] +blue[1][0] +blue[2][0] +"|");
	System.out.println(" _________ ");
	System.out.println("    |" +red[0][0] +red[0][1] +red[0][2] +"|   ");
	System.out.println("    |" +red[1][0] +red[1][1] +red[1][2] +"|   ");
	System.out.println("    |" +red[2][0] +red[2][1] +red[2][2] +"|   ");
	System.out.println("     ---    ");
	System.out.println("    |" +yellow[0][0] +yellow[0][1] +yellow[0][2] +"|   ");
	System.out.println("    |" +yellow[1][0] +yellow[1][1] +yellow[1][2] +"|   ");
	System.out.println("    |" +yellow[2][0] +yellow[2][1] +yellow[2][2] +"|   ");		
	System.out.println("     ---    ");	
	}
	public void faceTurn(int center, boolean direction) { //true for clockwise, false for CCW
			//array values and indexes are: 0 - index, 1 - first corner coordinate 1, 2 - first corner coordinate 2, 
			//3 - first edge coordinate, 4 - second edge coordinate, 5 - second corner coordinate 1, 6 - second corner coordinate 2
			int[] side1 = {0,0,0,0,0,0,0};
			int[] side2 = {0,0,0,0,0,0,0};
			int[] side3 = {0,0,0,0,0,0,0}; 
			int[] side4 = {0,0,0,0,0,0,0};
			int sameSide = -1;
			
		
		switch(center) {
		
		case 0: int[] whiteSide1 = {3,0,2,0,1,0,0};
				int[] whiteSide2 = {4,0,2,0,1,0,0};
				int[] whiteSide3 = {2,0,2,0,1,0,0};
				int[] whiteSide4 = {1,0,2,0,1,0,0};
				side1 = whiteSide1;
				side2 = whiteSide2;
				side3 = whiteSide3;
				side4 = whiteSide4;
				sameSide = 5;
				break;
		
		case 1: int[] redSide1 = {3,2,2,1,2,0,2};
				int[] redSide2 = {0,2,0,2,1,2,2};
				int[] redSide3 = {2,0,0,1,0,2,0};
				int[] redSide4 = {5,0,2,0,1,0,0};
				side1 = redSide1;
				side2 = redSide2;
				side3 = redSide3;
				side4 = redSide4;
				sameSide = 4;
				break;
			
		case 2: int[] blueSide1 = {0,2,2,1,2,0,2};
				int[] blueSide2 = {4,0,0,1,0,2,0};
				int[] blueSide3 = {5,2,2,1,2,0,2};
				int[] blueSide4 = {1,2,2,1,2,0,2};
				side1 = blueSide1;
				side2 = blueSide2;
				side3 = blueSide3;
				side4 = blueSide4;
				sameSide = 3;
				break;
		
		case 3: int[] greenSide1 = {5,0,0,1,0,2,0};
				int[] greenSide2 = {4,2,2,1,2,0,2};
				int[] greenSide3 = {0,0,0,1,0,2,0};
				int[] greenSide4 = {1,0,0,1,0,2,0};
				side1 = greenSide1;
				side2 = greenSide2;
				side3 = greenSide3;
				side4 = greenSide4;
				sameSide = 2;
				break;
				
		case 4: int[] orangeSide1 = {3,0,0,1,0,2,0};
				int[] orangeSide2 = {5,2,0,2,1,2,2};
				int[] orangeSide3 = {2,2,2,1,2,0,2};
				int[] orangeSide4 = {0,0,2,0,1,0,0};
				side1 = orangeSide1;
				side2 = orangeSide2;
				side3 = orangeSide3;
				side4 = orangeSide4;
				sameSide = 1;
				break;
				
		case 5: int[] yellowSide1 = {3,2,0,2,1,2,2};
				int[] yellowSide2 = {1,2,0,2,1,2,2};
				int[] yellowSide3 = {2,2,0,2,1,2,2};
				int[] yelloSide4 = {4,2,0,2,1,2,2};
				side1 = yellowSide1;
				side2 = yellowSide2;
				side3 = yellowSide3;
				side4 = yelloSide4;
				sameSide = 0;
				break;
		}
		
		int centerFace[][] = sides.get(center);
		int sideFace1[][] = sides.get(side1[0]);
		int sideFace2[][] = sides.get(side2[0]);
		int sideFace3[][] =  sides.get(side3[0]);
		int sideFace4[][] = sides.get(side4[0]);
		int finalSide[][] = sides.get(sameSide);
		int centerEdgeHold = centerFace[0][1];
		int centerCornerHold = centerFace[0][0];
		int cornerHold1 = sideFace1[side1[1]][side1[2]];
		int edgeHold = sideFace1[side1[3]][side1[4]];
		int cornerHold2 = sideFace1[side1[5]][side1[6]];
			
		if(direction == true) {
			centerFace[0][1] = centerFace[1][0];
			centerFace[1][0] = centerFace[2][1];
			centerFace[2][1] = centerFace[1][2];
			centerFace[1][2] = centerEdgeHold;
			
			centerFace[0][0] = centerFace[2][0];
			centerFace[2][0] = centerFace[2][2];
			centerFace[2][2] = centerFace[0][2];
			centerFace[0][2] = centerCornerHold;
			
			sideFace1[side1[1]][side1[2]] = sideFace4[side4[1]][side4[2]];
			sideFace1[side1[3]][side1[4]] = sideFace4[side4[3]][side4[4]];
			sideFace1[side1[5]][side1[6]] = sideFace4[side4[5]][side4[6]];
	
			sideFace4[side4[1]][side4[2]] = sideFace3[side3[1]][side3[2]];
			sideFace4[side4[3]][side4[4]] = sideFace3[side3[3]][side3[4]];
			sideFace4[side4[5]][side4[6]] = sideFace3[side3[5]][side3[6]];
			 
			sideFace3[side3[1]][side3[2]] = sideFace2[side2[1]][side2[2]];
			sideFace3[side3[3]][side3[4]] = sideFace2[side2[3]][side2[4]];
			sideFace3[side3[5]][side3[6]] = sideFace2[side2[5]][side2[6]];
			
			sideFace2[side2[1]][side2[2]] = cornerHold1;
			sideFace2[side2[3]][side2[4]] = edgeHold;
			sideFace2[side2[5]][side2[6]] = cornerHold2;
			System.out.println("********Clockwise ROTATION around side " +center +"*****************"); 
		}
		
		else {
			centerFace[0][1] = centerFace[1][2];
			centerFace[1][2] = centerFace[2][1];
			centerFace[2][1] = centerFace[1][0];
			centerFace[1][0] = centerEdgeHold;
			
			centerFace[0][0] = centerFace[0][2];
			centerFace[0][2] = centerFace[2][2];
			centerFace[2][2] = centerFace[2][0];
			centerFace[2][0] = centerCornerHold;
			
			sideFace1[side1[1]][side1[2]] = sideFace2[side2[1]][side2[2]];
			sideFace1[side1[3]][side1[4]] = sideFace2[side2[3]][side2[4]];
			sideFace1[side1[5]][side1[6]] = sideFace2[side2[5]][side2[6]];
	
			sideFace2[side2[1]][side2[2]] = sideFace3[side3[1]][side3[2]];
			sideFace2[side2[3]][side2[4]] = sideFace3[side3[3]][side3[4]];
			sideFace2[side2[5]][side2[6]] = sideFace3[side3[5]][side3[6]];
			 
			sideFace3[side3[1]][side3[2]] = sideFace4[side4[1]][side4[2]];
			sideFace3[side3[3]][side3[4]] = sideFace4[side4[3]][side4[4]];
			sideFace3[side3[5]][side3[6]] = sideFace4[side4[5]][side4[6]];
			
			sideFace4[side4[1]][side4[2]] = cornerHold1;
			sideFace4[side4[3]][side4[4]] = edgeHold;
			sideFace4[side4[5]][side4[6]] = cornerHold2;
			System.out.println("*****Counter-Clockwise ROTATION around side " +center +"*************"); 
		}
		//rewrites all new faces to their old locations in the array list
		ArrayList<int[][]> newSides = new ArrayList<int[][]>(6);
		
		for(int i=0; i<6; i++)
		{
			if (i==center)
				newSides.add(i, centerFace);
			
			if(i==side1[0])
				newSides.add(i, sideFace1);
			
			if(i==side2[0])
				newSides.add(i, sideFace2);
			
			if(i==side3[0])
				newSides.add(i, sideFace3);
			
			if(i==side4[0])
				newSides.add(i, sideFace4);
			
			if(i==sameSide)
				newSides.add(i, finalSide);
		}
		
		sides = newSides;
		//this.displayNet(); //remove comment while debugging
		
	}
	
public void faceTurn(int center) {//default the call to a clockwise turn unless specified
	faceTurn(center, true);
}

public void faceTurn(int center, boolean direction, boolean multiple) // does 2 turns if multiple is true
{
	if (multiple == true)
		faceTurn(center, direction);
		faceTurn(center, direction);
}

public void setDefault() {
	this.setSide(0, 0, 0, 0, 0, 0, 0, 0, 0);
	this.setSide(1, 1, 1, 1, 1, 1, 1, 1, 1);
	this.setSide(2, 2, 2, 2, 2, 2, 2, 2, 2);
	this.setSide(3, 3, 3, 3, 3, 3, 3, 3, 3);
	this.setSide(4, 4, 4, 4, 4, 4, 4, 4, 4);
	this.setSide(5, 5, 5, 5, 5, 5, 5, 5, 5);
}
public void turnTest(int index) {// testing method for debugging turns
	int centerFace[][] = sides.get(index);
	int centerEdgeHold = centerFace[0][1];
	int centerCornerHold = centerFace[0][0];
	
	centerFace[0][1] = centerFace[1][0];
	centerFace[1][0] = centerFace[2][1];
	centerFace[2][1] = centerFace[1][2];
	centerFace[1][2] = centerEdgeHold;
	
	centerFace[0][0] = centerFace[2][0];
	centerFace[2][0] = centerFace[2][2];
	centerFace[2][2] = centerFace[0][2];
	centerFace[0][2] = centerCornerHold;
	
	sides.add(index, centerFace);
}

public void solveCube() {//reorder/rename solve method names as more are added
	
	//while (solve4() != true);
	//while(solve3()!= true);
	while(solve2()!=true);
	while(solve1()!=true);
	while(solve0()!=true);
	
}

private boolean solve0() {

	int[][] front = this.getSide(1);//loads red
	
	switch(front[2][1]) {
	
	case 1: this.displayNet();
			return true;
	
	case 2: System.out.println("Aligning top:");
			this.faceTurn(yellow, true);
			return false;
	
	case 3: System.out.println("Aligning top:");
			this.faceTurn(yellow, false);
			return false;
	
	case 4: System.out.println("Aligning top:");
			this.faceTurn(yellow, true, true);
			return false;
			
	default: return false;
	}
}

private boolean solve1() {
	//load the array sides of the orange, green red and blue sides
	 
	int sideStatus[] = {-1, -1, -1, -1};
	ArrayList<int[][]>check = new ArrayList<int[][]>();
	check.add(this.getSide(1));//red at index 0
	check.add(this.getSide(2));//blue at index 1
	check.add(this.getSide(3));//green at index 2
	check.add(this.getSide(4));//orange at index 3
	boolean direction;
	
	for (int i=0; i <4; i++) {
		sideStatus[i] = solve1Check(check.get(i));
	}
	
	if(sideStatus[0] == 2 && sideStatus[1] == 2 && sideStatus[2] == 2 && sideStatus[3] == 2)//all the top is the same
		return true;//write another function to line up completed line with centers
	
	if(sideStatus[0] == 1 && sideStatus[1] == 1 || sideStatus[1] == 1 && sideStatus[2] == 1 || 
	   sideStatus[2] == 1 && sideStatus[3] == 1 || sideStatus[3] == 1 && sideStatus[1] == 1) {// all corners match
		
	if(sideStatus[0] == 1 && sideStatus[1] == 1 && sideStatus[2] == 1 && sideStatus[3] == 1) {
			solve1Alg2(1, true);// default to turn red
			return false;
	}
		
		else {
			for(int i = 0 ; i < 4; i++)
				if(sideStatus[i] == 2) {
					direction = solve1GetDir(i, check);
					solve1Alg2(i+1,direction);		
		}
		return false;
		}}
					
	else if(sideStatus[0] ==  1 && sideStatus[1] == 0 || sideStatus[1] == 1 && sideStatus[2] == 0 ||
	   sideStatus[2] ==  1 && sideStatus[3] == 0 || sideStatus[3] == 1 && sideStatus[0] == 0 ) {//only one corner set matches
		for(int i = 0; i<4; i++) {
			if(sideStatus[i] == 1)
				solve1Alg1(i+1);
		}
		return false;
	}
	
	else
		solve1Alg1(1);//default to turn red
			return false;
	
}

public boolean solve2() {
	
	int[][] check = {{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1}};//
	int[][] yellow = this.getSide(5);
	int[][] red = this.getSide(1);
	int[][] blue = this.getSide(2);
	int[][] green = this.getSide(3);
	int[][] orange = this.getSide(4);
	
	for(int x=1; x<4; x++) {
		for(int y=1; y<4; y++)
			check[x][y] = yellow[x-1][y-1];
		}

	check[0][1] = red[2][0];
	check[0][2] = red[2][1];
	check[0][3] = red[2][2];
	check[1][4] = blue[2][0];
	check[2][4] = blue[2][1];
	check[3][4] = blue[2][2];
	check[1][0] = green[2][2];
	check[2][0] = green[2][1];
	check[3][0] = green[2][0];
	check[4][1] = orange[2][2];
	check[4][2] = orange[2][1];
	check[4][3] = orange[2][0];
	
	int switchSelect1 = solve2Switch1(yellow);
	
	if (switchSelect1 != 0) {
		
		System.out.println("Starting OLL first algorithm");
		switch(switchSelect1) {
		
		case 1: this.faceTurn(4); //line
				this.faceTurn(2);
				this.faceTurn(5);
				this.faceTurn(2,false);
				this.faceTurn(5,false);
				this.faceTurn(4,false);
				break;
		
		case 2:	this.faceTurn(4); //L
				this.faceTurn(5);
				this.faceTurn(2);
				this.faceTurn(5,false);
				this.faceTurn(2,false);
				this.faceTurn(4,false);
				break;
			
		case 3:	this.faceTurn(4); //'dot' case does case 1 and then case 2 algorithims
				this.faceTurn(2);
				this.faceTurn(5);
				this.faceTurn(2,false);
				this.faceTurn(5,false);
				this.faceTurn(4,false);
				this.faceTurn(5,true,true);
				
				this.faceTurn(4);
				this.faceTurn(5);
				this.faceTurn(2);
				this.faceTurn(5,false);
				this.faceTurn(2,false);
				this.faceTurn(4,false);
				break;
				
		case 4: this.faceTurn(5);
		}
		return false;
	}

	int switchSelect2 = solve2Switch2(check);
	
	if(switchSelect2!=0 && switchSelect2!=8)
		System.out.println("Starting OLL second algorithm:");
	
	switch(switchSelect2) {
	
	case 0:	this.displayNet();
			return true;
	
	case 1: this.faceTurn(2,true,true); //(R2' D) (R' U2) (R D') (R' U2 R')
			this.faceTurn(0);
			this.faceTurn(2, false);
			this.faceTurn(5,true,true);
			this.faceTurn(2);
			this.faceTurn(0,false);
			this.faceTurn(2,false);
			this.faceTurn(5,true,true);
			this.faceTurn(2,false);
			break;
			
	case 2: this.faceTurn(3); //L F R' F' L' F R F'
			this.faceTurn(4);
			this.faceTurn(2,false);
			this.faceTurn(4, false);
			this.faceTurn(3, false);
			this.faceTurn(4);
			this.faceTurn(2);
			this.faceTurn(4, false);
			break;	
	
	case 3: this.faceTurn(2); //R U2 R' U' (R U R' U') (R U R' U') R U' R'
			this.faceTurn(5,true,true);
			this.faceTurn(2,false);
			this.faceTurn(5,false);
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2,false);
			this.faceTurn(5,false);
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2,false);
			this.faceTurn(5,false);
			this.faceTurn(2);
			this.faceTurn(5,false);
			this.faceTurn(2,false);
			break;
	
	case 4: this.faceTurn(2); //sune
			this.faceTurn(5);
			this.faceTurn(2, false);
			this.faceTurn(5);
			this.faceTurn(2);
			this.faceTurn(5,true,true);
			this.faceTurn(2, false);
			break;
		
	case 5:	this.faceTurn(2, false); //anti-sune
			this.faceTurn(5);
			this.faceTurn(3);
			this.faceTurn(5, false);
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(3,false);
			break;
							
	case 6: this.faceTurn(2); //R U2' [R2 U'] [R2 U'] R2 U2' R
			this.faceTurn(5,true, true);
			this.faceTurn(2, true,true);
			this.faceTurn(5,false);
			this.faceTurn(2,true,true);
			this.faceTurn(5, false);
			this.faceTurn(2, true, true);
			this.faceTurn(5, true, true);
			this.faceTurn(2);
			break;
		
	case 7: this.faceTurn(2); //(R U2') (R2' U') (R2 U') (R2' U2' R)
			this.faceTurn(5,true,true);
			this.faceTurn(2, true, true);
			this.faceTurn(5,false);
			this.faceTurn(2, true, true);
			this.faceTurn(5, false);
			this.faceTurn(2, true, true);
			this.faceTurn(5, true, true);
			this.faceTurn(2);
			break;
	
	case 8: this.faceTurn(5);
			break;
	}
	
	return false;
}

public boolean solve3() {
	return solve3(0);
}

public boolean solve3(int status) { 
//status int starts at 0, increments by one each time a pair is inserted
	
	int[][] white = this.getSide(0);
	int[][] red = this.getSide(1);
	int[][] blue = this.getSide(2);
	int[][] green = this.getSide(3);
	int[][] orange = this.getSide(4);
	int[][] yellow = this.getSide(5);
	
	//corner 1 check
	
	while(status == 0) { //corner 1 - orange and green
		
		if(white[0][0] == 0 && orange[0][2] == 4 && green[0][0] == 3 && orange[1][0] == 4 && green[1][0] == 3)
			return solve3(1);
		
		if(white[0][0] == 0 && orange[0][2] == 4 || white[0][0] == 3 && orange[0][2] == 0 || white[0][0] == 4 && orange[0][2] == 3) { //check if corner is in green-orange
			this.faceTurn(4);
			this.faceTurn(5);
			this.faceTurn(4, false);
			this.faceTurn(5, false);
		}
		
		if(white[0][2] == 0 && blue[0][2] == 4 || white[0][2] == 3 && blue[0][2] == 0 || white[0][2] == 4 && blue[0][2] == 3) { // check if corner is in orange - blue
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2, false);	
		}
		
		if(white[2][2] == 0 && red[0][2] == 4 || white[2][2] == 3 && red[0][2] == 0 || white[2][2] == 4 && red[0][2] == 3) { // check if corner is in blue - red
			this.faceTurn(1);
			this.faceTurn(5);
			this.faceTurn(1, false);
			this.faceTurn(5);
		}
		
		if(white[2][0] == 0 && green[0][2] == 4 || white[2][0] == 3 && green[0][2] == 0 || white[2][0] == 4 && green[0][2] == 3) { // check if corner is in red - green
			this.faceTurn(3);
			this.faceTurn(5);
			this.faceTurn(3, false);
			this.faceTurn(5,true,true);
		}
		
		//see if corner was in top layer already
		if(yellow[0][0] == 3 && green[2][2] == 4 || yellow[0][0] == 4 && green[2][2] == 0 || yellow[0][0] == 0 && green[2][2] == 3) //check if corner is above red-green
			this.faceTurn(5,false);
		
		if(yellow[0][2] == 3 && red[2][2] == 4 || yellow[0][2] == 4 && red[2][2] == 0 || yellow[0][2] == 0 && red[2][2] == 3) //check if corner is above blue-red
			this.faceTurn(5,false,true);
			
		if(yellow[2][2] == 3 && blue[2][2] == 4 || yellow[2][2] == 4 && blue[2][2] == 0 || yellow[2][2] == 0 && blue[2][2] == 3)
			this.faceTurn(5);
			
		//corner has to be in top layer now right above where it should go in
		
		if(green[1][0] == 3 && orange[1][2] ==  4 || green[1][0] == 4 && orange[1][2] == 3) {//checks under corner slot (why its longer)
			this.faceTurn(4);
			this.faceTurn(5);
			this.faceTurn(4, false);
			this.faceTurn(5,true, true);
			this.faceTurn(4);
			this.faceTurn(5, false);
			this.faceTurn(4, false);
		}
		
		if(orange[1][0] == 3 && blue[1][2] == 4|| orange[1][0] == 4 && blue[1][2] == 3) {//orange blue
			this.faceTurn(5);
			this.faceTurn(2);
			this.faceTurn(5,false);
			this.faceTurn(2,false);
		}
		
		if(blue[1][0] == 3 && red[1][2] == 4|| blue[1][0] == 4 && red[1][2] == 3) { //blue-red
			this.faceTurn(1);
			this.faceTurn(5, false);
			this.faceTurn(1, false);
			this.faceTurn(5);
		}	
		
		if(red[1][0] == 3 && green[1][2] == 4|| red[1][0] == 4 && green[1][2] == 3) { //red-green
			this.faceTurn(5, false);
			this.faceTurn(3);
			this.faceTurn(5, false);
			this.faceTurn(3, false);
			this.faceTurn(5,true,true);
		}	
		
		if(yellow[2][1] == 3 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 3) {//edge is directly to right (orange-yellow)
			this.faceTurn(3, false);
			this.faceTurn(5,true,true);
			this.faceTurn(3);
			this.faceTurn(5);
			//should then activate next if statement
		}
		
		if(yellow[1][2] == 3 && blue[2][1] == 4 || yellow[1][2] == 4 && blue[2][1] == 3) {// edge is in opposite spot of corner (blue-yellow)
			this.faceTurn(5);
			this.faceTurn(3, false);
			this.faceTurn(5, false);
			this.faceTurn(3);
			this.faceTurn(5, false);
		}
		
		if(yellow[1][0] == 3 && orange[2][1] == 4 || yellow[1][0] == 4 && orange[2][1] == 3) {//edge is directly to left (green-yellow)
			this.faceTurn(3, false);
			this.faceTurn(5,true,true);
			this.faceTurn(3);
			this.faceTurn(5);	
		}
		//now matching corner and edge are in the top layer and corner to the left - ready for insert
		this.insert(0);
	}
	
	while(status == 1) { //pair 2 - red - green
		
		if(white[2][0] == 0 && red[0][0] == 1 && red[1][0] == 1 && green[0][2] == 3 && green[1][2] == 3)
			return solve3(2);
		
		if(white[2][0] == 0 && red[0][0] == 1 || white[2][0] == 1 && red[0][0] == 3 || white[2][0] == 3 && red[0][0] == 0) { //check if corner is in red - green
			this.faceTurn(3);
			this.faceTurn(5);
			this.faceTurn(3, false);
			this.faceTurn(5, false);
		}
		
		if(white[0][2] == 0 && blue[0][2] == 1 || white[0][2] == 1  && blue[0][2] == 3 || white[0][2] == 3 && blue[0][2] == 0) { // check if corner is in orange - blue
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2, false);
			this.faceTurn(5);
		}
		
		if(white[2][2] == 0 && blue[0][0] == 1 || white[2][2] == 1 && blue[0][0] == 3 || white[2][2] == 3 && blue[0][2] == 0) { // check if corner is in blue - red
			this.faceTurn(1);
			this.faceTurn(5);
			this.faceTurn(1, false);
			this.faceTurn(5,true,true);
		}
		
		//see if corner was in top layer already
		if(yellow[2][1] == 0 && green[2][0] == 1 || yellow[2][1] == 1 && green[2][0] == 3 || yellow[2][1] == 3 && green[2][0] == 0) //check if corner is above orange-green
			this.faceTurn(5);
		
		if(yellow[0][2] == 0 && red[2][2] == 1 || yellow[0][2] == 1 && red[2][2] == 3 || yellow[0][2] == 3 && red[2][2] == 0) //check if corner is above blue-red
			this.faceTurn(5,false);
			
		if(yellow[2][2] == 0 && blue[2][2] == 1 || yellow[2][2] == 1 && blue[2][2] == 3 || yellow[2][2] == 3 && blue[2][2] == 0)//check above blue-orange
			this.faceTurn(5, true, true);
		
		//corner has to be in top layer now right above where it should go in
		
		if(green[1][2] == 3 && red[1][0] ==  1 || green[1][2] == 1 && red[1][0] == 3) {//checks under corner slot (why its longer)
			this.faceTurn(3);
			this.faceTurn(5);
			this.faceTurn(3, false);
			this.faceTurn(5,true, true);
			this.faceTurn(3);
			this.faceTurn(5, false);
			this.faceTurn(3, false);
		}
		
		if(blue[1][2] == 1 && orange[1][0] == 3|| blue[1][2] == 3 && orange[1][0] == 1) { //orange-blue
			this.faceTurn(2);
			this.faceTurn(5, false);
			this.faceTurn(2, false);
			this.faceTurn(5);
		}	
		
		if(red[1][2] == 1 && blue[1][0] == 3|| red[1][2] == 3 && blue[1][0] == 1) { //blue-red
			this.faceTurn(5, false);
			this.faceTurn(1);
			this.faceTurn(5, false);
			this.faceTurn(1, false);
			this.faceTurn(5,true,true);
		}	
		
		if(yellow[1][0] == 3 && green[2][1] == 1 || yellow[1][0] == 1 && green[2][1] == 3) {//edge is directly to right
			this.faceTurn(1, false);
			this.faceTurn(5,true,true);
			this.faceTurn(1);
			this.faceTurn(5);
			//should then activate next if statement
		}
		
		if(yellow[2][1] == 3 && orange[2][1] == 1 || yellow[2][1] == 1 && orange[2][1] == 3) {// edge is in opposite spot of corner
			this.faceTurn(5);
			this.faceTurn(2, false);
			this.faceTurn(5, false);
			this.faceTurn(2);
			this.faceTurn(5, false);
		}
		
		if(yellow[0][1] == 3 && red[2][1] == 1 || yellow[0][1] == 1 && red[2][1] == 3) {//edge is directly to left
			this.faceTurn(1,false);
			this.faceTurn(5,true,true);
			this.faceTurn(1);
			this.faceTurn(5);	
		}
		
		this.insert(1);
	}
	
	while(status == 2) {//pair 3 - blue-red
		
		if(white[2][2] == 0 && blue[0][0] == 2 && blue[1][0] == 2 && red[0][2] == 1 && red[1][2] == 1)
			return solve3(3);
		
		if(white[2][2] == 0 && blue[0][0] == 2 || white[2][2] == 2 && blue[0][0] == 1 || white[2][2] == 1 && blue[0][0] == 0) { //check if corner is in blue-red
			this.faceTurn(1);
			this.faceTurn(5);
			this.faceTurn(1, false);
			this.faceTurn(5, false);
		}
		
		if(white[0][2] == 0 && blue[0][2] == 2 || white[0][2] == 2 && blue[0][2] == 1 || white[0][2] == 1 && blue[0][2] == 0) { // check if corner is in orange-blue
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2, false);
			this.faceTurn(5,true,true);
		}
		
		//see if corner was in top layer already
		if(yellow[0][0] == 0 && green[2][2] == 2 || yellow[0][0] == 1 && green[2][2] == 0 || yellow[0][0] == 2 && green[2][2] == 1) //check if corner is above red-green
			this.faceTurn(5);
		
		if(yellow[2][0] == 0 && orange[2][2] == 2 || yellow[2][0] == 1 && orange[2][2] == 0 || yellow[2][0] == 2 && orange[2][2] == 1) //check if corner is above green-orange
			this.faceTurn(5,false,true);
			
		if(yellow[2][2] == 0 && blue[2][2] == 2 || yellow[2][2] == 1&& blue[2][2] == 0 || yellow[2][2] == 2  && blue[2][2] == 1)//check blue-orange
			this.faceTurn(5,false);
			
		//corner has to be in top layer now right above where it should go in
		
		if(blue[1][0] == 1 && red[1][2] ==  2 || blue[1][0] == 2 && red[1][2] == 1) {//checks under corner slot (why its longer)
			this.faceTurn(1);
			this.faceTurn(5);
			this.faceTurn(1, false);
			this.faceTurn(5,true, true);
			this.faceTurn(1);
			this.faceTurn(5, false);
			this.faceTurn(1, false);
		}
		
		if(orange[1][0] == 1 && blue[1][2] == 2|| orange[1][0] == 2 && blue[1][2] == 1) {//orange blue
			this.faceTurn(5,false);
			this.faceTurn(2);
			this.faceTurn(5,false);
			this.faceTurn(2,false);
			this.faceTurn(5,true,true);
		}
		
		if(yellow[0][1] == 1 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 1) {//edge is directly to right (red)
			this.faceTurn(1);
			this.faceTurn(5,true,true);
			this.faceTurn(1,false);
			this.faceTurn(5,false);
			//should then activate next if statement
		}
		
		if(yellow[1][0] == 1 && green[2][1] == 2 || yellow[1][0] == 2 && green[2][1] == 1) {// edge is in opposite spot of corner (green)
			this.faceTurn(5, false);
			this.faceTurn(1);
			this.faceTurn(5, false);
			this.faceTurn(1, false);
			this.faceTurn(5);
		}
		
		if(yellow[2][0] == 3 && blue[2][1] == 4 || yellow[2][0] == 4 && blue[2][1] == 3) {//edge is directly to left (blue)
			this.faceTurn(1);
			this.faceTurn(5,true,true);
			this.faceTurn(1, false);
			this.faceTurn(5,false);	
		}
		this.insert(2);
	}	
	
	while(status == 3) {//pair 4 - orange-blue
		
		if(white[0][2] == 0 && orange[0][0] == 4 && orange[1][0] == 4 && blue[0][2] == 2 && blue[1][2] == 2)
			return true; //all pairs are matched up
		
		if(white[0][2] == 0 && orange[0][0] == 4 || white[0][2] == 2 && orange[0][0] == 0 || white[0][2] == 4 && orange[0][0] == 2) { //check if corner is in orange-blue
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2, false);
			this.faceTurn(5, false);
		}
		
		//see if corner was in top layer already
		if(yellow[0][2] == 0 && red[2][2] == 4 || yellow[0][2] == 2 && red[2][2] == 0 || yellow[0][2] == 4 && red[2][2] == 2) //check if corner is above blue-red
			this.faceTurn(5);
		
		if(yellow[0][0] == 0 && green[2][2] == 4 || yellow[0][0] == 2 && green[2][2] == 0 || yellow[0][0] == 4 && green[2][2] == 2) //check if corner is above red-green
			this.faceTurn(5,false,true);
			
		if(yellow[2][0] == 0 && orange[2][2] == 4 || yellow[2][0] == 2 && orange[2][2] == 0 || yellow[2][0] == 4  && orange[2][2] == 2)//check green-orange
			this.faceTurn(5,false);
			
		//corner has to be in top layer now right above where it should go in
		
		if(orange[1][0] == 2 && blue[1][2] ==  4 || orange[1][0] == 4 && blue[1][2] == 2) {//checks under corner slot (why its longer)
			this.faceTurn(2);
			this.faceTurn(5);
			this.faceTurn(2, false);
			this.faceTurn(5,true, true);
			this.faceTurn(2);
			this.faceTurn(5, false);
			this.faceTurn(2, false);
		}
		
		if(yellow[1][2] == 4 && blue[2][1] == 2 || yellow[1][2] == 2 && blue[2][1] == 4) {//edge is directly to right (blue)
			this.faceTurn(2);
			this.faceTurn(5,true,true);
			this.faceTurn(2,false);
			this.faceTurn(5,false);
			//should then activate next if statement
		}
		
		if(yellow[0][1] == 4 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 4) {// edge is in opposite spot of corner (red
			this.faceTurn(5, false);
			this.faceTurn(2);
			this.faceTurn(5, false);
			this.faceTurn(2, false);
			this.faceTurn(5);
		}
		
		if(yellow[2][1] == 2 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 2) {//edge is directly to left (orange)
			this.faceTurn(2);
			this.faceTurn(5,true,true);
			this.faceTurn(2, false);
			this.faceTurn(5,false);	
		}
		this.insert(3);
	}	
	return false; //never reached
}

private boolean solve4() { return solve4(0);}

private boolean solve4(int state) {
	//method that will take random cube and create the white cross
	
	//sequentially find each white edge and move it to the right spot
	//find edges and line them up in order: red, blue, orange, green (improve later)
	int[][] white = this.getSide(0);
	int[][] red = this.getSide(1);
	int[][] blue = this.getSide(2);
	int[][] green = this.getSide(3);
	int[][] orange = this.getSide(4);
	int[][] yellow = this.getSide(5);
	
	
	while(state == 0) {//red white
		
		if(white[2][1] == 0 && red[0][1] == 1) {return solve4(1);}
		
		if(yellow[0][1] == 0 && red[2][1] == 1 || yellow[0][1] == 1 && red[2][1] == 0) {
			this.faceTurn(1);
			return solve4(0);
		}
		
		if(yellow[1][2] == 0 && blue[2][1] == 1 || yellow[1][2] == 1 && blue[2][1] == 0) {
			this.faceTurn(2);
			return solve4(0);
		}
		
		if(yellow[2][1] == 0 && orange[2][1] == 1 || yellow[2][1] == 1 && orange[2][1] == 0) {
			this.faceTurn(4);
			return solve4(0);
		}
		
		if(yellow[1][0] == 0 && green[2][1] == 1 || yellow[1][0] == 1 && green[2][1] == 0) {
			this.faceTurn(3);
			return solve4(0);
		}
		
		if(red[1][2] == 1 && blue[1][0] == 0) {
			this.faceTurn(1, false);
			return solve4(0);
		}
			
		if(red[1][2] == 0 && blue[1][0] == 1) {
			this.faceTurn(2);
			this.faceTurn(0);
			return solve4(0);
		}
		
		if(blue[1][2] == 1 && orange[1][0] ==0) {
			this.faceTurn(2,false);
			this.faceTurn(0);
			return solve4(0);
		}
			
		if(blue[1][2] == 0 && orange[1][0] ==1) {
			this.faceTurn(4);
			this.faceTurn(0,true,true);
			return solve4(0);
		}
		
		if(orange[1][2] == 1 && green[1][0] ==0) {
			this.faceTurn(4,false);
			this.faceTurn(0,true,true);
			return solve4(0);
		}
			
		if(orange[1][2] == 0 && green[1][0] ==1) {
			this.faceTurn(3);
			this.faceTurn(0,false);
			return solve4(0);
		}
		
		if(green[1][2] == 1 && red[1][0] == 0) {
			this.faceTurn(3, false);
			this.faceTurn(0,false);
			return solve4(0);
		}
			
		if(green[1][2] == 0 && red[1][0] == 1) {
			this.faceTurn(1);
			return solve4(0);
		}
		
		if(white[2][1] == 1 && red[0][1] == 0) {
			this.faceTurn(1);
			this.faceTurn(0,false);
			this.faceTurn(2);
			this.faceTurn(0);
			return solve4(0);
		}
		
		if(white[1][2] == 0 && blue[0][1] ==1) {
			this.faceTurn(0);
			return solve4(0);
		}
			
		if(white[1][2] == 1 && blue[0][1] == 0) {
			this.faceTurn(2,false);
			this.faceTurn(1,false);
			return solve4(0);
		}
		
		if(white[0][1] == 0 && orange[0][1] ==1) {
			this.faceTurn(0,true,true);
			return solve4(0);
		}
			
		if(white[0][1] == 1 && orange[0][1] == 0) {
			this.faceTurn(4,false);
			this.faceTurn(0,false);
			this.faceTurn(1,false);
			this.faceTurn(0);
			return solve4(0);
		}
			
		if(white[1][0] == 0 && green[0][1] ==1) {
			this.faceTurn(0,false);
			return solve4(0);
		}
			
		if(white[1][0] == 1 && green[0][1] == 0) {
			this.faceTurn(3);
			this.faceTurn(1);
			return solve4(0);
		}
	}
	
	while(state == 1) {//white blue
		
		if(white[1][2] == 0 && blue[0][1] == 1) {return solve4(2);}
		
		if(yellow[0][1] == 0 && red[2][1] == 2 || yellow[0][1] == 2 && red[2][1] == 0) {
			this.faceTurn(1);
			return solve4(1);
		}
		
		if(yellow[1][2] == 0 && blue[2][1] == 2 || yellow[1][2] == 2 && blue[2][1] == 0) {
			this.faceTurn(2);
			return solve4(1);
		}
		
		if(yellow[2][1] == 0 && orange[2][1] == 2 || yellow[2][1] == 2 && orange[2][1] == 0) {
			this.faceTurn(4);
			return solve4(1);
		}
		
		if(yellow[1][0] == 0 && green[2][1] == 2 || yellow[1][0] == 2 && green[2][1] == 0) {
			this.faceTurn(3);
			return solve4(1);
		}
		
		if(red[1][2] == 2 && blue[1][0] == 0) {
			this.faceTurn(0);
			this.faceTurn(1, false);
			this.faceTurn(0,false);
			return solve4(1);
		}
			
		if(red[1][2] == 0 && blue[1][0] == 2) {
			this.faceTurn(2);
			return solve4(1);
		}
		
		if(blue[1][2] == 2 && orange[1][0] ==0) {
			this.faceTurn(2,false);
			return solve4(1);
		}
			
		if(blue[1][2] == 0 && orange[1][0] ==2) {
			this.faceTurn(0,false);
			this.faceTurn(4);
			this.faceTurn(0,true);
			return solve4(1);
		}
		
		if(orange[1][2] == 2 && green[1][0] ==0) {
			this.faceTurn(0,false);
			this.faceTurn(4,false);
			this.faceTurn(0,true);
			return solve4(1);
		}
			
		if(orange[1][2] == 0 && green[1][0] ==2) {
			this.faceTurn(0,true,true);
			this.faceTurn(3);
			this.faceTurn(0,false, true);
			return solve4(1);
		}
		
		if(green[1][2] == 2 && red[1][0] == 0) {
			this.faceTurn(0,true,true);
			this.faceTurn(3, false);
			this.faceTurn(0,false, true);
			return solve4(1);
		}
			
		if(green[1][2] == 0 && red[1][0] == 2) {
			this.faceTurn(0);
			this.faceTurn(1);
			this.faceTurn(0,false);
			return solve4(1);
		}
		
		if(white[1][2] == 2 && blue[0][1] == 0) {
			this.faceTurn(2);
			this.faceTurn(0,false);
			this.faceTurn(4);
			this.faceTurn(0);			
			return solve4(1);
		}
		
		if(white[0][1] == 0 && orange[0][1] ==2) {
			this.faceTurn(0);
			return solve4(1);
		}
			
		if(white[0][1] == 2 && orange[0][1] == 0) {
			this.faceTurn(4,false);
			this.faceTurn(2,false);
			return solve4(1);
		}
			
		if(white[1][0] == 0 && green[0][1] ==2) {
			this.faceTurn(0,false,true);
			return solve4(1);
		}
			
		if(white[1][0] == 2 && green[0][1] == 0) {
			this.faceTurn(3);
			this.faceTurn(0);
			this.faceTurn(1);
			this.faceTurn(0,false);
			return solve4(1);
		}
	}
	
	while(state == 2) {//white orange
		
		if(white[0][1] == 0 && orange[0][1] == 4) {return solve4(3);}
		
		if(yellow[0][1] == 0 && red[2][1] == 4 || yellow[0][1] == 4 && red[2][1] == 0) {
			this.faceTurn(1);
			return solve4(2);
		}
		
		if(yellow[1][2] == 0 && blue[2][1] == 4 || yellow[1][2] == 4 && blue[2][1] == 0) {
			this.faceTurn(2);
			return solve4(2);
		}
		
		if(yellow[2][1] == 0 && orange[2][1] == 4 || yellow[2][1] == 4 && orange[2][1] == 0) {
			this.faceTurn(4);
			return solve4(2);
		}
		
		if(yellow[1][0] == 0 && green[2][1] == 4 || yellow[1][0] == 4 && green[2][1] == 0) {
			this.faceTurn(3);
			return solve4(2);
		}
		
		if(red[1][2] == 4 && blue[1][0] == 0) {
			this.faceTurn(0, true, true);
			this.faceTurn(1, false);
			this.faceTurn(0,false, true);
			return solve4(2);
		}
			
		if(red[1][2] == 0 && blue[1][0] == 4) {
			this.faceTurn(0);
			this.faceTurn(2);
			this.faceTurn(0,false);
			return solve4(2);
		}
		
		if(blue[1][2] == 4 && orange[1][0] ==0) {
			
			this.faceTurn(0);
			this.faceTurn(2,false);
			this.faceTurn(0,false);
			return solve4(2);
		}
			
		if(blue[1][2] == 0 && orange[1][0] ==4) {
			this.faceTurn(2);
			return solve4(2);
		}
		
		if(orange[1][2] == 4 && green[1][0] ==0) {
			this.faceTurn(4,false);
			return solve4(2);
		}
			
		if(orange[1][2] == 0 && green[1][0] ==4) {
			this.faceTurn(0,false);
			this.faceTurn(3);
			this.faceTurn(0);
			return solve4(1);
		}
		
		if(green[1][2] == 4 && red[1][0] == 0) {
			this.faceTurn(0,false);
			this.faceTurn(3, false);
			this.faceTurn(0);
			return solve4(2);
		}
			
		if(green[1][2] == 0 && red[1][0] == 4) {
			this.faceTurn(0,true,true);
			this.faceTurn(1);
			this.faceTurn(0,false,true);
			return solve4(2);
		}
			
		if(white[0][1] == 4 && orange[0][1] == 0) {
			this.faceTurn(4,false);
			this.faceTurn(0);
			this.faceTurn(2,false);
			this.faceTurn(0,false);
			return solve4(2);
		}
			
		if(white[1][0] == 0 && green[0][1] ==4) {
			this.faceTurn(0,true);
			return solve4(2);
		}
			
		if(white[1][0] == 2 && green[0][1] == 0) {
			this.faceTurn(3,false);
			this.faceTurn(4,false);
			return solve4(2);
		}
	}
	
	while(state == 3) {//white green
		
	}
}

private void insert(int status) {//inserts corner/edge pairs in F2L
	
	int left, right, cornerX, cornerY, edgeX, edgeY;
	
	switch(status) {
	case 0:
		left = green;
		right = orange;
		cornerX = 2;
		cornerY = 0;
		edgeX = 0;
		edgeY = 1;
		break;
		
	case 1:
		left = red;
		right = green;
		cornerX = 0;
		cornerY = 0;
		edgeX = 1;
		edgeY = 2;
		break;
		
	case 2:
		left = blue;
		right = red;
		cornerX = 0;
		cornerY = 2;
		edgeX = 2;
		edgeY = 1;
		break;
		
	case 3:
		left = orange;
		right = blue;
		cornerX = 2;
		cornerY = 2;
		edgeX = 1;
		edgeY =  0;
		break; 
		
	default:
		left = 0;
		right = 0;
		cornerX = 0;
		cornerY = 0;
		edgeX = 0;
		edgeY = 0;
	}
	
	int[][] Top = this.getSide(yellow);
//	int[][] Left = this.getSide(left);
//	int[][] Right = this.getSide(right);
	
	if(Top[cornerX][cornerY] == white) {
		//do weird alg
		if(Top[edgeX][edgeY] == left) {
			this.faceTurn(yellow,false,true);//lineup edge with matching colour(right)
			this.faceTurn(right);
			this.faceTurn(yellow);
			this.faceTurn(right,false);
			this.faceTurn(yellow);
			this.faceTurn(right);
			this.faceTurn(yellow,false);
			this.faceTurn(right,false);
		}
		else {
			this.faceTurn(yellow,false);//lineup edge with matching colour(left)
			this.faceTurn(left, false);
			this.faceTurn(yellow, true, true);
			this.faceTurn(left);
			this.faceTurn(yellow, false);
			this.faceTurn(left, false);
			this.faceTurn(yellow);
			this.faceTurn(left);
		}
	}
	
	else if(Top[cornerX][cornerY] == Top[edgeX][edgeY]) {
		//do match algorithm
		this.faceTurn(yellow);
		this.faceTurn(left, false);
		this.faceTurn(yellow, false);
		this.faceTurn(left);
		this.faceTurn(yellow,false, true);
		this.faceTurn(left, false);
		this.faceTurn(yellow);
		this.faceTurn(left);
		
	}
	
	else {
		//do opposite algorithm
		if(Top[cornerX][cornerY] == left) {
			this.faceTurn(left, false);
			this.faceTurn(yellow, false);
			this.faceTurn(left);
		}
		
		else {//have to move edge before insertion
			this.faceTurn(yellow);
			this.faceTurn(left,false);
			this.faceTurn(yellow);
			this.faceTurn(left);
			this.faceTurn(yellow,false);
			this.faceTurn(right);
			this.faceTurn(yellow);
			this.faceTurn(right,false);
		}			
	}
}


private int solve2Switch1(int[][] yellow) {// returns 0 for cross, 1 for L, 2 for line and 3 for dot
	
	if(yellow[1][0] == 5 && yellow[1][2] == 5 && yellow[0][1] == 5)
		return 0;
	
	if(yellow[1][0] == 5 && yellow[1][2] == 5)
		return 1;
	
	if(yellow[1][0] == 5 && yellow[0][1] == 5)
		return 2;
	
	if(yellow[1][0] != 5 && yellow[1][2] != 5 && yellow[0][1] != 5)// cant have just 1 right edge - no need to check
		return 3;
	
	return 4;
		
}

private int solve2Switch2(int[][] check) {//0 for complete, 8 if none and then it will rotate and check again
	
	int corners = cornerCount(check);
	
	if(corners == 4)
		return 0;
	
	if(corners == 2) {
		
		if(check[4][1] == 5 && check[4][3] == 5)
			return 1;

		
		if(check[0][1] == 5 && check[4][1] == 5) 
			return 2;
		
		if(check[3][0] == 5 && check[0][3] == 5)
			return 3;
		}
	
	if(corners == 1) {
		
		if(check[0][1] == 5 && check[1][4] == 5 && check[4][3] == 5)
			return 4;
		
		if(check[4][1] == 5 && check[0][3] == 5 && check[3][4] == 5)
			return 5;
	}
	
	if(corners == 0) {
		
		if(check[3][0] == 5 && check[1][0] == 5 && check[0][3] == 5 && check[4][3] == 5)
			return 6;
			
		if(check[0][1] == 5 && check[0][3] == 5 && check[4][1] == 5 && check[4][3] == 5)
			return 7;
	}	
	
	return 8;	
}

public static int cornerCount(int[][] check) {//counts number of correct corners in OLL
	int corners = 0;
	
	if(check[1][1] == 5)
		corners++;
	
	if(check[1][3] == 5)
		corners++;
		
	if(check[3][1] == 5)
		corners++;
	
	if(check[3][3] == 5)
		corners++;
	
	return corners;
}

private int solve1Check(int[][] face) { //returns 0 for [000], 1 for [101] and 2 for [111] (1s being same and 0s being different)
	if(face[2][0]==face[2][2]) {
		if(face[2][0] == face[2][1])
			return 2;
		else
			return 1;
		}
	return 0;	
}

public void solve1Alg1(int back) {//change to private after test
	int side = sideNumberChange(back, true);
	int front = sideNumberChange(side, true);
	
	System.out.println("Starting final stage - alg 1:");
	this.faceTurn(side, false);
	this.faceTurn(front);
	this.faceTurn(side, false);
	this.faceTurn(back, true, true);
	this.faceTurn(side);
	this.faceTurn(front, false);
	this.faceTurn(side, false);
	this.faceTurn(back, true, true);
	this.faceTurn(side, true, true);
	
	this.displayNet();
}

private void solve1Alg2(int back, boolean direction /*true is CW, false is CCW*/) {
	int rSide = sideNumberChange(back, true);
	int front = sideNumberChange(rSide, true);
	int lSide = sideNumberChange(back, false);
	
	
	System.out.println("Starting final stage - alg 2:" );
	this.faceTurn(front,true, true);
	this.faceTurn(5, direction);
	this.faceTurn(rSide, false);
	this.faceTurn(lSide, true);
	this.faceTurn(front, true, true);
	this.faceTurn(rSide, true);
	this.faceTurn(lSide, false);
	this.faceTurn(5, direction);
	this.faceTurn(front, true, true);
	
	this.displayNet();

}

private boolean solve1GetDir(int complete, ArrayList<int[][]> faces) {
int[][] front , lSide;
	
	if(complete == 0) {
		front = faces.get(3);
		lSide = faces.get(2);
	}
	
	else if(complete == 1) {
		front = faces.get(2);
		lSide = faces.get(0);
	}

	else if(complete == 2) {
		front = faces.get(1);
		lSide = faces.get(3);
	}
	
	else if(complete == 3) {
		front = faces.get(0);
		lSide = faces.get(1);
	}
	
	else { //never used
		front = faces.get(0);
		lSide = faces.get(0);
	}
	
	if(front[2][1] == lSide[2][2])
		return true;
		
	else
		return false;
}

private int sideNumberChange(int face, boolean direction) {

	if(direction == true) {
	
	switch(face) {
		
		case 1: return 2;
		case 2: return 4;
		case 3: return 1;
		case 4: return 3;	
	}}

	switch(face) {
		case 1: return 3;
		case 2: return 1;
		case 3: return 4;
		case 4: return 2;
		default: return -1;
	}
}

public static void main(String args[]) {

	Cube cube = new Cube();
	
	cube.setSide(0,o,w,w,w,w,b,b,y);
	cube.setSide(1,r,r,b,r,o,g,o,r);
	cube.setSide(2,r,b,b,g,b,y,b,g);
	cube.setSide(3,y,g,w,y,w,r,r,o);
	cube.setSide(4,o,o,b,o,g,o,r,w);
	cube.setSide(5,y,y,g,g,y,g,y,w);
	
	
//	cube.faceTurn(5);

//	cube.solveCube();
	
	cube.displayNet();
	
	boolean garbage = cube.solve3();
	cube.displayNet();
}
}