
public class Die implements Comparable<Die>{
    
    private int numSides; // specifies total number of sides on a single dice
    private String name;
    private String description;
    private String fileName;
    private boolean isSelected;

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }


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
    public Die(String name, int numSides, String fileName, boolean isSelected){
        this.name = generateDieName(numSides); // dynamically generates name based on params
        this.fileName = generateFileName(numSides);
        this.numSides = numSides;
        this.isSelected = isSelected;
        this.description = generateDescription();
    }
    
    /* Sort the dice by their number of sides, from smallest to largest */
    @Override
    public int compareTo(Die other){
        return Integer.compare(this.numSides, other.numSides);
    }

    /* 
    Dynamically generates a die name based on its parameters 
    Will need to add further logic for special dice
    */
    public String generateDieName(int numSides){
        String dieName = "";
        dieName += numSides + "-Sided Die";
        return dieName;
    }

    public String generateFileName(int numSides){
        String fileName = "";
        fileName += "D" + numSides;
        return fileName;
    }
    
    public String generateDescription(){
        String info = "This is a " + name + "\n it's sides are: ";
        for(int i = 1; i<numSides + 1;i++) {
        	if(i == numSides) {
        		info = info + i;
        	}else {
        		info = info + i + ", ";
        	}
        	
        }
        
        
    	return info;
    }
    

    @Override
    public String toString(){
        String string = "";
        string += "Name: " + name;
        return string;
    }
}
