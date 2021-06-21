package main.java.ru.nsu.dyuganov.tron;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.GameController.GameController;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameModel;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.BotController;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserLocalController;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        // интерфейс, выбор режима игры (локальная / по сети)
        // запуск игры в нужном режиме (фабрику бы организовать...)

        /* СЕТЕВАЯ ВЕРСИЯ
        * Открывает соединение с сервером (ip и порт прописаны в пропертис), если он доступен.
        *   Получает сообщения в виде класса GameUpdates, рисует содержимое.
        *   Параллельно отправляет нажатия на клавиатуру в каждй момент времени. Они ловятся на сервере контроллером.
        *   Игра происходит на сервере, потом завершается, и разрывается сетевое соединение.
        *   Все это пока игра не закончится. Потом соединение закрывается, игрок попадает в меню.
        * Иначе сообщение об ошибке и возврат в меню.
        * */

        /* ЛОКАЛЬНАЯ ВЕРСИЯ
        * Создает экземпляр игры, инициализирует.
        * Создает ботов они связываются с игрой через контроллер. // можно user и bot унаследовать от иетнрфейса с методом getNextDirection
        * Играется игра, очки пишутся в таблицу рекордов (можно хранить ее во внешнем файле).
        * После игрок возвращается в главное меню.
        * */

        KeyController keyController = new KeyController();

        GameGUI gameGUI = new GameGUI(keyController);
        gameGUI.run();

        UserList userList = new UserList();
        initUserList(userList, gameGUI.getBotsNum(), keyController);
        GameModel gameModel = new GameModel(userList);
        GameController gameController = new GameController(gameModel, gameGUI);

        Thread controllerThread = new Thread(gameController);
        controllerThread.start();
        controllerThread.join();
    }

    private static void initUserList(UserList userList, int botsNum, KeyController keyController){
        userList.clearAll();
        userList.add(new UserLocalController(keyController));
        for (int i = 0; i < botsNum; ++i){
            userList.add(new BotController());
        }
    }
}
