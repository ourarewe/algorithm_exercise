package algorithm_exercise_java;
import java.util.*;
import java.lang.*;

public class algorithm_exercise {
	public static void main(String[] args){
		A a = new B();
		a.methonA();
		
		Solution s = new Solution();
		System.out.println(s.NumberOf1(11));
		System.out.println("end");
		//System.out.println(s.isSymmetrical(p1));
		
		/*ArrayList aa = new ArrayList();
		int[] a = {0,0};
		a[1]=1;
		System.out.println(a[1]);*/
		
		/*����
		int[][] a = {{0,1,1,1},{0,1,1,1},{0,1,1,1}};
		Partition p = new Partition();
		int[] b=p.getPartition(a, 4, 3);
		System.out.println(b[0]+","+b[1]);
		System.out.println(a[2][3]);*/
		
		/*String s = "Hello World";
		System.out.println(s);
		Transform tr = new Transform();
		System.out.println(tr.trans(s, 11));
		System.out.println(s.substring(5, 6));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(0x7fffffff);*/
		
		/*//----------��ɫ������·��-------------------------------------
		Solution s = new Solution();
		int[] a = {0,0,1,-1,-1,1,-1,-1,1,1,0,-1,-1,1,-1,-1,1,0,-1,-1,0,-1,-1}; 
		TreeNode p = new TreeNode(a[0]);
	    s.BuildTree(p,a);s.PrintTree(p);System.out.println();
		System.out.println(s.findPath(p));
		//--------------------------------------------------
*/		
		/*//---------��������-----------------------------------
		System.out.println("������������");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.trim();
        String[] temp = input.split(" ");
        double[] nums = new double[temp.length];
        double result = 0;
        for (int i = 0; i < temp.length; i++) {
            nums[i] = Double.parseDouble(temp[i]);
            result += nums[i];
        }
        System.out.println("��Щ���ĺ�Ϊ:" + result);
        scanner.close();
        //--------------------------------------------------
*/    
		
		/*String[] s = {"a","n"};
		String ss = s[0]+s[1];
		System.out.println(jiechen(9));*/
		
		//�ַ�����
		Solution solution = new Solution();
		//System.out.println(solution.Permutation("abcd"));
		
		//�����������
		int[] A = {2,1,4,3,1,5,6};
		System.out.println(solution.findLongest(A, 7));
	}
	
	public static int jiechen(int n){
        if(n>=1){
            n=n*jiechen(n-1);
            return n;
        }
        return 1;
    }
}

class A{
	public void methonA(){
		System.out.println("A");
	}
}

class B extends A{
	public void methonB(){
		System.out.println("B");
		
	}
}
//-----------------------------------------------------------
//--------------------���------------------------------------------
class Solution {
	//------------------ͳ�ƶ�����1�ĸ���----------------------
	public int  NumberOf1(int n) {
	     int m=0x40000000;
         int count = 0;
 
         do{
             if((m&n)==m) count++;
             m=m>>1;
         }while(m!=0);
         if(n>=0) return count;
         else return count+1;
     }
		//----------���Ž�------------------
	/*public int NumberOf1(int n) {
        int count = 0;
        while(n!= 0){
            count++;
            n = n & (n - 1);
         }
        return count;
    }*/
	//------------------------------------------------------------
	//--------------------���������-----------------------------------------
	boolean isSymmetrical(TreeNode pRoot){
		if(pRoot==null) return true;
	    else return fun1(pRoot.left,pRoot.right);
	}
	boolean fun1(TreeNode pl,TreeNode pr){
		if(pl==null&&pr==null) return true;
		else if(pl!=null&&pr==null) return false;
		else if(pl==null&&pr!=null) return false;	
		else if(pl.val!=pr.val) return false;	
	    else return fun1(pl.left,pr.right)&&fun1(pl.right,pr.left);
	}
	//-----------------------------------------------------------------------
	//-------------------------��ɫ�·��---------------------------------------
	int path_max;
	public int findPath(TreeNode root) {
		if(root==null) return 0;
		int count=0;path_max=1;
		fun2(root,root.val,count);
		int path = path_max; path_max=1;
        return path;
    }
	public void fun2(TreeNode p,int val,int count){
		if(p==null) {if(count>path_max) path_max=count;return;}
		if(p.val==val){count++;}
		else {if(count>path_max) path_max=count;count=1;}
		fun2(p.left,p.val,count);
		fun2(p.right,p.val,count);	
	}
	//------------------------------------------------------------------------
	
