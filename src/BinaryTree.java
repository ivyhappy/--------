public class BinaryTree {
	BinaryTree L,R,P;//此为节点的左右子节点和父节点
	int D,d,x,y,in,num;//此为其子树的最大衰减值D，与其父节点的衰减值d，x,y为画图坐标，in为第几层的标记，num为计算大写字母标记的中间量
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
	
	
	
