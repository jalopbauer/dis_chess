package game_interruption.movement_validation

import game_data.GameData
import game_interruption.GameInterruption

case class OrOrValidationNotMet(gameData: GameData, leftGameInterruption: Either[GameData, GameInterruption], middleGameInterruption: Either[GameData, GameInterruption], rightGameInterruption: Either[GameData, GameInterruption] ) extends GameInterruption(gameData: GameData):
  def getMessage:String =
    leftGameInterruption.getOrElse("").toString.concat("   Or  ").concat(middleGameInterruption.getOrElse("").toString.concat("   Or  ").concat(rightGameInterruption.getOrElse("").toString))

