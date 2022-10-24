package game_action.post_movement_invalidation

import game_action.GameAction
  import game_data.GameData
  import game_interruption.GameInterruption

  trait PostMovementInvalidator extends GameAction:
    def act(gameData: GameData): Either[GameData, GameInterruption]