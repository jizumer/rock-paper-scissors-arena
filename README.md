# rock-paper-scissors-arena


This repository is an exercise as a proposal for a simple backend architecture, as a basis to discuss aspects of 
technical design and good practices.

Consists on an implementation of Rock, Paper, Scissors game.

# Getting Started

## What's included

* Backend source code in a mono-repo approach. It's Java based, structured with gradle. This configuration is a 
proposal for a single repository, that would allow to deploy different applications based on the same bounded contexts.
* The source code is distributed in contexts, modules and aggregates. The logic has been pushed towards domain entities
as far as the proposed statement allows it. There are typical Hex Architecture layers, and application and domain services
have been identified.
* There are two main contexts identified: "dashboard" and "playground". Although it has not been possible to promote domain
objects from one domain to the other, both have been created in order to illustrate this approach and for discussion.
* There is also a "core" domain, for shared resources between different potential parts of the codebase and even the
 organization, as a shared kernel.  
* Comments have been included in several pieces of code to propose some discussion topics about those features that
 could not be implemented in the scope of this example, but should be considered in a real environment.
 * There are unit and acceptance tests included. e2e and automated performance testing could be a good next enhancement.
 * Github actions basic workflow in order to allow extra testing warranties and as a starting point for CI/CD or
  performance automation discussion.
 
 ## What's not included (yet)
 As mentioned before, there are some elements not included in this exercise for scope reasons. The main non included
 features are:
 
 * Frontend is not included in the codebase, but its packages are included, deployment procedure is proposed, and even
 a health-check endpoint can be accessed.
 * Domain segregation: Even when all domains have been created to propose this discussion, the promotion of aggregates 
 from "playground" context to "dashboard" context is not implemented. This is something that would have to be addressed 
 in a real life situation as the codebase grows.
 * Communication between different bounded contexts could be addressed with an asynchronous event bus system. It could 
 be in the form of an in memory event bus, or an external system.
 * Validation errors will raise http 500 status codes. An explicit error management has not been implemented, in order to 
 return correct expected HTTP status codes.

 
 ## Other considerations
 
 * The statement explicitly told not to use a real database (although it would be quite simple to include a real database 
 container in docker-compose as future improvement). The database has been simulated in the form of an in-memory 
 repository that stores data in a map. Concurrency and transactionality issues has not been addressed, because it has 
 been considered out of scope, but it could be an interesting topic for discussion as well.
 * Security features, such as authorization and authentication, have not been even mentioned in the statement, but 
 have been considered, as mentioned in the next point.
 * Id's for entities are not generated in the backend, but expected (and validated) to be generated outside it. It 
 improves the integrity of our domain and decouples our system from external systems such as databases. Related with
 this, the statement indicated that multiple users in multiple browsers should be able to play their own rounds 
 independently. For this, the backend expects receiving player ids from the frontend. In a real life situation, this id
 would come from an Auth server (eg: as a JWT), but in the scope of this exercise, it is allowed every randomly 
 generated UUID. 
 * Criteria pattern has been applied in a basic way, not even being necessary for such a simple example, but in terms
 of facing future codebase growth.
 * External configuration has not been addressed because it has not been considered within scope, and because the statement
 problem accepts very little configuration at the moment.
 * As mentioned before, this project structure is a proposal for deploying different apps leveraging on the same
 domain classes. For now, only the backend is available, so there is a main Boot class that scans the whole classpath
 to instantiate beans. When other apps are included, it is intended to evolve to a more complex bootstrap system that
 boot app-specific context depending on the received commanline arguments or other configurations.
 
### Some helpers 

Along with the source code, there are some helpers included:

* Makefile including common commands with gradle and Docker.
* docker-compose.yml and Dockerfile intended to run tests within the container.

## Requisites

* Java 11 & Gradle 6.4: Required to run locally.
* Docker & Docker compose: Required to run on containers.

## To run the application

Using the included Makefile script is the simplest way to run the app:

To build the app:
```
make build
```
To run all tests:

```
make test
``` 
To run the app locally:
```
make run
``` 
NOTE: As we mentioned before, we have developed a selective application startup depending on the arguments received
from command line. The only really implemented app is backend but there is another "frontend" option available as well.
 
If you run the command:

```
gradlew run --args=backend
```
You will boot the backend app. And executing:

```
gradlew run --args=frontend
```
You will boot the frontend app. For now, only one controller localhost:8080/frontend-health` is available in the frontend
which is a health check.

**For now, `make run` is mapped with `gradlew run --args=backend`, so it will boot the backend app.**

And that's it. Now once the application is running, by default, it will be accessible in `http://localhost:8080`. 


### API endpoints

These are the endpoints that will be reachable:

_NOTE: Id's are expected to be UUIDs_

Plays a new round between current player (indicated by POST) and a second automatic player. Player 1 is considered the 
real user, and will make a random move (rock, paper or scissors). Player 2 will always make the same move: rock.
```
[PUT]
/rounds/play/{idRound}
```
In the POST data, there will be necessarily included idPlayer. This way of representing the data is intendet to store
more information when a new entity is stored in the database.
```json
{
    "idPlayer": "0f749880-a9c8-46ce-ad56-b74f9d8dff14"
}
```

Get the rounds played by player indicated by `idPlayer` currently stored in database.

```
[GET]
/rounds/player/{idPlayer}
```
Collect statistics about totals:

* Total number of rounds.
* Total wins for 1st players.
* Total wins for 2nd players.
* Total draws.

```
/stats
```
There are also health checks included, for orchestration or load balancing.

```
[GET]
/health
/frontend-health
```
This data is intendet to be processed by the second domain classes (dashboard), and received through an event bus, or
any other kind of asynchronous event sourcing system.
 
The resulting data will look like this:

```json
{
    "player1Wins": 0,
    "player2Wins": 0,
    "draws": 0,
    "totalRounds": 0
}
```


## Other commands

To clean the workspace:
```
make clean
``` 
To boot up a docker-compose:
```
make container-boot 
``` 
_NOTE: You may ask "why a docker compose file to deploy a single container?" Because it is intended as a usefull resource
to deploy a development environment as well. It could include, in the future, the frontend (if necessary to serve 
static resources), databases, or queues/topic brokers or every system used to orchestrate workloads or collect metrics._

To run tests within the container (see docker-compose.yml, since workspace app volume is mounted on the container)
```
make container-test
``` 
To stop container
```
make container-stop
``` 

Additionally, the image built will remain in the local docker installation. In case you want to delete it:

```
 docker rmi rock-paper-scissors-arena_rock.paper.scissors 
```