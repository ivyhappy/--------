
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
		
		JLabel lblBooster = new JLabel("ʹ����֪");
		lblBooster.setForeground(Color.BLACK);
		lblBooster.setFont(new Font("΢���ź�", Font.BOLD, 15));
		lblBooster.setBounds(21, 20, 338, 25);
		add(lblBooster);
	
		JLabel lbl1 = new JLabel("һ���ڵ��ڵ�ֵΪD(�Դ˽ڵ�Ϊ��������������Ҷ�ӵ�˥���������");
		lbl1 .setForeground(Color.BLACK);
		lbl1 .setFont(new Font("΢���ź�", Font.BOLD, 13));
		lbl1 .setBounds(21, 50, 409, 15);
		add(lbl1 );
		
		JLabel lbl1_2 = new JLabel("ֵ),�����ϵ�ֵΪd(���ӽڵ��˥����)");
		lbl1_2.setForeground(Color.BLACK);
		lbl1_2.setFont(new Font("΢���ź�", Font.BOLD, 13));
		lbl1_2.setBounds(48, 80, 409, 15);
		add(lbl1_2);
		
		JLabel lbl2 = new JLabel("�����Զ���ʾ�������޷���ͣ");
		lbl2.setForeground(Color.BLACK);
		lbl2.setFont(new Font("΢���ź�", Font.BOLD, 13));
		lbl2.setBounds(21, 110, 409, 15);
		add(lbl2);
		
		JLabel lbl3 = new JLabel("������������Ҫ��������˥����������������������Ҫ���ȷ������");
		lbl3.setForeground(Color.BLACK);
		lbl3.setFont(new Font("΢���ź�", Font.BOLD, 13));
		lbl3.setBounds(21, 140, 409, 15);
		add(lbl3);
		
		JLabel lbl4 = new JLabel("����ֵ������ɺ������������");
		lbl4.setForeground(Color.BLACK);
		lbl4.setFont(new Font("΢���ź�", Font.BOLD, 13));
		lbl4.setBounds(48, 170, 409, 15);
		add(lbl4);
		
		/*JLabel lbl4_2 = new JLabel("");
		lbl4_2.setForeground(Color.BLACK);
		lbl4_2.setFont(new Font("΢���ź�", Font.BOLD, 13));
		lbl4_2.setBounds(48, 200, 409, 15);
		add(lbl4_2);*/
	}
}