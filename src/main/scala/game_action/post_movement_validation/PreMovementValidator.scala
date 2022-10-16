package game_action.post_movement_validation

import game_action.GameAction
  import game_data.GameData
  import game_interruption.GameInterruption

  trait PreMovementValidator extends GameAction:
    def act(gameData: GameData): Either[GameData, GameInterruption]