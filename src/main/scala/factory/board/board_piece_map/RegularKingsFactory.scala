package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece,PieceColor,PieceType}

  case class RegularKingsFactory() extends BoardPieceMapFactory:
      def createPieces(): Map[Coordinate, Option[Piece]] =
        val pieceType = PieceType.KING
        Map(Coordinate(5,8) -> Some(Piece(PieceColor.WHITE, pieceType)), Coordinate(5,1) -> Some(Piece(PieceColor.BLACK, pieceType)))