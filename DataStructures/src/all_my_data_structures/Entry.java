package all_my_data_structures;

public class Entry {
	private Object key;
	private Object value;
	
	public Entry(Object key, Object value) {
		this.key = key;
		this.value = value;
	}
	
	public Object getKey() {
		return key;
	}
	
	public Object getValue() {
		return value;
	}
	
	public boolean setValue(Object value) {
		this.value = value;
		return true;
	}

}
