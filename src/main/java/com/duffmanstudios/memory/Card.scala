package com.duffmanstudios.memory

/**
 * Created by Student on 27/12/13.
 */
class Card(val Id: Int) {

  override def equals(other: Any): Boolean = {
    other.isInstanceOf[Card] && other.asInstanceOf[Card].Id == this.Id
  }
}
