package eu.sirotin.example.optional;

public class CupOfWater {
	
	private boolean isBoiled;
	private boolean isFilled;
	
	public CupOfBoiledWater boil() {return new CupOfBoiledWater();}
	public void fill() {isFilled = true;}
	public void empty() {isFilled = false;}
	
	public boolean isBoiled() {
		return isBoiled;
	}
	public boolean isFilled() {
		return isFilled;
	}
	
}
