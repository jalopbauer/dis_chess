package game_data.board:

  import game_data.movement.Movement
  import game_data.piece.Piece


  case class RegularBoard (pieces:Map[Coordinate, Option[Piece]]) extends Board:

    def makeMovement(movement: Movement): (Board, Option[Piece]) =
      val maybeToPiece = pieces(movement.to)
      val value = pieces(movement.from)
      val newPieces = pieces - movement.to - movement.from + (movement.to -> value) + (movement.from -> None)
      (RegularBoard(newPieces),maybeToPiece)

    private def coordinateInRange(coordinate: Coordinate) : Boolean =
      inRange(coordinate.x) && inRange(coordinate.y)
    private def inRange(int: Int) : Boolean =
      int > 0 && int < 9

    def coordinateBelongs(playerMovement: Coordinate): Option[Coordinate] =
      if(!coordinateInRange(playerMovement)) None
      else Some(playerMovement)

    def getPiece(coordinate: Coordinate): Option[Piece] =
      pieces(coordinate)

    def getPieces: Map[Coordinate, Piece] =
      pieces.filter(x => x._2.isDefined).map(x => (x._1 , x._2.get))

    def putPieceInCoordinate(coordinate:Coordinate, piece: Piece): Board =
      val newPieces = pieces - coordinate + (coordinate -> Some(piece))
      RegularBoard(newPieces)
