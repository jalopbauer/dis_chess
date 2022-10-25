package game_action.game_end_validation

import game_action.movement_validation.exposed.RegularBoardPiecesMovementValidator
import game_action.post_movement_invalidation.{CheckValidator, ToCoordinateCheckValidator}
import game_data.GameData
import game_data.board.{Board, Coordinate}
import game_data.movement.Movement
import game_data.piece.PieceType
import game_interruption.GameInterruption
import game_interruption.game_end_validation.KingWasEaten

case class KingWasEatenValidation() extends GameEndValidator:
  def act(gameData: GameData): Either[GameData, GameInterruption] = {
    val piece = gameData.turns.last.eatenPiece
    if (piece.isDefined && piece.get.pieceType == PieceType.KING) Right(KingWasEaten(gameData))
    else Left(gameData)
  }