package a3.memory;

import aiantwars.EAntType;
import aiantwars.IAntInfo;
import aiantwars.ILocationInfo;
import a3.utility.Calc;

/**
 *
 * @author Jonas Rafn
 */
public class Tile {

    private int x;
    private int y;
    private int direction;
    private int foodCount;
    private int movementCost;
    private IAntInfo ant;
    private boolean isFilled;
    private boolean isRock;
    private TileType type = TileType.DEFAULT;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(int x, int y, int foodCount, IAntInfo ant, boolean isFilled, boolean isRock) {
        this.x = x;
        this.y = y;
        this.foodCount = foodCount;
        this.ant = ant;
        this.isFilled = isFilled;
        this.isRock = isRock;
    }

    public Tile(ILocationInfo location) {
        this.x = location.getX();
        this.y = location.getY();
        this.foodCount = location.getFoodCount();
        this.ant = location.getAnt();
        this.isFilled = location.isFilled();
        this.isRock = location.isRock();
    }

    public Tile(int x, int y, IAntInfo ant, int direction, int foodCount) {
        this.x = x;
        this.y = y;
        this.ant = ant;
        this.direction = direction;
        this.foodCount = foodCount;
        calcMovementCost(ant, direction);
    }

    public void setMovementCost(int movementCost) {
        this.movementCost = movementCost;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getFoodCost() {
        return movementCost - getFoodCount();
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public IAntInfo getAnt() {
        return ant;
    }

    public void setAnt(IAntInfo ant) {
        this.ant = ant;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setIsFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public boolean isRock() {
        return isRock;
    }

    public void setIsRock(boolean isRock) {
        this.isRock = isRock;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    private void calcMovementCost(IAntInfo ant, int direction) {
        if (ant != null) {
            int currentDirection = ant.getDirection();
            EAntType antType = ant.getAntType();
            movementCost = Calc.getMovementCost(Calc.getMovementAction(currentDirection, direction), antType, true);
        }
    }

    @Override
    public String toString() {
        return "Tile: " + "(" + x + "," + y + ")" + ", isRock: " + isRock + ", foodCount: " + foodCount;
    }

}