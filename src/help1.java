import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

public class help1 extends JPanel {
	JRootPane jframe=null;
	public help1(JRootPane jr) {
		setBackground(Color.CYAN);
		setSize(434, 223);
		setLayout(null);
		
		JLabel lblBooster = new JLabel("Booster µƒÀ„∑® «£∫");
		lblBooster.setForeground(Color.BLACK);
		lblBooster.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
		lblBooster.setBounds(10, 10, 137, 25);
		add(lblBooster);
		
		JLabel lblFori = new JLabel("for(i µƒ√ø∏ˆ∫¢◊”){");
		lblFori.setForeground(Color.BLACK);
		lblFori.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		lblFori.setBounds(48, 29, 119, 30);
		add(lblFori);
		
		JLabel lblIfdjdjtolerance = new JLabel("if(D(j)+d(j)>tolerance){");
		lblIfdjdjtolerance.setForeground(Color.BLACK);
		lblIfdjdjtolerance.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		lblIfdjdjtolerance.setBounds(79, 56, 155, 15);
		add(lblIfdjdjtolerance);
		
		JLabel lblj = new JLabel("‘⁄j¥¶…Ë÷√∑≈¥Û∆˜;");
		lblj.setForeground(Color.BLACK);
		lblj.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		lblj.setBounds(109, 77, 155, 15);
		add(lblj);
		
		JLabel lblDimaxdidj = new JLabel("D(i)=D(i);");
		lblDimaxdidj.setForeground(Color.BLACK);
		lblDimaxdidj.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		lblDimaxdidj.setBounds(109, 98, 189, 15);
		add(lblDimaxdidj);
		
		JLabel lblelse = new JLabel("}else{");
		lblelse.setForeground(Color.BLACK);
		lblelse.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		lblelse.setBounds(85, 112, 54, 15);
		add(lblelse);
		
		JLabel lblDimaxdidjdj = new JLabel("D(i)=max{D(i),D(j)+d(j)};");
		lblDimaxdidjdj.setForeground(Color.BLACK);
		lblDimaxdidjdj.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		lblDimaxdidjdj.setBounds(109, 137, 174, 15);
		add(lblDimaxdidjdj);
		
		JLabel label = new JLabel("}");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		label.setBounds(58, 172, 54, 15);
		add(label);
		
		JLabel label_1 = new JLabel("}");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 13));
		label_1.setBounds(85, 158, 54, 15);
		add(label_1);
	}
}