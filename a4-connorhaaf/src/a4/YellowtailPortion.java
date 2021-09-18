package a4;

public class YellowtailPortion extends IngredientPortionImpl {
	
	static Yellowtail yellowtail = new Yellowtail();
	
	public YellowtailPortion(double amount) {
		super(yellowtail, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new YellowtailPortion(other.getAmount() + this.getAmount());
	}
}