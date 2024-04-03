package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripDAOTest {
    @Test
    void shouldThrowsWhenRetrieving() {
        // Given
        // When
        // Then
         assertThrows(CollaboratorCallException.class,
                 () -> TripDAO.tripsBy(new User())
         );
    }
}
