import akka.actor.{Actor, ActorSystem, Props}


// Define Actor
class Greeter extends Actor {
  override def receive: Receive = {
    case s: String => println(s"Hello $s")
  }
}


object HelloAkka extends App {

  // Create an Actor System
  val system = ActorSystem("Hello-Akka")

  // Create the Actor
  val greeter = system.actorOf(Props[Greeter], "greeter") // Name "greeter" is optional

  // Send message to Actor
  greeter ! "Akka"
}
