package router

import akka.actor.{ActorSystem, Props}
import router.Worker.Work

object RunActorPool extends App {

  val system = ActorSystem("router")
  val router = system.actorOf(Props[RouterPool], "Router")

  router ! Work()
  Thread.sleep(100)

  router ! Work()
  Thread.sleep(100)

  router ! Work()
  Thread.sleep(100)

  system.terminate()

}
