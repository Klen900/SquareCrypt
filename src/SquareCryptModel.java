public class SquareCryptModel {
	
	
	//instance variables
	int[][] matrix;
	int row= 127;
	int col = 255; 
	int count = 0;
	public int countMatrices =0;
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
				
				matrix[i][j]= 0;

			}
		}
		
	}
	
	public Boolean isFull(int indX){
		
//		for(int j = 0; j<255; j++){
//			
//			if(matrix[indX][j]==0){
//				return false;
//			}
//			
//		}
		
		if(count ==255){
			
			countMatrices++;

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
				
            while(matrix[x][y] != 0){
            	
            	y = (int)Math.floor(Math.random()*col);
            	
			}
			}else{
				
				isFull = true;
				count = 0;

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