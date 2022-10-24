package game_action.movement_validation.exposed

import game_action.movement_validation.MovementValidator
import game_action.movement_validation.piece.*
import game_action.post_movement_invalidation.PostMovementInvalidator
import game_data.GameData
import game_data.board.Coordinate
import game_data.movement.Movement
import game_data.piece.{Piece, PieceColor, PieceType}
import game_interruption.{GameInterruption, MoveIsInvalid}
import player.Player

import scala.util.Right

  case class CheckValidator() extends PostMovementInvalidator():
    val regularBoardMovementValidator: RegularBoardPiecesMovementValidator = RegularBoardPiecesMovementValidator()
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val movement = gameData.movement
      val player = movement.player
      val pieces = gameData.board.getPieces
      val yourKing = pieces.filter(x => x._2.color == player.color && x._2.pieceType == PieceType.KING).keys
      val enemyPieces = pieces.filter(x => x._2.color != player.color)
      val pieceCanAttackMap = enemyPieces.dropWhile(x => regularBoardMovementValidator.act(GameData(gameData.board,Movement(x._1, yourKing.head, Player(x._2.color)), gameData.turns)).isRight)
      if (pieceCanAttackMap.nonEmpty)
        val value = pieceCanAttackMap.head
        Right(MoveIsInvalid(gameData, "Tas en jaque pa".concat(s"Piece: $value")))
      else
        Left(gameData)
