import java.math.*;
import java.util.Random;
public class Booster {
	private showarea sha;
	Area area = null;
	Drawing draw[]=new Drawing[5000];
	int begin=0,end=0,max=0;
	int tolerance=0;
	boolean ra=false;
	int l=1;
	public void setbegin(int in){
		this.begin=in;
	}
	public int getbegin(){
		return this.begin;
	}
	public int geten(){
		return this.end;
	}
	public void seten(int en){
		this.end=en;
	}
	
	Booster(showarea dp,Area da,boolean ran) {
		sha= dp;
		area = da;
		ra=ran;
		run();
		}
	public void run(){
		BinaryTree Root=area.nodes[1];
		tolerance=area.tolerance;
		setbegin(area.index);
		poo(area.nodes[1]);
		if(ra){
			area.index=1;
			area.nodes[1].d=0;area.nodes[1].D=0;
			Ran();
			setbegin(area.index);
			area.tolerance=tolerance;
			area.index+=1;
			area.draws[area.index]=new fillL();
			area.draws[area.index].s1="��ʱ����ֵΪ��"+Integer.toString(tolerance)
					+"���÷Ŵ����ĵ��У�";
			area.draws[area.index].x1=5;area.draws[area.index].y1=20;
		}
		else{
			area.index++;
			area.draws[area.index]=new fillL();
			area.draws[area.index].s1="��ʱ����ֵΪ��"+Integer.toString(area.tolerance)
					+"���÷Ŵ����ĵ��У�";
			area.draws[area.index].x1=5;area.draws[area.index].y1=20;
		}
		postOrder(Root);
		seten(area.index);
	}
	public void Ran(){
		Random ran=new Random();
		int n=ran.nextInt(26)+5;
		poOrd(area.nodes[1],n,0);
		if(area.nodes[1].L!=null)po(area.nodes[1].L);
		if(area.nodes[1].R!=null)po(area.nodes[1].R);
		tolerance=ran.nextInt(50)+max;
		area.max=max;
	}
	public void po(BinaryTree b){
		if(b!=null){
			int x=b.x;
			int y=b.y;
			area.index+=1;
			area.draws[area.index]=new fillCircle();
			area.draws[area.index].x1=x;
			area.draws[area.index].y1=y;
			area.draws[area.index].x2=b.P.x;
			area.draws[area.index].y2=b.P.y;
			area.draws[area.index].s1=Integer.toString(b.d);
			char s2;
			b.num=area.index-2;
			s2=(char) (b.num+'A');
			area.draws[area.index].s2=String.valueOf(s2);
			if(b.L!=null) po(b.L);
			if(b.R!=null) po(b.R);
		}
	}
	public void poOrd(BinaryTree b,int n,int current) {
		if(b!=null){
			if(current==n||b.in==5)//���нڵ㶼�Ѿ�������ɻ����Ѿ������ˣ����ٴ�������
				return;
			Random ra=new Random();
			int r=ra.nextInt(2);
			if(r==0){//����������
				current+=1;
				r=ra.nextInt(100);
				if(max<r) max=r;
				b.L=new BinaryTree();
				b.L.P=b;
				b.L.D=0;
				b.L.d=r;
				b.L.in=b.in+1;
				if(b.in==1){
					b.L.x=b.x-200;
					b.L.y=b.y+180;
				}
				else{
					b.L.x=b.x-100+b.L.in*10;
					b.L.y=b.y+100;
				}
				poOrd(b.L,n,current);
			}
			if(current==n)
				return;
			r=ra.nextInt(2);
			
			if(r==0||b.L==null){//����������
				current+=1;
				r=ra.nextInt(100);
				if(max<r) max=r;
				b.R=new BinaryTree();
				b.R.P=b;
				b.R.D=0;
				b.R.d=r;
				b.R.in=b.in+1;
				
				if(b.in==1){
					b.R.x=b.x+170;
					b.R.y=b.y+180;
				}
				else{
					if(b.L!=null)
						b.R.x=b.L.x+180-50*(b.R.in-3);
					else{
						b.R.x=b.x+60;
						
					}
					b.R.y=b.y+100;
				}
				poOrd(b.R,n,current);
			}
		}
	}
	public void poo(BinaryTree b){
		if(b!=null){
			b.D=0;
			if(b.L!=null) poo(b.L);
			if(b.R!=null) poo(b.R);
		}
	}
	public void postOrder(BinaryTree b){//�����������������ӻ�ͼ����
		if(b!=null){//��һ�η��ʴ˽ڵ�
			area.index+=1;//��ӻ�ͼ����ı��
			if(b.in==1){//��Ϊ���ڵ�
				area.draws[area.index]=new fillCircler();//�����ʱ��ͼ�ķ���
				area.draws[area.index].i=2;//i=2������ʱѡ����ɫ
				area.draws[area.index].s1=Integer.toString(b.D);	
				}
			else	
				area.draws[area.index]=new fillCircleb();//�����Ǹ��ڵ㶨��ķ���
			
			area.draws[area.index].x1=b.x;
			area.draws[area.index].y1=b.y;//��������
			area.draws[area.index].s1=Integer.toString(b.D);		

			
			if(b.L==null&&b.R==null){//�����ӽڵ�
				area.index+=1;
				if(b.in==1){//��ʱΪ���ڵ�
					area.draws[area.index]=new fillCircler();//�����ʱ��ͼ�ķ���	
					area.draws[area.index].i=3;//i=3������ʱѡ���ɫ	
					}
				else	
					area.draws[area.index]=new fillCircley();//�����Ǹ��ڵ㶨��ķ���
				area.draws[area.index].x1=b.x;
				area.draws[area.index].y1=b.y;//��������
				area.draws[area.index].s1=Integer.toString(b.D);
				return;
			}
			//�ݹ鿪ʼ
			if(b.L!=null)postOrder(b.L);//����������
			if(b.R!=null)postOrder(b.R);//����������
			
			//���㸸�ڵ��Dֵ�����ж��Ƿ��������ӽڵ���ӷŴ���
			
			if(b.L!=null){//���ڵ��ж�
				if(b.L.d+b.L.D>= tolerance){
					area.index+=1;
					area.draws[area.index]=new fillCirclew();
					area.draws[area.index].x1=b.L.x;area.draws[area.index].y1=b.L.y;
					area.draws[area.index].s1=Integer.toString(b.L.D);
					
					area.index+=1;
					area.draws[area.index]=new fillL();char a=(char)(b.L.num+'A');
					area.draws[area.index].s1=String.valueOf(a)+":"+Integer.toString(b.L.d)
							+"+"+Integer.toString(b.L.D)+"="+Integer.toString(b.L.d+b.L.D)
							+">/=����ֵ"+Integer.toString(tolerance);

					area.draws[area.index].x1=5;area.draws[area.index].y1=20+l*20;l+=1;
					
					area.index+=1;
					if(b.in==1){
						area.draws[area.index]=new fillCircler();
//i=3
						area.draws[area.index].i=3;
						}
					else{
						area.draws[area.index]=new fillCircley();
					}
					area.draws[area.index].x1=b.x;area.draws[area.index].y1=b.y;
					area.draws[area.index].s1=Integer.toString(b.D);
				}
				else{
					b.D=Math.max(b.L.d+b.L.D,b.D);
					area.index+=1;
					if(b.in==1){
//i=3						
						area.draws[area.index]=new fillCircler();
						area.draws[area.index].i=3;
						}
					else	
						area.draws[area.index]=new fillCircley();
					area.draws[area.index].x1=b.x;area.draws[area.index].y1=b.y;
					area.draws[area.index].s1=Integer.toString(b.D);
				}
				
			}
			if(b.R!=null){
				if(b.R.d+b.R.D>=tolerance){
					area.index+=1;
					area.draws[area.index]=new fillCirclew();
					area.draws[area.index].x1=b.R.x;
					area.draws[area.index].y1=b.R.y;
					area.draws[area.index].s1=Integer.toString(b.R.D);
					
					area.index+=1;
					area.draws[area.index]=new fillL();char a=(char)(b.R.num+'A');
					area.draws[area.index].s1=String.valueOf(a)+":"+Integer.toString(b.R.d)+"+"+Integer.toString(b.R.D)+"="+Integer.toString(b.R.d+b.R.D)+">/=����ֵ"+Integer.toString(tolerance);

					//area.draws[area.index].s1=String.valueOf(a)+"��ʱb.R.d+b.R.D="+Integer.toString(b.R.d+b.R.D)+">/=����ֵ"+Integer.toString(tolerance);
					area.draws[area.index].x1=5;area.draws[area.index].y1=20+l*20;
					l+=1;
					
					
					if(b.in==1){
						area.index+=1;
//i=3						
						area.draws[area.index]=new fillCircler();
						area.draws[area.index].i=3;
						}
					else{
						area.index+=1;
						area.draws[area.index]=new fillCircley();
					}
					area.draws[area.index].x1=b.x;
					area.draws[area.index].y1=b.y;
					area.draws[area.index].s1=Integer.toString(b.D);
				}
				else{
					b.D=Math.max(b.R.d+b.R.D,b.D);
					area.index+=1;
					if(b.in==1){
//i=3
						area.draws[area.index]=new fillCircler();
						area.draws[area.index].i=3;
						}
					else	
						area.draws[area.index]=new fillCircley();
					area.draws[area.index].x1=b.x;
					area.draws[area.index].y1=b.y;
					area.draws[area.index].s1=Integer.toString(b.D);
				}
				
			}

		}
	}
}
