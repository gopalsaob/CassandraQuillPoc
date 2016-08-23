package dto

case class A(
              id: String,
              xyz: List[B]
            )

case class B(
              x: String,
              y: String
            )