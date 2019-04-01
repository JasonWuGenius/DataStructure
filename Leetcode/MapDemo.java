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
		
		//将Map集合中的映射关系取出来。存入到Set集合中去。
		Set<Map.Entry<String, String>> entrySet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = entrySet.iterator();
		
		while(it.hasNext()){
			Map.Entry<String, String> me = it.next();
			String key = me.getKey();
			String value = me.getValue();
			System.out.println(key+" : "+value);
			
		}	
		//先获取map集合中所有键的Set集合，keySet()
		Set<String> keySet = map.keySet();
		//有了Set集合，就可以获取其迭代器
		Iterator<String> it2 = keySet.iterator();
		
		while(it2.hasNext()){
			String key2 = it2.next();
			String value2 = map.get(key2);
			System.out.println(key2+" : "+value2);
		}
	}

}

/*
Map.Entry 其实Entry也是一个接口，它是Map接口中的一个内部接口。

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
