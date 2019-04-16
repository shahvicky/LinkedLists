public class quick2 {
	
    void Sort(int a[],int p,int r){
        if(p<r){
        int[] q=partition(a,p,r);
		
        //System.out.print(q[0]+ ">>"+q[1]+" ");
        Sort(a,p,q[0]);
        
		
			Sort(a,q[1],r);
        }
    }
    int[] partition(int a[],int p,int r){
        int i=p-1;
        int l=r-1;
		int m;
        int x=a[r];
        for(int k=p;k<=l+1;k++){
			if(a[k]<x){
				int y=a[k];
				a[k]=a[++i];
				a[i]=y;
			}
			if(a[k]>x){
				while(a[l]>x){
					if(l>k){
					l--;}
					else
						break;
				}
				int y=a[l];
				a[l]=a[k];
				a[k]=y;
			}
		}	
		if(a[l]>a[r]){
		a[r]=a[l];
		a[l]=x;
		
		}
		l++;
		
		//System.out.println("p-->"+p+" r-->"+r+" ");
        for(int d=p;d<=r;d++)
         System.out.print(a[d]+" ");
		System.out.println("l :"+l+" i :"+i+" x: "+x);
		int z[]={i,l};
		return z;
				
    }
    public static void main(String args[]) {
        int x=10;
        int y=25;
        int z=x+y;
        int a[]={9,9,9,6,9,9,9,9,8,8,8,8,7,7,7,7,6,6,6,6,6,5,5,5,5};
		int[] b={9,9,9,96,9,9,9,8,8,8,8,7,7,7,7,6,6,6,6,6,5,5,5,5};
		for(int i=0;i<b.length-1;i++){
			for(int j=i;j<b.length;j++){
				if(b[i]>b[j]){
					int t=b[j];
					b[j]=b[i];
				b[i]=t;}
			}
		}
        quick2 m=new quick2();
        m.Sort(a,0,a.length-1);
		
        System.out.println();
        for(int i=0;i<a.length;i++)
         System.out.print(a[i]+" ");
	 System.out.println();
	 System.out.println();
	for(int i=0;i<b.length;i++){
        System.out.print(b[i]+" ");
    }
	
        //System.out.println("Sum of x+y = " + z);
    }
}
