public class BinaryTree {
	BinaryTree L,R,P;//��Ϊ�ڵ�������ӽڵ�͸��ڵ�
	int D,d,x,y,in,num;//��Ϊ�����������˥��ֵD�����丸�ڵ��˥��ֵd��x,yΪ��ͼ���꣬inΪ�ڼ���ı�ǣ�numΪ�����д��ĸ��ǵ��м���
	boolean ifadd=false,addall=false;
	public BinaryTree(){
	
	}
	public BinaryTree getR() {
		return R;
	}
	public void setR(BinaryTree R) {
		this.R = R;
	}
	public BinaryTree getL() {
		return L;
	}
	public void setL(BinaryTree L) {
		this.L = L;
	}	
}	
	
	
	
