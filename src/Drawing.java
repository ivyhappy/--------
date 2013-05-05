import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
class Drawing {
int x1,y1,x2,y2,i;   	    //x1,y1,x2,y2定义坐标,i选择颜色i
String s1,s2;				//定义输出语句

void draw(Graphics g1 ){}//定义画图函数

}
class fillCircler extends Drawing{//根
	void draw(Graphics g ){
		if(i==1)
			g.setColor(Color.pink);
		else if(i==2)
			g.setColor(Color.blue);
		else if(i==3)
			g.setColor(Color.yellow);
		g.fillOval(x1-25,y1-25,50,50);
		g.setColor(Color.black);
		g.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置字体
		g.drawString(s1, x1, y1);
	}
}
class fillCircle extends Drawing{//初始化的子节点
	void draw(Graphics g){
		g.setColor(Color.pink);
		g.drawLine(x1, y1, x2, y2);//子节点和父节点之间的连线
		g.fillOval(x1-15,y1-15,30,30);//定义圆的坐标和大小
		g.setColor(Color.black);//定义字体颜色
		g.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置字体
		g.drawString(s2, x1-25, y1+5);//定义语句坐标
	    if(s1 != null)
	    	g.drawString( s1, (x1+x2)/2,(y1+y2)/2);
	    g.setColor(Color.black);
		g.setFont(new Font("微软雅黑", Font.BOLD, 15));
		g.drawString("0", x1-5, y1+5);
	}
}

class fillCircley extends Drawing{//二次访问子节点
	void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(x1-15,y1-15,30,30);
		g.setColor(Color.black);
		g.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置字体
		g.drawString(s1, x1-5, y1+5);
		
	}
}
class fillCircleb extends Drawing{//一次访问子节点
	void draw(Graphics g ){
		g.setColor(Color.blue);
		g.fillOval(x1-15,y1-15,30,30);
		g.setColor(Color.black);
		g.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置字体
		g.drawString(s1, x1-5, y1+5);
		
	}
}
class fillCirclew extends Drawing{//放置放大器点
	void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(x1-15,y1-15,30,30);
		g.setColor(Color.black);
		g.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置字体
		g.drawString(s1, x1-5, y1+5);
	}
}
class fillL extends Drawing{//必要的说明语句
		void draw(Graphics g){
			g.setColor(Color.black);
			g.setFont(new Font("微软雅黑", Font.BOLD, 15));//设置字体
			g.drawString(s1, x1,y1);
			
		}	

	}
