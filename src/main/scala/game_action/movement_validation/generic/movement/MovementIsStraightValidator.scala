package game_action.movement_validation.generic.movement

import game_action.movement_validation.MovementValidator
import game_data.GameData
import game_interruption.GameInterruption
import game_interruption.movement_validation.{MoveIsInvalid, MovementIsNotStraight}

  case class MovementIsStraightValidator() extends MovementValidator:
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      val vector = gameData.movement.to.vector(gameData.movement.from)
      if ((vector.x == 0 && vector.y != 0) || (vector.x != 0 && vector.y == 0))
        Left(gameData)
      else
        Right(MovementIsNotStraight(gameData))





