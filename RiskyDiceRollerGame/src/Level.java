/* Holds functionality for updating level appearance and level info */
public class Level {
    private String name;
    private int difficulty;
    private String levelID;
    private boolean levelComplete;
    private int minRange;
    private int maxRange;

    public Level(String levelId, String name, int difficulty, boolean levelComplete, int minRange, int maxRange) {
        this.levelID = levelId;
        this.name = name;
        this.difficulty = difficulty;
        this.levelComplete = levelComplete;
        this.minRange = minRange;
        this.maxRange = maxRange;
    }

    public Level(String name, int difficulty, boolean levelComplete, int minRange, int maxRange) {
        this.name = name;
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

    public String getLevelID() {
        return levelID;
    }

    public void setLevelID(String levelID) {
        this.levelID = levelID;
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



}
