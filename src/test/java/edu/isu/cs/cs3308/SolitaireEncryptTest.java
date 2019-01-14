package edu.isu.cs.cs3308;

import org.junit.Test;
import static org.junit.Assert.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class SolitaireEncryptTest {

    @Test
    public void testExecute() {
        SolitaireEncrypt encrypt = new SolitaireEncrypt("data/deck1.txt");
        try {
            List<String> encrypted = Files.readAllLines(Paths.get("data/encrypted.txt"));
            List<String> decrypted = Files.readAllLines(Paths.get("data/messages.txt"));

            for (int i = 0; i < encrypted.size(); i++) {
                String result = encrypt.execute(decrypted.get(i));
                assertEquals(result, encrypted.get(i));
            }
        } catch (IOException e) {
            fail();
        }
    }
}
