package game_data.movement:
  
  import game_data.board.Coordinate
  import player.Player
  
  case class Movement(from: Coordinate, to: Coordinate, player: Player)
