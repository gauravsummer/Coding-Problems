package common;

public class Triplet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0,1,0,-2,-1,0};
		int one = a[0];
		int count = 1;
		int two = 0, three = 0;
		int i=0;
		boolean flag = false;
		for(i=1; i<a.length; i++) {
			if(flag == true)
				break;
			if(a[i] > one) {
				
				two = a[i];
				
				count = 2;
				if(i != a.length-1) {
					
					for(int j=i+1; j<a.length; j++) {
						if(a[j] > two) {
							three = a[j];
							//System.out.println("fg"+one+" "+two+" "+three);
							count = 3;
							flag = true;
							break;
						}
					}
				}	
			}else
				one = a[i];
		}
		
		//System.out.println(count);
		if(count == 3){
			System.out.println("True");
			System.out.println("one : "+one+" two: "+two +" three: "+three);
			
		}
		else
			System.out.println("False");
	}

}
