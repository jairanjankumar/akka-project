package router

import akka.actor.{Actor, ActorRef, Props}
import router.Worker.Work

class RouterPool extends Actor {

  var routees: List[ActorRef] = _

  override def preStart() = {
    routees = List.fill(5)(
      context.actorOf(Props[Worker])
    )
  }

  override def receive: Receive = {
    case msg: Work =>
      println(s"I am a routerPool, and I received a message.. ")
      routees(util.Random.nextInt(routees.size)) forward msg
  }

}

class RouterGroup(routees: List[String]) extends Actor {
  def receive = {
    case msg: Work =>
      println(s"I am a routerGroup, and I received a Work message.. ")
      context.actorSelection(routees(util.Random.nextInt(routees.size))) forward msg
  }
}
