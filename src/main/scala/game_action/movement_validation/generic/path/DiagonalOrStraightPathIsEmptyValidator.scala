package game_action.movement_validation.generic.path:

  import game_action.movement_validation.generic.OrCompositeValidator

  case class DiagonalOrStraightPathIsEmptyValidator() extends OrCompositeValidator(DiagonalPathIsEmptyValidator(),StraightlPathIsEmptyValidator())



