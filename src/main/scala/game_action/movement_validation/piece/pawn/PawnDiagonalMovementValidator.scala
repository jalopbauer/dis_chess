package game_action.movement_validation.piece.pawn

import game_action.movement_validation.MovementValidator
import game_action.movement_validation.generic.movement.{MovementIsDiagonalDownTopColorValidator, MovementIsDiagonalUpBottomColorValidator, MovementIsDiagonalValidator, MovementIsOneDiagonalUpValidator, OneDiagonalRespectingColorValidator}
import game_action.movement_validation.generic.{AndCompositeValidator, OrCompositeValidator, ToPiecePositionIsDifferentColorValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
import game_data.GameData
import game_data.piece.PieceColor
import game_interruption.{GameInterruption, MoveIsInvalid}

  case class PawnDiagonalMovementValidator() extends MovementValidator() :
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      Right(MoveIsInvalid(gameData, "Movement is not diagonal"))