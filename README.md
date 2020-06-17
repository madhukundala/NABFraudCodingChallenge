# TicTacToe
TicTacToe game developed with Spring Boot with spring security.

##Install Tools
Gradle version 5.8 ,SDK JAva, IntelliJ, Docker


##Dev Technologies   
SpringBoot, Mockito, In memoryDB, Java, Docker

##Swagger UI for endpoints 

http://localhost:9090/swagger-ui.html

##PostMan URL's below 

For CreateGame : http://localhost:9090/v1/nab/api/game/createGame 
Basic Auth User Name and password : john 
Request Body : {
               	"gameType": "COMPETITION",
               	"piece": "X"
               }
               
Response : {
               "gameId": 3,
               "secondPlayer": null,
               "firstPlayer": {
                   "playerId": 1,
                   "userName": "john",
                   "email": "john@gmail.com"
               },
               "firstPlayerPieceCode": "X",
               "gameType": "COMPETITION",
               "gameStatus": "WAITS_FOR_PLAYER",
               "created": "2020-06-17T12:02:58.176+0000"
           } 


To Join Game :

URL : http://localhost:9090/v1/nab/api/game/joinGame
Request Body : {
               	"gameId": 3,
               	"gameType": "COMPETITION",
               	"piece": "O"
               }
               
Response : 
{
    "gameId": 3,
    "secondPlayer": {
        "playerId": 2,
        "userName": "paul",
        "email": "paul@gmail.com"
    },
    "firstPlayer": {
        "playerId": 1,
        "userName": "john",
        "email": "john@gmail.com"
    },
    "firstPlayerPieceCode": "X",
    "gameType": "COMPETITION",
    "gameStatus": "IN_PROGRESS",
    "created": "2020-06-17T10:19:31.796+0000"
}



# To Start application and deploy it using docker 

## Run Local 
```shell script
gradle clean build 
gradle bootrun
```

## Docker
```shell script
gradle clean docker` 
```


# NABFraudCodingChallenge
