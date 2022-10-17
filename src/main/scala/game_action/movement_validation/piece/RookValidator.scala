package game_action.movement_validation.piece

  import game_action.movement_validation.MovementValidator
  import game_action.movement_validation.generic.path.StraightlPathIsEmptyValidator
  import game_interruption.GameInterruption

  case class RookValidator() extends PieceValidator(StraightlPathIsEmptyValidator())