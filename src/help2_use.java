
import javax.swing.JPanel;
import javax.swing.JRootPane;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class help2_use extends JPanel {
	JRootPane jframe=null;
	public help2_use(JRootPane jr) {
		setBackground(Color.CYAN);
		setSize(434, 223);
		setLayout(null);
		
		JLabel lblBooster = new JLabel("使用须知");
		lblBooster.setForeground(Color.BLACK);
		lblBooster.setFont(new Font("微软雅黑", Font.BOLD, 15));
		lblBooster.setBounds(21, 20, 338, 25);
		add(lblBooster);
	
		JLabel lbl1 = new JLabel("一、节点内的值为D(以此节点为根的子树的任意叶子的衰减量的最大");
		lbl1 .setForeground(Color.BLACK);
		lbl1 .setFont(new Font("微软雅黑", Font.BOLD, 13));
		lbl1 .setBounds(21, 50, 409, 15);
		add(lbl1 );
		
		JLabel lbl1_2 = new JLabel("值),连线上的值为d(到子节点的衰减量)");
		lbl1_2.setForeground(Color.BLACK);
		lbl1_2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lbl1_2.setBounds(48, 80, 409, 15);
		add(lbl1_2);
		
		JLabel lbl2 = new JLabel("二、自动演示过程中无法暂停");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lbl2.setBounds(21, 110, 409, 15);
		add(lbl2);
		
		JLabel lbl3 = new JLabel("三、容忍量需要大于所有衰减量，且输入容忍量后需要点击确定，所");
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lbl3.setBounds(21, 140, 409, 15);
		add(lbl3);
		
		JLabel lbl4 = new JLabel("有数值输入完成后需点击输入完成");
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lbl4.setBounds(48, 170, 409, 15);
		add(lbl4);
		
		/*JLabel lbl4_2 = new JLabel("");
		lbl4_2.setForeground(Color.BLACK);
		lbl4_2.setFont(new Font("微软雅黑", Font.BOLD, 13));
		lbl4_2.setBounds(48, 200, 409, 15);
		add(lbl4_2);*/
	}
}