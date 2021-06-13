package main.java.ru.nsu.dyuganov.tron;

import main.java.ru.nsu.dyuganov.tron.GUI.GUI;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;

import java.security.Guard;
import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) {
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
        GUI gui = new GUI(keyController);
        gui.start();

        Thread newThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 1000; ++i){
                    System.out.println(keyController.getCurrentDirection());
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        newThread.setDaemon(true);
        newThread.start();



    }
}
