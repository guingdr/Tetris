/**
Guilherme Nascimento Gouvêa dos Reis 2018.1
**/

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.Color;

import javax.swing.GroupLayout;

import java.awt.GraphicsConfiguration;
import java.awt.Toolkit;
import java.awt.Dimension;

// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //
// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //



class MainFrame extends JFrame{

	//   ---   ---   ---   //
	private JPanel leftMargin;
	private JPanel rightMargin;

	private GamePanel gPanel;
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	class WindowListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	//   ---   ---   ---   //


	MainFrame(){

		//   ---   ---   ---   //
		leftMargin  = new JPanel();
		rightMargin = new JPanel();
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		gPanel = new GamePanel();

		JPanel cardPanel  = new JPanel();
		CardLayout cardLayout = new CardLayout();

		cardPanel.setLayout(cardLayout);
		cardPanel.add(gPanel, "Game");
		//   ---   ---   ---   //	


		//   ---   ---   ---   //
		GroupLayout gLayout = new GroupLayout(this.getContentPane());
		this.getContentPane().setLayout(gLayout);

		gLayout.setAutoCreateGaps(true);
		gLayout.setAutoCreateContainerGaps(true);

		GroupLayout.SequentialGroup hGroup = gLayout.createSequentialGroup();
		hGroup.addComponent(leftMargin);
		hGroup.addComponent(cardPanel, 331, 331, 331);
		hGroup.addComponent(rightMargin);
		gLayout.setHorizontalGroup(hGroup);

		GroupLayout.ParallelGroup vGroup = gLayout.createParallelGroup();
		vGroup.addComponent(leftMargin);
		vGroup.addComponent(cardPanel, 661, 661, 661);
		vGroup.addComponent(rightMargin);
		gLayout.setVerticalGroup(vGroup);
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		WindowListener wl = new WindowListener();
		this.addWindowListener(wl);
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		final GraphicsConfiguration config = this.getGraphicsConfiguration();

        final int left   = Toolkit.getDefaultToolkit().getScreenInsets(config).left;
        final int right  = Toolkit.getDefaultToolkit().getScreenInsets(config).right;
        final int top    = Toolkit.getDefaultToolkit().getScreenInsets(config).top;
        final int bottom = Toolkit.getDefaultToolkit().getScreenInsets(config).bottom;

        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int width  = screenSize.width  - left - right;
        final int height = screenSize.height - top  - bottom;

        this.setResizable(false);
        this.setSize(width, height);
		this.setLocationRelativeTo(null);
        this.setVisible(true);

		// MEEEH
		gPanel.requestFocusInWindow();
		//   ---   ---   ---   //

	}

}