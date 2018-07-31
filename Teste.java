/**
Guilherme Nascimento Gouvêa dos Reis 2018.1
**/

import java.awt.Frame;
import java.awt.CardLayout;
import java.awt.Panel;
import java.awt.Button;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import javax.swing.GroupLayout;

// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //
// -----     -----     -----     -----     -----     -----     -----     -----     -----     ----- //



public class Teste extends Frame{

	//   ---   ---   ---   //
	private CardLayout cardLayout1 = new CardLayout();
	private Panel      cardPanel1  = new Panel(cardLayout1);

	private CardLayout cardLayout2 = new CardLayout();
	private Panel      cardPanel2  = new Panel(cardLayout2);
	//   ---   ---   ---   //

	

	//   ---   ---   ---   //
	private Button button_a;
	private Button button_b;
	private Button button_c;
	private Button button_d;
	//   ---   ---   ---   //

	//   ---   ---   ---   //
	class WindowListener extends WindowAdapter{
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	}
	//   ---   ---   ---   //


	//   ---   ---   ---   //
	class ButtonAListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardLayout1.show(cardPanel1, "PanelA");
		}
	}

	class ButtonBListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardLayout1.show(cardPanel1, "PanelB");
		}
	}

	class ButtonCListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardLayout2.show(cardPanel2, "PanelC");
		}
	}

	class ButtonDListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			cardLayout2.show(cardPanel2, "PanelD");
		}
	}
	//   ---   ---   ---   //



	Teste(){

		//   ---   ---   ---   //
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);

		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		button_a = new Button("Botao A");
		button_b = new Button("Botao B");
		button_c = new Button("Botao C");
		button_d = new Button("Botao D");
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		Panel panel_a = new Panel();
		panel_a.setBackground(Color.green);
		panel_a.add(button_b);
		Panel panel_b = new Panel();
		panel_b.setBackground(Color.red);
		panel_b.add(button_a);

		cardPanel1.setLayout(cardLayout1);
		cardPanel1.add(panel_a, "PanelA");
		cardPanel1.add(panel_b, "PanelB");


		Panel panel_c = new Panel();
		panel_c.setBackground(Color.yellow);
		panel_c.add(button_d);
		Panel panel_d = new Panel();
		panel_d.setBackground(Color.blue);
		panel_d.add(button_c);

		cardPanel2.setLayout(cardLayout2);
		cardPanel2.add(panel_c, "PanelC");
		cardPanel2.add(panel_d, "PanelD");
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addComponent(cardPanel1)
				.addComponent(cardPanel2)
		);

		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addComponent(cardPanel1)
				.addComponent(cardPanel2)
		);
		//   ---   ---   ---   //


		//   ---   ---   ---   //
		WindowListener wl = new WindowListener();
		this.addWindowListener(wl);
		//   ---   ---   ---   //

		//   ---   ---   ---   //
		ButtonAListener bal = new ButtonAListener();
		button_a.addActionListener(bal);

		ButtonBListener bbl = new ButtonBListener();
		button_b.addActionListener(bbl);

		ButtonCListener bcl = new ButtonCListener();
		button_c.addActionListener(bcl);

		ButtonDListener bdl = new ButtonDListener();
		button_d.addActionListener(bdl);
		//   ---   ---   ---   //

		this.pack();
		this.setResizable(false);
		this.setVisible(true);

	}



	public static void main(String[] args){
		new Teste();
	}

}