	//--------------��������-------------------------------------------------
	int sta_i = 1;
	public void BuildTree(TreeNode root,int[] a){
		/*for(int i=0;i<a.length;i++){
			BuildTree(root,a[i]);
		}*/
		if(sta_i<a.length){
			if(a[sta_i]!=-1){root.left=new TreeNode(a[sta_i]);sta_i++;BuildTree(root.left,a);}
			else{sta_i++;}
			if(a[sta_i]!=-1){root.right=new TreeNode(a[sta_i]);sta_i++;BuildTree(root.right,a);}
			else{sta_i++;}
		}
		if(sta_i>=a.length) sta_i=1;
	}
	//----------------------------------------------------------------------
	//----------------��ӡ������--------------------------------
	public void PrintTree(TreeNode p){
		if(p!=null){System.out.print(p.val+",");PrintTree(p.left);PrintTree(p.right);}
	}
	//--------------------------------------------------------
	
	/* �ַ���������
	 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c
	 * �������г����������ַ���abc,acb,bac,bca,cab��cba�� ����밴��ĸ˳�������
	 */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<String>();
        HashSet<String> h = new HashSet<String>(res); 
        unionstr("",str,h);
        res.addAll(h);  
        Collections.sort(res);
        return res;	
     }
     public void unionstr(String last_str,String remain_str,HashSet<String> res){
     	System.out.println("remain_str.length()="+remain_str.length()+" "+remain_str);
     	if(remain_str.length()==1){res.add(last_str+remain_str);}
     	for(int mid=0;mid<remain_str.length();mid++){
     		unionstr(last_str+remain_str.substring(mid,mid+1),remain_str.substring(0,mid)+remain_str.substring(mid+1,remain_str.length()),res);
     	}
     }
     //---------------------------------------------------------------------------------------------------------------
   
     /* �����������
      * ����һ���������У������һ�����Ӷ�ΪO(nlogn)���㷨�����ظ����е�����������еĳ��ȣ�
      * ����������ж���Ϊ����һ������U1��U2...������Ui < Ui+1����A[Ui] < A[Ui+1]��
      * ����һ����������A�����еĳ���n���뷵������������еĳ��ȡ�
      * ���룺[2,1,4,3,1,5,6],7  ����� 4
      */
     public int findLongest(int[] A, int n) {
         int[] B = new int[n+1]; B[1] = A[0];
         int len=1,start=0,end=len,mid;
         for(int i = 1;i<n;i++){
             if(A[i]>B[len]) {len++;B[len] = A[i];}
             else{
                 start=1;end=len;
                 while(start<=end){
                   mid=(start+end)/2;
                   if(B[mid]<A[i]) start=mid+1;
                   else end=mid-1;
               } B[start] = A[i];
             }
         }
         return len;
     }
     //----------------------------------------------------------------------------------------------------
}
//-----------------------------------------------------------------------------
//---------------------------�������ڵ�-------------------------------------------------	
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

//--------------------------------------------------------------------------
//-------------------�ַ�ת��---------------------------------------------------
class Transform {
    public String trans(String s, int n) {
    	String s1="",ss="";int i;
    	//ArrayList<String> al = new ArrayList<String>();
    	for(i=0;i<n;i++){
    		if(s.substring(i,i+1).matches("[a-z]")) 
    			s1=s1+s.substring(i, i+1).toUpperCase();
    		else if(s.substring(i, i+1).matches("[A-Z]")) 
    			s1=s1+s.substring(i, i+1).toLowerCase();
    		else if(s.substring(i, i+1).equals(" ")) {ss=" "+s1+ss;s1="";}
    	}
    	ss=s1+ss;
        return ss;
    }
}
//----------------------------------------------------------------------------------
//---------����------------------------------------------------------
class Partition {
    public int[] getPartition(int[][] land, int n, int m) {
        int i,ii,j,k; int count=0; int min=0x7FFFFFFF; int[] res = {0,1};
        //ArrayList<Integer> al = new ArrayList<Integer>();
    	for(i=0;i<=n;i++){
    		count=0;
    		for(ii=0;ii<m;ii++){
    			for(j=0;j<=i-1;j++){if(land[ii][j]==1) count++;}
    			for(k=i;k<n;k++){if(land[ii][k]==0) count++;}
    		}
    		System.out.println(count+" "+min+" "+i);
    		if(count<min) {min=count;res[0]=i;res[1]=i+1;}
    	}
    	return res;
    }
}
//----------------------------------------------------------------------------
