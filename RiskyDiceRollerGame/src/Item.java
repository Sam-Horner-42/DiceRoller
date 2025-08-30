
public abstract class Item {
    private final String name;
    private final String description;
    private boolean isSelected;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    
    public void setIsSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public boolean getIsSelected() {
    	return isSelected;
    }

    public abstract void use(IntWrapper total);
}