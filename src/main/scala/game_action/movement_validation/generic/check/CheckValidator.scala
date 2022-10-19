package game_action.movement_validation.generic.check:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_data.piece.Piece
  import game_interruption.GameInterruption

  case class CheckValidator(piece:List[Piece]) extends MovementValidator :
    def act(gameData: GameData): Either[GameData, GameInterruption] =
      
      Left(gameData)