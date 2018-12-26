package router

import akka.actor.Actor

class Worker extends Actor {

  import Worker._

  def receive = {
    case msg: Work => println(s"I received the work msg and my actor is $self")
  }
}

object Worker {

  case class Work()

}
