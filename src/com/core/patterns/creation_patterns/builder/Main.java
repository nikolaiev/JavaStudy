package com.core.patterns.creation_patterns.builder;

/**
 * Created by vlad on 15.02.17.
 * <p>
 * Building pattern
 * <p>
 * creating object from diff parts
 * <p>
 * common algo of creating objects
 */

abstract class Building {
    String base;
    String walls;
    String roof;

    abstract void setFoundamental(String base);

    abstract void setWalls(String walls);

    abstract void setRoof(String roof);
}

class Cottage extends Building {

    @Override
    void setFoundamental(String base) {
        this.base = base;
    }

    @Override
    void setWalls(String walls) {
        this.walls = walls;
    }

    @Override
    void setRoof(String roof) {
        this.roof = roof;

    }
}

class SkyScrapper extends Building {

    @Override
    void setFoundamental(String base) {
        this.base = base;
    }

    @Override
    void setWalls(String walls) {
        this.walls = walls;
    }

    @Override
    void setRoof(String roof) {
        this.roof = roof;

    }
}

abstract class Builder {
    Building building;

    public Building getBuilding() {
        return building;
    }

    public abstract void buildBase();

    public abstract void buildWalls();

    public abstract void buildRoof();

}

class CottageBuilder extends Builder {
    public CottageBuilder() {
        building = new Cottage();
    }

    @Override
    public void buildBase() {
        building.setFoundamental("base");
    }

    @Override
    public void buildWalls() {
        building.setWalls("walls");
    }

    @Override
    public void buildRoof() {
        building.setRoof("roof");
    }
}

class SkyScrabberBuilder extends Builder {
    public SkyScrabberBuilder() {
        building = new SkyScrapper();
    }

    @Override
    public void buildBase() {
        building.setFoundamental("base");
    }

    @Override
    public void buildWalls() {
        building.setWalls("walls");
    }

    @Override
    public void buildRoof() {
        building.setRoof("roof");
    }
}


/**
 * Incapsulation of common algorithm
 */
class Forman {
    Builder builder;

    public Forman(Builder builder) {
        this.builder = builder;
    }

    public void createBuilding() {
        builder.buildBase();
        builder.buildWalls();
        builder.buildRoof();
    }
}

public class Main {
    public static void main(String[] args) {
        Builder builder = new CottageBuilder();
        Forman forman = new Forman(builder);

        forman.createBuilding();

        Building building = builder.getBuilding();
    }
}
