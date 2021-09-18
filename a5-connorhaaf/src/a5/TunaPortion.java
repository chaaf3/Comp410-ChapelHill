package a5;

public class TunaPortion extends IngredientPortionImpl {
	
	static Tuna tuna = new Tuna();
	
	public TunaPortion(double amount) {
		super(tuna, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new TunaPortion(other.getAmount() + this.getAmount());
	}
}
