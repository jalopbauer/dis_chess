package game_data:

  import game_data.board.Board
  import game_data.movement.Movement
  import game_data.turn.Turn

  case class GameData(board: Board, movement: Movement, turns: List[Turn]):
     override def toString:String = "Completed"
