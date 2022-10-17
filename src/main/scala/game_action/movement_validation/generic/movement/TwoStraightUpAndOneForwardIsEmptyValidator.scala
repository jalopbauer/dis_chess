package game_action.movement_validation.generic.movement:

  import game_action.movement_validation.generic.AndCompositeValidator
  import game_action.movement_validation.generic.path.OneUpIsEmptyValidator

  case class TwoStraightUpAndOneForwardIsEmptyValidator() extends AndCompositeValidator(MovementIsTwoStraightUpValidator(), OneUpIsEmptyValidator())
