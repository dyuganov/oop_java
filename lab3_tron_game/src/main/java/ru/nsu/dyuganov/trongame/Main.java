package ru.nsu.dyuganov.trongame;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.trongame.Model.GameManager.TronGame;

public class Main {
    private final static Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.trongame/log4j/log4j.xml");
        Thread gameMainThread = new Thread(new TronGame());
        logger.info("Game thread start");
        gameMainThread.start();
    }
}


