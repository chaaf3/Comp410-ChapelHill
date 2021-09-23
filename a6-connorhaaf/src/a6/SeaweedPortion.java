package a6;


public class SeaweedPortion extends IngredientPortionImpl {
	
	static Seaweed seaweed = new Seaweed();

	public SeaweedPortion(double amount) {
		super(seaweed, amount);
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
