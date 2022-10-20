package game_interruption.movement_validation

import game_data.GameData
import game_interruption.GameInterruption

case class AndValidationNotMet(gameData: GameData,leftGameInterruption: String, rightGameInterruption: String ) extends GameInterruption(gameData: GameData):
  def getMessage:String =
    leftGameInterruption.toString.concat("     ").concat(rightGameInterruption.toString)

