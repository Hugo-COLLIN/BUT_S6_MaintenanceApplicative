package org.craftedsw.tripservicekata.user;

import org.craftedsw.tripservicekata.trip.Trip;

public class UserBuilder {

	public static UserBuilder createUser() {
		return new UserBuilder();
	}

	private User[] friends = new User[] {};

	// Pattern (manière de faire) élégante
	public UserBuilder withFriends(User... users) {
		this.friends = users;
		return this;
	}

	private Trip[] trips = new Trip[] {};

	// Pattern (manière de faire) élégante
	public UserBuilder withTrips(Trip... users) {
		this.trips = users;
		return this;
	}

	public User build() {
		User user = new User();
		for (User friend : friends)
			user.addFriend(friend);
		for (Trip trip : trips)
			user.addTrip(trip);
		return user;
	}



//	void WANNADOTHIS {
//		User u = createUser()
//				.withFriends(new User(), new User(), new User())
//				.withTrips(new Trip())
//				.build();
//
//	UserBuilder builder = createUser().withFriends(new User());
//	user1 = builder.build()
//	user2 = builder.build()
//
//	UserBuilder builder2 = new UservBuilder();
//	builder2.withFriends(new User)
//	User u = builder2.build();
//	}
}
