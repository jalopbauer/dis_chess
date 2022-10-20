package game_interruption.movement_validation

import game_data.GameData
import game_interruption.GameInterruption

  case class ToPositionPieceIsSameColor(gameData: GameData) extends GameInterruption(gameData: GameData):
    def getMessage:String =
      "ToPositionPieceIsSameColor"

