package org.agilecards.configuration.logs;

import ch.qos.logback.core.ConsoleAppender;
import org.fusesource.jansi.AnsiConsole;
import java.io.OutputStream;

/**
 * Created by bewilcox on 31/03/2017.
 */
public class AnsiConsoleAppender<E> extends ConsoleAppender<E> {

    @Override
    public void setOutputStream(OutputStream outputStream) {
        super.setOutputStream(AnsiConsole.wrapOutputStream(outputStream));
    }
}
