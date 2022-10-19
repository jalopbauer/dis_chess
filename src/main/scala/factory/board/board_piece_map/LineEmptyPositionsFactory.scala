package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor, PieceType}

  case class LineEmptyPositionsFactory(yPos:Int):
    def createPieces(): Map[Coordinate, Option[Piece]] =
      (1 to 8).map(x => {Coordinate(x, yPos)}).map(k => k -> None).toMap