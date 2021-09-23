package a6;


public class EelPortion extends IngredientPortionImpl {
	
	static Eel eel = new Eel();
	
	public EelPortion(double amount) {
		super(eel, amount);
	}
	public IngredientPortion combine(IngredientPortion other) {
		if (other == null) {
			return this;
		}
		if (!other.getName().equals(this.getName())) {
			throw new RuntimeException("You can't");
		}
			return new EelPortion(other.getAmount() + this.getAmount());
	}
}