package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.user.User;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TripServiceTest {

    private User loggedInUser = null;

	public class TestableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }
    }

    @Test
    void shouldThrowsWhenUserIsNotLoggedIn() {
        // Given
        TripService tripService = new TestableTripService();
        loggedInUser = null;
        User user = new User();

        // When
        // Then
         assertThrows(UserNotLoggedInException.class,
                 () -> tripService.getTripsByUser(user)
         );
    }
}
