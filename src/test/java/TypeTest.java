import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TypeTest {
    @Test
    public void simpleTest() {
        assertEquals(Type.Bool, (Type.Bool));

        assertNotEquals(Type.Bool, (Type.Int));
    }

    @Test
    public void nestedTest() {
        assertEquals(Type.Array(Type.Bool), (Type.Array(Type.Bool)));
        assertNotEquals(Type.Array(Type.Int), (Type.Array(Type.Float)));
        assertNotEquals(Type.Array(Type.Bool), (Type.Bool));
    }

    @Test
    public void doubleNested() {
        assertEquals(Type.Array(Type.Array(Type.Bool)), (Type.Array(Type.Array(Type.Bool))));
        assertNotEquals(Type.Array(Type.Array(Type.Bool)), (Type.Array((Type.Bool))));
    }
}
