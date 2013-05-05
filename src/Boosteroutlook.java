import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.SWTResourceManager;
import javax.swing.ImageIcon;

//每一步的比较过程都需要进行描述
public class Boosteroutlook extends Shell {
	private JTextField text_tolerate;
	public static int tolerance,nodes;
	JButton[]bts=new JButton[9];
	showarea sh=null;
	boolean ran=false;
	int end=0,begin=0,current=0;
	private JTextField textField;
	public void setTo(int x){//设置接口
		tolerance = x;
	   }
	public int getTo(){
		return tolerance ;
		}
	public void setNo(int x){
		nodes = x;
	   }
	public int getNo(){
		return nodes ;
		}
	
	/**
	 * Launch the application.
	 * @param args
	 */
	
	public static void main(String args[])  throws InterruptedException{
		try {
			Display display = Display.getDefault();
			Boosteroutlook shell = new Boosteroutlook(display);
			shell.open();
			
			shell.layout();
			while (!shell.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the shell.
	 * @param display
	 */
	public Boosteroutlook(Display display) {
		super(display, SWT.CLOSE | SWT.MIN);//屏蔽放大缩小功能
		setMinimumSize(new Point(39, 39));
		setBackground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		
		Composite composite = new Composite(this, SWT.EMBEDDED);
		composite.setBounds(0, 0, 1184, 64);
		
		Frame frame = SWT_AWT.new_Frame(composite);
		
		Panel panel = new Panel();
		frame.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JRootPane rootPane = new JRootPane();
		rootPane.getContentPane().setBackground(Color.BLACK);
		panel.add(rootPane);
		rootPane.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("二叉树放置放大器");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 40));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 10, 1085, 44);
		rootPane.getContentPane().add(lblNewLabel);
		
		Composite composite_1 = new Composite(this, SWT.EMBEDDED);
		composite_1.setBounds(0, 65, 782, 64);
		
		Frame frame_1 = SWT_AWT.new_Frame(composite_1);
		
		Panel panel_1 = new Panel();
		frame_1.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JRootPane rootPane_1 = new JRootPane();
		rootPane_1.getContentPane().setBackground(new Color(255, 0, 0));
		panel_1.add(rootPane_1);
		rootPane_1.getContentPane().setLayout(null);
		
		JLabel lblWode = new JLabel("演   示  区");
		lblWode.setForeground(Color.WHITE);
		lblWode.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 30));
		lblWode.setBounds(274, 10, 159, 44);
		rootPane_1.getContentPane().add(lblWode);
		
		Composite composite_2 = new Composite(this, SWT.EMBEDDED);
		composite_2.setBounds(788, 65, 396, 64);
		
		Frame frame_2 = SWT_AWT.new_Frame(composite_2);
		
		Panel panel_2 = new Panel();
		frame_2.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JRootPane rootPane_2 = new JRootPane();
		rootPane_2.getContentPane().setBackground(new Color(255, 255, 0));
		panel_2.add(rootPane_2);
		rootPane_2.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("控 制 区");
		label.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 30));
		label.setForeground(Color.WHITE);
		label.setBackground(Color.WHITE);
		label.setBounds(155, 10, 146, 44);
		rootPane_2.getContentPane().add(label);
		
		
		Composite composite_3 = new Composite(this, SWT.EMBEDDED);
		composite_3.setBounds(0, 135, 782, 526);
		composite_3.setLayout(null);
		
		Frame frame_3 = SWT_AWT.new_Frame(composite_3);
		
		Panel panel_3 = new Panel();
		frame_3.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		final JRootPane rootPane_3 = new JRootPane();
		rootPane_3.getContentPane().setBackground(Color.CYAN);
		panel_3.add(rootPane_3);
		rootPane_3.getContentPane().setLayout(null);
		sh=new showarea(rootPane_3);
		rootPane_3.getContentPane().add(sh);
		
		Composite composite_4 = new Composite(this, SWT.EMBEDDED);
		composite_4.setBounds(788, 135, 396, 526);

		Frame frame_4 = SWT_AWT.new_Frame(composite_4);

		Panel inputArea = new Panel();
		frame_4.add(inputArea);
		inputArea.setLayout(new BorderLayout(0, 0));

		JRootPane inputroot = new JRootPane();
		inputroot.getContentPane().setBackground(Color.BLUE);
		inputArea.add(inputroot);
		inputroot.getContentPane().setLayout(null);

		JLabel label_4 = new JLabel("请输入容忍量为");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("微软雅黑", Font.BOLD, 20));
		label_4.setBounds(0, 32, 151, 40);
		inputroot.getContentPane().add(label_4);

		text_tolerate = new JTextField();//输入      容忍值
		text_tolerate.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent event) {
			}
			public void inputMethodTextChanged(InputMethodEvent event) {
				
			}
		});		
		text_tolerate.setForeground(Color.WHITE);
		text_tolerate.setFont(new Font("微软雅黑", Font.BOLD, 16));
		text_tolerate.setColumns(10);
		text_tolerate.setBackground(Color.PINK);
		text_tolerate.setBounds(141, 44, 66, 21);
		inputroot.getContentPane().add(text_tolerate);

		final JButton button_sure = new JButton("确定");
		button_sure.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*if(sh.area.getIndex()==1)
					JOptionPane.showMessageDialog(null,"请先行确定各子节点的消耗值，再行确定容忍值。注意：消耗值必须比容忍值小！！！");*/
				
				String s=text_tolerate.getText();//   获取容忍值
				int a=0;
				for(int j=1;j<=s.length();j++){
					int c=s.charAt(j-1)-'0';
					if(c<0||c>9){
						JOptionPane.showMessageDialog(null,"请输入一个整数");
					}
					a+=c;
					if(j!=s.length())
						a*=10;
					}
				if(a<=sh.area.max)
					JOptionPane.showMessageDialog(null, "容忍值必须大于所有消减值！此时需要大于"
				+Integer.toString(sh.area.max));
				tolerance=a;
				sh.area.setto(tolerance);
			}
		});
		
		button_sure.setForeground(Color.BLACK);
		button_sure.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_sure.setBackground(Color.YELLOW);
		button_sure.setBounds(217, 42, 93, 23);
		
		inputroot.getContentPane().add(button_sure);

		final JButton button_be = new JButton("上一步");
		button_be.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				current-=1;
				if(current>=begin)
					pp(sh.area,current);
				else{
					JOptionPane.showMessageDialog(null,"没有再上一步");
					current+=1;
				}

			}
		});
		button_be.setEnabled(false);
		button_be.setForeground(Color.BLACK);
		button_be.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_be.setBackground(Color.YELLOW);
		button_be.setBounds(12, 135, 117, 23);
		inputroot.getContentPane().add(button_be);

		final JButton button_ne = new JButton("下一步");
		button_ne.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				current+=1;
				if(current<=end)
					pp(sh.area,current);
				else{
					current-=1;
					JOptionPane.showMessageDialog(null,"已经到最后一步");
				}
			}
		});
		button_ne.setForeground(Color.BLACK);
		button_ne.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_ne.setBackground(Color.YELLOW);
		button_ne.setBounds(141, 135, 107, 23);
		button_ne.setEnabled(false);
		inputroot.getContentPane().add(button_ne);

		final JButton button_self = new JButton("自动显示");
		button_self.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				current=begin;
				for(int i=1;i<=end-begin;){
					pp(sh.area,current+i);
					i++;
				}
				current=end;
			}
		});
		button_self.setEnabled(false);
		button_self.setForeground(Color.BLACK);
		button_self.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_self.setBackground(Color.YELLOW);
		button_self.setBounds(12, 170, 107, 23);
		inputroot.getContentPane().add(button_self);

		JButton button_help = new JButton("帮助");
		button_help.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				 Display.getDefault().syncExec(new Runnable() {
					    public void run() {
					    	help window=new help();
							window.open();
					    }
					    }); 				
			}
		});
		
		final JButton button_2 = new JButton("重新显示");
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				current=begin;
				 pp(sh.area,current);
			}
		});
		button_2.setForeground(Color.BLACK);
		button_2.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_2.setEnabled(false);
		button_2.setBackground(Color.YELLOW);
		button_2.setBounds(141, 170, 107, 23);
		inputroot.getContentPane().add(button_2);
		
		JButton button_random = new JButton("随机取数");
		button_random.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*ran=true;
				sh.settRd(true);
				sh.area=new Area(sh,true);*/
				Booster b=new Booster(sh,sh.area,true);
				button_ne.setEnabled(true);
				button_be.setEnabled(true);
				button_self.setEnabled(true);
				button_2.setEnabled(true);
				begin=b.getbegin();
				end=b.geten();
				current=begin;
				pp(sh.area,begin);
			}
		});
		button_random.setForeground(Color.BLACK);
		button_random.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_random.setBackground(Color.YELLOW);
		button_random.setBounds(260, 100, 107, 23);
		inputroot.getContentPane().add(button_random);
		
		
		button_help.setForeground(Color.BLACK);
		button_help.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_help.setBackground(Color.YELLOW);
		button_help.setBounds(260, 135, 107, 23);
		inputroot.getContentPane().add(button_help);

		JButton button_5 = new JButton("重新输入");
		button_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				button_ne.setEnabled(false);
				button_be.setEnabled(false);
				button_self.setEnabled(false);
				button_2.setEnabled(false);
				/*sh.area=new Area(sh,false);*/
				sh.area.index=1;sh.area.max=0;
				sh.area.draws=new Drawing[500];
				sh.area.nodes=new BinaryTree [100];
				sh.area.draws[1]=new fillCircler();
				sh.area.draws[sh.area.index].x1=390;
				sh.area.draws[sh.area.index].y1=25;
				
				sh.area.nodes[1]=new BinaryTree();
				sh.area.nodes[1].in=1;
				sh.area.nodes[1].d=0;sh.area.nodes[1].D=0;
				sh.area.nodes[1].x=sh.area.draws[sh.area.index].x1;
				sh.area.nodes[1].y=sh.area.draws[sh.area.index].y1;
				sh.area.draws[1].i=1;sh.area.draws[sh.area.index].s1="0";
				sh.area.nodes[1].addall=false;sh.area.nodes[1].ifadd=false;
				tolerance=0;text_tolerate.setText(null);
				sh.area.tolerance=Integer.MAX_VALUE;
				pp(sh.area,sh.area.index);
				begin=0;end=0;
				
			}
		});
		button_5.setForeground(Color.BLACK);
		button_5.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button_5.setBackground(Color.YELLOW);
		button_5.setBounds(141, 100, 107, 23);
		inputroot.getContentPane().add(button_5);
		
		JButton button = new JButton("输入完成");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tolerance==0&&!ran){
					JOptionPane.showMessageDialog(null, "请输入容忍值，注意：容忍值必须大于所有消耗值！！！");
				}
				else{
					button_ne.setEnabled(true);
					button_be.setEnabled(true);
					button_self.setEnabled(true);
					button_2.setEnabled(true);
					if(end!=0&&begin!=0){
						sh.area.index=begin;
					}
					Booster b=new Booster(sh,sh.area,false);
					begin=b.getbegin();
					end=b.geten();
					current=begin;
				}
			}
		});
		
		button.setForeground(Color.BLACK);
		button.setFont(new Font("微软雅黑", Font.BOLD, 17));
		button.setBackground(Color.YELLOW);
		button.setBounds(12, 100, 114, 23);
		inputroot.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Boosteroutlook.class.getResource("/icon/f.png")));
		btnNewButton.setBounds(23, 213, 30, 32);
		inputroot.getContentPane().add(btnNewButton);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Boosteroutlook.class.getResource("/icon/second.png")));
		button_1.setBounds(23, 265, 30, 32);
		inputroot.getContentPane().add(button_1);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Boosteroutlook.class.getResource("/icon/third.png")));
		button_3.setBounds(23, 319, 30, 32);
		inputroot.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(Boosteroutlook.class.getResource("/icon/last.png")));
		button_4.setBounds(23, 371, 30, 32);
		inputroot.getContentPane().add(button_4);
		
		JLabel label_1 = new JLabel("初始状况下的节点");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label_1.setBounds(72, 213, 151, 40);
		inputroot.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("第一次遍历到的节点");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label_2.setBounds(72, 265, 151, 40);
		inputroot.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("第二次遍历到的节点");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label_3.setBounds(72, 319, 151, 40);
		inputroot.getContentPane().add(label_3);
		
		JLabel label_5 = new JLabel("放置了放大器的节点");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("微软雅黑", Font.BOLD, 16));
		label_5.setBounds(72, 371, 151, 40);
		inputroot.getContentPane().add(label_5);

		createContents();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void createContents() {
		setText("欢迎大家来到我的课程设计 ");
		setSize(1200, 700);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
	public void poo(BinaryTree b){
		if(b!=null){
			b.D=0;
			b.d=0;b.addall=false;
			b.ifadd=false;
			b.in=0;
			b.L=null;
			b.R=null;b.P=null;
		}
	}
	public void pp(Area a,int in){
		a.index=in;
		a.repaint();//
		a.update(a.getGraphics());//必须包含update才能保证程序画出图形，若不写此语句，程序会发出请求但是这个操作一般不会即时进行，不能保证每步都画出来
		try { // 睡眠0.5秒
			Thread.sleep(500);
			} catch (Exception e) {
				e.printStackTrace();
				}
		}
	}