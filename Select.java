package hw5_1;

import java.util.Scanner;

public class Select {
	public static void main(String[] args) {
		System.out.println("hw5_1 : 손창하");
		
	    Scanner sc = new Scanner(System.in);
	    int len = 20;
	    String[] n = new String[len];
	    
	    System.out.print("20개의 단어 입력: ");
	    for(int i = 0; i < len; i++) {
	    	n[i] = sc.next();
	    }
	    
	    
	    String re1 = select(n, 0, len - 1, 1);
	    String re6 = select(n, 0, len - 1, 6);
	    String re17 = select(n, 0, len - 1, 17);
	    String re20 = select(n, 0, len - 1, 20);
	    
	    
	    System.out.println("1번째 작은 단어 = " + re1);

    	System.out.println("6번째 작은 단어 = " + re6);

    	System.out.println("17번째 작은 단어 = " + re17);

    	System.out.println("20번째 작은 단어 = " + re20);

	 

	 
	    sc.close();
	    
	    }

	    public static String select(String[] n, int left, int right, int i){
	    	if(left == right){
	    		return n[left];
	    	}
	    		    	
	    	int result = part(n, left, right);

	    	int k = result - left + 1;
	    	
	    	if(i < k) {
	    		return select(n, left, result - 1, i);
	    	} else if(i == k) {
	    		return n[result];
	    	} else {
	    		return select(n, result + 1, right, i - k);
	    	}
	    }

	    public static int part(String[] n, int l, int r){
	        int left = l;
	        int right = r - 1;
	        int pivot = r; //배열의 마지막 값이 든 인덱스를 기준으로 설정
	       
	        while(left < right){
	        	//compareTo는 대소문자를 구분하여 비교하지만, IgnoreCase는 대소문자를 구분하지 않음.
	            if(n[left].compareToIgnoreCase(n[pivot]) > 0) { //만약 왼쪽 값이 기준 값 보다 크다면
	                if (n[right].compareToIgnoreCase(n[pivot]) > 0) { //만약 오른쪽 값이 기준 값보다 크다면
	                    right--; // right를 한칸 왼쪽으로 옮김.
	                }
	                else {//만약 오른쪽 값이 기준 값보다 작다면
	                    change(n, left, right);
	                    left++; // 왼쪽 오른쪽 자리 바꿨으니 왼쪽 값을 한칸 앞으로
	                }
	            }
	            else { //만약 왼쪽 값이 기준 값 보다 작다면
	                left++;
	            }
	        }

	        if(n[pivot].compareToIgnoreCase(n[right]) > 0) { //만약 기준 값이 왼쪽, 오른쪽이 만난 값보다 크다면
	            String temp = n[pivot]; //pivot값을 임시 저장
	            //pivot 값을 right값의 오른쪽에 삽입하는 과정
	            for(int i = pivot ; i > right + 1; i--){
	                n[i] = n[i-1];
	            }
	            n[right + 1] = temp;
	            return right+1;
	        } else {
	            String temp = n[pivot]; //pivot값을 임시 저장
	            //pivot 값을 right값의 오른쪽에 삽입하는 과정
	            for(int i = pivot; i > right; i--){
	                n[i] = n[i-1];
	            }
	            n[right] = temp;
	            return right;
	        }
	    }

	    //배열 자리 바꾸기 메소드
	    public static void change(String[] n, int a, int b){
	        String temp = n[a];
	        n[a] = n[b];
	        n[b] = temp;
	    }
}

