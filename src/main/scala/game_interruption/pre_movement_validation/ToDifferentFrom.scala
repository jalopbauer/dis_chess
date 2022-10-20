package game_interruption.pre_movement_validation

import game_data.GameData
import game_interruption.GameInterruption

  case class ToDifferentFrom(gameData: GameData) extends GameInterruption(gameData: GameData):
    def getMessage:String =
      s"To different from"

