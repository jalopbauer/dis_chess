package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorBishopFactory(yPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]] =
      val bishop = Some(Piece(pieceColor, PieceType.BISHOP))
      Map(Coordinate(3, yPos) -> bishop, Coordinate(6,yPos) -> bishop)