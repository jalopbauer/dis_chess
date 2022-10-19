package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor,PieceType}

  case class RegularSingleColorKinghtFactory(xPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]] =
      val horse = Some(Piece(pieceColor, PieceType.KNIGHT))
      Map(Coordinate(2, xPos) -> horse, Coordinate(7, xPos) -> horse)
      