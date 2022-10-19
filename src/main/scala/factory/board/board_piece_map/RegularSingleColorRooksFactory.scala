package factory.board.board_piece_map:
  
  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor, PieceType}
  
  case class RegularSingleColorRooksFactory(yPos: Int, pieceColor: PieceColor) extends BoardPieceMapFactory:
      def createPieces(): Map[Coordinate, Option[Piece]] =
        Map(Coordinate(1,yPos) -> Some(Piece(pieceColor, PieceType.ROOK)), Coordinate(8, yPos) -> Some(Piece(pieceColor, PieceType.ROOK)))