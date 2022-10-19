package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.{Piece,PieceColor}

  case class RegularKnightsFactory() extends BoardPieceMapFactory:
    def createPieces(): Map[Coordinate, Option[Piece]] =
      RegularSingleColorKinghtFactory(8,PieceColor.WHITE).createPieces() ++ RegularSingleColorKinghtFactory(1,PieceColor.BLACK).createPieces()