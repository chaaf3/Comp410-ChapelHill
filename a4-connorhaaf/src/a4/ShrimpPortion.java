package a4;

public class ShrimpPortion extends IngredientPortionImpl {
	
	static Shrimp shrimp = new Shrimp();

	public ShrimpPortion(double amount) {
		super(shrimp, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new SeaweedPortion(other.getAmount() + this.getAmount());
	}
}
