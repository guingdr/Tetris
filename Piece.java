/**
Guilherme Nascimento Gouvêa dos Reis 2018.1
**/

import java.awt.Color;

// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //
// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //



abstract class Piece{

	//   ---   ---   ---   //
	private char shape;
	private Color color;
	private char orientation;
	private Block[] blocks;
	//   ---   ---   ---   //


	Piece(char s){

		//   ---   ---   ---   //
		shape = s;
		orientation = 'A';

		blocks = new Block[4];
		for (int i = 0; i < 4; i++){
			blocks[i] = new Block(Color.BLACK);
		}
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void setColor(Color c){
		color = c;
		for (int i = 0; i < 4; i++){
			blocks[i].setColor(c);
		}
	}

	char    getShape()      { return shape;       }
	Color   getColor()      { return color;       }
	char    getOrientation(){ return orientation; }
	Block   getBlocks(int i){ return blocks[i];   }
	Block[] getBlocks()     { return blocks;      }
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	void moveUp()   { for (int i = 0; i < 4; i++){ blocks[i].moveUp();    } }
	void moveDown() { for (int i = 0; i < 4; i++){ blocks[i].moveDown();  } }
	void moveRight(){ for (int i = 0; i < 4; i++){ blocks[i].moveRight(); } }
	void moveLeft() { for (int i = 0; i < 4; i++){ blocks[i].moveLeft();  } }

	void rotateRight(){
		// ROTATE CLOCKWISE
		if (orientation < 'D'){
			orientation++;
		} else {
			orientation = 'A';
		}
	}

	void rotateLeft(){
		// ROTATE COUNTER-CLOCKWISE
		if (orientation > 'A'){
			orientation--;
		} else {
			orientation = 'D';
		}
	}

	void moveBlock(int i, int x, int y){ blocks[i].moveBlock(x, y); }
	//   ---   ---   ---   //

}


// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //
// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //

class PieceA extends Piece{

	PieceA(){

		//   ---   ---   ---   //
		super('A');

		setColor(Color.ORANGE);

		moveBlock(0, 3, 0);
		moveBlock(1, 4, 0);
		moveBlock(2, 5, 0);
		moveBlock(3, 6, 0);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, +1);
				moveBlock(3, -2, +2);
				break;
			case 'B':
				moveBlock(0, -1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, -1);
				moveBlock(3, +2, -2);
				break;
			case 'C':
				moveBlock(0, +2, +2);
				moveBlock(1, +1, +1);
				moveBlock(2, +0, +0);
				moveBlock(3, -1, -1);
				break;
			case 'D':
				moveBlock(0, -2, -2);
				moveBlock(1, -1, -1);
				moveBlock(2, +0, +0);
				moveBlock(3, +1, +1);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +2, +2);
				moveBlock(1, +1, +1);
				moveBlock(2, +0, +0);
				moveBlock(3, -1, -1);
				break;
			case 'B':
				moveBlock(0, -1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, -1);
				moveBlock(3, +2, -2);
				break;
			case 'C':
				moveBlock(0, +1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, +1);
				moveBlock(3, -2, +2);
				break;
			case 'D':
				moveBlock(0, -2, -2);
				moveBlock(1, -1, -1);
				moveBlock(2, +0, +0);
				moveBlock(3, +1, +1);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}

class PieceB extends Piece{

	PieceB(){

		//   ---   ---   ---   //
		super('B');

		setColor(Color.RED);

		moveBlock(0, 4, 0);
		moveBlock(1, 5, 0);
		moveBlock(2, 4, 1);
		moveBlock(3, 5, 1);
		//   ---   ---   ---   //
	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
			case 'B':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
			case 'C':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
			case 'D':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
			case 'B':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
			case 'C':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
			case 'D':
				moveBlock(0, +0, +0);
				moveBlock(1, +0, +0);
				moveBlock(2, +0, +0);
				moveBlock(3, +0, +0);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}

class PieceC extends Piece{

