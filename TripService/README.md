# Trip Service

## Business Rules

Imagine a social networking website for travellers:

- You need to be logged in to see the content
- You need to be a friend to see someone else's trips
- If you are not logged in, the code throws an exception

## Exercices Rules

- Our job is to write tests for the TripService class until we have 100% coverage
- Once we have 100% coverage, we need to refactor and make the code better.
- At the end of the refactoring, both tests and production code should clearly describe the business rules

## Exercices Constraints

- We cannot manually change production code if not covered by tests, that means:
    - We cannot type type of the TripService class while still not covered by tests
- If we need to change the TripService class in order to test, you can do so using automated refactorings (via IDE)
- We CANNOT change the public interface of TripService, that means:
    - We cannot change its constructor
    - We cannot change the method signature
    - Both changes above might cause other classes to change, which is not desirable now
- We CANNOT introduce state in the TripService
    - TripService is stateless. Introducing state may cause multi-thread issues
