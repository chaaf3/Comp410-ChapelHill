package a5;

public class CrabPortion extends IngredientPortionImpl {
	
	static Crab crab = new Crab();
	
	public CrabPortion(double amount) {
		super(crab, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new CrabPortion(other.getAmount() + this.getAmount());
	}
}
