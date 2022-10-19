package game_data.board:

  import game_data.movement.Movement
  import game_data.piece.Piece


  case class RegularBoard (pieces:Map[Coordinate, Option[Piece]]) extends Board:

    def makeMovement(movement: Movement): (Board, Option[Piece]) =
      (this,None)
      
    def coordinateBelongs(playerMovement: Coordinate): Option[Coordinate] =
      if(!pieces.contains(playerMovement)) None
      else Some(playerMovement)

    def getPiece(coordinate: Coordinate): Option[Piece] =
      pieces(coordinate)

    def getPieces: Map[Coordinate, Piece] =
      pieces.filter(x => x._2.isDefined).map(x => (x._1 , x._2.get))