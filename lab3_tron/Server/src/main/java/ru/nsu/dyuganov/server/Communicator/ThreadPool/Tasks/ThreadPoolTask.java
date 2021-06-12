package main.java.ru.nsu.dyuganov.server.Communicator.ThreadPool.Tasks;

import java.io.IOException;

public interface ThreadPoolTask {
    void execute() throws IOException;
}
