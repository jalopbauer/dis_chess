package game_integration

import edu.austral.dissis.chess.gui.ChessPiece
import game_data.board.Coordinate
import game_data.piece.Piece
import scala.jdk.CollectionConverters.*

case class MiPiecesToChessPiece():
  val myPieceColorToPlayerColor: MyPieceColorToPlayerColor = MyPieceColorToPlayerColor()
  val myCoordinateToPosition: MyCoordinateToPosition = MyCoordinateToPosition()
  def transform(myPieces: Map[Coordinate,Piece]):java.util.List[ChessPiece] =
    myPieces.map(coordinatePiece => {
      val piece = coordinatePiece._2
      val coordinate = coordinatePiece._1
      new ChessPiece("yaya" , myPieceColorToPlayerColor.transform(piece.color), myCoordinateToPosition.transform(coordinate), piece.pieceType.toString)
    }).toList.asJava
