# BUT 3A : Maintenance Applicative

In this lecture, you will learn to detect *code smells* and do the appropriate *code refactoring* using nice *design patterns*.  
You will also see why it's so important to do intensive testing **before** the refactoring.  

To do so, we'll work with famous refactoring Kata aggregated into this repository.

## Resources

### Design pattern

[Refactoring guru](https://refactoring.guru/design-patterns) has a very good list of design patterns with pseudo-codes, examples of usage, pros and cons.  
This is a great resources to get started !

If you want to go further, there is the design pattern bible : [Design Patterns: Elements of Reusable Object-Oriented Software](https://www.oreilly.com/library/view/design-patterns-elements/0201633612/) by the infamous Gang of Four (Erich Gamma, Richard Helm, Ralph Jonhson and John Vlissides).  
Another very good book, way more friendly for beginners, is [Head First - Design Patterns](https://www.oreilly.com/library/view/design-patterns-elements/0201633612/).

### Code Smells

[Luzkan's catalog](https://luzkan.github.io/smells/) is a great resource to learn about code smells.  
[Refactoring guru](https://refactoring.guru/) also has a nice list of [code smells](https://refactoring.guru/refactoring/smells) with explanations and treatments.  

If you want to go further, I strongly advice you to read [Refactoring: Improving the Design of Existing Code](https://martinfowler.com/books/refactoring.html) by Martin Fowler.

## Kata 

### Kata \#1

[Gilded Rose](https://gitlab.inria.fr/tbiasutt/refactoring/-/tree/main/GildedRose) by [Emily Bache](https://github.com/emilybache)

In this kata, you will:
- see the utility of unit testing for code refactoring
- discover [ApprovalTests](https://github.com/approvals/ApprovalTests.Java)
- write a unit test with 100% code coverage
- use the "mutation testing" method to ensure the unit test are exhaustive 
- use the "lift up conditional" refactoring method
- use polymorphism for even better refactoring

### Kata \#2

[Tell Don't Ask](https://gitlab.inria.fr/tbiasutt/refactoring/-/tree/main/TellDontAsk) by [Gabriele Tondi](https://github.com/racingDeveloper)

In this kata, you will:
- see the "tell don't ask" principle
- deal with anemic domain model

### Kata \#3

[Trip Service](https://gitlab.inria.fr/tbiasutt/refactoring/-/tree/main/TripService) by [Sandro Mancuso](https://github.com/sandromancuso)

In this kata, you will:
- test classes strongly coupled to singleton
- write your own mocking classes
- create a builder to ease readability
- use guard clause to make cleaner code
- break strong coupling to static methods
- discover [Mockito](https://site.mockito.org/) and dependency injection

### Bonus Kata 

[Trivia Game](https://gitlab.inria.fr/tbiasutt/refactoring/-/tree/main/TriviaGame) by [J. B. Rainsberger](https://github.com/jbrains)

We won't have enough time to explore this kata during class, but feel free to try it, it's a typical kata people practice during a Legacy Code Retreat.

Here is a live coding by Victor Rentea: [part 1](https://www.youtube.com/watch?v=iOYsxBvMkLk) and [part 2](https://www.youtube.com/watch?v=OVqnQ0xxx0I).
