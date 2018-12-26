package actorRef

import akka.actor.Actor

class Counter extends Actor {

  import Counter._

  var count = 0

  def receive = {
    case Inc(x) => count += 1
    case Dec(x) => count -= 1
  }
}


object Counter {

  final case class Inc(num: Int)

  final case class Dec(num: Int)

}
