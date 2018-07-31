/**
Guilherme Nascimento Gouvêa dos Reis 2018.1
**/

import javax.swing.JPanel;
import javax.swing.JComponent;

import java.awt.Dimension;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import javax.swing.Timer;

import javax.swing.KeyStroke;

import java.awt.Color;

import java.awt.Graphics;
import java.awt.Graphics2D;

// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //
// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //



class GamePanel extends JPanel{

	//   ---   ---   ---   //
	private static int rowsBlocks = 20;
	private static int colsBlocks = 10;

	private int blocksWidth  = Block.getBlockWidth();
	private int blocksHeight = Block.getBlockHeight();

	private Piece     fallingPiece;
	private Block[][] bottomBlocks = new Block[rowsBlocks][colsBlocks];

	private boolean listeningKeys;
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	class TimerActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if (possibleMoveDown()){
				fallingPiece.moveDown();
			} else {
				for (int i = 0; i < 4; i++){
					Block block = fallingPiece.getBlocks(i);
					int x = block.getBlockX();
					int y = block.getBlockY();
					bottomBlocks[y][x] = block;
				}

				boolean hasFilledRows;
				do {
					hasFilledRows = false;
					for (int i = 0; i < rowsBlocks; i++){
						boolean iIsFilledRow = true;
						for (int j = 0; j < colsBlocks; j++){
							if (bottomBlocks[i][j] == null){
								iIsFilledRow = false;
								break;
							}
						}
						if (iIsFilledRow){
							for (int j = i; j > 0; j--){
								for (int k = 0; k < colsBlocks; k++){
									if (bottomBlocks[j][k] != null){
										bottomBlocks[j][k].moveDown();
									}
									bottomBlocks[j][k] = bottomBlocks[j - 1][k];
								}
							}
							bottomBlocks[0] = new Block[colsBlocks];
							hasFilledRows = true;
						}
					}
				} while (hasFilledRows);

				sortPiece();
			}
			repaint();
		}
	}
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	class KeyTimerActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setListeningKeys();
		}
	}
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	class PieceAction extends AbstractAction{
		public void actionPerformed(ActionEvent e){
			resetListeningKeys();
			repaint();
		}
	}


	class MoveAction extends PieceAction{
		public void actionPerformed(ActionEvent e){
			super.actionPerformed(e);
		}
	}

	class MoveUpAction extends MoveAction{
		public void actionPerformed(ActionEvent e){
			if (getListeningKeys() && possibleMoveUp()){
				fallingPiece.moveUp();
				super.actionPerformed(e);
			}
		}
	}

	class MoveDownAction extends MoveAction{
		public void actionPerformed(ActionEvent e){
			if (getListeningKeys() && possibleMoveDown()){
				//fallingPiece.moveDown();
				timer.setDelay(100);
				super.actionPerformed(e);
			}
		}
	}

	class MoveRightAction extends MoveAction{
		public void actionPerformed(ActionEvent e){
			if (getListeningKeys() && possibleMoveRight()){
				fallingPiece.moveRight();
				super.actionPerformed(e);
			}
		}
	}

	class MoveLeftAction extends MoveAction{
		public void actionPerformed(ActionEvent e){
			if (getListeningKeys() && possibleMoveLeft()){
				fallingPiece.moveLeft();
				super.actionPerformed(e);
			}
		}
	}


	// MEEEH
	class RotateAction extends PieceAction{
		public void actionPerformed(ActionEvent e){
			super.actionPerformed(e);
		}
	}

	// MEEEH
	class RotateRightAction extends RotateAction{
		public void actionPerformed(ActionEvent e){
			if (getListeningKeys()){
				fallingPiece.rotateRight();
				super.actionPerformed(e);
			}
		}
	}

	// MEEEH
	class RotateLeftAction extends RotateAction{
		public void actionPerformed(ActionEvent e){
			if (getListeningKeys()){
				fallingPiece.rotateLeft();
				super.actionPerformed(e);
			}
		}
	}
	//   ---   ---   ---   //


	GamePanel(){

		//   ---   ---   ---   //
		sortPiece();
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		TimerActionListener tal = new TimerActionListener();
		Timer timer = new Timer(1000, tal);
		timer.start();
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		KeyTimerActionListener ktal = new KeyTimerActionListener();
		Timer keyTimer = new Timer(500, ktal);
		keyTimer.start();
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;

		// MEEEH
		MoveUpAction mua = new MoveUpAction();
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("UP"), "MoveUp");
		this.getActionMap().put("MoveUp", mua);

		// MEEEH
		MoveDownAction mda = new MoveDownAction();
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("DOWN"), "MoveDown");
		this.getActionMap().put("MoveDown", mda);

		MoveRightAction mra = new MoveRightAction();
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("RIGHT"), "MoveRight");
		this.getActionMap().put("MoveRight", mra);

		MoveLeftAction mla = new MoveLeftAction();
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("LEFT"), "MoveLeft");
		this.getActionMap().put("MoveLeft", mla);

		RotateRightAction rra = new RotateRightAction();
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("A"), "RotateLeft");
		this.getActionMap().put("RotateLeft", rra);

		RotateLeftAction rla = new RotateLeftAction();
		this.getInputMap(IFW).put(KeyStroke.getKeyStroke("D"), "RotateLeft");
		this.getActionMap().put("RotateLeft", rla);
		//   ---   ---   ---   //

	}


	//   ---   ---   ---   //
	protected void paintComponent(Graphics g){
		super.paintComponent(g);

		this.setBackground(Color.WHITE);

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

		// MEEEH
		g2d.setColor(Color.LIGHT_GRAY);
		for (int i = 0; i <= rowsBlocks; i++){
			g2d.drawLine(0, i*blocksHeight, colsBlocks*blocksWidth, i*blocksHeight);
		}
		for (int i = 0; i <= colsBlocks; i++){
			g2d.drawLine(i*blocksWidth, 0, i*blocksWidth, rowsBlocks*blocksHeight);
		}
		
		for (int i = 0; i < 4; i++){
			g2d.setColor(fallingPiece.getColor());
			g2d.fill(fallingPiece.getBlocks(i));
			g2d.setColor(Color.BLACK);
			g2d.draw(fallingPiece.getBlocks(i));
		}

		for (int i = 0; i < rowsBlocks; i++){
			for (int j = 0; j < colsBlocks; j++){
				if (bottomBlocks[i][j] != null){
					g2d.setColor(bottomBlocks[i][j].getColor());
					g2d.fill(bottomBlocks[i][j]);
					g2d.setColor(Color.BLACK);
					g2d.draw(bottomBlocks[i][j]);
				}
			}
		}
	}
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	void setListeningKeys()  { listeningKeys = true;  }
	void resetListeningKeys(){ listeningKeys = false; }

	boolean getListeningKeys(){ return listeningKeys; }
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	void  setFallingPiece(Piece fp){ fallingPiece = fp;   }
	Piece getFallingPiece()        { return fallingPiece; }
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	void sortPiece(){
		switch ((char) (Math.random() * (('G' - 'A') + 1)) + 'A'){
			case 'A': fallingPiece = new PieceA(); break;
			case 'B': fallingPiece = new PieceB(); break;
			case 'C': fallingPiece = new PieceC(); break;
			case 'D': fallingPiece = new PieceD(); break;
			case 'E': fallingPiece = new PieceE(); break;
			case 'F': fallingPiece = new PieceF(); break;
			case 'G': fallingPiece = new PieceG(); break;
		}
	}
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	boolean possibleMoveUp(){
		boolean possibleMove = true;
		for (int i = 0; i < 4; i++){
			int x = fallingPiece.getBlocks(i).getBlockX();
			int y = fallingPiece.getBlocks(i).getBlockY();
			if (y == 0 || bottomBlocks[y - 1][x] != null){
				possibleMove = false;
				break;
			}
		}
		return possibleMove;
	}

	boolean possibleMoveDown(){
		boolean possibleMove = true;
		for (int i = 0; i < 4; i++){
			int x = fallingPiece.getBlocks(i).getBlockX();
			int y = fallingPiece.getBlocks(i).getBlockY();
			if (y == (rowsBlocks - 1) || bottomBlocks[y + 1][x] != null){
				possibleMove = false;
				break;
			}
		}
		return possibleMove;
	}

	boolean possibleMoveRight(){
		boolean possibleMove = true;
		for (int i = 0; i < 4; i++){
			int x = fallingPiece.getBlocks(i).getBlockX();
			int y = fallingPiece.getBlocks(i).getBlockY();
			if (x == (colsBlocks - 1) || bottomBlocks[y][x + 1] != null){
				possibleMove = false;
				break;
			}
		}
		return possibleMove;
	}

	boolean possibleMoveLeft(){
		boolean possibleMove = true;
		for (int i = 0; i < 4; i++){
			int x = fallingPiece.getBlocks(i).getBlockX();
			int y = fallingPiece.getBlocks(i).getBlockY();
			if (x == 0 || bottomBlocks[y][x - 1] != null){
				possibleMove = false;
				break;
			}
		}
		return possibleMove;
	}
	//   ---   ---   ---   //

}