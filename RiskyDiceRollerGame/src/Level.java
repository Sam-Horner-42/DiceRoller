/* Holds functionality for updating level appearance and level info */
public class Level {
    private String name;
    private int difficulty;
    private boolean isComplete;
    private int minRange;
    private int maxRange;
    String defaultImgPath;
    String hoveredImgPath;
    String lockedImgPath;
    boolean isLocked;

    /* Holds the level ID to get from the hashmap, the levels name, the two seperate image icons for the different paths */
    public Level(String name, String defaultImgPath, String hoveredImgPath, String lockedImgPath, int difficulty, boolean isComplete, int minRange, int maxRange, boolean isLocked) {
        this.name = name;
        this.defaultImgPath = defaultImgPath;
        this.hoveredImgPath = hoveredImgPath;
        this.lockedImgPath = lockedImgPath;
        this.difficulty = difficulty;
        this.isComplete = isComplete;
        this.minRange = minRange;
        this.maxRange = maxRange;
        this.isLocked = isLocked;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }


    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public int getMinRange() {
        return minRange;
    }

    public void setMinRange(int minRange) {
        this.minRange = minRange;
    }

    public int getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(int maxRange) {
        this.maxRange = maxRange;
    }

    public String getDefaultImgPath(){
        return defaultImgPath;
    }

    public void setDefaultImgPath(String defaultImgPath){
        this.defaultImgPath = defaultImgPath;
    }

    public String getHoveredImgPath(){
        return defaultImgPath;
    }

    public void setHoveredImgPath(String defaultImgPath){
        this.defaultImgPath = defaultImgPath;
    }

    public String getLockedImgPath(){
        return defaultImgPath;
    }

    public void setLockedImgPath(String defaultImgPath){
        this.defaultImgPath = defaultImgPath;
    }

    public boolean getIsLocked(){
        return isLocked;
    }

    public void setIsLocked(boolean isLocked){
        this.isLocked = isLocked;
    }





}
