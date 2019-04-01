package Leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("02", "Jason");
		map.put("01", "Ted");
		map.put("04", "Ben");
		map.put("05", "TOm");
		
		//��Map�����е�ӳ���ϵȡ���������뵽Set������ȥ��
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		
		while(it.hasNext()){
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+" : "+value);
			
		}	
		//�Ȼ�ȡmap���������м���Set���ϣ�keySet()
		Set<String> keySet = map.keySet();
		//����Set���ϣ��Ϳ��Ի�ȡ�������
		Iterator<String> it2 = keySet.iterator();
		
		while(it2.hasNext()){
			String key2 = it2.next();
			String value2 = map.get(key2);
			System.out.println(key2+" : "+value2);
		}
	}

}

/*
Map.Entry ��ʵEntryҲ��һ���ӿڣ�����Map�ӿ��е�һ���ڲ��ӿڡ�

interface Map
{
    public static interface Entry
    {
        public abstract Object getKey();
        public abstract Object getValue();

    }
}

class HashMap implements Map
{
    class Hahs implements Map.Entry
    {
        public  Object getKey(){}
        public  Object getValue(){}
    }
    
}
*/