	//   ---   ---   ---   //
	PieceC(){

		//   ---   ---   ---   //
		super('C');

		setColor(Color.YELLOW);

		moveBlock(0, 3, 0);
		moveBlock(1, 4, 0);
		moveBlock(2, 5, 0);
		moveBlock(3, 4, 1);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, +1);
				moveBlock(3, -1, -1);
				break;
			case 'B':
				moveBlock(0, +1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, -1);
				moveBlock(3, +1, -1);
				break;
			case 'C':
				moveBlock(0, -1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, -1);
				moveBlock(3, +1, +1);
				break;
			case 'D':
				moveBlock(0, -1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, +1);
				moveBlock(3, -1, +1);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, -1);
				moveBlock(3, +1, -1);
				break;
			case 'B':
				moveBlock(0, -1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, -1);
				moveBlock(3, +1, +1);
				break;
			case 'C':
				moveBlock(0, -1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, +1);
				moveBlock(3, -1, +1);
				break;
			case 'D':
				moveBlock(0, +1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, +1);
				moveBlock(3, -1, -1);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}

class PieceD extends Piece{

	PieceD(){

		//   ---   ---   ---   //
		super('D');

		setColor(Color.CYAN);

		moveBlock(0, 3, 1);
		moveBlock(1, 4, 1);
		moveBlock(2, 5, 1);
		moveBlock(3, 5, 0);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, -2);
				moveBlock(1, +0, -1);
				moveBlock(2, -1, +0);
				moveBlock(3, +0, +1);
				break;
			case 'B':
				moveBlock(0, +1, +2);
				moveBlock(1, +0, +1);
				moveBlock(2, -1, +0);
				moveBlock(3, -2, +1);
				break;
			case 'C':
				moveBlock(0, -1, +0);
				moveBlock(1, +0, -1);
				moveBlock(2, +1, -2);
				moveBlock(3, +0, -3);
				break;
			case 'D':
				moveBlock(0, -1, +0);
				moveBlock(1, +0, +1);
				moveBlock(2, +1, +2);
				moveBlock(3, +2, +1);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, +0);
				moveBlock(1, +0, -1);
				moveBlock(2, -1, -2);
				moveBlock(3, -2, -1);
				break;
			case 'B':
				moveBlock(0, -1, +2);
				moveBlock(1, +0, +1);
				moveBlock(2, +1, +0);
				moveBlock(3, +0, -1);
				break;
			case 'C':
				moveBlock(0, -1, -2);
				moveBlock(1, +0, -1);
				moveBlock(2, +1, +0);
				moveBlock(3, +2, -1);
				break;
			case 'D':
				moveBlock(0, +1, +0);
				moveBlock(1, +0, +1);
				moveBlock(2, -1, +2);
				moveBlock(3, +0, +3);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}

class PieceE extends Piece{

	PieceE(){

		//   ---   ---   ---   //
		super('E');

		setColor(Color.PINK);

		moveBlock(0, 3, 0);
		moveBlock(1, 4, 0);
		moveBlock(2, 5, 0);
		moveBlock(3, 5, 1);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +2, -2);
				moveBlock(1, +1, -1);
				moveBlock(2, +0, +0);
				moveBlock(3, -1, -1);
				break;
			case 'B':
				moveBlock(0, +0, +2);
				moveBlock(1, -1, +1);
				moveBlock(2, -2, +0);
				moveBlock(3, -1, -1);
				break;
			case 'C':
				moveBlock(0, -2, +0);
				moveBlock(1, -1, -1);
				moveBlock(2, +0, -2);
				moveBlock(3, +1, -1);
				break;
			case 'D':
				moveBlock(0, +0, +0);
				moveBlock(1, +1, +1);
				moveBlock(2, +2, +2);
				moveBlock(3, +1, +3);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +0, +0);
				moveBlock(1, -1, -1);
				moveBlock(2, -2, -2);
				moveBlock(3, -1, -3);
				break;
			case 'B':
				moveBlock(0, -2, +2);
				moveBlock(1, -1, +1);
				moveBlock(2, +0, +0);
				moveBlock(3, +1, +1);
				break;
			case 'C':
				moveBlock(0, +0, -2);
				moveBlock(1, +1, -1);
				moveBlock(2, +2, +0);
				moveBlock(3, +1, +1);
				break;
			case 'D':
				moveBlock(0, +2, +0);
				moveBlock(1, +1, +1);
				moveBlock(2, +0, +2);
				moveBlock(3, -1, +1);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}

