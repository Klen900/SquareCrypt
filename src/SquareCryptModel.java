public class SquareCryptModel {
	/**
	 * This class creates the matrix that holds the character values
	 * The rows represent the numerical value of the character that goes from 0-127
	 * The columns hold the frequency of each character which can get to 255
	 * We first create an empty matrix with values of -1. the values that the matrix holds is the order at which the character was entered
	 * 
	 */
	
	//instance variables
	int[][] matrix;
	int row= 127;
	int col = 255; 
	int count = 1;//counts the order 

	Boolean isFull = false;

	//constructor
	SquareCryptModel(){
 
		makeNewModel();

	}

	public void makeNewModel(){
		
		matrix = new int[row][col];

		//filling the matrix with RGB color = white.
		for(int i=0; i<row; i++){
			for(int j =0;j<col; j++ ){
				
				matrix[i][j]= -1;

			}
		}
		
	}
	
	//erases all values in the matrix
	public void clearAll(){
		
		 makeNewModel();
		
	}
	
	//checks if the matrix has reached 255 characters.
	public Boolean isFull(int indX){
		
		if(count ==255){
			
			return true;
		}
		
		return false;
		
	}
	
	/**
	 * stores the char value in the matrix
	 * @param str
	 * @return
	 */
	public int[][] setMatrixIndecies(String str){

		char chr;
		int x,y;
		
		for(int k=0; k<str.length();k++){
			
			chr = str.charAt(k);
			
			x = (int)chr; //x is equal to the numerical value of the character
			
			y = (int)Math.floor(Math.random()*col); //y is a random value at the row in which the char is stored
			
			
			//for duplicated characters, we need to check if the column is full at each given row
			if(!isFull(x)){
				
            while(matrix[x][y] != -1){
            	
            	y = (int)Math.floor(Math.random()*col);//while the index at row = x is full, keep looking for another y value in which to store the char order
            	
			}
			}else{
				
				isFull = true;//if the whole row is full, it means that we stored 255 chars, so the matrix returns true for isFull
				count = 1;//set the count back to 1 for the new matrix

			}
			
			matrix[x][y] = count; //when y is selected, store the order of the char in the matrix indices
			
			count ++;//increment the count each time we do.
			
		}
		return matrix;
	}

		public int[][] getMatrix() {
		return matrix;
	}

//end of class	

}