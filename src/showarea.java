import java.awt.Point;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRootPane;

public class showarea extends JPanel {
	JRootPane jframe=null;
	Point point =null;
	Area area;
	boolean random=false;
	public boolean getRd(){
		return this.random;
	}
	public void settRd(boolean in){
		this.random=in;
	}
	public void setarea(Area a){
		this.area=a;
	}
	public Area getarea(){
		return this.area;
	}
    public showarea(JRootPane jr) {
		super();
		setBackground(Color.CYAN);
		setSize(782, 526);
		setLayout(null);
		area = new Area (this,random);
		area.setBounds(0, 0, 782, 526);
		add(area);
		validate();	
	}
}