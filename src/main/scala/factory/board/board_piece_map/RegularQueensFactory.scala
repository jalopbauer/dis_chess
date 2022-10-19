package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece,PieceColor,PieceType}

  case class RegularQueensFactory() extends BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]] =
      val pieceType = PieceType.QUEEN
      Map(Coordinate(4,8) -> Some(Piece(PieceColor.WHITE, pieceType)), Coordinate(4,1) -> Some(Piece(PieceColor.BLACK, pieceType)))