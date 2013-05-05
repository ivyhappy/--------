import java.awt.Canvas;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.lang.Integer;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Area extends Canvas{
	Point point =null;
	JPanel controller;
	int index = 1,end=0,max=0;
	BinaryTree nodes[]=new BinaryTree [100];
	Drawing draws[]=new Drawing[5000];
	String s;
	int tolerance=Integer.MAX_VALUE;
	
	private Image iBuffer;
	private Graphics gBuffer;
	
	public int getto(){
		return this.tolerance;
	}
	public void setto(int in){
		this.tolerance=in;
	}
	public void setIndex(int x){//设置index的接口
    	index = x;
    }
    public int getIndex(){//设置index的接口
    	return index ;
    }
    public void setmax(int x){
    	max = x;
    }
    public int getmax(){
    	return max ;
    }
    public void setnodes(BinaryTree[] s){
    	this.nodes=s;
    }
    public BinaryTree[]  getno(){
    	return nodes ;
    }
    public void setd(Drawing[] s){
    	this.draws=s;
    }
    public Drawing[] getdraws(){
    	return draws ;
    }
	
    public Area (JPanel controller,boolean random){
		super();
		this.controller=controller;
		draws[1]=new fillCircler();
		draws[index].x1=390;
		draws[index].y1=25;
		nodes[1]=new BinaryTree();nodes[1].in=1;
		nodes[1].d=0;nodes[1].D=0;
		nodes[1].x=draws[index].x1;
		nodes[1].y=draws[index].y1;
		draws[index].i=1;draws[index].s1="0";
		nodes[1].addall=false;nodes[1].ifadd=false;
	}
	
	public boolean mouseDown(Event event ,int x, int y){
		if(point==null){
			point =new Point(x,y);
		}else{
			point.x=x;
			point.y=y;
		}
		repaint();
		int i;
		for(i=1;i<=index;){
			if(nodes[i]!=null){
				if(point.x>=nodes[i].x-30&&point.x<=nodes[i].x+30&&point.y>=nodes[i].y-30&&point.y<=nodes[i].y+30){
					if(nodes[i].addall)
						break;
					
					s=JOptionPane.showInputDialog(null,"请输入子节点的消耗量" +"","输入",JOptionPane.PLAIN_MESSAGE);
					if(s==null)	break;
					int a=0;
					a=jurge(s);//System.out.println(a);

					if(tolerance!=Integer.MAX_VALUE){
					while(a>=tolerance){
						JOptionPane.showMessageDialog(null,"请输入一个比容忍值小的整数");
						s=JOptionPane.showInputDialog(null,"请输入子节点的消耗量" +"","输入",JOptionPane.PLAIN_MESSAGE);
						if(s==null)	break;
						a=jurge(s);
						//System.out.println(a);
					}
					}
					if(s!=null){
						if(nodes[i].ifadd){
							index++;
							int r=index;
							nodes[r]=new BinaryTree();
							nodes[i].R=nodes[r];
							nodes[i].addall=true;
							nodes[r].P=nodes[i];
							nodes[r].D=0;
							nodes[r].in=nodes[i].in+1;
							nodes[r].addall=false;nodes[r].ifadd=false;
							nodes[r].num=index-2;
							if(i==1){
								nodes[r].x=nodes[i].x+170;
								nodes[r].y=nodes[i].y+180;
							}
							else{
								nodes[r].x=nodes[i].L.x+180-50*(nodes[r].in-3);
								nodes[r].y=nodes[i].y+100;
							}
							
							if(max<=a)max=a;
							nodes[r].d=a;
							point.x=nodes[r].x;
							point.y=nodes[r].y;
							draws[index]=new fillCircle();
							draws[index].x1=point.x;
							draws[index].y1=point.y;
							draws[index].x2=nodes[i].x;
							draws[index].y2=nodes[i].y;
							draws[index].s1=Integer.toString(a);
							
							char s2;
							s2=(char) (index+'A'-2);
							draws[index].s2=String.valueOf(s2);//=index+'A'-1;);

							repaint();
							}
						else{
							index++;
							int l=index;
							nodes[l]=new BinaryTree();
							nodes[i].L=nodes[l];
							nodes[i].addall=false;
							nodes[i].ifadd=true;
							nodes[l].D=0;
							nodes[l].num=index-2;
							nodes[l].P=nodes[i];
							nodes[l].in=nodes[i].in+1;
							nodes[l].addall=false;nodes[l].ifadd=false;
							if(i==1){
								nodes[l].x=nodes[i].x-200;
								nodes[l].y=nodes[i].y+180;
							}
							else{
								nodes[l].x=nodes[i].x-100+nodes[l].in*10;
								nodes[l].y=nodes[i].y+100;
							}
							
							if(max<=a)max=a;
							nodes[l].d=a;
							point.x=nodes[l].x;
							point.y=nodes[l].y;
							draws[index]=new fillCircle();
							draws[index].x1=point.x;
							draws[index].y1=point.y;
							draws[index].x2=nodes[i].x;
							draws[index].y2=nodes[i].y;
							draws[index].s1=Integer.toString(a);
							char s2;
							s2=(char) (index+'A'-2);
							draws[index].s2=String.valueOf(s2);
							repaint();
							}
						}
					break;
					}
				}
			i++;
			}
	
		return false;
	}
	void draw(Graphics g , Drawing i)
	{
		i.draw(g);
	}
	public void paint(Graphics g){
			int j=1;
			while(j<=index)
			{
				draw(g,draws[j]);
				j++;
		    }
			
	}
	public void update(Graphics g){
		if(iBuffer==null){
			iBuffer=createImage(this.getSize().width,this.getSize().height);
			gBuffer=iBuffer.getGraphics();
		}
		gBuffer.setColor(getBackground());
		gBuffer.fillRect(0,0,(int )this.getSize().getWidth(),(int)this.getSize().getHeight());
		paint(gBuffer);
		g.drawImage(iBuffer,0, 0,this);
	}
	public int jurge(String s){
		boolean a=false;int s1=0;
		while(!a){
			try { 
				s1= Integer.parseInt(s);
				a=true;
				} catch (Exception e) {
					a=false;
					JOptionPane.showMessageDialog(null,"请输入一个整数");
					s=JOptionPane.showInputDialog(null,"请输入子节点的消耗量" +"","输入",JOptionPane.PLAIN_MESSAGE);
					}
		}
		return s1;
	}
}

