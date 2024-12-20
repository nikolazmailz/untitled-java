///**
// * Example:
// * var li = ListNode(5)
// * var v = li.`val`
// * Definition for singly-linked list.
// * class ListNode(var `val`: Int) {
// *     var next: ListNode? = null
// * }
// */
//class Solution {
//
//    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
//
//        val list1 = createList(l1)
//        val list2 = createList(l2)
//        var commonList: List<Int>? = null
//
//        commonList = if(list1.size >= list2.size) {
//            createCommonList(list1, list2)
//        } else {
//            createCommonList(list2, list1)
//        }
//
//        val listNode = commonList.stream().map {
//            ListNode(it)
//        }.collect(Collectors.toList())
//
//        for(i in 0..<listNode.size-1){
//            listNode[i].next = listNode[i+1]
//        }
//
//        return listNode.first()
//    }
//
//    private fun createCommonList(bigList: List<Int>, smallList: List<Int>): List<Int> {
//        val list = arrayListOf<Int>()
//        val maxSize = bigList.size
//        var toNextRound = 0
//        for (i in 0..<maxSize){
//            var sum: Int
//            var small = 0
//            if(smallList.size > i){
//                small = smallList[i]
//            }
//            if(bigList[i].plus(small).plus(toNextRound) > 9) {
//                sum = toNextRound.plus(bigList[i]).plus(small).minus(10)
//                toNextRound = 1
//            } else {
//                sum = toNextRound.plus(bigList[i]).plus(small)
//                toNextRound = 0
//            }
//            list.add(sum)
//        }
//        if(toNextRound > 0) list.add(1)
//        return list
//    }
//
//    private fun createList(l: ListNode?): List<Int> {
//        val list = arrayListOf<Int>()
//        var currentNode: ListNode? = null
//
//        if(l != null) {
//            currentNode = l
//        }
//
//        while (currentNode?.next != null) {
//            currentNode.`val`?.let { list.add(it) }
//            currentNode = currentNode.next
//        }
//        list.add(currentNode?.`val`!!)
//        return list
//    }
//}