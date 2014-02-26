import scala.collection.mutable.ArrayBuffer

package com.int.queue {
	private[queue] abstract class IntQueue {
		def get() : Int
		def put(x: Int)
	}

	class BasicIntQueue extends IntQueue {
		private val buff = new ArrayBuffer[Int]

		def get() = buff.remove(0)
		def put(x: Int) {buff += x}
		override def toString: String = buff.toString
	}

	package traits {

		trait Doubling extends IntQueue {
			abstract override def put(x: Int) {super.put(2*x)}
		}

		trait Incrementing extends IntQueue {
			abstract override def put(x: Int) { super.put(x+1)}
		}

		trait Filtering extends IntQueue {
			abstract override def put(x: Int) { if (x >= 0) super.put(x)}
		}

		trait Nothing extends IntQueue {

		}
	}
}



object main {
	import com.int.queue._
	import com.int.queue.traits._

	def main(args:Array[String]) {
		val q = new BasicIntQueue with Nothing

		for(i <- 1 to 10) q.put(i)
		val list = for(i <- 1 until 10) {
			q.get
			println(q)
		}

	}
}