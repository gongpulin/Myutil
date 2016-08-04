package oop

/**
  * Created by gpl on 2016/8/1.
  */

class Outer(val name:String){ outer=>
    class Inner(val name:String){
        def foo(b:Inner) = println("Outer:"+outer.name+"    Inner:"+b.name)
}

}
//Java语言的内部类是从属于外部类的，而Scala语言的内部类是从属于外部类的每个具体实例对象的。
object InnerClass{
    def main(args:Array[String]): Unit ={
        val outer1 = new Outer("Outer1")
        val outer2 = new Outer("Outer2")
        val inner1 = new outer1.Inner("inner1")
        val inner2 = new outer2.Inner("inner2")
        inner1.foo(inner1)
        inner2.foo(inner2)
    }
}
