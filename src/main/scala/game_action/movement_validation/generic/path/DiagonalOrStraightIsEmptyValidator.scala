package game_action.movement_validation.generic.path:

  import game_action.movement_validation.generic.OrCompositeValidator

  case class DiagonalOrStraightIsEmptyValidator() extends OrCompositeValidator(DiagonalIsEmptyValidator(),StraightlIsEmptyValidator())



