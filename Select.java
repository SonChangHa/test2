package hw5_1;

import java.util.Scanner;

public class Select {
	public static void main(String[] args) {
		System.out.println("hw5_1 : ��â��");
		
	    Scanner sc = new Scanner(System.in);
	    int len = 20;
	    String[] n = new String[len];
	    
	    System.out.print("20���� �ܾ� �Է�: ");
	    for(int i = 0; i < len; i++) {
	    	n[i] = sc.next();
	    }
	    
	    
	    String re1 = select(n, 0, len - 1, 1);
	    String re6 = select(n, 0, len - 1, 6);
	    String re17 = select(n, 0, len - 1, 17);
	    String re20 = select(n, 0, len - 1, 20);
	    
	    
	    System.out.println("1��° ���� �ܾ� = " + re1);

    	System.out.println("6��° ���� �ܾ� = " + re6);

    	System.out.println("17��° ���� �ܾ� = " + re17);

    	System.out.println("20��° ���� �ܾ� = " + re20);

	 

	 
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
	        int pivot = r; //�迭�� ������ ���� �� �ε����� �������� ����
	       
	        while(left < right){
	        	//compareTo�� ��ҹ��ڸ� �����Ͽ� ��������, IgnoreCase�� ��ҹ��ڸ� �������� ����.
	            if(n[left].compareToIgnoreCase(n[pivot]) > 0) { //���� ���� ���� ���� �� ���� ũ�ٸ�
	                if (n[right].compareToIgnoreCase(n[pivot]) > 0) { //���� ������ ���� ���� ������ ũ�ٸ�
	                    right--; // right�� ��ĭ �������� �ű�.
	                }
	                else {//���� ������ ���� ���� ������ �۴ٸ�
	                    change(n, left, right);
	                    left++; // ���� ������ �ڸ� �ٲ����� ���� ���� ��ĭ ������
	                }
	            }
	            else { //���� ���� ���� ���� �� ���� �۴ٸ�
	                left++;
	            }
	        }

	        if(n[pivot].compareToIgnoreCase(n[right]) > 0) { //���� ���� ���� ����, �������� ���� ������ ũ�ٸ�
	            String temp = n[pivot]; //pivot���� �ӽ� ����
	            //pivot ���� right���� �����ʿ� �����ϴ� ����
	            for(int i = pivot ; i > right + 1; i--){
	                n[i] = n[i-1];
	            }
	            n[right + 1] = temp;
	            return right+1;
	        } else {
	            String temp = n[pivot]; //pivot���� �ӽ� ����
	            //pivot ���� right���� �����ʿ� �����ϴ� ����
	            for(int i = pivot; i > right; i--){
	                n[i] = n[i-1];
	            }
	            n[right] = temp;
	            return right;
	        }
	    }

	    //�迭 �ڸ� �ٲٱ� �޼ҵ�
	    public static void change(String[] n, int a, int b){
	        String temp = n[a];
	        n[a] = n[b];
	        n[b] = temp;
	    }
}

