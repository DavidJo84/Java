package test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,0,0,1,1,1,1,1},{1,1,0,0,0,0,0,0},{1,1,0,1,1,1,0,0},{1,1,0,1,1,1,0,0}
		,{1,0,0,1,1,1,0,1},{1,0,1,1,0,1,0,1},{0,0,1,0,0,0,0,0},{0,1,1,0,1,1,1,1}};
		int cnt=1;
		int cnt2=1;
		int row =0;
		int col =0;
		for(int i =0; i<a.length;i++) {
			for(int j=0; j<a.length;j++)
			if(j<a.length-1 && a[i][j]==a[i][j+1]) {
				row = j;
				col = i;
				cnt++;
				if(cnt>=4) {
//					for(int k=row-3;k<=row;k++) {
						
						System.out.println(col+"/"+row);
//					}
				}
				
			} else if(j==a.length-1 && a[i][j-1]==a[i][j]){
				row = j;
				col = i;
				cnt++;
				if(cnt>=4) {
					System.out.println(col+"/"+row);
				}
				cnt=1;
			}else {
				cnt=1;
				
			}
			
		}
	}

}
