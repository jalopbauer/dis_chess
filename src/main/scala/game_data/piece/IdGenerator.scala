package game_data.piece:
    
  object IdGenerator:
    var number = 0
    def getId(): Int=
      number +=1
      number