class PieceF extends Piece{

	PieceF(){

		//   ---   ---   ---   //
		super('F');

		setColor(Color.GREEN);

		moveBlock(0, 3, 1);
		moveBlock(1, 4, 1);
		moveBlock(2, 4, 0);
		moveBlock(3, 5, 0);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, -2);
				moveBlock(1, +0, -1);
				moveBlock(2, +1, +0);
				moveBlock(3, +0, +1);
				break;
			case 'B':
				moveBlock(0, +1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, +1);
				moveBlock(3, -2, +0);
				break;
			case 'C':
				moveBlock(0, -1, +1);
				moveBlock(1, +0, +0);
				moveBlock(2, -1, -1);
				moveBlock(3, +0, -2);
				break;
			case 'D':
				moveBlock(0, -1, +0);
				moveBlock(1, +0, +1);
				moveBlock(2, +1, +0);
				moveBlock(3, +2, +1);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +1, +0);
				moveBlock(1, +0, -1);
				moveBlock(2, -1, +0);
				moveBlock(3, -2, -1);
				break;
			case 'B':
				moveBlock(0, -1, +2);
				moveBlock(1, +0, +1);
				moveBlock(2, -1, +0);
				moveBlock(3, +0, -1);
				break;
			case 'C':
				moveBlock(0, -1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, -1);
				moveBlock(3, +2, +0);
				break;
			case 'D':
				moveBlock(0, +1, -1);
				moveBlock(1, +0, +0);
				moveBlock(2, +1, +1);
				moveBlock(3, +0, +2);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}

class PieceG extends Piece{

	PieceG(){

		//   ---   ---   ---   //
		super('G');

		setColor(Color.BLUE);

		moveBlock(0, 3, 0);
		moveBlock(1, 4, 0);
		moveBlock(2, 4, 1);
		moveBlock(3, 5, 1);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void rotateRight(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +2, -1);
				moveBlock(1, +1, +0);
				moveBlock(2, +0, -1);
				moveBlock(3, -1, +0);
				break;
			case 'B':
				moveBlock(0, +0, +2);
				moveBlock(1, -1, +1);
				moveBlock(2, +0, +0);
				moveBlock(3, -1, -1);
				break;
			case 'C':
				moveBlock(0, -2, +0);
				moveBlock(1, -1, -1);
				moveBlock(2, +0, +0);
				moveBlock(3, +1, -1);
				break;
			case 'D':
				moveBlock(0, +0, -1);
				moveBlock(1, +1, +0);
				moveBlock(2, +0, +1);
				moveBlock(3, +1, +2);
				break;
		}
		super.rotateRight();
	}

	void rotateLeft(){
		switch (getOrientation()){
			case 'A':
				moveBlock(0, +0, +1);
				moveBlock(1, -1, +0);
				moveBlock(2, +0, -1);
				moveBlock(3, -1, -2);
				break;
			case 'B':
				moveBlock(0, -2, +1);
				moveBlock(1, -1, +0);
				moveBlock(2, +0, +1);
				moveBlock(3, +1, +0);
				break;
			case 'C':
				moveBlock(0, +0, -2);
				moveBlock(1, +1, -1);
				moveBlock(2, +0, +0);
				moveBlock(3, +1, +1);
				break;
			case 'D':
				moveBlock(0, +2, +0);
				moveBlock(1, +1, +1);
				moveBlock(2, +0, +0);
				moveBlock(3, -1, +1);
				break;
		}
		super.rotateLeft();
	}
	//   ---   ---   ---   //

}