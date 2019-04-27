package Leetcode_Tree;

/*
	����վ

	��һ����·���� N ������վ�����е� i ������վ������ gas[i] ����

	����һ�������������޵ĵ��������ӵ� i ������վ������ i+1 ������վ��Ҫ�������� cost[i] ����������е�һ������վ��������ʼʱ����Ϊ�ա�

	���������ƻ�·��ʻһ�ܣ��򷵻س���ʱ����վ�ı�ţ����򷵻� -1��

	˵��: 

	�����Ŀ�н⣬�ô𰸼�ΪΨһ�𰸡�
	���������Ϊ�ǿ����飬�ҳ�����ͬ��
	���������е�Ԫ�ؾ�Ϊ�Ǹ�����
	ʾ�� 1:

	����: 
	gas  = [1,2,3,4,5]
	cost = [3,4,5,1,2]

	���: 3

	����:
	�� 3 �ż���վ(����Ϊ 3 ��)�������ɻ�� 4 �����͡���ʱ������ = 0 + 4 = 4 ������
	���� 4 �ż���վ����ʱ������ 4 - 1 + 5 = 8 ������
	���� 0 �ż���վ����ʱ������ 8 - 2 + 1 = 7 ������
	���� 1 �ż���վ����ʱ������ 7 - 3 + 2 = 6 ������
	���� 2 �ż���վ����ʱ������ 6 - 4 + 3 = 5 ������
	���� 3 �ż���վ������Ҫ���� 5 �����ͣ������㹻�㷵�ص� 3 �ż���վ��
	��ˣ�3 ��Ϊ��ʼ������
	ʾ�� 2:

	����: 
	gas  = [2,3,4]
	cost = [3,4,3]

	���: -1

	����:
	�㲻�ܴ� 0 �Ż� 1 �ż���վ��������Ϊû���㹻�����Ϳ���������ʻ����һ������վ��
	���Ǵ� 2 �ż���վ���������Ի�� 4 �����͡� ��ʱ������ = 0 + 4 = 4 ������
	���� 0 �ż���վ����ʱ������ 4 - 3 + 2 = 3 ������
	���� 1 �ż���վ����ʱ������ 3 - 3 + 3 = 3 ������
	���޷����� 2 �ż���վ����Ϊ������Ҫ���� 4 �����ͣ������������ֻ�� 3 �����͡�
	��ˣ������������㶼�������ƻ�·��ʻһ�ܡ�
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int total = 0;
        int current = 0;
        for(int i=0; i<gas.length; i++){
            total += gas[i] - cost[i];
            current += gas[i] - cost[i];
            if(current < 0){
                start = i+1;
                current = 0;
            }
        }
        return total >= 0? start : -1;
    }
}
