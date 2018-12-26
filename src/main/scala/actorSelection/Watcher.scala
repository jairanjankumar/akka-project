package actorSelection

import akka.actor.{Actor, ActorIdentity, ActorSelection, Identify}

class Watcher extends Actor {

  val selection: ActorSelection = context.actorSelection("/user/counter")

  selection ! Identify(None)

  def receive = {
    case ActorIdentity(_, Some(ref)) => println(s"Actor reference for counter is $ref")
    case ActorIdentity(_, None) => println("Actor reference for counter doesn't live")
  }

}
