package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor, PieceType}

  case class RegularSingleColorBishopFactory(yPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]] =
      Map(Coordinate(3, yPos) -> Some(Piece(pieceColor, PieceType.BISHOP)), Coordinate(6,yPos) -> Some(Piece(pieceColor, PieceType.BISHOP)))