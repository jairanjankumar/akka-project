package actorSelection

import actorRef.Counter
import akka.actor.{ActorSystem, Props}

object RunWatch extends App {

  val system = ActorSystem("Watch-actor-selection")

  val counter = system.actorOf(Props[Counter], "counter")
  val watcher = system.actorOf(Props[Watcher], "watcher")

  Thread.sleep(100)
  system.terminate()

}
