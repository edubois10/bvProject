package com.redhat.bvbackend;

import io.quarkus.test.junit.QuarkusTest;

import com.redhat.bvbackend.player.Player;
import com.redhat.bvbackend.player.PlayerRepository;

import io.quarkus.test.junit.mockito.InjectMock;
import org.mockito.Mockito;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import javax.ws.rs.WebApplicationException;

@QuarkusTest
public class PlayerTest {

    //@InjectMock
    //Session session;

    @InjectMock
    PlayerRepository playerRepository;

    @Test
    public void testPanacheRepositoryMocking() throws Throwable {
        // Mocked classes always return a default value
        assertEquals(0, playerRepository.count());

        // Now let's specify the return value
        Mockito.when(playerRepository.count()).thenReturn(23L);
        assertEquals(23, playerRepository.count());

        // Now let's change the return value
        Mockito.when(playerRepository.count()).thenReturn(42L);
        assertEquals(42, playerRepository.count());

        // Now let's call the original method
        Mockito.when(playerRepository.count()).thenCallRealMethod();
        assertEquals(0, playerRepository.count());

        // Check that we called it 4 times
        Mockito.verify(playerRepository, Mockito.times(4)).count();

        // Mock only with specific parameters
        Player p = new Player();
        Mockito.when(playerRepository.findById(12L)).thenReturn(p);
        assertSame(p, playerRepository.findById(12L));
        assertNull(playerRepository.findById(42L));
        
        // Mock throwing
        Mockito.when(playerRepository.findById(12L)).thenThrow(new WebApplicationException());
        assertThrows(WebApplicationException.class, () -> playerRepository.findById(12L));

        Mockito.when(playerRepository.findOrdered()).thenReturn(Collections.emptyList());
        assertTrue(playerRepository.findOrdered().isEmpty());

        // We can even mock your custom methods
        Mockito.verify(playerRepository).findOrdered();
        Mockito.verify(playerRepository, Mockito.atLeastOnce()).findById(Mockito.any());
        Mockito.verifyNoMoreInteractions(playerRepository);
        
    }
}