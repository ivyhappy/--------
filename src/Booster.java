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
			area.draws[area.index].s1="此时容忍值为："+Integer.toString(tolerance)
					+"放置放大器的点有：";
			area.draws[area.index].x1=5;area.draws[area.index].y1=20;
		}
		else{
			area.index++;
			area.draws[area.index]=new fillL();
			area.draws[area.index].s1="此时容忍值为："+Integer.toString(area.tolerance)
					+"放置放大器的点有：";
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
			if(current==n||b.in==5)//所有节点都已经创建完成或者已经五行了，不再创建子数
				return;
			Random ra=new Random();
			int r=ra.nextInt(2);
			if(r==0){//建立左子树
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
			
			if(r==0||b.L==null){//建立右子树
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
	public void postOrder(BinaryTree b){//后序遍历二叉树并添加画图步骤
		if(b!=null){//第一次访问此节点
			area.index+=1;//添加画图步骤的标记
			if(b.in==1){//若为根节点
				area.draws[area.index]=new fillCircler();//定义此时画图的方法
				area.draws[area.index].i=2;//i=2，即此时选择蓝色
				area.draws[area.index].s1=Integer.toString(b.D);	
				}
			else	
				area.draws[area.index]=new fillCircleb();//若不是根节点定义的方法
			
			area.draws[area.index].x1=b.x;
			area.draws[area.index].y1=b.y;//定义坐标
			area.draws[area.index].s1=Integer.toString(b.D);		

			
			if(b.L==null&&b.R==null){//若无子节点
				area.index+=1;
				if(b.in==1){//此时为根节点
					area.draws[area.index]=new fillCircler();//定义此时画图的方法	
					area.draws[area.index].i=3;//i=3，即此时选择黄色	
					}
				else	
					area.draws[area.index]=new fillCircley();//若不是根节点定义的方法
				area.draws[area.index].x1=b.x;
				area.draws[area.index].y1=b.y;//定义坐标
				area.draws[area.index].s1=Integer.toString(b.D);
				return;
			}
			//递归开始
			if(b.L!=null)postOrder(b.L);//访问左子树
			if(b.R!=null)postOrder(b.R);//访问右子树
			
			//计算父节点的D值，并判断是否在左右子节点添加放大器
			
			if(b.L!=null){//做节点判断
				if(b.L.d+b.L.D>= tolerance){
					area.index+=1;
					area.draws[area.index]=new fillCirclew();
					area.draws[area.index].x1=b.L.x;area.draws[area.index].y1=b.L.y;
					area.draws[area.index].s1=Integer.toString(b.L.D);
					
					area.index+=1;
					area.draws[area.index]=new fillL();char a=(char)(b.L.num+'A');
					area.draws[area.index].s1=String.valueOf(a)+":"+Integer.toString(b.L.d)
							+"+"+Integer.toString(b.L.D)+"="+Integer.toString(b.L.d+b.L.D)
							+">/=容忍值"+Integer.toString(tolerance);

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
					area.draws[area.index].s1=String.valueOf(a)+":"+Integer.toString(b.R.d)+"+"+Integer.toString(b.R.D)+"="+Integer.toString(b.R.d+b.R.D)+">/=容忍值"+Integer.toString(tolerance);

					//area.draws[area.index].s1=String.valueOf(a)+"此时b.R.d+b.R.D="+Integer.toString(b.R.d+b.R.D)+">/=容忍值"+Integer.toString(tolerance);
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
