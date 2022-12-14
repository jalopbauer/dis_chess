package game_action.post_movement_invalidation

import game_action.movement_validation.exposed.RegularBoardPiecesMovementValidator
import game_data.GameData
import game_data.movement.Movement
import game_data.piece.PieceType
import game_interruption.{GameInterruption, MoveIsInvalid}
import player.Player

case class CheckValidator() extends PostMovementInvalidator() :

  val toCoordinateCheckValidator: ToCoordinateCheckValidator = ToCoordinateCheckValidator()
  def act(gameData: GameData): Either[GameData, GameInterruption] =
    val movement = gameData.movement
    val player = movement.player
    val pieces = gameData.board.getPieces
    val yourKing = pieces.filter(x => x._2.color == player.color && x._2.pieceType == PieceType.KING).keys.head
    toCoordinateCheckValidator.act(GameData(gameData.board
      , Movement(movement.from, yourKing, player)
      , gameData.turns))
