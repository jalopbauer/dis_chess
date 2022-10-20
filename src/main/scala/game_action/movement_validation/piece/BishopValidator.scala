package game_action.movement_validation.piece:

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.{AndCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_action.movement_validation.generic.movement.MovementIsDiagonalValidator
  import game_data.GameData
  import game_interruption.GameInterruption

  case class BishopValidator() extends AndCompositeValidator(MovementIsDiagonalValidator(), ToPositionIsEmptyOrPieceIsDifferentColorValidator())