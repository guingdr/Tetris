/**
Guilherme Nascimento Gouvêa dos Reis 2018.1
**/

import java.awt.Rectangle;
import java.awt.Dimension;
import java.awt.Point;

import java.awt.Color;

// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //
// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //



class Block extends Rectangle{

	//   ---   ---   ---   //
	private static int width  = 33;
	private static int height = 33;
	private Color color;
	//   ---   ---   ---   //


	Block(Color c){

		//   ---   ---   ---   //
		super(width,  height);
		setColor(c);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	void setColor(Color c){ color = c; }
	Color getColor(){ return color; }
	//   ---   ---   ---   //

	//   ---   ---   ---   //
	int getBlockX(){ return (int) getX()/width;  }
	int getBlockY(){ return (int) getY()/height; }
	//   ---   ---   ---   //

	//   ---   ---   ---   //
	void moveBlock(int deltaX, int deltaY){
		Point p = getLocation();
		p.setLocation(p.getX() + deltaX*width, p.getY() + deltaY*height);
		this.setLocation(p);
	}

	void moveUp()   { moveBlock(+0, -1); }
	void moveDown() { moveBlock(+0, +1); }
	void moveRight(){ moveBlock(+1, +0); }
	void moveLeft() { moveBlock(-1, +0); }
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	static int getBlockWidth() { return Block.width;  }
	static int getBlockHeight(){ return Block.height; }
	//   ---   ---   ---   //

}