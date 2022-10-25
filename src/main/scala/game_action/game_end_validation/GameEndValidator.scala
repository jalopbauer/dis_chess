package game_action.game_end_validation

import game_action.GameAction
  import game_data.GameData
  import game_interruption.GameInterruption

  trait GameEndValidator extends GameAction:
    def act(gameData: GameData): Either[GameData, GameInterruption]