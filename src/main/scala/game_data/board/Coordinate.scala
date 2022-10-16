package game_data.board:
  
  case class Coordinate(x:Int,y:Int):
    def vector(from: Coordinate): Coordinate =
      Coordinate(x - from.x, y - from.y)
