package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {

    User BOB = new User();
    User PAULA = new User();

    @Test
    void shouldNotBeFriendWithStranger() {
        User user = UserBuilder
                .createUser()
                .withFriends(BOB)
                .build();
        assertFalse(user.isFriendWith(PAULA));
    }

    @Test
    void shouldBeFriend() {
        User user = UserBuilder
                .createUser()
                .withFriends(BOB, PAULA)
                .build();
        assertTrue(user.isFriendWith(PAULA));
    }

    @Test
    void shouldAddFriend() {
        // Given
        User user = new User();
        User friend = new User();

        // When
        user.addFriend(friend);

        // Then
        assertTrue(user.getFriends().contains(friend));
    }

    @Test
    void shouldAddTrip() {
        // Given
        User user = new User();
        Trip trip = new Trip();

        // When
        user.addTrip(trip);

        // Then
        assertTrue(user.trips().contains(trip));
    }

}
