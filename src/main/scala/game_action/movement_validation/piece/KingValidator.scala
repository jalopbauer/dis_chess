package game_action.movement_validation.piece:
  
  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.movement.MovementIsLShapedValidator
  import game_action.movement_validation.generic.{AndCompositeValidator, ToPositionIsEmptyOrPieceIsDifferentColorValidator}
  import game_interruption.GameInterruption

  case class KingValidator() extends AndCompositeValidator(MovementIsLShapedValidator(), ToPositionIsEmptyOrPieceIsDifferentColorValidator())