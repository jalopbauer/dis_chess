package game_integration

import edu.austral.dissis.chess.gui.ChessPiece
import game_data.board.Coordinate
import game_data.piece.Piece
import scala.jdk.CollectionConverters.*

case class MiPiecesToChessPiece():
  val myPieceColorToPlayerColor: MyPieceColorToPlayerColor = MyPieceColorToPlayerColor()
  val myCoordinateToPosition: MyCoordinateToPosition = MyCoordinateToPosition()
  def transform(myPieces: Map[Coordinate,Piece]):java.util.List[ChessPiece] = {
    val pieces = myPieces
    println(pieces.toList)
    var id = 0
    val java = pieces.map(coordinatePiece => {
      id += 1
      val piece = coordinatePiece._2
      val coordinate = coordinatePiece._1
      new ChessPiece(s"$id", myPieceColorToPlayerColor.transform(piece.color), myCoordinateToPosition.transform(coordinate), piece.pieceType.toString.toLowerCase())
    }).toList.asJava
    println(java)
    java
  }
