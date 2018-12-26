package actorRef

import akka.actor.{ActorSystem, PoisonPill, Props}

object RunActorRef extends App {

  val system = ActorSystem("Actor-Paths")

  val counter1 = system.actorOf(Props[Counter], "actorRef.Counter")
  println(s"Actot reference for Counter1 : $counter1")
  val counterSelection1 = system.actorSelection("actorRef.Counter")
  println(s"Actot Selection for Counter1 : $counterSelection1")

  counter1 ! PoisonPill
  Thread.sleep(100)

  val counter2 = system.actorOf(Props[Counter], "actorRef.Counter")
  println(s"Actot reference for Counter2 : $counter2")
  val counterSelection2 = system.actorSelection("actorRef.Counter")
  println(s"Actot Selection for Counter2 : $counterSelection2")

  system.terminate()

}
