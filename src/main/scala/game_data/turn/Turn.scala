package game_data.turn:

  import game_data.movement.Movement
  import game_data.piece.Piece

  case class Turn(eatenPiece:Option[Piece], movement: Movement)
