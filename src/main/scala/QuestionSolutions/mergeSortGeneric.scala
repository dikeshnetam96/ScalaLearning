package QuestionSolutions


object mergeSortGeneric extends App {

  def mergeSortedLists[A](list1 : List[A], list2 : List[A]) (implicit ordering: Ordering[A]) : List[A] = { //
    (list1,list2) match {
      case (Nil, _) => list2
      case (_, Nil) => list1
      case (head1 :: tail1, head2 :: tail2) =>
        if(ordering.lt(head1,head2))
          head1 :: mergeSortedLists(tail1,list2)
        else
          head2 :: mergeSortedLists(list1, tail2)
    }
  }

  // Example usage:
  val sortedList1 = List(1, 3, 5, 7, 9)
  val sortedList2 = List(2, 4, 6, 8, 10)

  val mergedList = mergeSortedLists(sortedList1, sortedList2)
  println(mergedList)

}
