# 1.ADCS.pruebas

- Diseño Modelo/Vista/Controlador con Presentador del Modelo/Vista/Controlador

![Alt text](https://www.plantuml.com/plantuml/img/ZLLDRzGm4BtxLrZRIqjfnFPK2LGL5iG5f1L5lLk9bKPAxE8aj5NXl-CPh-t9E0kSuioRD_FcmydDE2atpKClHDshSPGVdPhR-scKB-9SFlJg-VHC_1P29FkhYyO-cejh-SMsNRrYl-lqOum6PtbYdJAjXe2TcRHJzNIwisQohk-rm_31-nQqK8fSS106ehECkFSwaRTEtFSUNoL-q-CywBzGWyEI6wWVh78D4nknsn-pSle8kEzqNM8Y5rzLrvBLAbA50EuNvGXI1A1SiX08fVcaHCmUKp1pZaua9ZHr8IjSmNAliBRK7K4QXON5rWWfal5zNUi7qWiPXuSB2DDgDO73lYBcfOHw9qqDdzMGtmzQUPAOWwGzgP-LUScxK-ZA3iJuxbT8KMOe-CcL3_-u9zk4DPUlzgV-XyjEcLht_vMmM2xYP5DpwNtc3PAaXKjj9Sw5bHvSZop6j6nHmi_bu9Fxxv1rJMVyXaZhkhOphoKnUVr-jyxU-cWi32ncTXJB-qc1k4RHWifOiBI5nI2EERAXnZJGV4W0JtOFcUtxx4mmWU1FpjcqykWEKV2GAPkhfwlDuV8MsBQgBf-sbvjmXGzm4JgG8NOuIGahitbJLTl8F01uKNUspro4WOe7ij_QSDFE-SUzLiq1oC7IjyEpw9v50jgqcOVWJboWORXuU2ZbuLU6-6FTy7wZJUF_hty0)

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
}

class MoveController #cyan {
}

class CancelController #cyan {
}

class ResumeController  #cyan{
}

class PlayController  #cyan{
+ move(Coordinate origin, Coordinate target);
}
PlayController ..> Coordinate

PlayView ..> Coordinate

class Coordinate{
}

PlayController *-down-> CancelController
PlayController *-down-> MoveController


class Game{
}
Game *-down-> Board
Game *-down-> Turn
Game ..> Error

class Board{
}
Board *-down-> "8x8" Square
Board *-down-> "1..2x12" Piece
Board ..> Error

class Square{
}
Square  --> "0..1" Piece
Square *--> Color

class Piece{
}
Piece <|-down- Men
Piece <|-down- Crownhead
Piece *--> Color 

class Men{
}

class Crownhead{
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