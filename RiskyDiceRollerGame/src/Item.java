
public abstract class Item {
    private final String name;
    private final String description;
    private boolean selected;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    
    public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
    	return selected;
    }

    public abstract void use(IntWrapper total);
}