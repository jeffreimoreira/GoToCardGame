Assumptions
- a player is bound to a game - they exist once they enter a game, they are not tracked once they leave a game
- from requirements, I assume we cannot use a simple h2 db for this POC


Things I would have done, given more time:

- Unit and endpoint tests with mockito
- Create and use relevant exceptions
- Track if a game is in progress to avoid undesired actions such as adding a deck
- use JPA and better entity relationships
