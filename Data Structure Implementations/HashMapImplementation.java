package Implementation;

import java.util.Map.Entry;

class HashMapCustom<K, V> {
	private Entry<K, V>[] table; // table of entries
	private int capacity = 4; // initial capacity of hashmap
	static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;
		public Entry(K key, V value, Entry<K, V> next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
	public HashMapCustom() {
		table = new Entry[capacity];
	}
	
	private int hash(K key) {
		return Math.abs(key.hashCode()) % capacity;
	}
	
	public void put(K newKey, V data) {
		if(newKey == null)
			return; // no nulls allowed
		int hash = hash(newKey); // hash calculation
		Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);// create new entry
		if(table[hash] == null) {
			table[hash] = newEntry;
		}
		else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			
			while(current != null) {
				if(current.value.equals(newKey)) {
					if(previous == null) {
						newEntry.next = current.next;
						table[hash] = newEntry;
						return;
					}
					else {
						newEntry.next = current.next;
						previous.next = newEntry;
						return;
					}
				}
				previous = current;
				current = current.next;
			}
			previous.next = newEntry;
		}
	}
	
	public V get(K key) {
		int hash = hash(key);
		if(table[hash] == null)
			return null;
		else {
			Entry<K, V> temp = table[hash];
			while(temp != null) {
				if(temp.key.equals(key))
					return temp.value;
				temp = temp.next;
			}
			return null;
		} 
	}
	
	public boolean remove(K deleteKey) {
		int hash = hash(deleteKey);
		if(table[hash] == null)
			return false; 
		else {
			Entry<K, V> previous = null;
			Entry<K, V> current = table[hash];
			
			while(current != null) {
				if(current.key.equals(deleteKey)) {
					if(previous == null) {
						table[hash] = table[hash].next;
						return true;
					}
					else {
						previous.next = current.next;
						return true;
					}
				}
				previous = current;
				current = current.next;
			}
			return false;
		}
	}
	
	public void display() {
		for(int i=0; i<capacity; i++) {
			if(table[i] != null) {
				Entry<K, V> entry = table[i];
				while(entry != null) {
					System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry=entry.next;
				}
			}
		}
	}
}
public class HashMapImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMapCustom<Integer, Integer> map = new HashMapCustom<Integer, Integer>();
		map.put(21, 12);
		map.put(25, 121);
		map.put(30, 151);
		map.put(33, 15);
		map.put(35, 89);
		System.out.println("value corresponding to key 21="+ map.get(21));
		System.out.println("value corresponding to key 51="+ map.get(51));
		System.out.print("Displaying : ");
        map.display();
        System.out.println("\n\nvalue corresponding to key 21 removed: "+ map.remove(21));
        System.out.println("value corresponding to key 51 removed: "+ map.remove(51));
        System.out.print("Displaying : ");
        map.display();
	}

}
