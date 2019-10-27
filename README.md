# 1.ADCS.pruebas

- Diseño Modelo/Vista/Controlador con Presentador del Modelo/Vista/Controlador

![Alt text](https://www.plantuml.com/plantuml/img/fLPHRzCm47xthx2wbuooYEvf4cZQA8W7GAhO1CzUQWLBgJsSXAug--_uph5zSLhOuCs-xyxttUVp9LTj9spNRnh6gaQqBNzdHLz_xrg-PtD-tuXTSSeU6MFH_k9iRRRwx99_ChMg3jY_AhaDfy6QdnWhT2tXGAKxQKNL5KkZEsERHbeytdlV01SQmaSn24EWDLdWol74kCE1gyRX1mE_oBRVo3-4UeTnh0zzQuHTPsG3TlEZ5rOU0LTALbECfUBByf9djR9O8O2hKJcC505eJfanXEBzn4IPFQJ8pEbqGZ6YKON4y02MjCBQeZgC28M51MaOPz5uNLNodcZ1m-LX0y9jrPB0lbyHSrHylPsaXWzYa_O3rpn9o47IdbGxeVUfToQyaWCnlldbKqmpJEAZQtxvnpspJZZayjdyb7znMGfToUP92IVDHPnC59U-vrmWV5yuTOhJrqdDCSte6l6SuzGZfyR3XSovHQYuCwQHBiXlWIbbCDQIH6ySDJUmZ5qhxLg96wjgfLzoOdBbk2Pqfyrz3qDBueB6LN69ZalJ60kEjxtL1Pe2GTL-Krf3Bu-jRjXklQr2ERo26N5uCoah6uyE2eGE3nRKCZiiFf19ZnnppFejf06rzy-HvxsrJfxdQVzValf10T6u0ACJ17Xd8ospGIvl0e6HDgFVY3t9vwuDzBdMEr_-FrVwH1aV_UXDP6SN3nUpOG9Fi4LPdZyipcV-z06U5EM3eLdyYdDuzxDNPRa8aGE0qnRlX35nrtRmHUNa8xXdV1_iZxb6nSgqgbD6HoMY8UhWUXzrICDEwjpqKUbwi2K-yHlY0iW80L_SIjrll2T1uQ9nuE225XV7tV28_1vLW_sLr6ltY_KR)

<code>
@startuml

class Draughts {
+ play()
}


Draughts *-down-> Logic
Draughts *-down-> View

class View #orange{
+ interact(Contorller)
}

class StartView #orange {
+ interact(StartController)
}

class PlayView  #orange {
+ interact(PllayController)
}

class ResumeView  #orange {
+ interact(ResumeController)
}
class BoardView #orange {
}
class SquareView #orange {
}
class PieceView #orange {
}

StartView ..> StartController
PlayView ..> PlayController
ResumeView ..> ResumeController

View *-down-> StartView
View *-down-> PlayView
View *-down-> ResumeView
StartView *-down-> BoardView
PlayView *-down-> BoardView
BoardView ..> SquareView
SquareView ..> PieceView
 
View ..> AcceptController 

class Logic{
+ getController()
}

Logic *--> State
Logic *--> Game
Logic *-down-> AcceptController

class Controller #cyan{
}

class AcceptController #cyan{
}

Controller <|-down- AcceptController
AcceptController <|-down- StartController
AcceptController <|-down- PlayController
Controller <|-down- MoveController
Controller <|-down- CancelController
AcceptController <|-down- ResumeController
Controller o--> Game

class StartController #cyan {
+ start();
}

class MoveController #cyan {
}

class CancelController #cyan {
}

class ResumeController  #cyan{
+ resume(boolean resumeGame);
}

class PlayController  #cyan{
+ move(Coordinate origin, Coordinate target);
+ Piece getPiece(Coordinate coordinate);
+ Color getTurn();
+ boolean isWinner();
+ boolean isDraw();
+ cancel();
}
PlayController ..> Coordinate

PlayView ..> Coordinate

class Coordinate{
}

PlayController *-down-> CancelController
PlayController *-down-> MoveController


class Game{
+ Piece getPiece(Coordinate coordinate);
+ Error move(Coordinate origin, Coordinate target);
+ Color getTurn();
+ boolean isWinner();
+ boolean isDraw();
+  State getState();

}
Game *-down-> Board
Game *-down-> Turn
Game ..> Error

class Board{
+ boolean canMoveAnyPiece();
+ Error move(Coordinate origin, Coordinate target);
+ Piece getPiece(Coordinate coordinate);
}
Board *-down-> "8x8" Square
Board *-down-> "1..2x12" Piece
Board ..> Error

class Square{
}
Square  --> "0..1" Piece
Square *--> Color

abstract class Piece{
 {abstract} boolean canMove(Position origin, Position target);
}
Piece <|-down- Men
Piece <|-down- King
Piece *--> Color 

class Men{
}

class King{
}

enum Color{
}

class Turn {
}
Turn *--> Color

class State{
}

class Error{
}
@enduml
</code>