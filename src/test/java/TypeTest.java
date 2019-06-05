import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TypeTest {
    @Test
    public void simpleTest() {
        assertTrue(Type.Bool.equals(Type.Bool));
        assertTrue(!Type.Bool.equals(Type.Int));
    }

    @Test
    public void nestedTest() {
        assertTrue(Type.Array(Type.Bool).equals(Type.Array(Type.Bool)));
        assertFalse(Type.Array(Type.Int).equals(Type.Array(Type.Float)));
        assertFalse(Type.Array(Type.Bool).equals(Type.Bool));
    }

    @Test
    public void doubleNested() {
        assertFalse(Type.Array(Type.Array(Type.Bool)).equals(Type.Array(Type.Array(Type.Bool))));
        assertFalse(Type.Array(Type.Array(Type.Bool)).equals(Type.Array((Type.Bool))));
    }
}
