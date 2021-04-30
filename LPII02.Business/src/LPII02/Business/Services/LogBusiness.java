/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LPII02.Business.Services;

import LPII02.Dal.Repositories.BaseRepository;
import LPII02.Dal.Repositories.LogRepository;
import LPII02.Domain.Entities.Log;
import java.lang.Thread;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author Gustavo
 */
public class LogBusiness extends BaseBusiness<Log> {

    private static List<Log> _logs;
    private static Object _lock;
    private static Logger _logger;

    public LogBusiness() {
        super(Log.class, null);

        synchronized (_lock) {
            if (_logger == null) {
                _logger = new Logger();
            }
        }
    }

    static {
        _logs = new ArrayList<Log>();
        _lock = new Object();
    }

    @Override
    public void insert(Log model) throws Exception {
        synchronized (_lock) {
            if (_logger.getState() == Thread.State.TERMINATED) {
                _logger = new Logger();
                _logger.start();
            }

//restartar a thread em caso de erro...
            _logs.add(model);
        }
    }

    public Log getInstance(int type, String message) {
        Builder builder = new Builder();

        return builder.get(type, message);
    }

    private class Builder {

        public Log get(int type, String message) {
            if (type == 1) {
                return getError(message);
            } else if (type == 2) {
                return getWarning(message);
            } else {
                return getTrack(message);
            }
        }

        private Log getError(String message) {
            Log model = new Log();

            model.setLogType(1);
            model.setDetails("Error: " + message);

            return model;
        }

        private Log getWarning(String message) {
            Log model = new Log();

            model.setLogType(2);
            model.setDetails("Warn: " + message);

            return model;
        }

        public Log getTrack(String message) {
            Log model = new Log();

            model.setLogType(3);
            model.setDetails("Track: " + message);

            return model;
        }
    }

    private class Logger extends Thread {

        @Override
        public void run() {
            boolean error = false;

            while (!error) {
                try {
                    //review to add some controlls...
                    LogRepository lRepository = new LogRepository();

                    synchronized (_lock) {
                        lRepository.insert(_logs, true);
                        _logs.removeAll(_logs);
                    }

                    sleep(20000);
                } catch (InterruptedException ex) {
                    //logging with log4net (when project finishing...
                    error = true;
                }
            }
        }
    }
}
