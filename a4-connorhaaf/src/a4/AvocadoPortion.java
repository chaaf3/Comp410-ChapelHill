package a4;

public class AvocadoPortion extends IngredientPortionImpl {
	
	static Avocado avocado = new Avocado();
	
	public AvocadoPortion(double amount) {
		super(avocado, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new AvocadoPortion(other.getAmount() + this.getAmount());
	}
}