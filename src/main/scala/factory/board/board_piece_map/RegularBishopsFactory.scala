package factory.board.board_piece_map:

  import game_data.board.Coordinate
  import game_data.piece.*

  case class RegularBishopsFactory() extends BoardPieceMapFactory:
    val whiteBishops: RegularSingleColorBishopFactory = RegularSingleColorBishopFactory(8,PieceColor.WHITE)
    val blackBishops: RegularSingleColorBishopFactory = RegularSingleColorBishopFactory(1,PieceColor.BLACK)
    def createPieces(): Map[Coordinate, Option[Piece]] =
      whiteBishops.createPieces() ++ blackBishops.createPieces()