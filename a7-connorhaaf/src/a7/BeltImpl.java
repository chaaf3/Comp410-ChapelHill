package a7;
import java.util.List;
import comp401sushi.Plate;
import java.util.ArrayList;


public class BeltImpl implements Belt {

	private Plate[] _belt;
	private List<BeltObserver> beltList;
	private Customer[] ppl;
	
	public BeltImpl(int belt_size) {
		if (belt_size < 1) {
			throw new IllegalArgumentException("Illegal belt size");
		}
		
		_belt = new Plate[belt_size];
		 beltList = new ArrayList<BeltObserver>();
		 ppl = new Customer[belt_size];
	}

	@Override
	public int getSize() {
		return _belt.length;
	}

	@Override
	public Plate getPlateAtPosition(int position) {
		position = normalize_position(position);

		return _belt[normalize_position(position)];
	}

	@Override
	public void setPlateAtPosition(Plate plate, int position) throws BeltPlateException {
		if (plate == null) {
			throw new IllegalArgumentException();
		}

		position = normalize_position(position);

		if (getPlateAtPosition(position) != null) {
			throw new BeltPlateException(position, plate, this);
		}
		
		_belt[position] = plate;
		notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position));
	}


	@Override
	public void clearPlateAtPosition(int position) { 
		position = normalize_position(position);
		Plate p = _belt[position];
		_belt[position] = null;		
		notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_REMOVED, p, position));
	}

	private int normalize_position(int position) {
		int size = getSize();
		return (((position % size) + size) % size);
	}
	
	
	@Override
	public int setPlateNearestToPosition(Plate plate, int position) throws BeltFullException {
		int offset = 0;
		position = normalize_position(position);

		while (offset < getSize()) {
			try {
				setPlateAtPosition(plate, position+offset);
				notifyObservers(new PlateEvent(PlateEvent.EventType.PLATE_PLACED, plate, position));
				return normalize_position(position+offset);
			}
			catch (BeltPlateException e) {
				offset += 1;
			}
		}
		throw new BeltFullException(this);
		
	}
	@Override
	public void rotate() {
		Plate last_plate = _belt[getSize()-1];
		
		for (int i = getSize()-1; i>0; i--) {
			_belt[i] = _belt[i-1];
		}
		_belt[0] = last_plate;
		for (int i = 0; i < this.getSize(); i++) {
			if (ppl[i] != null && _belt[i] != null) {
				notificationMethod(ppl[i], _belt[i], i);
			}
		}
		
	}
	public void addBeltObserver(BeltObserver o) {
		beltList.add(o);
		
	}
	public void removeBeltObserver(BeltObserver o) {
		beltList.remove(o);
	}
	public void notifyObservers(PlateEvent e) {
		for (BeltObserver ob: beltList) {
			ob.handlePlateEvent(e);
		}
	}
	
	public void registerCustomerAtPosition(Customer c, int position) {
		position = normalize_position(position);
		if (c == null) {
			throw new IllegalArgumentException();
		}
		else if (ppl[position] != null) {
			throw new RuntimeException("customer at position");
		}
		for(int i = 0; i < ppl.length; i++) {
			if (ppl[i] == c) {
				throw new RuntimeException("mario stole your seat");
			}
		}
		ppl[position] = c;
	}
	
	public Customer unregisterCustomerAtPosition(int position) {
		position = normalize_position(position);
		if (ppl[position] == null) {
			return null;
		}
			Customer reference = ppl[position];
			ppl[position] = null;
			return reference;
		
	}
	public void notificationMethod(Customer c, Plate p, int position) {
		c.observePlateOnBelt(this, p, position);
		
	}
}
