package a5;

public class RicePortion extends IngredientPortionImpl {
	
	static Rice rice = new Rice();
	
	public RicePortion(double amount) {
		super(rice, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new RicePortion(other.getAmount() + this.getAmount());
	}
}