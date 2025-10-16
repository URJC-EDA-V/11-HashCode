import es.urjc.grafo.EDA.mapas.Mapa;
import es.urjc.grafo.EDA.mapas.SimpleMapa;
import es.urjc.grafo.EDA.mapas.UnsortedArrayMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.Map.Entry;

public class WordCountTest {

    int initialValues = 50000;
    int updates = 50000;

    @Test
    @Order(1)
    public void countWordsInText() throws FileNotFoundException {
        Mapa<String, Integer> freq = new SimpleMapa<>();
        Scanner doc = null;
        doc = new Scanner(new File("src/test/resources/don_quijote.txt"));
        while (doc.hasNextLine()) {
            String[] data = doc.nextLine().split(" ");
            for (String word : data) {
                String key = word.toLowerCase();
                if (freq.containsKey(key)) {
                    freq.put(key, freq.get(key) + 1);
                } else {
                    freq.put(key, 1);
                }
            }
        }
        Assertions.assertFalse(freq.isEmpty());
        int maxCount = 0;
        String maxWord = "No word?";
        Iterator<Entry<String, Integer>> it = freq.entries().iterator();
        while (it.hasNext()) {
            Entry<String, Integer> ent = it.next();
            if (ent.getValue() > maxCount) {
                maxWord = ent.getKey();
                maxCount = ent.getValue();
            }
        }
        System.out.print("The most frequent word is '" + maxWord);
        System.out.println("' with " + maxCount + " occurrences.");
        Assertions.assertEquals("de", maxWord);
        Assertions.assertEquals(21, maxCount);
    }

    @Test
    @Order(2)
    void timeConsumptionOfSimpleMapa() {
        Random random = new Random();
        Mapa<Integer, Integer> freq = new SimpleMapa<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With UnsortedArrayMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(3)
    void timeConsumptionOfHashMap() {
        Random random = new Random();
        Map<Integer, Integer> freq = new HashMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With HashMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

    @Test
    @Order(4)
    void timeConsumptionOfUnsortedArrayMap() {
        Random random = new Random();
        Mapa<Integer, Integer> freq = new UnsortedArrayMap<>();
        Instant start = Instant.now();
        for (int i = 0; i < initialValues; i++) {
            freq.put(random.nextInt(), random.nextInt());
        }

        for (int i = 0; i < updates; i++) {
            int key = random.nextInt();
            if (!freq.containsKey(key)) {
                freq.put(key, random.nextInt());
                freq.remove(key);
            } else {
                freq.put(key, random.nextInt());
            }
        }
        Duration duration = Duration.between(start, Instant.now());
        System.out.printf("With UnsortedArrayMap, the test took %d.%d seconds%n", duration.toSecondsPart(), duration.toMillisPart());
    }

}
