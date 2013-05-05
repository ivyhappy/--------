
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;

import javax.swing.JRootPane;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.BorderLayout;

public class help {

	protected Shell shell;
	Display display = Display.getDefault();
	/**
	 * Launch the application.
	 * @param args
	 */
	/**
	 * Open the window.
	 */
	public void open() {
		createContents();
		shell.open();
		shell.layout();
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.CLOSE );
		shell.setSize(441, 289);
		shell.setText("帮助");
		
		Composite composite = new Composite(shell, SWT.EMBEDDED);
		composite.setBounds(0, 0, 434, 37);
		
		Frame frame = SWT_AWT.new_Frame(composite);
		
		Panel panel = new Panel();
		frame.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JRootPane rootPane = new JRootPane();
		panel.add(rootPane);
		
		
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(Color.WHITE);
		rootPane.getContentPane().add(toolBar, BorderLayout.CENTER);
		
		JButton alg = new JButton("关于算法");
		
		
		alg.setForeground(Color.WHITE);
		alg.setFont(new Font("微软雅黑", Font.BOLD, 15));
		alg.setBackground(Color.PINK);
		alg.setHorizontalAlignment(SwingConstants.LEFT);
		toolBar.add(alg);
		
		JButton use = new JButton("关于使用");
		
		
		use.setForeground(Color.WHITE);
		use.setFont(new Font("微软雅黑", Font.BOLD, 15));
		use.setBackground(Color.PINK);
		use.setHorizontalAlignment(SwingConstants.RIGHT);
		toolBar.add(use);
		
		Composite composite_1 = new Composite(shell, SWT.EMBEDDED);
		composite_1.setBounds(0, 35, 434, 226);
		
		Frame frame_1 = SWT_AWT.new_Frame(composite_1);
		
		Panel panel_1 = new Panel();
		frame_1.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		final JRootPane rootPane_1 = new JRootPane();
		rootPane_1.getContentPane().setBackground(Color.CYAN);
		panel_1.add(rootPane_1);
		
		alg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//System.out.println("daozherle 1");
				rootPane_1.repaint();
				rootPane_1.getContentPane().removeAll();
				help1 help=new help1(rootPane_1);
				rootPane_1.getContentPane().add(help);
			}
		});
		use.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rootPane_1.repaint();
				rootPane_1.getContentPane().removeAll();
				help2_use help2=new help2_use(rootPane_1);
				rootPane_1.getContentPane().add(help2);
			}
		});
	}

}

