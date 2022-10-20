package game_interruption.movement_validation

import game_data.GameData
import game_interruption.GameInterruption

  case class ToPositionIsEmpty(gameData: GameData) extends GameInterruption(gameData: GameData):
    def getMessage:String =
      s"ToPostionIsEmpty"

