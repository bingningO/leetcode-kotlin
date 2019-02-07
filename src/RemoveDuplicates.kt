import org.omg.CORBA.INTERNAL

fun main(args: Array<String>) {
    val test1 = intArrayOf( 1, 1, 2)
    val test2 = intArrayOf()
    val test3 = intArrayOf(0,0, 1,1,1, 3,3,4,4,4,4,5)
    print("${removeDuplicates(test1)}\n")
    test1.forEach {
        print("$it\n")
    }
    print("${removeDuplicates(test2)}\n")
    print("${removeDuplicates(test3)}\n")
    test3.forEach {
        print("$it\n")
    }
}

fun removeDuplicates(nums: IntArray): Int {
    if (nums.isEmpty()) return 0
    var count = 1
    for (i in 0 until nums.size -1) {
        if (nums[i] != nums[i+1]) {
            nums[count] = nums[i+1]
            count++
        }
    }
    return count
}