package game_action.movement_validation.piece

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.{AndCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_action.movement_validation.generic.path.StraightlIsEmptyValidator
  import game_interruption.GameInterruption

  case class RookValidator() extends AndCompositeValidator(StraightlIsEmptyValidator(), ToPositionIsEmptyOrPieceIsDifferentColorValidator())