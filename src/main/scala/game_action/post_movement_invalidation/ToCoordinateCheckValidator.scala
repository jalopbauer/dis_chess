package game_action.post_movement_invalidation

import game_action.movement_validation.exposed.RegularBoardPiecesMovementValidator
import game_data.GameData
import game_data.movement.Movement
import game_data.piece.PieceType
import game_interruption.{GameInterruption, MoveIsInvalid}
import player.Player

case class ToCoordinateCheckValidator() extends PostMovementInvalidator() :
  val regularBoardMovementValidator: RegularBoardPiecesMovementValidator = RegularBoardPiecesMovementValidator()

  def act(gameData: GameData): Either[GameData, GameInterruption] =
    val movement = gameData.movement
    val player = movement.player
    val pieces = gameData.board.getPieces
    val enemyPieces = pieces.filter(x => x._2.color != player.color)
    val pieceCanAttackMap = enemyPieces.dropWhile(x => regularBoardMovementValidator.act(GameData(gameData.board, Movement(x._1, movement.to, Player(x._2.color)), gameData.turns)).isRight)
    if (pieceCanAttackMap.nonEmpty)
      val value = pieceCanAttackMap.head
      Right(MoveIsInvalid(gameData, "Tas en jaque pa".concat(s"Piece: $value")))
    else
      Left(gameData)
