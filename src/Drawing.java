import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
class Drawing {
int x1,y1,x2,y2,i;   	    //x1,y1,x2,y2��������,iѡ����ɫi
String s1,s2;				//����������

void draw(Graphics g1 ){}//���廭ͼ����

}
class fillCircler extends Drawing{//��
	void draw(Graphics g ){
		if(i==1)
			g.setColor(Color.pink);
		else if(i==2)
			g.setColor(Color.blue);
		else if(i==3)
			g.setColor(Color.yellow);
		g.fillOval(x1-25,y1-25,50,50);
		g.setColor(Color.black);
		g.setFont(new Font("΢���ź�", Font.BOLD, 15));//��������
		g.drawString(s1, x1, y1);
	}
}
class fillCircle extends Drawing{//��ʼ�����ӽڵ�
	void draw(Graphics g){
		g.setColor(Color.pink);
		g.drawLine(x1, y1, x2, y2);//�ӽڵ�͸��ڵ�֮�������
		g.fillOval(x1-15,y1-15,30,30);//����Բ������ʹ�С
		g.setColor(Color.black);//����������ɫ
		g.setFont(new Font("΢���ź�", Font.BOLD, 15));//��������
		g.drawString(s2, x1-25, y1+5);//�����������
	    if(s1 != null)
	    	g.drawString( s1, (x1+x2)/2,(y1+y2)/2);
	    g.setColor(Color.black);
		g.setFont(new Font("΢���ź�", Font.BOLD, 15));
		g.drawString("0", x1-5, y1+5);
	}
}

class fillCircley extends Drawing{//���η����ӽڵ�
	void draw(Graphics g){
		g.setColor(Color.yellow);
		g.fillOval(x1-15,y1-15,30,30);
		g.setColor(Color.black);
		g.setFont(new Font("΢���ź�", Font.BOLD, 15));//��������
		g.drawString(s1, x1-5, y1+5);
		
	}
}
class fillCircleb extends Drawing{//һ�η����ӽڵ�
	void draw(Graphics g ){
		g.setColor(Color.blue);
		g.fillOval(x1-15,y1-15,30,30);
		g.setColor(Color.black);
		g.setFont(new Font("΢���ź�", Font.BOLD, 15));//��������
		g.drawString(s1, x1-5, y1+5);
		
	}
}
class fillCirclew extends Drawing{//���÷Ŵ�����
	void draw(Graphics g){
		g.setColor(Color.red);
		g.fillOval(x1-15,y1-15,30,30);
		g.setColor(Color.black);
		g.setFont(new Font("΢���ź�", Font.BOLD, 15));//��������
		g.drawString(s1, x1-5, y1+5);
	}
}
class fillL extends Drawing{//��Ҫ��˵�����
		void draw(Graphics g){
			g.setColor(Color.black);
			g.setFont(new Font("΢���ź�", Font.BOLD, 15));//��������
			g.drawString(s1, x1,y1);
			
		}	

	}
