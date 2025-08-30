public abstract class Item {
    private String name;
    private String description;
    private String fileName;
    private boolean isSelected;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean getIsSelected(){
        return isSelected;
    }

    public void setIsSelected(boolean isSelected){
        this.isSelected = isSelected;
    }
    
    

    public String getDescription() {
		return description;
	}

    /*
     * Constructs a single dice for use
     */
    public Item(String name, String fileName, boolean isSelected, String description){
        this.name = name;
        this.fileName = fileName;
        this.isSelected = isSelected;
        this.description = description;
    }

    
}
