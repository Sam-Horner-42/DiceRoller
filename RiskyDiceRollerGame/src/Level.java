/* Holds functionality for updating level appearance and level info */
public class Level {
    private String name;
    private int difficulty;
    private boolean levelComplete;
    private int minRange;
    private int maxRange;
    String defaultImgPath;
    String hoveredImgPath;

    /* Holds the level ID to get from the hashmap, the levels name, the two seperate image icons for the different paths */
    public Level(String name, String defaultImgPath, String hoveredImgPath, int difficulty, boolean levelComplete, int minRange, int maxRange, boolean isLocked) {
        this.name = name;
        this.defaultImgPath = defaultImgPath;
        this.hoveredImgPath = hoveredImgPath;
        this.difficulty = difficulty;
        this.levelComplete = levelComplete;
        this.minRange = minRange;
        this.maxRange = maxRange;
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


    public boolean isLevelComplete() {
        return levelComplete;
    }

    public void setLevelComplete(boolean levelComplete) {
        this.levelComplete = levelComplete;
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





}
