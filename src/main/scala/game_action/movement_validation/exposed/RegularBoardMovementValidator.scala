package game_action.movement_validation.exposed

import game_action.movement_validation.MovementValidator
import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator}
import game_action.movement_validation.piece.*
import game_data.GameData
import game_data.piece.{PieceColor, PieceType}
import game_interruption.GameInterruption

import scala.util.Right

  case class RegularBoardMovementValidator() extends AndCompositeValidator(RegularBoardPiecesMovementValidator(),CheckValidator())