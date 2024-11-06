package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fire_Fail() {
        TorpedoStore store = new TorpedoStore(1,1);
        assertEquals(false, store.fire(1));
    }

    @Test
    void fire_Throw() {
        TorpedoStore store = new TorpedoStore(1);
        assertThrows(IllegalArgumentException.class, () -> { store.fire(-1); } );
        assertThrows(IllegalArgumentException.class, () -> { store.fire(10); } );
    }

    @Test
    void isEmptyTest() {
        TorpedoStore store = new TorpedoStore(1,0);
        assertEquals(false, store.isEmpty());
        store.fire(1);
        assertEquals(true, store.isEmpty());
    }

    @Test
    void getTorpedoCountTest() {
        TorpedoStore store = new TorpedoStore(3,0);
        assertEquals(3, store.getTorpedoCount());
        store.fire(2);
        assertEquals(1, store.getTorpedoCount());
        store.fire(1);
        assertEquals(0, store.getTorpedoCount());
    }
}
