Assumptions
- a player is bound to a game - they exist once they enter a game, they are not tracked once they leave a game
- from requirements, I assume we cannot use a simple h2 db for this POC
- using Spring for simplicity


Things I would have done, given more time:

- Unit and endpoint tests with mockito
- use a proper git branching strategy for each feature
- Create and use relevant exceptions
- Track if a game is in progress to avoid undesired actions such as adding a deck
- use JPA and better entity relationships
- add javadoc for functions and classes, and OpenAPI to document endpoints


*** NOTE: logging feature added after deadline

*** For usage, see src/main/resources/GoToCardGame.postman_collection.json
- it can be imported on postman
