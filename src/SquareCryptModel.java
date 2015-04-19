
public class SquareCryptModel {
	
	
	//instance variables
	int[][] matrix;
	int row= 255;
	int col = 255; 
	int count = 0;

	//constructor
	SquareCryptModel(){

		matrix = new int[row][col];

		//filling the matrix with RGB color = white.
		for(int i=0; i<row; i++){
			for(int j =0;j<col; j++ ){
				
				matrix[i][j]= 0;

			}
		}
		
	}
	
	//print out the matrix
	
	public void  printMatrix(){
        
		for(int i=0; i<row; i++){
			
			for(int j =0;j<row; j++ ){
				
				System.out.print(matrix[i][j] +" ");

			}
			System.out.print("\n");
		}
	}
	
	public int[][] getMatrixIndecies(String str){

		char chr;
		int x,y;
		
		for(int k=0; k<str.length();k++){
			
			chr = str.charAt(k);
			
			x =  (int)chr;
			
			y = (int)Math.floor(Math.random()*255);
			
			//for duplicates
            while(matrix[x][y] != 0){
            	
            	y = (int)Math.floor(Math.random()*255);
			}

			System.out.print( "x " + x + "y " + y);
			matrix[x][y] = count;
			
			//System.out.print( Character.getNumericValue(chr)+ " " );
			//System.out.println(matrix[x][y] );
			count ++;
		}
		return matrix;
	}

		public int[][] getMatrix() {
		return matrix;
	}


		public static void main(String[] args){
			
			String str = "ahgsbndikel?m";
		
//			SquareCryptModel mySquareCryptModel = new SquareCryptModel();
//			
//		   mySquareCryptModel.getMatrixIndecies(str);
			
			//mySquareCryptModel.printMatrix(); 
		}

//end of class	

}
