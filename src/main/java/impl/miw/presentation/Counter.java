package impl.miw.presentation;

public class Counter {
	private static Counter instance;
	private Integer counter=0;
	
	private Counter(){}
	
	public static Counter getInstance(){
		if (instance == null){
			instance = new Counter();
		}
		return instance;
	}
	
	public Integer inc(){
		return ++instance.counter;
	}

	public Integer getCounter() {
		return counter;
	}

}
