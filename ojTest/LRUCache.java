package ojTest;

public class LRUCache {
	private int capacity;
	private node[] keys;
	private int cursor;//非空节点数量
	private int total;
	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cursor = 0;
        this.total = 0;
        this.keys = new node[this.capacity];
        for(int i = 0; i < this.capacity; i++)
        {
        	keys[i] = new node(-1,-1);
        }
    }
    
    public int get(int key) {
    	int result = -1;
        for(int i = 0;i<this.cursor;i++)
        {
        	if(keys[i].key == key){
        		result = this.keys[i].value;
        		this.keys[i].accumulate = total++;
        		break;
        	}
        }
        return result;
    }
    
    public void set(int key, int value) {
    	boolean exist = false;
    	for(int i = 0;i<this.cursor;i++)
        {
        	if(this.keys[i].key == key){
        		this.keys[i].value = value;
        		this.keys[i].accumulate = total++;
        		exist = true;
        		break;
        	}
        }
    	if(exist == false){
    		if(this.cursor < this.capacity)
    		{
    			this.keys[this.cursor].key = key;
    			this.keys[this.cursor].value = value;
    			this.keys[this.cursor].accumulate = total++;
    			this.cursor++;
    			
    		}else if(this.cursor == this.capacity){
    			int min = 99999;
    			int index = -1;
    			int ii = 0;
    			for(ii = 0;ii<this.cursor;ii++)
    			{
    				if(this.keys[ii].accumulate<min)
    				{
    					min = this.keys[ii].accumulate;
    					index = ii;
    				}
    			}
    			this.keys[index].key = key;
    			this.keys[index].value = value;
    			this.keys[index].accumulate = total++;
    		}
    	}
    }
    
    static class node{
    	public int key;
    	public int value;
    	public int accumulate;
    	public node(int key,int value){
    		super();
    		this.key = key;
    		this.value = value;
    		this.accumulate = 0;
    	}
    }
    public static void main(String args[]){
    	LRUCache lc = new LRUCache(2);
    	lc.set(2,1);
    	lc.set(1, 1);
    	System.out.println(lc.get(2));
    	//lc.set(1,1);
    	lc.set(4,1);
    	System.out.println(lc.get(1));
    	System.out.println(lc.get(2));
    	//set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)
//    	k = lc.get(4);
//    	System.out.println(lc.cursor);
//    	System.out.println(lc.get(3));
    }
}
