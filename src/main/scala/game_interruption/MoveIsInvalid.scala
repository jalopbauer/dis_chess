package game_interruption

import game_data.GameData

case class MoveIsInvalid(gameData: GameData, message:String) extends GameInterruption(gameData: GameData):
  def getMessage:String =
    message