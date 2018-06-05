package ru.ilka.google.mentoring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.ilka.google.mentoring.task1.AnagramDeterminer;


public class Demo {
    private static final Logger logger = LogManager.getLogger(Demo.class);

    public static void main(String ... args){
        AnagramDeterminer anagramDeterminer = new AnagramDeterminer();
        logger.debug(anagramDeterminer.areAnagramsSentences("as asd asda.", "as asd asad.",false));

    }
}
