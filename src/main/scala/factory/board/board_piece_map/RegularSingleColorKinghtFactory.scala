package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor,PieceType}

  case class RegularSingleColorKinghtFactory(xPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]] =
      Map(Coordinate(2, xPos) -> Some(Piece(pieceColor, PieceType.KNIGHT)), Coordinate(7, xPos) -> Some(Piece(pieceColor, PieceType.KNIGHT)))
      