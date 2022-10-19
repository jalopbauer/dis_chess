package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece, PieceColor, PieceType}

  case class YcoordPawnsFactory(xPos: Int, pieceColor: PieceColor, yCoordMaxValue: Int):
    def createPieces(): Map[Coordinate, Option[Piece]] =
      (1 to yCoordMaxValue).map(y => {Coordinate(y, xPos)}).map(k => k -> Some(Piece(pieceColor, PieceType.PAWN))).toMap