package edu.isu.cs.cs3308;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import edu.isu.cs.cs3308.structures.impl.SinglyLinkedList;

/**
 * @author Isaac Griffith
 */
public class SinglyLinkedListTest {

    @Test
    public void testIndexOf() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        assertEquals(list.indexOf(1), 0);
        assertEquals(list.indexOf(2), 1);
        assertEquals(list.indexOf(3), 2);
        assertEquals(list.indexOf(null), -1);
        assertEquals(list.indexOf(4), -1);
    }
}
