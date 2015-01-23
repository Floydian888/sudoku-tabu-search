package main;

public class Movement {
	
	public Movement(Coordinates from, Coordinates to){
		this.from = from;
		this.to = to;
	}
	
	public Coordinates from;
	public Coordinates to;
	
	@Override public String toString(){
		StringBuilder result = new StringBuilder();
		result.append(from.toString());
		result.append(to.toString());
		return result.toString();
	}
}
