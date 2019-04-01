package Leetcode_BinarySearch;

public class leetcode_069 {
	/**
	 * 	ʵ�� int sqrt(int x) ������
		���㲢���� x ��ƽ���������� x �ǷǸ�������
		���ڷ������������������ֻ���������Ĳ��֣�С�����ֽ�����ȥ��
	 */
	//����һ��������������1��ʼ�𽥱�����ʱ�临�Ӷ�̫�ߣ�������ʹ��
	public int mySqrt1(int x){
		for(long i=0; i<=x; i++){
			if(i*i>x){
				return (int)i-1;
			}
			else if(i*i == x){
				return (int)i;
			}
		}
		return 0;
	}
	//�����������ֲ��ҷ���
	public int mySqrt2(int x){
		int left = 1;
		int right = x;
		int mid = (left+right)/2;
		while(left<right){
			if(mid*mid == x){
				break;
			}
			else if(mid*mid>x){
				right = mid-1;
				mid = (left+right)/2;
			}
			else if(mid*mid<x){
				left = mid+1;
				mid = (left+right)/2;
			}
		}
		return mid*mid>x? mid-1:mid;
	}
	//��������ţ�ٷ����-�����ٶȿ죬
	private final double precision = 0.001;
	public int mySqrt3(int x){
		double y = x * 1.0;
		double sqrt_y = 1;
		while(Math.abs(y - sqrt_y*sqrt_y)>precision){
			sqrt_y = (sqrt_y + y / sqrt_y) / 2;
		}
		return (int)sqrt_y;
	}
	
	public static void main(String[] args) {
		leetcode_069 l069 = new leetcode_069();
		int x = 4;
		System.out.println("The sqrt of "+x+" : "+l069.mySqrt3(x));
	}

}
