package game_action.movement_validation.generic:

  import game_action.movement_validation.MovementValidator
  import game_data.GameData
  import game_interruption.GameInterruption
  case class ToPositionIsEmptyOrPieceIsDifferentColorValidator() extends OrCompositeValidator(ToPositionIsEmptyValidator()
                                                                                                , ToPiecePositionIsDifferentColorValidator())



