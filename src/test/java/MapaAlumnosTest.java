import es.urjc.grafo.EDA.mapas.Alumno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.*;

public class MapaAlumnosTest {

    static List<Alumno> alumnos;
    static Random rand = new Random();

    @BeforeAll
    public static void setUpListAlumnos() {
        alumnos = new ArrayList<>(10);
        alumnos.add(new Alumno("Alan Turing", rand.nextInt()));
        alumnos.add(new Alumno("Tim Berners-Lee", rand.nextInt()));
        alumnos.add(new Alumno("Ada Lovelace", rand.nextInt()));
        alumnos.add(new Alumno("John McCarthy", rand.nextInt()));
        alumnos.add(new Alumno("Ray Tomlinson", rand.nextInt()));
        alumnos.add(new Alumno("Linus Torvalds", rand.nextInt()));
        alumnos.add(new Alumno("James Gosling", rand.nextInt()));
        alumnos.add(new Alumno("Donald Knuth", rand.nextInt()));
        alumnos.add(new Alumno("Barbara Liskov", rand.nextInt()));
        alumnos.add(new Alumno("Grace Hopper", rand.nextInt()));
    }

    @Test
    public void testAddingAlumnosToMap() {
        Map<Alumno, Float> notasAlumnos = new HashMap<>();
        for (Alumno alumno : alumnos) {
            notasAlumnos.put(alumno, rand.nextFloat(0, 10));
        }

        Assertions.assertEquals(10, notasAlumnos.size());

        for (Alumno alumno : alumnos) {
            Assertions.assertTrue(notasAlumnos.containsKey(alumno));
            System.out.println("Nota del estudiante " + alumno.getNombre() + ": " + notasAlumnos.get(alumno));
        }

        Alumno alumnoNoMatriculado = new Alumno("Mortadelo", rand.nextInt());
        Assertions.assertFalse(notasAlumnos.containsKey(alumnoNoMatriculado));
    }

}
