public class SquareCryptModel {
	
	
	//instance variables
	int[][] matrix;
	int row= 127;
	int col = 255; 
	int count = 1;

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
	
	public void clearAll(){
<<<<<<< HEAD
		makeNewModel();
=======
		
		 makeNewModel();
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
		
	}
	
	public Boolean isFull(int indX){
		
		if(count ==255){
			
			return true;
		}
		
		return false;
		
	}
	
	public int[][] setMatrixIndecies(String str){

		char chr;
		int x,y;
		
		for(int k=0; k<str.length();k++){
			
			chr = str.charAt(k);
			
			x =  (int)chr;
			
			y = (int)Math.floor(Math.random()*col);
			
			
			//for duplicates
			if(!isFull(x)){
				
<<<<<<< HEAD
				while(matrix[x][y] != -1){
=======
            while(matrix[x][y] != -1){
>>>>>>> b3fc24825be54ef1bab413f28af7ac39357228f3
            	
            	y = (int)Math.floor(Math.random()*col);
            	
			}
			}else{
				
				isFull = true;
				count = 1;

			}
			
			matrix[x][y] = count;
			
			count ++;
			
		}
		return matrix;
	}

		public int[][] getMatrix() {
		return matrix;
	}

//end of class	

}