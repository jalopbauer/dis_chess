package factory.board.board_piece_map

import game_data.board.Coordinate
import game_data.piece.{Piece, PieceColor, PieceType}

  case class EmptyPositionsFactory():
    val lineEmptyPositionsFactory3: LineEmptyPositionsFactory = LineEmptyPositionsFactory(3)
    val lineEmptyPositionsFactory4: LineEmptyPositionsFactory = LineEmptyPositionsFactory(4)
    val lineEmptyPositionsFactory5: LineEmptyPositionsFactory = LineEmptyPositionsFactory(5)
    val lineEmptyPositionsFactory6: LineEmptyPositionsFactory = LineEmptyPositionsFactory(6)
    def createPieces(): Map[Coordinate, Option[Piece]] =
      lineEmptyPositionsFactory3.createPieces() ++ lineEmptyPositionsFactory4.createPieces() ++ lineEmptyPositionsFactory5.createPieces() ++ lineEmptyPositionsFactory6.createPieces()